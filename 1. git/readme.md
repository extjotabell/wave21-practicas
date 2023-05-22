# Comandos principales de Git

## Inicializar un repositorio

`git init`

Este comando se utiliza para crear un nuevo repositorio local en el directorio actual.

## Agregar cambios al área de preparación (staging)

`git add <archivo>`

Agrega un archivo específico al área de preparación (staging) para incluirlo en el próximo commit.

`git add .`

Agrega todos los archivos modificados y nuevos al área de preparación (staging) para incluirlos en el próximo commit.

## Realizar un commit

`git commit -m "mensaje del commit"`

Crea un nuevo commit con los cambios del área de preparación (staging) y lo guarda en el historial del repositorio.

## Vincular un repositorio remoto

`git remote add origin <URL del repositorio remoto>`

Establece una conexión entre el repositorio local y un repositorio remoto.

## Subir cambios al repositorio remoto

`git push origin <rama>`

Envía los commits locales de una rama específica al repositorio remoto.

## Traer los últimos cambios del repositorio remoto

`git pull origin <rama>`

Obtiene los commits remotos de una rama específica al repositorio local.

## Crear una nueva rama

`git branch <nombre de la rama>`

Crea una nueva rama con el nombre especificado.

## Cambiar a una rama específica

`git checkout <nombre de la rama>`

Cambia a la rama especificada y actualiza el directorio de trabajo con los archivos de esa rama.

## Resolver conflictos

Cuando hay conflictos entre dos ramas o archivos, Git muestra los conflictos y debes editar los archivos para resolverlos manualmente. Algunos comandos útiles son:

`git status`

Muestra los archivos con conflictos pendientes.

`git diff <archivo>`

Muestra las diferencias entre la versión local y la versión remota del archivo especificado.

