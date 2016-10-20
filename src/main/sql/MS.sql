drop schema if exists ms;
create schema ms;

drop table if exists ms.manufacturer;
create table ms.manufacturer (
  id int primary key not null auto_increment,
  name varchar(30) unique
);

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
  endDate date,
  FOREIGN KEY (manufacturerId) REFERENCES ms.manufacturer(id) ON DELETE CASCADE
);