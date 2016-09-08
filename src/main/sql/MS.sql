drop schema if exists ms;

create schema ms;

drop table if exists ms.ad;

create table ms.ad (
	id int primary key not null auto_increment,
    title varchar(255),
    description varchar(2048),
    manufacturerId int,
    modelId int,
    produceYear year,
    capacity int,
    mileage int,
    phone varchar(15),
    email varchar(30),
    startDate date,
    endDate date
 );