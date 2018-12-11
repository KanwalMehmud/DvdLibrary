Drop database dvdlibary_test;
create database if not exists dvdlibary_test;
use dvdlibary_test;

CREATE TABLE IF NOT EXISTS `dvd` (
 `dvdId` int(11) NOT NULL AUTO_INCREMENT,
 `title` varchar(50) NOT NULL,
 `releaseDate` date ,
 `mpaaRating` varchar(50) NOT NULL,
 `directorName` varchar(50) NOT NULL,
 `studio` varchar(50) NOT NULL,
  `userRating` varchar(50) Default NULL,
 PRIMARY KEY (`dvdId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=23 ;


insert into dvd (title, releaseDate, mpaaRating, directorName, studio, userRating) values ('Super Mantest','2012/12/22','5','Sue Alan','Marvel','4');
insert into dvd (title, releaseDate, mpaaRating, directorName, studio, userRating) values ('Dvd1test','2010/12/22','5','Sue Alan','Marvel','4');


select * from dvd;