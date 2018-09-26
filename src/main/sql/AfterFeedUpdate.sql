update ms.model m set m.fuelSystem = replace(m.fuelSystem,'Carburettor','Карбюратор');
update ms.model m set m.fuelSystem = replace(m.fuelSystem,'Injection','Инжектор');
update ms.model m set m.fuelSystem = replace(m.fuelSystem,'Turbo','Турбина');
update ms.model m set m.fuelSystem = replace(m.fuelSystem,'. EFI','');
update ms.model m set m.fuelSystem = replace(m.fuelSystem,'. Electronic Sequential Port Fuel Инжектор (ESPFI)','');
update ms.model m set m.fuelSystem = replace(m.fuelSystem,'. Electronic Sequential Port Fuel Инжектор','');

update ms.model m set m.fuelControl = replace(m.fuelControl,'Double Overhead Cams/Twin Cam (DOHC)','Два распредвала в головке цилиндров (DOHC)');
update ms.model m set m.fuelControl = replace(m.fuelControl,'Single Overhead Cams (SOHC)','Один распредвал в головке цилиндров (SOHC)');
update ms.model m set m.fuelControl = replace(m.fuelControl,'Overhead Valves (OHV)','Верхнеклапанный со штанговым приводом (OHV)');
update ms.model m set m.fuelControl = replace(m.fuelControl,'Overhead Cams (OHC)','Верхневальный (OHC)');
update ms.model m set m.fuelControl = replace(m.fuelControl,'Desmodromic valve control','Десмодромный');
update ms.model m set m.fuelControl = replace(m.fuelControl,'Port control','Поршневой');
update ms.model m set m.fuelControl = replace(m.fuelControl,'Membrane & variable discharge openings','Мембранный клапан и переменные выпускные отверстия');
update ms.model m set m.fuelControl = replace(m.fuelControl,'Membrane & power valve','Мембранный и мощностной клапана');
update ms.model m set m.fuelControl = replace(m.fuelControl,'Membrane','Мембранный клапан');
update ms.model m set m.fuelControl = replace(m.fuelControl,'Sidevalves','Боковые клапана');
update ms.model m set m.fuelControl = replace(m.fuelControl,'Rotary valves & variable discharge openings','Дисковый клапан и переменные выпускные отверстия');
update ms.model m set m.fuelControl = replace(m.fuelControl,'Rotary valves','Дисковый клапан');
update ms.model m set m.fuelControl = replace(m.fuelControl,'Standing valves','Всасывающий клапан');
update ms.model m set m.fuelControl = replace(m.fuelControl,'Pushrods','Штанговые толкатели');

update ms.model set lubrications = 'Мокрый картер' where lubrications in ('Wet sump', 'Wet sump.', '  Wet sump', 'Wet-sump', 'Wet sump,');
update ms.model set lubrications = 'Сухой картер' where lubrications in ('Dry sump', 'Dry-sump', 'Dry sumpy');
update ms.model set lubrications = 'Маслонасос' where lubrications in ('Oil Pump', 'By pump', 'Pump', 'Pressure lubrication');
update ms.model set lubrications = 'Раздельная смазка' where lubrications in ('Separate lubrication', 'Separate lubrification', 'Seperate lubrification');
update ms.model set lubrications = 'Принудительная смазка, мокрый картер' where lubrications = 'Forced lubrication, wet sump';
/*update ms.model set lubrications = '' where lubrications in ('Forced oil lubrication with 2 Eaton pumps','Pressure lubrication with 2 Eaton pumps');*/
update ms.model set lubrications = 'Полу-сухой картер' where lubrications = 'Semi-dry sump';
update ms.model set lubrications = 'Принудительная смазка, полу-сухой картер' where lubrications = 'Forced lubrication, semi-dry sump';

update ms.model set power = replace(power, 'RPM', 'об/мин');
update ms.model set torque = replace(torque, 'RPM', 'об/мин');

update ms.model set frontBrakes = replace(frontBrakes, 'Single disc', 'Однодисковые');
update ms.model set frontBrakes = replace(frontBrakes, 'Double disc', 'Двухдисковые');
update ms.model set frontBrakes = replace(frontBrakes, 'Dual disc', 'Двухдисковые');
update ms.model set frontBrakes = 'Барабанные' where frontBrakes like 'Expanding brake%';
update ms.model set frontBrakes = replace(frontBrakes, 'Hydraulic', 'Гидравлические');

update ms.model set rearbrakes = replace(rearbrakes, 'Single disc', 'Однодисковые');
update ms.model set rearbrakes = replace(rearbrakes, 'Double disc', 'Двухдисковые');
update ms.model set rearbrakes = replace(rearbrakes, 'Dual disc', 'Двухдисковые');
update ms.model set rearbrakes = 'Барабанные' where rearbrakes like 'Expanding brake%';
update ms.model set rearbrakes = replace(rearbrakes, 'Hydraulic', 'Гидравлические');

update ms.model set gearbox = '1-на передача' where gearbox = '1-speed';
update ms.model set gearbox = '2-х скоростная' where gearbox = '2-speed';
update ms.model set gearbox = '3-х скорос тная' where gearbox = '3-speed';
update ms.model set gearbox = '4-х скоростная' where gearbox = '4-speed';
update ms.model set gearbox = '5-ти скоростная' where gearbox = '5-speed';
update ms.model set gearbox = '6-ти скоростная' where gearbox = '6-speed';
update ms.model set gearbox = '7-ми скоростная' where gearbox = '7-speed';
update ms.model set gearbox = '8-ми скоростная' where gearbox = '8-speed';
update ms.model set gearbox = '9-ти скоростная' where gearbox = '9-speed';
update ms.model set gearbox = '10-ти скоростная' where gearbox = '10-speed';
update ms.model set gearbox = '100 скоростная' where gearbox = '100-speed';
update ms.model set gearbox = '4-x скоростная с задней' where gearbox = '4-speed with reverse';
update ms.model set gearbox = '5-ти скоростная с задней' where gearbox = '5-speed with reverse';
update ms.model set gearbox = '6-ти скоростная с задней' where gearbox = '6-speed with reverse';
update ms.model set gearbox = 'Автоматическая' where gearbox = 'Automatic';
update ms.model set gearbox = 'Автоматическая 2-х скоростная' where gearbox = '2-speed automatic';
update ms.model set gearbox = 'Автоматическая 3-х скоростная' where gearbox = '3-speed automatic';

update ms.model set price = replace(price, 'US$', 'USD');
update ms.model set price = replace(price, 'Euro', 'EUR');