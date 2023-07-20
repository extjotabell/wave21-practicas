CREATE SCHEMA IF NOT EXISTS `empresa_internet` DEFAULT CHARACTER SET utf8; 

CREATE TABLE IF NOT EXISTS `empresa_internet`.`CLIENTE` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `dni` VARCHAR(10) NOT NULL,
  `nombre` VARCHAR(20) NOT NULL,
  `apellido` VARCHAR(20) NOT NULL,
  `fecha_nacimiento` DATE NOT NULL,
  `provincia` VARCHAR(45) NULL DEFAULT NULL,
  `ciudad` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

INSERT INTO `CLIENTE` VALUES 
(1,'123456781','Pedro','Rodríguez','2001-05-29','Punta Carretas','Montevideo')
,(2,'123456781','María','Rodríguez','1930-09-22','Centro','Montevideo')
,(3,'123456781','Juan','Rodríguez','1992-07-10','Pocitos','Montevideo')
,(4,'123456781','Carlos','Rodríguez','1988-03-02','Las Piedras','Canelones')
,(5,'123456781','Benjamin','Rodríguez','1995-11-18','Cordon','Montevideo')
,(6,'123456781','Julieta','Rodríguez','1991-12-07','Salto','Salto')
,(7,'123456781','Matias','Rodríguez','1987-08-25','Buceo','Montevideo')
,(8,'123456781','Antonella','Rodríguez','1994-02-12','La Paz','Canelones')
,(9,'123456781','Victoria','Rodríguez','1993-06-30','Flores','Flores')
,(10,'123456781','Camila','Rodríguez','1990-04-08','Santana','Rivera');

CREATE TABLE IF NOT EXISTS `empresa_internet`.`PLAN` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cliente_id` INT NOT NULL,
  `precio` DECIMAL(2,0) NOT NULL,
  `descuento` DECIMAL(2,0) NOT NULL,
  `tipo_plan_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `cliente_id_idx` (`cliente_id` ASC) VISIBLE,
  INDEX `tipo_plan_id_idx` (`tipo_plan_id` ASC) VISIBLE,
  CONSTRAINT `cliente_id`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `empresa_internet`.`CLIENTE` (`id`)
    ON DELETE NO ACTION
    ON UPDATE RESTRICT,
  CONSTRAINT `tipo_plan_id`
    FOREIGN KEY (`tipo_plan_id`)
    REFERENCES `empresa_internet`.`PLAN` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `PLAN` VALUES (1,1,0,1,1),(2,3,5,2,1),(3,5,10,3,2),(4,6,15,4,3),(5,7,20,5,4);

CREATE TABLE IF NOT EXISTS `empresa_internet`.`TIPO_PLAN` (
  `id` INT NOT NULL AUTO_INCREMENT,CLIENTE
  `nombre` VARCHAR(45) NOT NULL,
  `velocidad` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

INSERT INTO `tipo_plan` VALUES (1,'Básico',10),(2,'Estándar',20),(3,'Pro',50),(4,'Pro Pro',100);




