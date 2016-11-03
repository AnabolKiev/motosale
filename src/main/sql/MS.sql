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

drop table if exists ms.modelList;
create table ms.modelList (
  url varchar(255) primary key not null,
  manufacturer varchar(30)
);

drop table if exists ms.modelAttribute;
create table ms.modelAttribute (
  id int primary key not null auto_increment,
  url varchar(255) not null,
  attrName varchar(255),
  attrValue varchar(255),
  FOREIGN KEY (url) REFERENCES ms.modelList(url) ON DELETE CASCADE
);