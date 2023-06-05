package com.example.be_java_hisp_w21_g1.Controller;

import com.example.be_java_hisp_w21_g1.DTO.Request.PostProductDTO;
import com.example.be_java_hisp_w21_g1.DTO.Response.FollowedListDTO;
import com.example.be_java_hisp_w21_g1.DTO.Response.PostDTO;
import com.example.be_java_hisp_w21_g1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class  Controller {
    @Autowired
    UserService userService;

    //US 0001: Poder realizar la acción de “Follow” (seguir) a un determinado vendedor
    //Recibe FollowPostDTO
    //Retorna status code
    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> follow(@PathVariable int userId, @PathVariable int userIdToFollow){
        return null;
    }

    //US 0002: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
    //Recibe UserIdDTO
    //Retorna FollowersCountDTO
    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<?> countFollowers(@PathVariable int userId){
        return null;
    }

    //US 0003: Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
    //Recibe UserIdDTO
    //Retorna FollowerListDTO
    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<?> listFollowers(@PathVariable int userId){
        return null;
    }

    //US 0004: Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)
    //Recibe UserIdDTO
    //Retorna FollowedListDTO
    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<?> listFollowed(@PathVariable int userId){
        return null;
    }

    //US 0005: Dar de alta una nueva publicación
    //Recibe PostProductDTO
    //Retorna status code
    @PostMapping("/products/post")
    public ResponseEntity<?> postProduct(@RequestBody PostProductDTO body){
        return null;
    }

    //US 0006: Obtener un listado de las publicaciones realizadas por los vendedores que un usuario
    // sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha,
    // publicaciones más recientes primero).
    //Recibe UserIdDTO
    //Retorna PostBySeller
    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<?> latestsPosts(@PathVariable int userId){
        return null;
    }


    //US 0007: Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
    //Recibe FollowPostDTO
    //Retorna status code
    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollowUser(@PathVariable int userId, PathVariable userIdToUnfollow) {
        return null;
    }

    //US 0008: Ordenamiento alfabético ascendente y descendente
    @GetMapping("/users/{UserId}/followers/list?order=name_asc")
    public ResponseEntity<?> orderFollowersBy(@PathVariable int userId, @RequestParam(value = "order", required = true) String alf_order){
        return null;
    }

    @GetMapping("/users/{UserID}/followed/list?order=name_asc")
    public ResponseEntity<?> orderFollowedBy(@PathVariable int userId, @RequestParam(value = "order", required = true) String alf_order){
        return null;
    }

    //US 0009: Ordenamiento por fecha ascendente y descendente
    /*
    * /products/followed/{userId}/list?order=date_asc
    /products/followed/{userId}/list?order=date_desc
    */
    @GetMapping("products/followed/{userId}/list")
    public ResponseEntity<?> orderProductsBy(@PathVariable int userId, @RequestParam(value = "order", required = true) String dateOrder){
        return null;
    }


    //US 0010: Llevar a cabo la publicación de un nuevo producto en promoción
    @PostMapping("/products/promo-post")
    public ResponseEntity<?> newProductInSale() {
        return null;
    }

    //US 0011: Obtener la cantidad de productos en promoción de un determinado vendedor

    @GetMapping("/products/promo-post/count")
    public ResponseEntity<?> promoProductsCount(@RequestParam(value = "user_id", required = true) int userId){
        return null;
    }

    //US 0012: OPCIONAL
    @GetMapping("/products/promo-post/list?user_id={userId}")
    public ResponseEntity<?> productsInSaleBySeller(@PathVariable int userId){
        return null;
    }

}
