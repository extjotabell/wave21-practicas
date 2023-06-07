package com.linktracker.linktracker.Service;

import com.linktracker.linktracker.DTO.LinkRequestDto;
import com.linktracker.linktracker.DTO.LinkResponseDto;
import com.linktracker.linktracker.DTO.LinkResponseSaveDto;
import com.linktracker.linktracker.Entity.LinkEntity;
import com.linktracker.linktracker.Repository.ILinkRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImpl implements ILinkService{
    private ILinkRepository _repository;
    private ModelMapper modelMapper;

    public LinkServiceImpl(ILinkRepository repository){
        this._repository = repository;
        this.modelMapper = new ModelMapper();
    }
    @Override
    public LinkResponseSaveDto save(LinkRequestDto link) {
        return modelMapper.map(this._repository.save(modelMapper.map(link, LinkEntity.class)), LinkResponseSaveDto.class);
    }

    @Override
    public LinkResponseDto getById(Integer id) {
        return modelMapper.map(this._repository.getById(id), LinkResponseDto.class);
    }

    @Override
    public void delete(Integer id) {
        this._repository.delete(id);
    }

    @Override
    public void inactivelink(Integer id) {
        LinkEntity link = this._repository.getById(id);
        link.setIsInvalid(true);
        this._repository.update(link);
    }

    @Override
    public LinkResponseDto redirect(Integer id) {
        LinkEntity link = this._repository.getById(id);
        link.setRedirectCount(link.getRedirectCount() + 1);
        this._repository.update(link);
        return modelMapper.map(link, LinkResponseDto.class);
    }
}
