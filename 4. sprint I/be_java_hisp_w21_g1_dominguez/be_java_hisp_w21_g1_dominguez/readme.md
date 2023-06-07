# C. Requerimiento Bonus

Obtener la cantidad de publicaciones de productos totales (sin promo y con promo) de todos los vendedores (Que Sigo!).

## Method

GET

## SIGN

- /users/{userId}/followed/products/count

## Example

- /users/4698/followed/products/count

## Payload

{

	“user_id”: 4698,
	“followed”: [
		{
			“user_id”: 234,
			“user_name”: “vendedor1”,
			“total_products_count”: 9
		},
		{
			“user_id”: 567,
			“user_name”: “vendedor2”,
			“total_products_count”: 6
		}
		
	] 

}

## Filtros / Parametros

- Parámetros: userId
- Tipo: int
- Descripción/Ejemplo : Número que identifica a cada usuario
