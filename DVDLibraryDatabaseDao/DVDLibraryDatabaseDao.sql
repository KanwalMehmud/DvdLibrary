Drop database dvdlibary;
create database if not exists DvdLibary;
use DvdLibary;

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


insert into dvd (title, releaseDate, mpaaRating, directorName, studio, userRating) values ('Super Man','2012/12/22','5','Sue Alan','Marvel','4');
insert into dvd (title, releaseDate, mpaaRating, directorName, studio, userRating) values ('Dvd1','2010/12/22','5','Sue Alan','Marvel','4');
insert into dvd (title, releaseDate, mpaaRating, directorName, studio, userRating) values ('Dvd2','2011/10/15','3','Mary Jane','Marvel','5');
insert into dvd (title, releaseDate, mpaaRating, directorName, studio, userRating) values ('Dvd3','2013/1/24','5','Sue Alan','Marvel','0');
insert into dvd (title, releaseDate, mpaaRating, directorName, studio, userRating) values ('Dvd4','2016/2/20','3','Bob Billy','Marvel','5');
insert into dvd (title, releaseDate, mpaaRating, directorName, studio, userRating) values ('Dvd5','2015/3/18','1','Sue Alan','Marvel','5');
insert into dvd (title, releaseDate, mpaaRating, directorName, studio, userRating) values ('Dvd6','2014/2/03','5','Mary Jane','Marvel','4');
insert into dvd (title, releaseDate, mpaaRating, directorName, studio, userRating) values ('Dvd7','2018/5/18','4','Sue Alan','Marvel','2');


select * from dvd;