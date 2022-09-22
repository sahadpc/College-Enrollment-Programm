create database studentCourses;
use studentCourses;
create table user(
userId int primary key,
firstname varchar(20),
middlename varchar(10),
lastname varchar(20),
emailid varchar(50),
mobileNumber varchar(50),
Userpassword varchar(30)
);
create table address( 
userId int,
city varchar(30),
state varchar(30),
pincode varchar(6),
constraint foreign key (userId) references user(userId)
);
create table studentMarks (
userId int,
sscMarks double,
constraint foreign key(userId) references user(userId)
);