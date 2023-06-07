# Individual + bonus

El desarrollo se llevo a cabo en conjunto, ya que los cambios propuestos en bonus  
terminaron modificando un poco el desarrollo individual y grupal.  
Tal es asi que los requerimientos funcionales no estan tal cual fueron especificados.
Esto no fue consultado con el usuario, a efectos praticos tome la consigna de cualquier propuesta de mejora.

## Token

Observe que es pasaba un `user_id` en todos lados para identificarse.
Lo que hice fue dos nuevos endpoint, uno para crear un usuario,
a este se le pide nombre y un password.
Y otro endpoint para loguear al usuario y devolver un token random.

Con ese token se identificara al usuario, por tanto para poder seguir a alguien
o realizar acciones en su nombre necesita un token que se genera con la password secreta del usuario.

## Product y post

Como grupo se decidio poner la entidad entera de product dentro de post.
A raiz de esto, propongo que se guarde solo una referencia como un id.

El campo product_id aun sigue estando, pero, si se pasa un product_id que
ya tenga cargado se utilizara ese antes del que se envie.
Tranquilamente se podria sacar este campo, pero opte por dejarlo ya que podria ser
la referencia de un product en otro sistema. (Asi lo pense)

## Promo

Las promos se guardan como `Post` comunes, y la entidad `PromoPost` guarda la referencia al
Post y el resto de datos.
En caso de que `has_promo` sea `false` el `discount` se setea en 0.

## Otros

Algunas propuesta que preferi dejar de lado fueron:
- renombrar algunos endpoint, me parece que algunos endpoints podrian tener una esctructura similar.
- separar el `User` en `Buyer` y `Seller`
- crear endpoint get de `Post`

