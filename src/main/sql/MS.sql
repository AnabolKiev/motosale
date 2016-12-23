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
  active boolean not null default false
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
  name varchar(20) unique,
  nameeng varchar(20) unique 
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

drop table if exists ms.finaldrivetype;
create table ms.finaldrivetype (
  id int primary key not null auto_increment,
  name varchar(30) unique,
  nameeng varchar(30) unique
);

drop table if exists ms.model;
create table ms.model (
  id					int primary key not null auto_increment,
  name					varchar(100), 		-- 'Model:' 
  year					smallint, 			-- 'Year:'
  manufacturerId		int,
  categoryID			int, 				-- 'Category:'
  borestroke			varchar(30), 		-- 'Bore x stroke:'
  compression			varchar(10), 		-- 'Compression:'
  coolingID				int, 				-- 'Cooling system:'
  displacement			decimal(7,2) unsigned, 	-- 'Displacement:'
  engine				varchar(255), 		-- 'Engine details:'
  engineeng				varchar(255), 		-- 'Engine details:'
  enginetypeID			int, 				-- 'Engine type:'
  lubrications			varchar(255), 		-- 'Lubrication system:'
  lubricationseng		varchar(255), 		-- 'Lubrication system:'
  maxRPM				int, 				-- 'Max RPM:'
  oilcapacity			decimal(5,2) unsigned, 	-- 'Oil capacity:'
  valverpercylinder		smallint, 			-- 'Valves per cylinder:'
  frame					varchar(255), 		-- 'Frame type:'
  frameeng				varchar(255), 		-- 'Frame type:'
  gearbox				varchar(30), 		-- 'Gearbox:'
  gearboxeng			varchar(30), 		-- 'Gearbox:'
  finaldriveID			int, 				-- 'Transmission type, final drive:'
  clutch				varchar(255), 		-- 'Clutch:'
  clutcheng				varchar(255), 		-- 'Clutch:'
  height				int unsigned, 	-- 'Overall height:'
  length				int unsigned, 	-- 'Overall length:'
  width					int unsigned, 	-- 'Overall width:'
  dryweight				decimal(5,1) unsigned, 	-- 'Dry weight:'
  wetweight				decimal(5,1) unsigned, 	-- 'Weight incl. oil, gas, etc:'
  wheelbase				smallint unsigned, 	-- 'Wheelbase:' 
  clearance				smallint, 			-- 'Ground clearance:'
  carrying				varchar(255), 		-- 'Carrying capacity:'
  carryingeng			varchar(255), 		-- 'Carrying capacity:'
  seatheight			smallint, 			-- 'Seat height:'
  altseatheight			smallint, 			-- 'Alternate seat height:'
  seat					varchar(255), 		-- 'Seat:'
  seateng				varchar(255), 		-- 'Seat:'
  power					varchar(40), 		-- 'Power:' 
  torque				varchar(60), 		-- 'Torque:'
  powerweight			decimal(5,4) unsigned, 	-- 'Power/weight ratio:'
  topspeed				decimal(4,1) unsigned, 	-- 'Top speed:'
  acceleration100		decimal(6,3) unsigned, 	-- '0-100 km/h (0-62 mph):'
  acceleration60_140	decimal(6,3) unsigned, 	-- '60-140 km/h (37-87 mph), highest gear:'
  quotertime			decimal(6,3) unsigned, 	-- '1/4 mile (0.4 km):'
  ignition				varchar(255), 		-- 'Ignition:'
  ignitioneng			varchar(255), 		-- 'Ignition:'
  starterID				int, 				-- 'Starter:'
  light					varchar(255), 		-- 'Light:'
  lighteng				varchar(255), 		-- 'Light:'
  emission				varchar(255), 		-- 'Emission details:'
  emissioneng			varchar(255), 		-- 'Emission details:'
  exhaust				varchar(255), 		-- 'Exhaust system:'
  exhausteng			varchar(255), 		-- 'Exhaust system:'
  co2					decimal(6,1) unsigned, 	-- 'Greenhouse gases:'
  fuelcontrol			varchar(50), 		-- 'Fuel control:'
  fuelcontroleng		varchar(50), 		-- 'Fuel control:'
  fuelsystem			varchar(300), 		-- 'Fuel system:'
  fuelsystemeng			varchar(300), 		-- 'Fuel system:'
  fuelcapacity			decimal(6,2) unsigned, 	-- 'Fuel capacity:'
  reservefuel			decimal(6,2) unsigned, 	-- 'Reserve fuel capacity:'
  consumtion			decimal(6,2) unsigned, 	-- 'Fuel consumption:'
  frontbrakesdiameter	smallint unsigned, 	-- 'Front brakes diameter:'
  frontbrakes			varchar(255), 		-- 'Front brakes:'
  frontbrakeseng		varchar(255), 		-- 'Front brakes:'
  rearbrakesdiameter	smallint, 	-- 'Rear brakes diameter:'
  rearbrakes			varchar(200), 		-- 'Rear brakes:'
  rearbrakeseng			varchar(200), 		-- 'Rear brakes:'
  frontweightperc		decimal(4,1) unsigned, 	-- 'Front percentage of weight:'
  frontsuspension		varchar(255), 		-- 'Front suspension:'
  frontsuspensioneng		varchar(255), 		-- 'Front suspension:'
  fronttravel			smallint,			-- 'Front wheel travel:'
  rearweightperc			decimal(4,1) unsigned, 	-- 'Rear percentage of weight:'
  rearsuspension		varchar(255), 		-- 'Rear suspension:'
  rearsuspensioneng		varchar(255), 		-- 'Rear suspension:'
  reartravel			smallint, 			-- 'Rear wheel travel:'
  fronttyre				varchar(30), 		-- 'Front tyre:'
  fronttyreeng			varchar(30), 		-- 'Front tyre:'
  reartyre				varchar(30), 		-- 'Rear tyre:'
  reartyreeng			varchar(30), 		-- 'Rear tyre:'  
  wheels				varchar(255), 		-- 'Wheels:'
  wheelseng				varchar(255), 		-- 'Wheels:'
  rake					decimal(4,1) unsigned,	-- 'Rake (fork angle):'
  trail					smallint, 			-- 'Trail:'
  driveline				varchar(255), 		-- 'Driveline:'
  drivelineeng			varchar(255), 		-- 'Driveline:'
  electrical			varchar(255), 		-- 'Electrical:'
  electricaleng			varchar(255), 		-- 'Electrical:'
  instruments			varchar(512), 		-- 'Instruments:'
  instrumentseng		varchar(512), 		-- 'Instruments:'
  modifications			varchar(2048), 		-- 'Modifications compared to previous model:'
  modificationseng		varchar(2048), 		-- 'Modifications compared to previous model:'
  price					varchar(15), 		-- 'Price as new (MSRP):'
  colors				varchar(300), 		-- 'Color options:'
  colorseng				varchar(300), 		-- 'Color options:'
  comments				varchar(2048),		-- 'Comments:'
  commentseng			varchar(2048),		-- 'Comments:'

  FOREIGN KEY (manufacturerId) REFERENCES ms.manufacturer(id) ON DELETE CASCADE,
  FOREIGN KEY (categoryID) REFERENCES ms.category(id) ON DELETE CASCADE,
  FOREIGN KEY (coolingID) REFERENCES ms.coolingtype(id) ON DELETE CASCADE,
  FOREIGN KEY (enginetypeID) REFERENCES ms.enginetype(id) ON DELETE CASCADE,
  FOREIGN KEY (finaldriveID) REFERENCES ms.finaldrivetype(id) ON DELETE CASCADE,
  FOREIGN KEY (starterID) REFERENCES ms.startertype(id) ON DELETE CASCADE
);
drop index model_manufacturer_name_year_I on ms.model;
create unique index model_manufacturer_name_year_I ON ms.model (manufacturerId, name, year);


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
