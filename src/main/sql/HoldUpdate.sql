update modelattribute_hold
set attrValue = 'Single � 320 mm floating discs, 4 piston radial caliper'
where url = '/C:/DevTools/MCS/MCS/www.motorcyclespecs.co.za/model/aprilia/aprilia_rs125r_08.html' and attrName = 'Front Brakes';

update modelattribute_hold
set attrValue = '120 mm / 4.7 in'
where url = '/C:/DevTools/MCS/MCS/www.motorcyclespecs.co.za/model/aprilia/aprilia_rs125r_08.html' and attrName = 'Rear Wheel Travel';

insert into modelattribute_hold(url,attrName,attrValue)
values('/C:/DevTools/MCS/MCS/www.motorcyclespecs.co.za/model/Honda/honda_cb125 82.html','Rear suspension','Swing arm, 2.6 in wheel travel');

update modelattribute_hold
set attrName = 'Front Tyre'
where url = '/C:/DevTools/MCS/MCS/www.motorcyclespecs.co.za/model/Honda/honda_cb125 82.html' and attrName = 'Swing arm, 2.6 in wheel travel.Front Tyre';


update ms.modelattribute_hold ma
set attrname = '0-100 km/h'
where ma.attrname in ('0-100 km/h','Acc: 0 - 100 km/h','Acc: 0 - 100 km/h / 62 mph','Acceleration 0 - 100 km / 62 mph','Acceleration 0 - 100 km/h','Acceleration 0 - 100 km/h / 60 mph',
'Acceleration 0 - 100 km/h / 62 mph','Acceleration 0 - 100mk/h / 62 mph','Acceleration 0-100 km/h','Acceleration 0-100 km/h / 62 mph ','Acceleration: 0 - 100 km/h / 62 mph',
'Acceleration: 0 - 100 km/h                         0 - 60 mph','Standing 0 - 100 km/h','Standing 0 - 100 km/h / 62 mph','Standing 0 - 100km','Standing 0 - 100km/h',
'Standing 0 - 100km/h / 62 mph','Standing 0 - 60 mph','Standing 0 - 60 mph / 97 km/h','Standing 0 - 97 km/h / 60 mph','Standing 0 -100 km/h','Standing 0- 100 km/h','Standing 60mph  ',
'Standing Start 0 - 100 km/h                           0 - 62 mph','Standing Start: 0 - 100 km/h                            0 - 62 mph','Standing: 0 - 100 km/h',
'Acc: 0 - 60 mph','Acc: 0 - 97 km/h / 60 mph','Acceleration 0 - 60 mph','Acceleration 0 - 60 mph / 97 km/h','Acceleration 0 - 97 km/h / 60 mph','Acceleration 0-60','Acceleration 0-60 mph',
'Acceleration: 0 - 97 km/h / 60 mph','Acceleration: 0 - 97 km/h /60 mph','Acceleration: 0-60 mph / 97 km/h (claimed)','Acelleration 0 - 97 km/h / 60 mph');

update ms.modelattribute_hold ma
set attrname = 'ABS'
where ma.attrname in ('ABS','ABS System');

update ms.modelattribute_hold ma
set attrname = 'Air Filter'
where ma.attrname in ('Air Cleaner','Air Filter','Air Filtration');

update ms.modelattribute_hold ma
set attrname = '100-0 km/h'
where ma.attrname in ('Braking 00 km/h - 0','Braking 100 - 0','Braking 100 - 0 km/h','Braking 100 km/h - 0','Braking 100 km/h / 62 mph - 0','Braking Distance 60 mph - 0',
'Braking 100 km/h / 62 mph - 0 ','Braking 100 km/h / 62 mph -  0','Braking 100 km/h / 67 mph - 0','Braking 100 km/h- 0','Braking 100 km/h  - 0','Braking 100km/h - 0 / 60 mph - 0',
'Braking 100kmh - 0 / 60 mph - 0','Braking 100kmh-0 / 60mph - 0','Braking 60 mph - 0','Braking 60 mph / 97 km/h - 0','Braking 96 km/h / 60 mph - 0',
'Braking 97 km/h / 60 mph - 0','Braking Distance 97 km/h / 60 mph - 0','Braking: 100 km/h - 0','Braking: 97 km/h / 60 mph - 0','Braking  100 - 0','Stopping Distance 100 kmh-0 (60mph-0)') ;

update ms.modelattribute_hold ma
set attrname = 'Battery'
where ma.attrname in ('Battery 12N','Battery Capacity','Battery ','Battery');

update ms.modelattribute_hold ma
set attrname = 'Generator'
where ma.attrname in ('ACG Output','Alternator','Alternator / Generator','Generator') ;

update ms.modelattribute_hold ma
set attrname = 'Consumption avg'
where ma.attrname in ('Average Consumption','Average Consumption (@ 64 km/h / 40 mph)','Average Consumption (Combined)','Average Consumption ','Average Consumption (claimed)',
'Average Fuel Consumption','Consumption','Consumption Average','Consumption Average (@ 120 km/h / 75 mph)','Consumption Average (claimed)','Consumption  average','Consumption Average',
'Cunsumption Average','Fuel Consumption','Fuel Consumption (claimed)','Fuel Consumption (Combined)','Fuel Consumption (est)','Fuel Consumption Average');

update ms.modelattribute_hold ma
set attrname = 'Dimensions'
where ma.attrname in ('  Dimensions  ','Dimension','Dimensions (from 2002','Dimensions ','Dimensions  L / W / H','Length / Width / Height',
'Dimensions  L /W / H','Dimensions H','Dimensions  ','Dimensions',' Dimension','Overall Dimensions','Overall length � Overall width � Overall height(m)');

update ms.modelattribute_hold ma
set attrname = 'Year'
where ma.attrname in ('Year','Year.','Model');

update ms.modelattribute_hold ma
set attrname = 'Make Model'
where ma.attrname in ('Make Model    ','Make Model','Make Model.') ;

update ms.modelattribute_hold ma
set attrname = 'Engine'
where ma.attrname in ('Engine Type','Engine');

update ms.modelattribute_hold ma
set attrname = 'Capacity'
where ma.attrname in ('Capacity','Capacityir coole');

update ms.modelattribute_hold ma
set attrname = 'Wet Weight'
where ma.attrname in (' Wet-Weight',' Wet Weight','We  Weight','WetWeight','Wet-Weight','Wet Wieght','Wet Weight  ','Wet Weight  (No Fuel)','Wet Weight ','Wet Weight Weight','Wet Weight /',
'Wet Weight (incl sidecar)','Wet Weight','Wet Weigh','Wet -Weight','Wedt-Weight','We -Weight','Wit-Weight','Curb Weight','Curb Weight ','Curb-Weight','Kerb Weight','Unladen weight, road ready, fully fuelled');

update ms.modelattribute_hold ma
set attrname = 'Dry Weight'
where ma.attrname in ('Dry -Weight','Dry Weigh','Dry Weight','Dry Weight (claimed)','Dry Weight (Est)','Dry Weight /','Dry Weight / Wet Weight','Dry Weight / Wet-Weight','Dry Weightt',
'Dry Weight ','Dry Weight  ','Dry Wheight','Dry Wight','Dry-Weight','Dry-Weight / Wet-weight','Dry-Weight Street Version','Dry-Weight ','Dryt Weight','DryWeight','Dry  Weight',
'Weight',' Dry-Weight');

update ms.modelattribute_hold ma
set attrname = 'Wheelbase'
where ma.attrname in (' Wheelbase','Wheelbsase','Wheelbase ','Wheelbase:','Wheelbase','Wheel Base','Weelbase');

update ms.modelattribute_hold ma
set attrname = 'Bore x Stroke'
where ma.attrname in ('Bore and Stoke','Bore and Strok','Bore and Stroke','Bore x Sroke','Bore x Stroke','Bore/Stroke');

update ms.modelattribute_hold ma
set attrname = 'Cooling'
where ma.attrname in ('Cooking System','Cooled System','Cooling','Cooling Ssytem','Cooling Sysstem','Cooling System','Cooling System  ',
'Cooling Systom','Cooling Sytem','Coolling System','Coooling System');

update ms.modelattribute_hold ma
set attrname = 'Compression'
where ma.attrname in ('Compression','Compression Ratio','Compression Ratio ','Compression System','Coompression Ratio');

update ms.modelattribute_hold ma
set attrname = 'Induction'
where ma.attrname in ('Induction','Fuel system','Fuel supply system','Fuel Supply','Fuel injection','Carburettors','Carburettor','Carburetors','Carburetor');

update ms.modelattribute_hold ma
set attrname = 'Starting'
where ma.attrname in (' Starting','Stgarting','Starting ','Starting','Starter','Start5ing','Starring','Staring','Staarting','Electric','tarting');

update ms.modelattribute_hold ma
set attrname = 'Max Power'
where ma.attrname in ('Power','Maximum Power','Max Rower','Max Powner','Max Power  ','Max Power cranckshaft','Max Power at driveshaft',
'Max Power Arial','Max Power (claimed)','Max Power (at shaft)','Max Power (Approx)','Max Power');

update ms.modelattribute_hold ma
set attrname = 'Max Power Tyre'
where ma.attrname in ('Power Rear Tyre','Max Power  Rear Wheel','Max Power Rear Wheel','Max Power (rear wheel)','Max Power (rear tyre)','Max Power  Rear Wheel','Max Power  Rear Tyre',
'Max Power Reat Tyre','Max Power Rear Wheel','Max Power Rear Tyre','Max Power at Rear Wheel','Max Power (rear tyre)','Max Power (at rear wheel)','Max Power (at rear tyre)',
'Max Power (@ rear tyre)','Rear Wheel Power');

update ms.modelattribute_hold ma
set attrname = 'Max Power Ram Air'
where ma.attrname in ('Max Power with RAM Air','Max Power  Ram Aire','Max Power  Ram Air','Max Power with Ram Air','Max Power Ram Air');

update ms.modelattribute_hold ma
set attrname = 'Max Torque'
where ma.attrname in ('Torque','Maximum Torque','Max. Torque','Max Troque','Max Torque (Approx)','Max Torque','Max Toque');

update ms.modelattribute_hold ma
set attrname = 'Max Torque Ram Air'
where ma.attrname in ('Max Torque Ram Airr','Max Torque Ram Air') ;

update ms.modelattribute_hold ma
set attrname = 'Clutch'
where ma.attrname in ('Cltch','Cluch','Clutch','ClutchTransmission ','Clutch  DCT') ;

update ms.modelattribute_hold ma
set attrname = 'Transmission'
where ma.attrname in ('Transmissio','Transmission','Transmission / Drive','Transmission Type','Transmissione','Transmission ','Transmission  /  Drive','Transmission Clutch','Transmission   DCT');

update ms.modelattribute_hold ma
set attrname = 'Final Drive'
where ma.attrname in ('Drive','Drive Train','Fianl Drive','Final Drice','Final Driv','Final Drive','Final lDrive','Final Srive','Final  Drive','Final Drive',' Final Drive');

update ms.modelattribute_hold ma
set attrname = 'Fuel Capacity'
where ma.attrname in ('Fuel Capacity','Fuel Capacity / 9.4 US gal','Fuel Capacity ','Fuel Capacity (res)','Fuel Capacity km/l','Tank Capacity');

update ms.modelattribute_hold ma
set attrname = 'Top Speed'
where ma.attrname in ('Maximum Speed','Top Seed','Top Speed','Top Speed (claimed)','Top Speed (est)','Top Speed (est.)','Top Speed (estimated)','Top Speed (limited)','Top Speed (sustained)','Top Speed  ',
'Top Speed ','TopSpeed ');

update ms.modelattribute_hold ma
set attrname = 'Seat Height'
where ma.attrname in ('Saddle Height','Seat Heigh','Seat Height','Seat height:','Seat Height ','Seat Heigth','Seat Heigtht','Seat Heitght','Seat Hieght','Seat Higher','Swat H eight','Swat Height');
/*
update ms.modelattribute_hold ma
set attrname = 'Rake'
where ma.attrname in ('Caster','Castor:','Caster angle  /  Trail','Caster (rake)','Castor Angle','Caster Angle','Caster Angle:','Rake / Trail','Rake/Trail','Rake  / Trail','Rake  /  Trail',
'Rake  /  Trail  /  Fork Angle','Rake','Rake (Caster Angle)','Rake (steering head)','Rake / Trqil','Rake Caster Angle','Rake/','Rake/Castor','Rakem','Rake ', 'Rake  /  Castor',
'Rake (Caster Angle)','Rake l','  Rake',' Rake ','Steering Rake','Fork Angle','Fork Angle 30.5�','Steering Angle','Steering Angle (Left and Right)','Steering Angle (left to right)',
'Steering angle (left/right)','Steering angle (total)','Steering Angle left / right','Steering Angle, left / right','Steering angle ','Steering Head Angle','Steering head angle:',
'Steering Head Angle ','Steering lock (total)','Steering Lock Angle');

update ms.modelattribute_hold ma
set attrname = 'Trail'
where ma.attrname in ('Trail','Trail:','Trail ','Tral',' Trail','Castor','Wheel castor');
*/
update ms.modelattribute_hold ma
set attrname = 'Rear Wheel Travel'
where ma.attrname in ('Rear Eravel Travel','Rear heel Travel','Rear Shock Stroke','Rear Track','Rear Wheel Trael','Rear Wheel Travcel',
'Rear Wheel Travel','Rear Wheel Travel.','Rear Wheel Travl','Rear Wheel Ttavel','Rear Wheel  Travel');

update ms.modelattribute_hold ma
set attrname = 'Front Wheel Travel'
where ma.attrname in ('Font Wheel Travel','Front Wheel ravel','Front Wheel Trael','Front Wheel Traval','Front Wheel Travel',
'Front Wheel Travel.','Front Wheel TravelFront Wheel Travel','Front Wheel Travlel','Front Wheel Trqavel','Front Wheel  Travel','Front Wheel Travel','Front Whel Travel');

update ms.modelattribute_hold ma
set attrname = 
where ma.attrname in ;

update ms.modelattribute_hold ma
set attrname = 
where ma.attrname in ;

update ms.modelattribute_hold ma
set attrname = 
where ma.attrname in ;

update ms.modelattribute_hold ma
set attrname = 
where ma.attrname in ;

update ms.modelattribute_hold ma
set attrname = 
where ma.attrname in ;
