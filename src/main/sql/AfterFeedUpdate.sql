update ms.model m
set m.fuelSystem = replace(m.fuelSystem,'Carburettor','Карбюратор');
update ms.model m
set m.fuelSystem = replace(m.fuelSystem,'Injection','Инжектор');
update ms.model m
set m.fuelSystem = replace(m.fuelSystem,'Turbo','Турбина');
update ms.model m
set m.fuelSystem = replace(m.fuelSystem,'. EFI','');
update ms.model m
set m.fuelSystem = replace(m.fuelSystem,'. Electronic Sequential Port Fuel Инжектор (ESPFI)','');
update ms.model m
set m.fuelSystem = replace(m.fuelSystem,'. Electronic Sequential Port Fuel Инжектор','');

update ms.model m
set m.fuelControl = replace(m.fuelControl,'Double Overhead Cams/Twin Cam (DOHC)','Два распредвала в головке цилиндров (DOHC)');
update ms.model m
set m.fuelControl = replace(m.fuelControl,'Single Overhead Cams (SOHC)','Один распредвал в головке цилиндров (SOHC)');
update ms.model m
set m.fuelControl = replace(m.fuelControl,'Overhead Valves (OHV)','Верхнеклапанный со штанговым приводом (OHV)');
update ms.model m
set m.fuelControl = replace(m.fuelControl,'Overhead Cams (OHC)','Верхневальный (OHC)');
update ms.model m
set m.fuelControl = replace(m.fuelControl,'Desmodromic valve control','Десмодромный');
update ms.model m
set m.fuelControl = replace(m.fuelControl,'Port control','Поршневой');
update ms.model m
set m.fuelControl = replace(m.fuelControl,'Membrane & variable discharge openings','Мембранный клапан и переменные выпускные отверстия');
update ms.model m
set m.fuelControl = replace(m.fuelControl,'Membrane & power valve','Мембранный и мощностной клапана');
update ms.model m
set m.fuelControl = replace(m.fuelControl,'Membrane','Мембранный клапан');
update ms.model m
set m.fuelControl = replace(m.fuelControl,'Sidevalves','Боковые клапана');
update ms.model m
set m.fuelControl = replace(m.fuelControl,'Rotary valves & variable discharge openings','Дисковый клапан и переменные выпускные отверстия');
update ms.model m
set m.fuelControl = replace(m.fuelControl,'Rotary valves','Дисковый клапан');
update ms.model m
set m.fuelControl = replace(m.fuelControl,'Standing valves','Всасывающий клапан');
update ms.model m
set m.fuelControl = replace(m.fuelControl,'Pushrods','Штанговые толкатели');
