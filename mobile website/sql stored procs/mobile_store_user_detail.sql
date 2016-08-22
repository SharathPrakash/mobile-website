create table `user_detail`(
`id` varchar(45)not null AUTO_INCREMENT,
`emailId` varchar(45) not null,
`firstName` varchar(45),
`lastName` varchar(45),
`securityKey` varchar(45),
`address` varchar(100),
`city` varchar(45),
`state` varchar(45),
`pincode` int not null,
`mobnum` double not null
primary key(`emailId`));







insert into user_detail (emailId,firstName,lastName,passwor,address,state,city,pincode,mobnum)
 values(emailId,firstName,lastName,passwor,address,state,city,pincode,mobnum);