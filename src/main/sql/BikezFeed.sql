replace into manufacturer(name)
select distinct TRIM(TRAILING ' motorcycles' FROM manufacturer) manufacturerName from model_hold_bikez;

select m.url, mf.name, m.modelName,
(select attrValue from modelattribute_hold_bikez mh where mh.url = m.url and mh.attrName = 'Year:') as year
from model_hold_bikez m
left outer join manufacturer mf on mf.name = TRIM(TRAILING ' motorcycles' FROM m.manufacturer)

'0-100 km/h (0-62 mph):'
'1/4 mile (0.4 km):'
'60-140 km/h (37-87 mph), highest gear:'
'Alternate seat height:'
'Bore x stroke:'
'Carrying capacity:'
'Category:'	dictionary
'Clutch:'
'Color options:'
'Comments:'
'Compression:'
'Cooling system:' dictionary
'Displacement:'
'Driveline:'
'Dry weight:'
'Electrical:'
'Emission details:'
'Engine details:'
'Engine type:' dictionary
'Exhaust system:'
'Frame type:'
'Front brakes diameter:'
'Front brakes:'
'Front percentage of weight:'
'Front suspension:'
'Front tyre:'
'Front wheel travel:'
'Fuel capacity:'
'Fuel consumption:'
'Fuel control:'
'Fuel system:'
'Gearbox:'
'Greenhouse gases:'
'Ground clearance:'
'Ignition:'
'Instruments:'
'Light:'
'Lubrication system:'
'Max RPM:'
'Model:'
'Modifications compared to previous model:'
'Oil capacity:'
'Overall height:'
'Overall length:'
'Overall width:'
'Power/weight ratio:'
'Power:'
'Price as new (MSRP):'
'Rake (fork angle):'
'Rear brakes diameter:'
'Rear brakes:'
'Rear percentage of weight:'
'Rear suspension:'
'Rear tyre:'
'Rear wheel travel:'
'Reserve fuel capacity:'
'Seat height:'
'Seat:'
'Starter:' dictionary
'Top speed:'
'Torque:'
'Trail:'
'Transmission type, final drive:' dictionary
'Valves per cylinder:'
'Weight incl. oil, gas, etc:'
'Wheelbase:'
'Wheels:'
'Year:'

  
