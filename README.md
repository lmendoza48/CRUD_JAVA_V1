# CRUD JAVA with Spring MVC + Hibernate 4 + Maven 3

******************************************************************************************************************************************
******************************************************************************************************************************************

## Tables used:
**** User, Model -->> 'UserData' configuration:

CREATE TABLE `userInfo` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `dni` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `rolUser` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

***** Order, Model -->> 'OrderModel' configuration:

CREATE TABLE `orderData` (
  `idOrder` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(45) NOT NULL,
  `countBike` int(10) NOT NULL,
  `totalDays` int(10) NOT NULL,
  `totalPays` decimal(10,2) NOT NULL,
  `idUser` int(10) NOT NULL,
   PRIMARY KEY (`idOrder`),
   FOREIGN KEY (idUser) REFERENCES userInfo(idUser)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

******************************************************************************************************************************************
******************************************************************************************************************************************
******************************************************************************************************************************************
