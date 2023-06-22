package com.example.be_java_hisp_w21_g1.Controller;

import com.example.be_java_hisp_w21_g1.DTO.Request.FollowPostDTO;
import com.example.be_java_hisp_w21_g1.DTO.Request.PostProductDTO;
import com.example.be_java_hisp_w21_g1.DTO.Response.*;
import com.example.be_java_hisp_w21_g1.Service.UserService;
import jakarta.validation.Valid;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;




@RestController
@Validated
public class Controller {
    @Autowired
    UserService userService;

    //US 0001: Poder realizar la acción de “Follow” (seguir) a un determinado vendedor
    //Recibe FollowPostDTO
    //Retorna status code
    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<ResponseDTO> follow(
           @PathVariable(value = "userId", required = true)
            @NotNull(message = "User_id can't be empty")
            @Positive(message = "User_id can't be less than 0")
                Integer userId,
           @PathVariable Integer userIdToFollow
    ){
        FollowPostDTO followPostDTO = new FollowPostDTO(userId, userIdToFollow);
        ResponseEntity<ResponseDTO> response;
        userService.follow(followPostDTO);
        return new ResponseEntity<>(new ResponseDTO("Accion realizada con exito.", 200),HttpStatus.OK);
    }

    //US 0002: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
    //Recibe Integer
    //Retorna FollowersCountDTO
    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<FollowersCountDTO> countFollowers(
            @PathVariable(value = "userId", required = true)
                @NotNull(message = "User_id can't be empty")
                @Positive(message = "User_id can't be less than 0")
                    Integer userId
    ) {
        return new ResponseEntity<>(userService.getFollowersCount(userId), HttpStatus.OK);
    }

    //US 0003: Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
    //Recibe Integer
    //Retorna FollowerListDTO
    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<FollowerListDTO> listFollowers(
            @PathVariable (value = "userId", required = true)
                @NotNull(message = "User_id can't be empty")
                @Positive(message = "User_id can't be less than 0")
                    Integer userId,
            @RequestParam(value = "order", required = false) String alf_order
    ) {
        return new ResponseEntity<>(userService.getFollowersList(userId, alf_order), HttpStatus.OK);
    }

    //US 0004: Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)
    //Recibe Integer
    //Retorna FollowedListDTO
    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<FollowedListDTO> listFollowed(
            @PathVariable (value = "userId", required = true)
                @NotNull(message = "User_id can't be empty")
                @Positive(message = "User_id can't be less than 0")
                    Integer userId,
            @RequestParam(value = "order", required = false) String alf_order) {
        return new ResponseEntity<>(userService.getFollowedList(userId, alf_order), HttpStatus.OK);
    }

    //US 0005: Dar de alta una nueva publicación
    //Recibe PostProductDTO
    //Retorna status code
    @PostMapping("/products/post")
    public ResponseEntity<?> createPost(@RequestBody @Valid PostProductDTO postProductDTO){
        userService.createPost(postProductDTO);
        return new ResponseEntity<>("Se ha creado el post!", HttpStatus.OK);
    }



    /**
     * US 0006: Obtener un listado de las publicaciones realizadas por los vendedores que un usuario
     *     sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha,
     *     publicaciones más recientes primero).
     *
     * @param userId Integer
     * @param alf_order String
     * @return ResponseEntity<PostBySellerDTO>
     */
    @GetMapping("/products/followed/{user_id}/list")
    public ResponseEntity<PostBySellerDTO> latestsPosts(
            @PathVariable(value = "user_id", required = true)
                @NotNull(message = "User_id can't be empty")
                @Positive(message = "User_id can't be less than 0")
                    Integer userId,
            @RequestParam(value = "order", required = false) String alf_order){
        PostBySellerDTO latestPosts = userService.listPostsBySeller(userId, alf_order);
        return new ResponseEntity<>(latestPosts, HttpStatus.OK);
    }


    //US 0007: Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
    //Recibe FollowPostDTO
    //Retorna status code
    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollowUser(
            @PathVariable (value = "userId", required = true)
                @NotNull(message = "User_id can't be empty")
                @Positive(message = "User_id can't be less than 0")
                    Integer userId,
            @PathVariable int userIdToUnfollow) {
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

    /*//US 0010: Llevar a cabo la publicación de un nuevo producto en promoción
    @PostMapping("/products/promo-post")
    public ResponseEntity<?> newProductInSale() {
        return null;
    }

    //US 0011: Obtener la cantidad de productos en promoción de un determinado vendedor

    @GetMapping("/products/promo-post/count")
    public ResponseEntity<?> promoProductsCount(@RequestParam(value = "user_id", required = true) int userId) {
        return null;
    }

    //US 0012: OPCIONAL
    @GetMapping("/products/promo-post/list?user_id={userId}")
    public ResponseEntity<?> productsInSaleBySeller(
            @PathVariable (value = "userId", required = true)
                @NotNull(message = "User_id can't be empty")
                @Positive(message = "User_id can't be less than 0")
                    Integer userId
    ) {
        return null;
    }*/

}
