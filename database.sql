create database studentCourses;
use studentCourses;
create table user(
user_id int primary key,
first_name varchar(20),
middle_name varchar(10),
last_name varchar(20),
email_id varchar(50),
mobile_number varchar(50),
user_password varchar(30),
marks_id int ,
constraint foreign key (marks_id) references user(marks_id)
);
create table address( 
address_id int primary key,
user_id int,
city varchar(30),
state varchar(30),
pincode varchar(6),
constraint foreign key (user_id) references user(user_id)
);
create table studentmarks (
marks_id int primary key,
ssc_marks double
);
