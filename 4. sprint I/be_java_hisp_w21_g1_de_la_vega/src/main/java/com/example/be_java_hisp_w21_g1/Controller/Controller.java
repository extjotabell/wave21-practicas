package com.example.be_java_hisp_w21_g1.Controller;

import com.example.be_java_hisp_w21_g1.DTO.Request.FollowPostDTO;
import com.example.be_java_hisp_w21_g1.DTO.Request.PostProductDTO;
import com.example.be_java_hisp_w21_g1.DTO.Request.ProductInSaleDTO;
import com.example.be_java_hisp_w21_g1.DTO.Response.*;
import com.example.be_java_hisp_w21_g1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    @Autowired
    UserService userService;

    //US 0001: Poder realizar la acción de “Follow” (seguir) a un determinado vendedor
    //Recibe FollowPostDTO
    //Retorna status code
    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<ResponseDTO> follow(@PathVariable int userId, @PathVariable int userIdToFollow){
        FollowPostDTO followPostDTO = new FollowPostDTO(userId, userIdToFollow);
        ResponseEntity<ResponseDTO> response;
        userService.follow(followPostDTO);
        return new ResponseEntity<>(new ResponseDTO("Accion realizada con exito.", 200),HttpStatus.OK);
    }

    //US 0002: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
    //Recibe UserIdDTO
    //Retorna FollowersCountDTO
    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<FollowersCountDTO> countFollowers(@PathVariable int userId) {
        return new ResponseEntity<>(userService.getFollowersCount(userId), HttpStatus.OK);
    }

    //US 0003: Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
    //Recibe UserIdDTO
    //Retorna FollowerListDTO
    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<FollowerListDTO> listFollowers(@PathVariable int userId, @RequestParam(value = "order", required = false) String alf_order) {
        return new ResponseEntity<>(userService.getFollowersList(userId, alf_order), HttpStatus.OK);
    }

    //US 0004: Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)
    //Recibe UserIdDTO
    //Retorna FollowedListDTO
    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<FollowedListDTO> listFollowed(@PathVariable int userId, @RequestParam(value = "order", required = false) String alf_order) {
        return new ResponseEntity<>(userService.getFollowedList(userId, alf_order), HttpStatus.OK);
    }

    //US 0005: Dar de alta una nueva publicación
    //Recibe PostProductDTO
    //Retorna status code
    @PostMapping("/products/post")
    public ResponseEntity<?> createPost(@RequestBody PostProductDTO postProductDTO){
        userService.createPost(postProductDTO);
        return new ResponseEntity<>("Se ha creado el post!", HttpStatus.OK);
    }

    //US 0006: Obtener un listado de las publicaciones realizadas por los vendedores que un usuario
    // sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha,
    // publicaciones más recientes primero).
    //Recibe UserIdDTO
    //Retorna PostBySeller
    @GetMapping("/products/followed/{user_id}/list")
    public ResponseEntity<PostBySellerDTO> latestsPosts(@PathVariable("user_id") int userId, @RequestParam(value = "order", required = false) String alf_order){
        PostBySellerDTO latestPosts = userService.listPostsBySeller(userId, alf_order);
        return new ResponseEntity<>(latestPosts, HttpStatus.OK);
    }


    //US 0007: Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
    //Recibe FollowPostDTO
    //Retorna status code
    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollowUser(@PathVariable int userId, @PathVariable int userIdToUnfollow) {
        FollowPostDTO followPostDTO = new FollowPostDTO(userId, userIdToUnfollow);
        ResponseEntity<?> response;
        if(userService.unFollow(followPostDTO))
            response = new ResponseEntity<>(HttpStatus.OK);
        else
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return response;
    }
    /*
    @GetMapping("/users/{UserID}/followed/list?order=name_asc")
    public ResponseEntity<?> orderFollowedBy(@PathVariable int userId, @RequestParam(value = "order", required = true) String alf_order){
        return null;
    }
    //US 0009: Ordenamiento por fecha ascendente y descendente
    /*
    * /products/followed/{userId}/list?order=date_asc
    /products/followed/{userId}/list?order=date_desc

    @GetMapping("products/followed/{userId}/list//")
    public ResponseEntity<?> orderProductsBy(@PathVariable int userId, @RequestParam(value = "order", required = true) String dateOrder){
        return null;
    }
   */

    //US 0010: Llevar a cabo la publicación de un nuevo producto en promoción
    @PostMapping("/products/promo-post")
    public ResponseEntity<ResponseDTO> newProductInSale(@RequestBody ProductInSaleDTO dto) {
        userService.saveProductInSale(dto);
        return new ResponseEntity<>( new ResponseDTO("Creacion de Producto exitosa", 200),HttpStatus.OK);
    }

    //US 0011: Obtener la cantidad de productos en promoción de un determinado vendedor

    @GetMapping("/products/promo-post/count")
    public ResponseEntity<PromoProductDto> promoProductsCount(@RequestParam(value = "user_id", required = true) int userId) {
        return new ResponseEntity<>(userService.getPromoProductCount(userId), HttpStatus.OK);
    }

    //US 0012: OPCIONAL
    @GetMapping("/products/promo-post/list?user_id={userId}")
    public ResponseEntity<?> productsInSaleBySeller(@PathVariable int userId) {
        return null;
    }

}
