drop schema if exists ms;
create schema ms;

drop table if exists ms.manufacturer;
create table ms.manufacturer (
  id int primary key not null auto_increment,
  name varchar(30) unique,
  active boolean
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

drop table if exists ms.model_hold_bikez;
create table ms.model_hold_bikez (
  url varchar(255) primary key not null,
  manufacturer varchar(50),
  modelName varchar(150),
  modelYear varchar(10),
  attrCount int
);
drop index model_url_I on model_hold_bikez;
create index model_url_I ON model_hold_bikez (url);

drop table if exists ms.modelAttribute_hold_bikez;
create table ms.modelAttribute_hold_bikez (
  id int primary key not null auto_increment,
  url varchar(255) not null,
  attrName varchar(50),
  attrValue varchar(4096),
  FOREIGN KEY (url) REFERENCES ms.model_hold_bikez(url) ON DELETE CASCADE
);
drop index modelattribute_url_I on modelAttribute_hold_bikez;
create index modelattribute_url_I ON modelAttribute_hold_bikez (url);
drop index modelattribute_name_I on modelAttribute_hold_bikez;
create index modelattribute_name_I ON modelAttribute_hold_bikez (attrName);