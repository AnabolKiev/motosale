replace into manufacturer(name)
select distinct TRIM(TRAILING ' motorcycles' FROM manufacturer) manufacturerName from model_hold2;

select m.url, mf.name, m.modelName,
(select attrValue from modelattribute_hold2 mh where mh.url = m.url and mh.attrName = 'Year:') as year
from model_hold2 m
left outer join manufacturer mf on mf.name = TRIM(TRAILING ' motorcycles' FROM m.manufacturer)



  
