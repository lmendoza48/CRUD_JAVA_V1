# Java CRUD with Java 7 + Spring MVC + Spring Security  + Hibernate 4 + Maven 3 and MySql

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
# Crud For Rental Bike with Login User.

 * Conditional:

   1. Rental by hour, charging $5 per hour
   2. Rental by day, charging $20 a day
   3. Rental by week, changing $60 a week
   4. Family Rental, is a promotion that can include from 3 to 5 Rentals (of any type) with a discount of 30% of the total price
