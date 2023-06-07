package com.bootcamp.grupo3.socialmeli.exception;

import com.bootcamp.grupo3.socialmeli.dto.response.MessageDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> userNotFoundException(Exception e){
        return ResponseEntity.badRequest().body(new MessageDTO(e.getMessage()));
    }

    @ExceptionHandler(UserAlreadyFollowedException.class)
    public ResponseEntity<?> userAlreadyFollowedException(Exception e){
        return ResponseEntity.badRequest().body(new MessageDTO(e.getMessage()));
    }

    @ExceptionHandler(UserEqualsException.class)
    public ResponseEntity<?> userEqualsException(Exception e){
        return ResponseEntity.badRequest().body(new MessageDTO(e.getMessage()));
    }

    @ExceptionHandler(PromotionPostException.class)
    public ResponseEntity<?> promotionPostException(Exception e){
        return ResponseEntity.badRequest().body(new MessageDTO(e.getMessage()));
    }

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<?> postNotFoundException(Exception e){
        return ResponseEntity.badRequest().body(new MessageDTO(e.getMessage()));
    }

    @ExceptionHandler(UserAlreadyLikeException.class)
    public ResponseEntity<?> userAlreadyLikeException(Exception e){
        return ResponseEntity.badRequest().body(new MessageDTO(e.getMessage()));
    }
}
