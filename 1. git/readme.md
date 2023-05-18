##################################################
##  Resumen comandos Git                        ##
##  ====================                        ##
##                                              ##
##  Juan Manuel Martin Mora                     ##
##                                              ##
##  Bootcamp Wave 21                            ##
##                                              ##
##################################################


Configuración de git
====================
# Para configuración específica del proyecto, quitar --global

# configuración del nombre
git config --global user.name "John Doe"

# configuración del email
git config --global user.email johndoe@example.com

# para activar el color en los diff
git config --global color.diff auto


Configuración de un repositorio privado (acceso SSH)
====================================================
# situarse en el directorio del proyecto y poner:
git clone --bare /home/usuario/proyecto/.git /home/usuario/repositorio/nombre-proyecto
# ya tenemos un repositorio remoto

# eliminar el proyecto y bajarse una copia del repositorio remoto
git clone usuario@maquina:repositorio/nombre-proyecto/


.gitignore (para ignorar archivos en git)
=========================================
Los archivos sólo se ignoran si previamente no se han añadido al index,
es decir, deben aparecer como "Untracked files".


# ejemplo de archivo .gitignore
===============================
# Ignorar los siguientes archivos
proyecto/archivo1.txt
proyecto/archivo2.txt

# Ignorar archivos ocultos de Eclipse
.classpath
.project

# No ignorar este archivo
!.gitignore

# Ignorar un directorio completo
directorio/*


Comandos generales en git
=========================
# inicializar repositorio
git init

# commit sobre el repositorio local
git commit -am "mensaje del commit"

# estado del repositorio local
git status

# Añadir nuevos archivos al index
git add *

# Eliminar archivos del index
git rm file1 file2

# Actualizar el index con los archivos eliminados.
# Evita tener que hacer git rm file1 file2 file3 ...
git add -u

# diferencias entre versiones
git diff --cached

# traer los cambios de todas las ramas remotas, sin actualizar ninguna rama local
git fetch

# comparar los cambios entre una rama local y una remota
git diff rama_local rama_remota

# efectuar los cambios en la rama local actual
git merge rama_remota

# o bien simplemente usar:
git pull

# Ejemplo:
# actualizar la rama actual del repositorio local con los últimos cambios
# de la rama "master" del repositorio remoto
git pull usuario@maquina:/ruta/al/repositorio master

# info del repositorio local
git config -l

# info del repositorio remoto (p.e. para ver ramas remotas)
git remote show origin

# Añadir un repositorio remoto
git remote add <nombre_repositorio>
# Ejemplo:
# Traer todos los cambios desde un repositorio remoto llamado "repo_ejemplo"
git fetch repo_ejemplo
# y luego aplicar los cambios de la rama remota "master" a la rama actual
git merge repo_ejemplo/master

# Eliminar un repositorio remoto (dejar de seguirlo)
git remote rm <nombre_repositorio>

# "congelar" y poner los cambios actuales a salvo, sin hacer commit, para volver más tarde a ellos
git stash

# recuperar los cambios
git stash apply

# limpiar el stash
git stash clear


Manejando ramas
===============
# crear un branch local
git branch nuevo_branch

# cambiar a otro branch
git checkout nombre_branch

# crear un branch y cambiarse a este inmediatamente
git checkout -b nuevo_branch

# crear un branch que apunte a uno remoto
git branch nuevo_branch origin/nombre_branch

# crear un branch que apunte a uno remoto y cambiarse a este inmediatamente
git checkout -b nuevo_branch origin/nombre_branch

# fusionar un branch con el actual
git merge nuevo_branch

# crear una rama remota o actualizarla:
git push origin nuevo_branch
# debe existir también una rama local "nuevo_branch"

# listar los branch locales
git branch

# listar los branch remotos
git branch -r

# listar todos los branch
git branch -a

# renombrar un branch
git branch -m oldname newname

# eliminar un branch
git branch -d nombre_branch


Eliminación de archivos / Volviendo atrás
=========================================
# descartar cambios en un archivo y volver a la última versión
git checkout -- ruta_archivo

# volver a una versión concreta de un archivo
git checkout HASH -- ruta_archivo

# modificar un antiguo commit (se modifica sólo ese commit):
git revert HASH

# Descartar todos los cambios (eliminando/añadiendo archivos) y
# volver a un estado concreto del proyecto:
# ¡Cuidado! ¡Esto elimina todos los commits hechos!
# No aplicarlo en commits anteriores a un git-push, ya que
# no podremos hacer push sobre el repositorio remoto.
git reset --hard HASH

# Para forzar el push en el repositorio remoto (NO RECOMENDABLE):
git push origin +master

# recuperar commits eliminados:
git reflog
# una vez identificado el commit a recuperar, hacer:
git reset --hard HASH


Manipulando commits
====================
# Modificar el último commit
git commit --amend

# Unir varios commits en uno. Se usa 'squash' para unir el commit con el anterior.
# ¡¡Sólo en el caso de no haber hecho ya un push al repositorio remoto!!
git rebase -i HASH

# Aplicar los cambios introducidos por uno o varios commit creando un nuevo commit
git cherry-pick HASH

# Crear patches con los cambios de la rama actual respecto de la rama develop
# Esto genera un archivo (patch) por cada commit, con el formato 00XX-<mensaje_commit>.patch
git format-patch develop

# Aplicar todos los parches almacenados en un directorio a la rama actual
# Esto crea un commit por cada parche
git am ruta_directorio/00*
