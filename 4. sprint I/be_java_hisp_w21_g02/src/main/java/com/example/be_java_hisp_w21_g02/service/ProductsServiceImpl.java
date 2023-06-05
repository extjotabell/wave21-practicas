package com.example.be_java_hisp_w21_g02.service;

import com.example.be_java_hisp_w21_g02.dto.request.PostRequestDTO;
import com.example.be_java_hisp_w21_g02.dto.request.ProductDTO;
import com.example.be_java_hisp_w21_g02.exceptions.PostBadRequestException;
import com.example.be_java_hisp_w21_g02.model.Post;
import com.example.be_java_hisp_w21_g02.model.Product;
import com.example.be_java_hisp_w21_g02.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class ProductsServiceImpl implements IProductsService{

    @Autowired
    IUserRepository userRepository;

    @Override
    public ResponseEntity<?> createPost(PostRequestDTO postRequestDTO) {
        Post post = convertPostRequestDTOtoPost(postRequestDTO);
        Post response = userRepository.createPost(post);
        if(!isValidRequest(postRequestDTO) || response == null){
            throw new PostBadRequestException(String.format("Invalid post request"));
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private boolean isValidRequest(PostRequestDTO postRequestDTO){
        return postRequestDTO.getDate() != null && postRequestDTO.getPrice() >= 0;
    }

    private Post convertPostRequestDTOtoPost(PostRequestDTO postRequestDTO){
        Post post = new Post();
        post.setUserId(postRequestDTO.getUserId());
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        post.setDate(LocalDate.parse(postRequestDTO.getDate(), dateFormatter));
        post.setCategory(postRequestDTO.getCategory());
        post.setPrice(postRequestDTO.getPrice());
        post.setProduct(convertProductDTOtoProduct(postRequestDTO.getProduct()));
        return post;
    }

    private Product convertProductDTOtoProduct(ProductDTO productDTO){
        Product product = new Product();
        product.setId(product.getId());
        product.setType(productDTO.getType());
        product.setBrand(productDTO.getBrand());
        product.setNotes(productDTO.getNotes());
        return product;
    }
}
