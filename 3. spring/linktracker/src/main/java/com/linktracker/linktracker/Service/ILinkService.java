package com.linktracker.linktracker.Service;


import com.linktracker.linktracker.DTO.LinkRequestDto;
import com.linktracker.linktracker.DTO.LinkResponseDto;
import com.linktracker.linktracker.DTO.LinkResponseSaveDto;

public interface ILinkService {
    LinkResponseSaveDto save(LinkRequestDto link);
    LinkResponseDto getById(Integer id);
    void delete(Integer id);

    void inactivelink(Integer id);

    LinkResponseDto redirect(Integer id);
}
