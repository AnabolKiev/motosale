drop schema if exists ms;
create schema ms;
/*-----------------------------------------------------------------------------------*/
drop table if exists ms.model_hold_bikez;
create table ms.model_hold_bikez (
  url varchar(255) primary key not null,
  manufacturer varchar(50),
  modelName varchar(150),
  modelYear varchar(10),
  attrCount int
);
drop index model_url_I on model_hold_bikez;
create index model_url_I ON ms.model_hold_bikez (url);

drop table if exists ms.modelAttribute_hold_bikez;
create table ms.modelAttribute_hold_bikez (
  id int primary key not null auto_increment,
  url varchar(255) not null,
  attrName varchar(50),
  attrValue varchar(4096),
  FOREIGN KEY (url) REFERENCES ms.model_hold_bikez(url) ON DELETE CASCADE
);
drop index modelattribute_url_I on modelAttribute_hold_bikez;
create index modelattribute_url_I ON ms.modelAttribute_hold_bikez (url);
drop index modelattribute_name_I on modelAttribute_hold_bikez;
create index modelattribute_name_I ON ms.modelAttribute_hold_bikez (attrName);
/*-----------------------------------------------------------------------------------*/
drop table if exists ms.manufacturer;
create table ms.manufacturer (
  id int primary key not null auto_increment,
  name varchar(30) unique,
  active boolean
);

drop table if exists ms.category;
create table ms.category (
  id int primary key not null auto_increment,
  name varchar(30) unique,
  nameeng varchar(30) unique
);

drop table if exists ms.coolingtype;
create table ms.coolingtype (
  id int primary key not null auto_increment,
  name varchar(15) unique,
  nameeng varchar(15) unique
);

drop table if exists ms.enginetype;
create table ms.enginetype (
  id int primary key not null auto_increment,
  name varchar(50) unique,
  nameeng varchar(50) unique
);

drop table if exists ms.startertype;
create table ms.startertype (
  id int primary key not null auto_increment,
  name varchar(20) unique,
  nameeng varchar(20) unique
);

drop table if exists ms.startertype;
create table ms.startertype (
  id int primary key not null auto_increment,
  name varchar(20) unique,
  nameeng varchar(20) unique
);

drop table if exists ms.finaldrivetype;
create table ms.finaldrivetype (
  id int primary key not null auto_increment,
  name varchar(30) unique,
  nameeng varchar(30) unique
);

drop table if exists ms.model;
create table ms.model (
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


acceleration100 		'0-100 km/h (0-62 mph):' decimal [unsigned]
quotertime 				'1/4 mile (0.4 km):'	decimal [unsigned]
acceleration60_140		'60-140 km/h (37-87 mph), highest gear:'	decimal [unsigned]
altseatheigth			'Alternate seat height:' smallint
borestroke				'Bore x stroke:' varchar(30)
carrying				'Carrying capacity:' varchar(255)
categoryID				'Category:'	dictionary
clutch					'Clutch:' varchar(255)
colors					'Color options:' varchar(300)
comments				'Comments:' varchar(2048)
compression				'Compression:' varchar(10)
coolingID				'Cooling system:' dictionary
displacement			'Displacement:' decimal [unsigned]
driveline				'Driveline:' varchar(255)
dryweight				'Dry weight:' decimal [unsigned]
electrical				'Electrical:' varchar(255)
emission				'Emission details:' varchar(255)
engine					'Engine details:' varchar(255)
enginetypeID			'Engine type:' dictionary
exhaust					'Exhaust system:' varchar(255)
frame					'Frame type:' varchar(255)
frontbrakesdiameter		'Front brakes diameter:' decimal [unsigned]
frontbrakes				'Front brakes:' varchar(255)
fronweightperc			'Front percentage of weight:' decimal [unsigned]
fronsuspension			'Front suspension:' varchar(255)
fronttyre				'Front tyre:' varchar(30)
fronttravel				'Front wheel travel:' decimal [unsigned]
fuelcapacity			'Fuel capacity:' decimal [unsigned]
consumtion				'Fuel consumption:' decimal [unsigned]
fuelcontrol				'Fuel control:' varchar(50)
fuelsystem				'Fuel system:' varchar(300)
gearbox					'Gearbox:' varchar(30)
co2						'Greenhouse gases:' decimal [unsigned]
clearance				'Ground clearance:' smallint
ignition				'Ignition:' varchar(255)
instruments				'Instruments:' varchar(512)
light					'Light:' varchar(255)
lubricatios				'Lubrication system:' varchar(255)
maxRPM					'Max RPM:' smallint
name					'Model:' varchar(100)
modifications			'Modifications compared to previous model:' varchar(2048)
oilcapacity				'Oil capacity:' decimal [unsigned]
height					'Overall height:' smallint
length					'Overall length:' smallint
width					'Overall width:' smallint
powerweight				'Power/weight ratio:' decimal [unsigned]
power					'Power:' varchar(40)
price					'Price as new (MSRP):'varchar(10)
rake					'Rake (fork angle):' decimal [unsigned]
rearbrakesdiameter		'Rear brakes diameter:' decimal [unsigned]
rearbrakes				'Rear brakes:' varchar(200)
rearweightprc			'Rear percentage of weight:' decimal [unsigned]
rearsuspension			'Rear suspension:' varchar(255)
reartyre				'Rear tyre:' varchar(30)
reartravel				'Rear wheel travel:' decimal [unsigned]
reservefuel				'Reserve fuel capacity:' decimal [unsigned]
seatheight				'Seat height:' smallint
seat					'Seat:' varchar(255)
starter					'Starter:' dictionary
topspeed				'Top speed:' decimal [unsigned]
torque					'Torque:' varchar(60)
trail					'Trail:' smallint
finaldrive				'Transmission type, final drive:' dictionary
valverpercylinder		'Valves per cylinder:' smallint
wetweight				'Weight incl. oil, gas, etc:' decimal [unsigned]
wheelbase				'Wheelbase:' decimal [unsigned]
wheels					'Wheels:' varchar(255)
year					'Year:' smallint


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
