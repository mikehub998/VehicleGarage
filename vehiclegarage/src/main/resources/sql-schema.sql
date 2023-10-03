drop schema `garage`;
create schema if not exists `garage`;

use `garage`;

create table if not exists `customers` (
`id` int(10) not null auto_increment,
`firstName` varchar(40) not null,
`surname` varchar(40) not null,
primary key(`id`)
);

create table if not exists `vehicles` (
`id` int(10) not null auto_increment,
`vehicleMake` varchar(40) not null,
`vehicleModel` varchar(40) not null,
`engineSize` int(5) not null,
`transmission` varchar(40) not null,
cost int(10) not null,
primary key(`id`)
);



