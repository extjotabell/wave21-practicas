USE Empresa_Internet;

INSERT INTO Cliente VALUES
(1,"Juan Manuel","Martin Mora","34499756"),
(2,"Pepe","Langoni","33355321"),
(3,"Tremendo","Script","55978555"),
(4,"Juancito","Hermano","6584444"),
(5,"Javier","Flagus","38977895");


INSERT INTO Plan VALUES
(1,"PLan con internet y telefonia",300,"Incluir"),
(2,"Plan con internet y telefonia movil",100,"Hogar"),
(3,"Plan con internet y TV", 500,"hogar"),
(4,"Plan internet , TV y telefonia movil",500,"hogar"),
(5,"Enlace punto a punto", 1000,"Empresa");

INSERT INTO Paquete VALUES
(1,1,1),
(2,1,2),
(3,2,3),
(4,3,3),
(5,4,4),
(6,5,2),
(7,4,1);