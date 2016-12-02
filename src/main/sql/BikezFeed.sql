replace into manufacturer(name)
select distinct TRIM(TRAILING ' motorcycles' FROM manufacturer) manufacturerName from model_hold_bikez;

insert into ms.category(name, nameeng)
select distinct attrValue, attrValue from ms.modelattribute_hold_bikez ma
where attrName = 'Category:' order by 1;

insert into ms.coolingtype(name, nameeng)
select distinct attrValue, attrValue from ms.modelattribute_hold_bikez ma
where attrName = 'Cooling system:' order by 1;

insert into ms.enginetype(name, nameeng)
select distinct attrValue, attrValue from ms.modelattribute_hold_bikez ma
where attrName = 'Engine type:' order by 1;

insert into ms.startertype(name, nameeng)
select distinct attrValue, attrValue from ms.modelattribute_hold_bikez ma
where attrName = 'Starter:' order by 1;

insert into ms.finaldrivetype(name, nameeng)
select distinct attrValue, attrValue from ms.modelattribute_hold_bikez ma
where attrName = 'Transmission type, final drive:' order by 1;



select m.url, mf.name, m.modelName,
(select attrValue from modelattribute_hold_bikez mh where mh.url = m.url and mh.attrName = 'Year:') as year
from model_hold_bikez m
left outer join manufacturer mf on mf.name = TRIM(TRAILING ' motorcycles' FROM m.manufacturer)

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
