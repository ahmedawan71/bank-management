create database bankmanagementsystem;

show databases;

use bankmanagementsystem;

create table signup(formno varchar(20), name varchar(20), father_name varchar(20), dob varchar(20), gender varchar(20), email varchar(30), marital_status varchar(20), state varchar(25), city varchar(25), address varchar(40), pin varchar(20));

show tables;

select * from signup;

create table signuptwo(formno varchar(20), religion varchar(20), category varchar(30), income varchar(20), education varchar(20), occcupation varchar(20), pan varchar(20), cnic varchar(20), seniorcitizen varchar(20), existingaccount varchar(20)); 

create table signupthree(formno varchar(20), accountType varchar(40), cardNumber varchar(25), pinNumber varchar(10), facility varchar(100)); 
 
create table login(formno varchar(20), cardNumber varchar(25), pinNumber varchar(10)); 

select * from login;

create table bank(pin varchar(10), date varchar(50), type varchar(20), amount varchar(20));
  
SELECT * FROM bank; 

delete from bank where
pin = 9184;