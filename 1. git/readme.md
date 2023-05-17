CREAR RAMAS
git branch nombre_nueva_rama

CONOCER DONDE ESTAMOS PARADOS
git branch

CREAR UNA RAMA NUEVA A PARTIR DE OTRA Y POSICIONARSE EN ELLA
git checkout -b nueva_Rama_Nombre rama_Existente

CAMBIAR DE RAMA
git checkout otra_Rama

ELIMINAR RAMA (debe estar pasado en otra rama)
git branch -d nombre_Rama

COPIAR RAMA
git branch -c nombre_Rama nombre_Rama_Copia

VER DIFERENCIAS ENTRE RAMAS
git diff branch1 branch2

UNIFICAR (MERGEAR RAMAS)
git merge branchOrigen branchDestino

RESET
git reset HEAD~ --hard

TRAER CAMBIOS DE UN FILE CON CONFLICTOS Y LOS MUESTRA
git config pull.rebase false