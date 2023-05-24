Comandos Git

ls -> Listar contenido del directorio actual  
cd nombre-carpeta -> Acceder a una carpeta  
cd .. -> Retroceder de carpeta  
mkdir nombre-carpeta -> Crear una carpeta  
rm archivo -> Eliminar un archivo  
mv nombre1 nombre2 -> Cambiar nombre de un archivo  
touch archivo -> Crea un archivo de texto  
clear -> Limpiar pantalla de la consola  

git init -> crea el repositorio  
git add . / git add "archivo" -> Agrega al stage todos los archivos que hayamos creado en nuestro proyecto  
git status -> Verificar el estado de nuestro repo/saber en que branch estoy  
git commit -m "mensaje de commit"  
git clone "url del repo remoto a clonar" -> para descargar por primera vez un repo remoto a nuestra maquina  
Habiendo creado anteriormente un repo remoto y habeiendo configurado una identidad, para que nuestro repo local sepa donde queremos subir los cambios:  
	git remote add origin "url del repo remoto"  


git pull -> Traer cambios del remoto al local  
git push -> mandar cambios del local al remoto  

//Ver mas comandos en Drive -> Bootcamp -> Git
