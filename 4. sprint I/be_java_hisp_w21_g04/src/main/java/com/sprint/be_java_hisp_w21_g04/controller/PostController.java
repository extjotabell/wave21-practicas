package com.sprint.be_java_hisp_w21_g04.controller;

import com.sprint.be_java_hisp_w21_g04.dto.request.PostRequestDto;
import com.sprint.be_java_hisp_w21_g04.dto.request.PromoProductCountDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.PostResponseDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.SellerFollowedListPostResponseDto;
import com.sprint.be_java_hisp_w21_g04.entity.Post;
import com.sprint.be_java_hisp_w21_g04.exception.UserNotFoundException;
import com.sprint.be_java_hisp_w21_g04.service.post.IPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class PostController {
    private IPostService _service;

    public PostController(IPostService service){
        this._service = service;
    }

    @PostMapping("/post")
    public ResponseEntity<String> post(@RequestBody(required = true) PostRequestDto post) {
        this._service.post(post);
        return new ResponseEntity<>("Post agregado exitosamente",HttpStatus.OK);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<String> promoPost(@RequestBody(required = true) PostRequestDto post) {
        try {
            this._service.promoPost(post);
            return new ResponseEntity<>("Post agregado exitosamente",HttpStatus.OK);
        } catch (Exception e) {
            // se muestra el error en caso de que se genere una excepcion
            return new ResponseEntity<>("Hubo un error al procesar la solicitud", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/products/promo-post/count")
    public ResponseEntity<PromoProductCountDto> getPromoProductCount(@RequestParam(required = true) int userId) {
        try {
            PromoProductCountDto promoProductCount = _service.getPromoProductCount(userId);
            return new ResponseEntity<>(promoProductCount, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<SellerFollowedListPostResponseDto> sellerFollowedListPosts(@PathVariable int userId, @RequestParam(required = false, value = "order", defaultValue = "date_asc") String order){
        return new ResponseEntity<>(this._service.sellerFollowedListPosts(userId, order), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PostResponseDto>> getAll(){
        return new ResponseEntity<>(this._service.getAll(), HttpStatus.OK);
    }
}
