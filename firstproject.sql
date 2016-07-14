/*
SQLyog Trial v12.2.4 (64 bit)
MySQL - 5.1.22-rc-community : Database - firstproject
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`firstproject` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `firstproject`;

/*Table structure for table `cppquestions` */

DROP TABLE IF EXISTS `cppquestions`;

CREATE TABLE `cppquestions` (
  `Qno` int(20) NOT NULL AUTO_INCREMENT,
  `Question` longblob NOT NULL,
  `a` longblob NOT NULL,
  `b` longblob NOT NULL,
  `c` longblob NOT NULL,
  `d` longblob NOT NULL,
  `cans` char(1) NOT NULL,
  KEY `Qno` (`Qno`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

/*Data for the table `cppquestions` */

insert  into `cppquestions`(`Qno`,`Question`,`a`,`b`,`c`,`d`,`cans`) values 
(1,'Which of the following type of class allows only one object of it to be created?','Singleton','Abstract','Virtual','Anonymous','a'),
(2,'Which of the following is not a type of constructor?','Copy constructor','Friend Constructor','','Parameterized','b'),
(3,'Which of the following is not the member of class?','static','friend','virtual','const','b'),
(4,'Which of the following concepts means determining at runtime what method to invoke?','Data hiding','Dynamic Typing','Dynamic binding','Dynamic loading','c'),
(5,'How many instances of an abstract class can be created?','1','2','13','0','d'),
(6,'Which of the following concepts of OOPS means exposing only necessary information to client?','encapsulation','abstraction','data hiding','data binding','c'),
(7,'cout is a/an __________ .','operator','function','object','macro','c'),
(8,'How many types of polymorphisms are supported by C++?','1','2','3','4','b'),
(9,'Which of the following is an abstract data type?','int','double','string','Class','d'),
(10,'Which of the following approach is adapted by C++','Top-down','Bottom-up','Right-left','Left-Right','b'),
(11,' Which operator is having the highest precedence?','postfix','unary','shift','equality','a'),
(12,'What is this operator called ?: ?','conditional','relational','casting operator','none','a');

/*Table structure for table `cquestions` */

DROP TABLE IF EXISTS `cquestions`;

CREATE TABLE `cquestions` (
  `Qno` int(20) NOT NULL AUTO_INCREMENT,
  `Question` longblob NOT NULL,
  `a` longblob NOT NULL,
  `b` longblob NOT NULL,
  `c` longblob NOT NULL,
  `d` longblob NOT NULL,
  `cans` char(1) NOT NULL,
  KEY `Qno` (`Qno`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

/*Data for the table `cquestions` */

insert  into `cquestions`(`Qno`,`Question`,`a`,`b`,`c`,`d`,`cans`) values 
(1,'What does C stand for?','coding','computer','classes','concept of OOPs','b'),
(2,'extern int i; What is it?','declaration','definition','function','error','a'),
(3,'A float is 4 bytes. Double is 8 bytes.','True ','False','First is true','Second is true','a'),
(4,'Associativity has no role to play unless the precedence of operator is same.','True','False','Maybe','None','a'),
(5,'Bitwise & can be used to divide a number by powers of 2','True','False','Maybe','None','b'),
(6,'The keyword used to transfer control from a function back to the calling function is','switch','goto','goback','return','d'),
(7,'The library function used to find the last occurrence of a character in a string is','strlen()','laststr()','strstr()','strrchr()','d'),
(8,'Bit fields can\'t be used in union?','True','False','Maybe','None','b'),
(9,'The first argument to be supplied at command-line must always be count of total arguments.','True','False','Maybe','None','b'),
(10,'How will you free the allocated memory ?','remove(var-name)','free(var-name)','dalloc(var-name)','delete(var-name)','b'),
(11,'Following is the invalid inclusion of a file to the current program. Identify it.','#include <file>','#include ?file?','#include < file','all are invalid','c');

/*Table structure for table `javaquestions` */

DROP TABLE IF EXISTS `javaquestions`;

CREATE TABLE `javaquestions` (
  `Qno` int(11) NOT NULL AUTO_INCREMENT,
  `Question` longblob NOT NULL,
  `a` longblob NOT NULL,
  `b` longblob NOT NULL,
  `c` longblob NOT NULL,
  `d` longblob NOT NULL,
  `cans` char(1) NOT NULL,
  PRIMARY KEY (`Qno`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `javaquestions` */

insert  into `javaquestions`(`Qno`,`Question`,`a`,`b`,`c`,`d`,`cans`) values 
(1,'Which of these is not a valid keyword or reserved word in Java?','private','public','string','volatile','c'),
(2,'A class can have many methods with the same name. What is this OOP concept called?','Method Invocating','Method Overriding','Method labelling','Method Overloading','d'),
(3,'Which statement is true?','Hash table is a subclass of directory','ArrayList is a subclass of vector','Linked list is a subclass of ArrayList','Vector is a subclass of Stack','a'),
(4,'How many data types are supported by Java?','2','4','6','8','c'),
(5,'What is the range of data type short in Java?','-128 to 127','-32768 to 32767','-2147483648 to 2147483647','none','b'),
(6,'An expression involving byte, int, and literal numbers is promoted to which of these','int','long','byte','float','a'),
(7,'Which of these literals can be contained in a data type float variable?',' 1.7e-308','3.4e-038','1.7e+308','3.4e-050','b'),
(8,'Which data type value is returned by all transcendental math functions?','int','float','double','long','c'),
(9,'Which of these coding types is used for data type characters in Java?','ASCII','ISO-LATIN-1','UNICODE','none','c'),
(10,'Which one is a valid declaration of a boolean?','boolean b1 = 1;','boolean b2 = ?false?;','boolean b3 = false;',' boolean b4 = ?true?','c');

/*Table structure for table `login` */

DROP TABLE IF EXISTS `login`;

CREATE TABLE `login` (
  `Username` varchar(30) DEFAULT NULL,
  `Password` varchar(30) DEFAULT NULL,
  `Id` int(8) NOT NULL,
  `Usertype` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `login` */

insert  into `login`(`Username`,`Password`,`Id`,`Usertype`) values 
(NULL,NULL,1689654,'admin'),
('thisismuskan','muskanagarwal',1693796,'Student'),
('samnahar','sambhav',1872269,'Student'),
('kiaraagarwal','kiara',2141945,'Student'),
('muskan1308','muskanadmin',2345678,'admin'),
('vikaskhandelwal','vikas',4171326,'Student'),
('kantagarwal','kanta',4399287,'admin'),
('shivaniagarwal','shivani',4939225,'Student'),
('swatiyadav','swatiyadav',6453724,'Student'),
('madhuragarwal','madhuragarwal',7483111,'admin'),
('ayushivijay','ayushi',7551976,'Student'),
('ramavtar','ramavtar',7931832,'Student'),
('surendraagarwal','surendraadmin',8353869,'admin'),
('ayushivijay','ayushi',9861949,'Student');

/*Table structure for table `registration` */

DROP TABLE IF EXISTS `registration`;

CREATE TABLE `registration` (
  `name` varchar(40) DEFAULT NULL,
  `fathersname` varchar(40) DEFAULT NULL,
  `mobilenumber` varchar(100) DEFAULT NULL,
  `emailid` varchar(40) DEFAULT NULL,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `id` int(8) NOT NULL,
  `usertype` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `registration` */

insert  into `registration`(`name`,`fathersname`,`mobilenumber`,`emailid`,`username`,`password`,`id`,`usertype`) values 
('Madhur','Surendra','8752425327','madhuragarwal21@gmail.com','madhuragarwal','madhuragarwal',1234567,'Student'),
('Muskan','Surendra','9529726133','muskan1308@yahoo.in','muskanroxx','muskanagarwal',1693796,'Student'),
('Sambhav','Sunil','9352522884','samnahar@gmail.com','samnahar','sambhav',1872269,'Student'),
('Shivani','Suraj','774934201','shivani@gmail.com','shivaniagarwal','shivani',4939225,'Student'),
('Swati','Sunil','887560332','swati.yadav@gmail.com','swatiyadav','swatiyadav',6453724,'Student'),
('Ramu','parmanand','62492830','ramu@gmail.com','ramavtar','ramavtar',7931832,'Student');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
