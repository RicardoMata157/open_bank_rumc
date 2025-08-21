-- public.tah2cif_record definition

-- Drop table

-- DROP TABLE public.tah2cif_record;

CREATE TABLE "FCM".tah2cif_record (
	birth_date varchar(255) NULL,
	cust_id varchar(255) NOT NULL,
	risk_level varchar(255) NULL,
	CONSTRAINT tah2cif_record_pkey PRIMARY KEY (cust_id)
);


CREATE SCHEMA FCM;

CREATE SCHEMA T24_snapshot;


select pa.account_code, padf.id_account_field_def, padf.text_value  from pro_account pa 
inner join pro_account_dyn_field padf on pa.id=padf.id_account_record
where pa.account_code='4001264226'
and id_account_field_def ='CARDID';

pro_account_dyn_field

"case when operation_code in (9511, 9531, 9535, 9537,  9539, 9543, 2260, 2617, 2619, 2468, 2621, 2360, 2362, 2364, 2368, 2202, 2442, 2250, 2340, 2396, 2289, 2291, 2423, 2235, 2395, 2243, 2316, 2318, 2320, 2334, 2344, 2591, 2236, 2322, 2324, 2326, 2400, 2402, 2404, 2406, 9535, 3705, 2346, 2229, 9531, 2632, 2657, 2658, 2661, 9539, 2561, 2673, 2675, 2686, 2687, 2688, 2689, 2690, 2691, 2692, 2694, 2216, 4516, 4507, 4509, 4518, 2697) then 'input_tran'
case when operation_code in (9512, 9532, 9536, 9538,  9540, 9544, 9536, 2257, 2259, 2618, 2467, 2620, 2357, 2359, 2361, 2363, 2201, 2439, 2249, 2317, 2319, 2288, 2290, 2422, 2234, 2590, 2345, 2228, 2242, 2315, 2333, 2339, 2343, 2321, 2323, 2325, 2399, 2401, 2403, 2405, 2485, 2604, 2282, 2292, 2294, 2296, 5021, 5022, 3704, 2655, 2656, 9540, 2644, 2424, 2649, 2560, 2672, 2674, 2693, 2696, 4517, 4506, 4508, 4519, 2698) then 'output_tran'"











INSERT INTO fcm.tah2cif_record (
  onboarding_date, birth_date, nat_id, passport_nr, ssn_id, address1,
  birth_country, cif_record_id, city, classification, country,
  cust_id, first_name, "name", pep, risk_level, state,
  telno_fix, text_value, zipcode
) VALUES
  ('2022-10-20', '1995-03-10', 'MXN46694', 'P47947', 'SSN416193045', 'Calle 50 #517', 'MX', 'CIF001', 'Tijuana', 'C', 'MX', 'CUST001', 'Ricardo', 'Mata Crisostmo', TRUE, 'ALTO', 'CDMX', '5584331214', 'Revisión especial', '28804'),
  ('2024-09-05', '2003-10-17', 'MXN41459', 'P47738', 'SSN818551660', 'Calle 122 #929', 'MX', 'CIF002', 'Monterrey', 'B', 'MX', 'CUST002', 'Diana', 'Diana Pérez', FALSE, 'MEDIO', 'PUE', '5593726654', 'Cliente nuevo', '80557'),
  ('2022-06-28', '1975-08-29', 'MXN40620', 'P52630', 'SSN915710282', 'Calle 16 #296', 'MX', 'CIF003', 'Tijuana', 'B', 'MX', 'CUST003', 'Luis', 'Luis Gómez', FALSE, 'MEDIO', 'NL', '5541210115', 'PEP relevante', '12464'),
  ('2022-04-10', '1997-06-28', 'MXN56908', 'P82164', 'SSN409439111', 'Calle 191 #680', 'MX', 'CIF004', 'Guadalajara', 'B', 'MX', 'CUST004', 'Diana', 'Diana Martínez', FALSE, 'MEDIO', 'JAL', '5533015008', 'Cliente habitual', '26644'),
  ('2022-04-15', '1991-08-13', 'MXN30964', 'P37327', 'SSN896575104', 'Calle 100 #814', 'MX', 'CIF005', 'Monterrey', 'B', 'MX', 'CUST005', 'Juan', 'Juan López', TRUE, 'ALTO', 'PUE', '5547076108', 'PEP relevante', '70669'),
  ('2023-09-22', '2003-08-05', 'MXN92081', 'P86161', 'SSN302387785', 'Calle 41 #370', 'MX', 'CIF006', 'Ciudad de México', 'A', 'MX', 'CUST006', 'Ana', 'Ana Ruiz', FALSE, 'BAJO', 'PUE', '5556321502', 'Revisión especial', '15384'),
  ('2022-08-30', '1951-01-03', 'MXN96099', 'P18163', 'SSN011875419', 'Calle 23 #937', 'MX', 'CIF007', 'Guadalajara', 'A', 'MX', 'CUST007', 'Sofía', 'Sofía Gómez', FALSE, 'ALTO', 'PUE', '5531206365', 'PEP relevante', '29612'),
  ('2022-09-14', '1967-03-02', 'MXN85242', 'P07411', 'SSN361679414', 'Calle 102 #350', 'MX', 'CIF008', 'Guadalajara', 'C', 'MX', 'CUST008', 'Diana', 'Diana Gómez', FALSE, 'ALTO', 'PUE', '5579258793', 'PEP relevante', '12899'),
  ('2023-12-16', '2000-01-04', 'MXN97702', 'P59736', 'SSN030375252', 'Calle 64 #792', 'MX', 'CIF009', 'Guadalajara', 'C', 'MX', 'CUST009', 'Sofía', 'Sofía Gómez', FALSE, 'ALTO', 'BC', '5596314558', 'Cliente habitual', '51442'),
  ('2024-04-02', '1971-11-13', 'MXN69388', 'P52456', 'SSN973615805', 'Calle 97 #972', 'MX', 'CIF010', 'Tijuana', 'A', 'MX', 'CUST010', 'Sofía', 'Sofía Fernández', TRUE, 'ALTO', 'CDMX', '5571043390', 'Revisión especial', '66645'),
  ('2023-07-06', '1979-12-19', 'MXN54149', 'P07528', 'SSN329031350', 'Calle 38 #976', 'MX', 'CIF011', 'Ciudad de México', 'A', 'MX', 'CUST011', 'Juan', 'Juan Ramírez', FALSE, 'BAJO', 'BC', '5524247037', 'Revisión especial', '65552'),
  ('2022-01-05', '1993-11-14', 'MXN77134', 'P33282', 'SSN002803776', 'Calle 57 #685', 'MX', 'CIF012', 'Monterrey', 'A', 'MX', 'CUST012', 'Juan', 'Juan Ruiz', FALSE, 'MEDIO', 'NL', '5551926060', 'Revisión especial', '74864'),
  ('2022-01-07', '1959-07-17', 'MXN28788', 'P93158', 'SSN295506249', 'Calle 111 #178', 'MX', 'CIF013', 'Ciudad de México', 'A', 'MX', 'CUST013', 'Pedro', 'Pedro Ruiz', TRUE, 'MEDIO', 'NL', '5595689812', 'Cliente nuevo', '47065'),
  ('2024-03-23', '1955-11-28', 'MXN62462', 'P80093', 'SSN031665763', 'Calle 179 #722', 'MX', 'CIF014', 'Ciudad de México', 'C', 'MX', 'CUST014', 'Diana', 'Diana Pérez', TRUE, 'ALTO', 'NL', '5559697262', 'Revisión especial', '54298'),
  ('2022-12-27', '1950-02-09', 'MXN77652', 'P16338', 'SSN229913589', 'Calle 134 #774', 'MX', 'CIF015', 'Puebla', 'C', 'MX', 'CUST015', 'Diana', 'Diana Martínez', FALSE, 'MEDIO', 'CDMX', '5564096053', 'Cliente nuevo', '73224'),
  ('2023-03-24', '1998-04-01', 'MXN69287', 'P87902', 'SSN105664751', 'Calle 99 #470', 'MX', 'CIF016', 'Ciudad de México', 'C', 'MX', 'CUST016', 'Luis', 'Luis Hernández', FALSE, 'MEDIO', 'NL', '5592106058', 'Cliente nuevo', '75931'),
  ('2022-03-21', '1965-03-26', 'MXN59202', 'P46913', 'SSN268241788', 'Calle 28 #913', 'MX', 'CIF017', 'Guadalajara', 'A', 'MX', 'CUST017', 'Sofía', 'Sofía Hernández', FALSE, 'MEDIO', 'PUE', '5578762153', 'Revisión especial', '34928'),
  ('2022-06-11', '1980-08-22', 'MXN90667', 'P78762', 'SSN612636064', 'Calle 181 #309', 'MX', 'CIF018', 'Guadalajara', 'C', 'MX', 'CUST018', 'Luis', 'Luis Ruiz', FALSE, 'MEDIO', 'BC', '5579802610', 'Revisión especial', '31074'),
  ('2022-03-28', '1990-05-05', 'MXN39080', 'P75131', 'SSN895699959', 'Calle 48 #151', 'MX', 'CIF019', 'Guadalajara', 'A', 'MX', 'CUST019', 'Laura', 'Laura Hernández', TRUE, 'ALTO', 'BC', '5596936353', 'Cliente nuevo', '98209'),
  ('2024-10-10', '1957-05-27', 'MXN53678', 'P38026', 'SSN724381896', 'Calle 191 #702', 'MX', 'CIF020', 'Tijuana', 'B', 'MX', 'CUST020', 'Sofía', 'Sofía Fernández', FALSE, 'ALTO', 'BC', '5564691117', 'Cliente nuevo', '48970'),
  ('2023-09-18', '2002-05-18', 'MXN16077', 'P73776', 'SSN799303683', 'Calle 5 #311', 'MX', 'CIF021', 'Puebla', 'C', 'MX', 'CUST021', 'Pedro', 'Pedro López', TRUE, 'ALTO', 'BC', '5582374641', 'Cliente nuevo', '58573'),
  ('2024-06-02', '1967-10-29', 'MXN79776', 'P56338', 'SSN522690312', 'Calle 90 #982', 'MX', 'CIF022', 'Tijuana', 'B', 'MX', 'CUST022', 'Luis', 'Luis Hernández', FALSE, 'BAJO', 'CDMX', '5586896852', 'Revisión especial', '26691'),
  ('2023-03-22', '1978-07-13', 'MXN09541', 'P43379', 'SSN297077658', 'Calle 185 #798', 'MX', 'CIF023', 'Monterrey', 'A', 'MX', 'CUST023', 'Jorge', 'Jorge López', FALSE, 'ALTO', 'NL', '5518802956', 'Cliente habitual', '56452'),
  ('2023-02-10', '1951-11-11', 'MXN05951', 'P65304', 'SSN496360354', 'Calle 61 #665', 'MX', 'CIF024', 'Guadalajara', 'B', 'MX', 'CUST024', 'Jorge', 'Jorge Ramírez', TRUE, 'BAJO', 'CDMX', '5594408890', 'PEP relevante', '44578'),
  ('2024-02-11', '1963-07-19', 'MXN77553', 'P64392', 'SSN467615292', 'Calle 70 #269', 'MX', 'CIF025', 'Monterrey', 'B', 'MX', 'CUST025', 'Jorge', 'Jorge Fernández', TRUE, 'ALTO', 'JAL', '5553296055', 'Cliente habitual', '34380'),
  ('2022-11-20', '1955-05-30', 'MXN40121', 'P54936', 'SSN646168569', 'Calle 192 #920', 'MX', 'CIF026', 'Tijuana', 'C', 'MX', 'CUST026', 'Ana', 'Ana Pérez', TRUE, 'BAJO', 'BC', '5531317754', 'PEP relevante', '62122'),
  ('2024-03-14', '1967-01-02', 'MXN14309', 'P08890', 'SSN643360873', 'Calle 188 #118', 'MX', 'CIF027', 'Guadalajara', 'C', 'MX', 'CUST027', 'Carlos', 'Carlos Gómez', TRUE, 'MEDIO', 'PUE', '5593230148', 'Cliente habitual', '49237'),
  ('2024-02-13', '1990-04-25', 'MXN50597', 'P87300', 'SSN649116267', 'Calle 191 #756', 'MX', 'CIF028', 'Tijuana', 'A', 'MX', 'CUST028', 'María', 'María Ruiz', TRUE, 'ALTO', 'JAL', '5566178158', 'Cliente habitual', '88038'),
  ('2023-03-23', '1950-11-16', 'MXN19085', 'P60099', 'SSN261690360', 'Calle 132 #537', 'MX', 'CIF029', 'Monterrey', 'B', 'MX', 'CUST029', 'María', 'María Ruiz', TRUE, 'ALTO', 'BC', '5587882577', 'Cliente nuevo', '99574'),
  ('2024-01-28', '1995-06-09', 'MXN25041', 'P03171', 'SSN173187326', 'Calle 37 #597', 'MX', 'CIF030', 'Monterrey', 'B', 'MX', 'CUST030', 'Jorge', 'Jorge Pérez', FALSE, 'MEDIO', 'JAL', '5572934167', 'Cliente habitual', '70180'),
  ('2022-12-16', '2005-09-19', 'MXN68876', 'P60157', 'SSN261745805', 'Calle 140 #808', 'MX', 'CIF031', 'Monterrey', 'C', 'MX', 'CUST031', 'Luis', 'Luis Ruiz', FALSE, 'BAJO', 'CDMX', '5598467917', 'Cliente habitual', '96848'),
  ('2023-11-13', '1998-04-11', 'MXN85823', 'P36315', 'SSN686914944', 'Calle 171 #886', 'MX', 'CIF032', 'Puebla', 'C', 'MX', 'CUST032', 'Pedro', 'Pedro Fernández', FALSE, 'BAJO', 'NL', '5561193998', 'PEP relevante', '34466'),
  ('2024-03-23', '1957-10-24', 'MXN65249', 'P78843', 'SSN264087737', 'Calle 17 #469', 'MX', 'CIF033', 'Tijuana', 'A', 'MX', 'CUST033', 'Juan', 'Juan Ruiz', TRUE, 'ALTO', 'NL', '5526727820', 'Cliente habitual', '58125'),
  ('2023-03-03', '1958-04-15', 'MXN15909', 'P16637', 'SSN648550130', 'Calle 145 #774', 'MX', 'CIF034', 'Ciudad de México', 'C', 'MX', 'CUST034', 'Diana', 'Diana Pérez', TRUE, 'BAJO', 'NL', '5551341527', 'PEP relevante', '63584'),
  ('2022-05-02', '1958-07-10', 'MXN04884', 'P68573', 'SSN031235703', 'Calle 151 #532', 'MX', 'CIF035', 'Guadalajara', 'B', 'MX', 'CUST035', 'Laura', 'Laura Pérez', TRUE, 'BAJO', 'BC', '5556762943', 'Revisión especial', '91846'),
  ('2023-04-17', '1973-12-29', 'MXN20909', 'P15240', 'SSN417105894', 'Calle 98 #942', 'MX', 'CIF036', 'Tijuana', 'B', 'MX', 'CUST036', 'Jorge', 'Jorge Martínez', FALSE, 'ALTO', 'JAL', '5542056706', 'Cliente habitual', '32913'),
  ('2024-09-17', '1985-01-07', 'MXN60990', 'P23581', 'SSN743152819', 'Calle 13 #788', 'MX', 'CIF037', 'Ciudad de México', 'B', 'MX', 'CUST037', 'Pedro', 'Pedro Ruiz', TRUE, 'ALTO', 'JAL', '5531154133', 'Cliente habitual', '86547'),
  ('2022-04-26', '1952-05-10', 'MXN29109', 'P31065', 'SSN423510479', 'Calle 20 #735', 'MX', 'CIF038', 'Guadalajara', 'B', 'MX', 'CUST038', 'Sofía', 'Sofía López', FALSE, 'ALTO', 'CDMX', '5578982933', 'Revisión especial', '76758'),
  ('2022-01-29', '1999-03-01', 'MXN45589', 'P52013', 'SSN109706777', 'Calle 85 #143', 'MX', 'CIF039', 'Guadalajara', 'C', 'MX', 'CUST039', 'Luis', 'Luis Ramírez', TRUE, 'BAJO', 'JAL', '5530034602', 'Cliente nuevo', '63057'),
  ('2023-07-17', '1951-12-18', 'MXN87195', 'P17592', 'SSN482807441', 'Calle 31 #901', 'MX', 'CIF040', 'Guadalajara', 'B', 'MX', 'CUST040', 'Laura', 'Laura López', TRUE, 'MEDIO', 'JAL', '5578702937', 'Cliente nuevo', '77939'),
  ('2024-09-30', '1964-04-26', 'MXN85545', 'P87741', 'SSN038920850', 'Calle 170 #775', 'MX', 'CIF041', 'Ciudad de México', 'A', 'MX', 'CUST041', 'Ana', 'Ana Hernández', TRUE, 'ALTO', 'JAL', '5581705687', 'Revisión especial', '35853'),
  ('2022-10-05', '1971-11-14', 'MXN87608', 'P38587', 'SSN654921151', 'Calle 2 #527', 'MX', 'CIF042', 'Ciudad de México', 'A', 'MX', 'CUST042', 'Jorge', 'Jorge Hernández', TRUE, 'BAJO', 'JAL', '5576846184', 'PEP relevante', '17919'),
  ('2023-08-25', '1965-04-15', 'MXN80504', 'P60913', 'SSN163066480', 'Calle 29 #792', 'MX', 'CIF043', 'Tijuana', 'C', 'MX', 'CUST043', 'Juan', 'Juan Martínez', FALSE, 'BAJO', 'CDMX', '5590583329', 'Revisión especial', '47806'),
  ('2023-12-14', '1966-01-23', 'MXN75413', 'P56561', 'SSN971674060', 'Calle 196 #459', 'MX', 'CIF044', 'Monterrey', 'C', 'MX', 'CUST044', 'Juan', 'Juan Gómez', TRUE, 'ALTO', 'PUE', '5544637764', 'PEP relevante', '97945'),
  ('2023-09-29', '1969-04-16', 'MXN29404', 'P26212', 'SSN409617375', 'Calle 12 #113', 'MX', 'CIF045', 'Monterrey', 'B', 'MX', 'CUST045', 'Luis', 'Luis Martínez', FALSE, 'ALTO', 'PUE', '5593024571', 'Revisión especial', '61466'),
  ('2022-06-04', '1990-11-28', 'MXN38833', 'P24990', 'SSN227011781', 'Calle 36 #171', 'MX', 'CIF046', 'Puebla', 'B', 'MX', 'CUST046', 'Sofía', 'Sofía Ramírez', FALSE, 'ALTO', 'JAL', '5592368312', 'Cliente nuevo', '90735'),
  ('2022-05-21', '1960-05-16', 'MXN62719', 'P61138', 'SSN942913963', 'Calle 131 #359', 'MX', 'CIF047', 'Tijuana', 'A', 'MX', 'CUST047', 'Luis', 'Luis López', TRUE, 'BAJO', 'BC', '5511561964', 'PEP relevante', '95692'),
  ('2024-02-29', '2003-02-21', 'MXN30109', 'P53324', 'SSN920201699', 'Calle 89 #246', 'MX', 'CIF048', 'Ciudad de México', 'C', 'MX', 'CUST048', 'Sofía', 'Sofía Ruiz', FALSE, 'ALTO', 'CDMX', '5530418358', 'Revisión especial', '67160'),
  ('2023-10-28', '2000-07-12', 'MXN26582', 'P03377', 'SSN151633794', 'Calle 143 #336', 'MX', 'CIF049', 'Monterrey', 'B', 'MX', 'CUST049', 'Ana', 'Ana Martínez', TRUE, 'ALTO', 'BC', '5588741960', 'Cliente nuevo', '30057'),
  ('2022-10-27', '1996-09-29', 'MXN15382', 'P32195', 'SSN909170917', 'Calle 40 #355', 'MX', 'CIF050', 'Puebla', 'B', 'MX', 'CUST050', 'Pedro', 'Pedro Gómez', TRUE, 'BAJO', 'JAL', '5586907560', 'Cliente habitual', '28822'),
  ('2022-09-13', '1962-10-05', 'MXN11470', 'P51434', 'SSN109679468', 'Calle 35 #938', 'MX', 'CIF051', 'Guadalajara', 'A', 'MX', 'CUST051', 'Luis', 'Luis Martínez', TRUE, 'BAJO', 'JAL', '5530461850', 'Revisión especial', '41600'),
  ('2022-03-04', '1961-10-31', 'MXN87913', 'P15297', 'SSN763364873', 'Calle 32 #235', 'MX', 'CIF052', 'Tijuana', 'A', 'MX', 'CUST052', 'María', 'María Ramírez', FALSE, 'ALTO', 'PUE', '5545738543', 'Cliente nuevo', '38495'),
  ('2023-05-21', '2003-08-15', 'MXN63489', 'P34666', 'SSN793761077', 'Calle 7 #509', 'MX', 'CIF053', 'Monterrey', 'B', 'MX', 'CUST053', 'Ana', 'Ana Pérez', TRUE, 'ALTO', 'BC', '5567801140', 'Revisión especial', '96791'),
  ('2022-07-15', '1957-02-07', 'MXN65892', 'P82419', 'SSN704864286', 'Calle 197 #471', 'MX', 'CIF054', 'Puebla', 'B', 'MX', 'CUST054', 'Sofía', 'Sofía Pérez', FALSE, 'MEDIO', 'JAL', '5525108440', 'PEP relevante', '34146'),
  ('2022-04-02', '1998-01-06', 'MXN31589', 'P49005', 'SSN135972148', 'Calle 117 #620', 'MX', 'CIF055', 'Tijuana', 'C', 'MX', 'CUST055', 'Ana', 'Ana Martínez', TRUE, 'BAJO', 'JAL', '5573813605', 'PEP relevante', '98357'),
  ('2023-04-19', '1988-04-19', 'MXN72449', 'P94800', 'SSN537170573', 'Calle 11 #720', 'MX', 'CIF056', 'Ciudad de México', 'A', 'MX', 'CUST056', 'Jorge', 'Jorge Fernández', TRUE, 'MEDIO', 'BC', '5544496601', 'Cliente habitual', '78885'),
  ('2023-04-02', '2003-11-01', 'MXN19933', 'P66167', 'SSN257480573', 'Calle 99 #396', 'MX', 'CIF057', 'Monterrey', 'A', 'MX', 'CUST057', 'Pedro', 'Pedro López', FALSE, 'MEDIO', 'CDMX', '5537977812', 'Cliente nuevo', '65241'),
  ('2023-12-24', '2005-09-06', 'MXN55196', 'P58343', 'SSN380893971', 'Calle 146 #247', 'MX', 'CIF058', 'Guadalajara', 'B', 'MX', 'CUST058', 'Laura', 'Laura Fernández', FALSE, 'BAJO', 'PUE', '5534124367', 'Cliente habitual', '98559'),
  ('2022-05-14', '1969-05-20', 'MXN39006', 'P06629', 'SSN968933889', 'Calle 110 #142', 'MX', 'CIF059', 'Guadalajara', 'C', 'MX', 'CUST059', 'Pedro', 'Pedro Fernández', FALSE, 'MEDIO', 'BC', '5513559654', 'PEP relevante', '12133'),
  ('2023-07-31', '1989-05-14', 'MXN76455', 'P76380', 'SSN791004267', 'Calle 69 #238', 'MX', 'CIF060', 'Tijuana', 'A', 'MX', 'CUST060', 'María', 'María Ramírez', TRUE, 'MEDIO', 'NL', '5523125632', 'Revisión especial', '85439'),
  ('2022-12-21', '1972-12-04', 'MXN66940', 'P77903', 'SSN902407531', 'Calle 30 #167', 'MX', 'CIF061', 'Guadalajara', 'C', 'MX', 'CUST061', 'Pedro', 'Pedro Pérez', TRUE, 'MEDIO', 'BC', '5526230583', 'Revisión especial', '10627'),
  ('2024-01-02', '1969-03-30', 'MXN89652', 'P72677', 'SSN202689805', 'Calle 32 #352', 'MX', 'CIF062', 'Puebla', 'B', 'MX', 'CUST062', 'Diana', 'Diana Fernández', FALSE, 'ALTO', 'JAL', '5542984230', 'PEP relevante', '97223'),
  ('2022-01-16', '1974-05-17', 'MXN82795', 'P08131', 'SSN919652681', 'Calle 77 #270', 'MX', 'CIF063', 'Ciudad de México', 'C', 'MX', 'CUST063', 'Sofía', 'Sofía Ramírez', FALSE, 'MEDIO', 'CDMX', '5589105590', 'Cliente nuevo', '77835'),
  ('2022-03-07', '1988-01-22', 'MXN17582', 'P66863', 'SSN060348011', 'Calle 128 #417', 'MX', 'CIF064', 'Tijuana', 'C', 'MX', 'CUST064', 'Sofía', 'Sofía Ramírez', TRUE, 'BAJO', 'BC', '5559255204', 'Cliente nuevo', '36205'),
  ('2024-12-08', '1979-08-01', 'MXN06682', 'P39295', 'SSN341079355', 'Calle 118 #953', 'MX', 'CIF065', 'Monterrey', 'B', 'MX', 'CUST065', 'Luis', 'Luis Pérez', FALSE, 'BAJO', 'NL', '5528464380', 'Revisión especial', '58797'),
  ('2023-01-09', '1964-04-02', 'MXN60095', 'P89907', 'SSN064383306', 'Calle 11 #739', 'MX', 'CIF066', 'Ciudad de México', 'B', 'MX', 'CUST066', 'María', 'María Ruiz', FALSE, 'MEDIO', 'JAL', '5551348030', 'Cliente nuevo', '85701'),
  ('2024-07-16', '1962-09-06', 'MXN31517', 'P44938', 'SSN680326994', 'Calle 43 #858', 'MX', 'CIF067', 'Guadalajara', 'A', 'MX', 'CUST067', 'Luis', 'Luis Gómez', TRUE, 'MEDIO', 'PUE', '5520199036', 'Cliente habitual', '42536'),
  ('2022-06-04', '1968-12-18', 'MXN43277', 'P12858', 'SSN130664324', 'Calle 34 #615', 'MX', 'CIF068', 'Guadalajara', 'A', 'MX', 'CUST068', 'Sofía', 'Sofía Hernández', FALSE, 'MEDIO', 'CDMX', '5560097726', 'Cliente nuevo', '32234'),
  ('2024-09-12', '1992-09-05', 'MXN45149', 'P24948', 'SSN558425109', 'Calle 40 #327', 'MX', 'CIF069', 'Ciudad de México', 'B', 'MX', 'CUST069', 'Jorge', 'Jorge Gómez', TRUE, 'ALTO', 'NL', '5517520903', 'Cliente nuevo', '74890'),
  ('2023-11-09', '2001-11-13', 'MXN50074', 'P75738', 'SSN215504305', 'Calle 147 #960', 'MX', 'CIF070', 'Tijuana', 'A', 'MX', 'CUST070', 'Juan', 'Juan Hernández', TRUE, 'BAJO', 'BC', '5593392842', 'Cliente habitual', '85291'),
  ('2022-07-14', '1985-01-02', 'MXN19116', 'P24308', 'SSN335993225', 'Calle 87 #183', 'MX', 'CIF071', 'Puebla', 'A', 'MX', 'CUST071', 'María', 'María López', FALSE, 'MEDIO', 'CDMX', '5569480625', 'Revisión especial', '20907'),
  ('2024-11-29', '1970-02-09', 'MXN04385', 'P82513', 'SSN973673856', 'Calle 14 #735', 'MX', 'CIF072', 'Ciudad de México', 'C', 'MX', 'CUST072', 'Diana', 'Diana Gómez', TRUE, 'MEDIO', 'JAL', '5549463862', 'Revisión especial', '92072'),
  ('2023-10-07', '1968-01-29', 'MXN76935', 'P30584', 'SSN633990936', 'Calle 44 #414', 'MX', 'CIF073', 'Guadalajara', 'B', 'MX', 'CUST073', 'Ana', 'Ana Hernández', FALSE, 'BAJO', 'JAL', '5537405903', 'Cliente habitual', '62565'),
  ('2023-08-28', '1972-07-25', 'MXN38802', 'P72647', 'SSN849270429', 'Calle 74 #573', 'MX', 'CIF074', 'Tijuana', 'A', 'MX', 'CUST074', 'Diana', 'Diana Ruiz', FALSE, 'BAJO', 'NL', '5582384523', 'Revisión especial', '83313'),
  ('2023-12-07', '1952-06-06', 'MXN28118', 'P56249', 'SSN820119847', 'Calle 184 #550', 'MX', 'CIF075', 'Ciudad de México', 'B', 'MX', 'CUST075', 'Carlos', 'Carlos Ruiz', FALSE, 'MEDIO', 'CDMX', '5547528681', 'Revisión especial', '16541'),
  ('2023-11-27', '1958-03-14', 'MXN40323', 'P69673', 'SSN575526276', 'Calle 193 #915', 'MX', 'CIF076', 'Ciudad de México', 'C', 'MX', 'CUST076', 'Laura', 'Laura Hernández', FALSE, 'ALTO', 'JAL', '5546552822', 'Cliente habitual', '99916'),
  ('2023-06-28', '1955-06-19', 'MXN80203', 'P39884', 'SSN121411721', 'Calle 200 #312', 'MX', 'CIF077', 'Monterrey', 'A', 'MX', 'CUST077', 'Sofía', 'Sofía Pérez', FALSE, 'ALTO', 'CDMX', '5569706046', 'Revisión especial', '88489'),
  ('2022-09-23', '1985-10-13', 'MXN95762', 'P36725', 'SSN880309974', 'Calle 40 #868', 'MX', 'CIF078', 'Ciudad de México', 'A', 'MX', 'CUST078', 'Ana', 'Ana Ramírez', FALSE, 'MEDIO', 'PUE', '5546355523', 'Cliente habitual', '10493'),
  ('2022-08-06', '1953-09-28', 'MXN47913', 'P76553', 'SSN268872375', 'Calle 160 #552', 'MX', 'CIF079', 'Monterrey', 'B', 'MX', 'CUST079', 'Diana', 'Diana Fernández', TRUE, 'BAJO', 'JAL', '5523541287', 'Cliente nuevo', '12473'),
  ('2024-04-26', '1993-10-01', 'MXN87677', 'P19460', 'SSN093998094', 'Calle 42 #426', 'MX', 'CIF080', 'Ciudad de México', 'C', 'MX', 'CUST080', 'Ana', 'Ana Gómez', FALSE, 'MEDIO', 'JAL', '5543796924', 'Cliente nuevo', '14316'),
  ('2023-07-20', '1965-08-18', 'MXN69578', 'P17731', 'SSN111526956', 'Calle 158 #152', 'MX', 'CIF081', 'Guadalajara', 'B', 'MX', 'CUST081', 'Luis', 'Luis Gómez', TRUE, 'MEDIO', 'JAL', '5528521380', 'Cliente habitual', '48256'),
  ('2024-10-01', '1977-11-25', 'MXN82484', 'P86452', 'SSN332026506', 'Calle 78 #672', 'MX', 'CIF082', 'Ciudad de México', 'B', 'MX', 'CUST082', 'Carlos', 'Carlos Ramírez', FALSE, 'MEDIO', 'JAL', '5561207823', 'Cliente habitual', '52817'),
  ('2024-05-15', '1981-02-01', 'MXN23097', 'P99968', 'SSN424830217', 'Calle 136 #455', 'MX', 'CIF083', 'Guadalajara', 'A', 'MX', 'CUST083', 'Juan', 'Juan López', FALSE, 'BAJO', 'JAL', '5588652701', 'Revisión especial', '75115'),
  ('2024-08-16', '1969-05-02', 'MXN63430', 'P44090', 'SSN823525945', 'Calle 6 #445', 'MX', 'CIF084', 'Puebla', 'B', 'MX', 'CUST084', 'Ana', 'Ana Ramírez', FALSE, 'ALTO', 'CDMX', '5585651148', 'PEP relevante', '70878'),
  ('2023-12-03', '2002-11-16', 'MXN02233', 'P80656', 'SSN930050138', 'Calle 85 #182', 'MX', 'CIF085', 'Ciudad de México', 'B', 'MX', 'CUST085', 'Laura', 'Laura Ramírez', FALSE, 'BAJO', 'BC', '5587848986', 'Cliente nuevo', '88325'),
  ('2024-07-21', '1960-08-30', 'MXN97773', 'P96647', 'SSN001617138', 'Calle 174 #165', 'MX', 'CIF086', 'Monterrey', 'B', 'MX', 'CUST086', 'Carlos', 'Carlos Ruiz', FALSE, 'MEDIO', 'BC', '5513150252', 'Cliente nuevo', '18121'),
  ('2022-02-07', '1989-06-08', 'MXN38316', 'P54095', 'SSN344715053', 'Calle 79 #407', 'MX', 'CIF087', 'Tijuana', 'A', 'MX', 'CUST087', 'Sofía', 'Sofía Gómez', FALSE, 'ALTO', 'JAL', '5571182164', 'Revisión especial', '51148'),
  ('2023-01-10', '1973-11-05', 'MXN99823', 'P04713', 'SSN197124949', 'Calle 64 #834', 'MX', 'CIF088', 'Tijuana', 'C', 'MX', 'CUST088', 'Juan', 'Juan Gómez', FALSE, 'MEDIO', 'BC', '5516141525', 'Cliente nuevo', '53429'),
  ('2022-03-13', '2003-02-04', 'MXN64843', 'P30768', 'SSN000185841', 'Calle 106 #877', 'MX', 'CIF089', 'Guadalajara', 'C', 'MX', 'CUST089', 'Jorge', 'Jorge Pérez', TRUE, 'ALTO', 'PUE', '5577221026', 'Revisión especial', '32723'),
  ('2023-11-24', '2002-01-10', 'MXN80077', 'P49232', 'SSN265424946', 'Calle 64 #503', 'MX', 'CIF090', 'Ciudad de México', 'B', 'MX', 'CUST090', 'Diana', 'Diana Ruiz', FALSE, 'ALTO', 'BC', '5585458729', 'Cliente nuevo', '14297'),
  ('2022-03-09', '1978-11-25', 'MXN66230', 'P53353', 'SSN834120057', 'Calle 104 #257', 'MX', 'CIF091', 'Puebla', 'B', 'MX', 'CUST091', 'Sofía', 'Sofía Martínez', FALSE, 'MEDIO', 'PUE', '5560268788', 'Revisión especial', '67484'),
  ('2023-03-20', '1967-05-09', 'MXN66896', 'P70912', 'SSN787079708', 'Calle 184 #620', 'MX', 'CIF092', 'Puebla', 'B', 'MX', 'CUST092', 'María', 'María Hernández', FALSE, 'ALTO', 'PUE', '5511392738', 'Cliente habitual', '25734'),
  ('2024-05-03', '1995-09-28', 'MXN78018', 'P34293', 'SSN450471299', 'Calle 38 #330', 'MX', 'CIF093', 'Ciudad de México', 'B', 'MX', 'CUST093', 'Pedro', 'Pedro Ramírez', TRUE, 'MEDIO', 'PUE', '5580638620', 'PEP relevante', '70654'),
  ('2023-11-11', '1952-05-16', 'MXN17099', 'P35588', 'SSN248794279', 'Calle 134 #488', 'MX', 'CIF094', 'Tijuana', 'C', 'MX', 'CUST094', 'Carlos', 'Carlos Hernández', FALSE, 'MEDIO', 'BC', '5524218450', 'Cliente habitual', '70781'),
  ('2022-06-06', '1961-02-19', 'MXN73371', 'P38203', 'SSN502062405', 'Calle 1 #247', 'MX', 'CIF095', 'Tijuana', 'C', 'MX', 'CUST095', 'Juan', 'Juan López', FALSE, 'MEDIO', 'JAL', '5592848360', 'Revisión especial', '35520'),
  ('2024-03-24', '1974-12-04', 'MXN84341', 'P86762', 'SSN566676866', 'Calle 35 #755', 'MX', 'CIF096', 'Monterrey', 'B', 'MX', 'CUST096', 'Pedro', 'Pedro Martínez', FALSE, 'ALTO', 'CDMX', '5591017039', 'Cliente nuevo', '18218'),
  ('2023-06-17', '1980-05-18', 'MXN23772', 'P60691', 'SSN132240607', 'Calle 165 #154', 'MX', 'CIF097', 'Monterrey', 'B', 'MX', 'CUST097', 'Carlos', 'Carlos Martínez', TRUE, 'MEDIO', 'CDMX', '5590924729', 'Cliente habitual', '12177'),
  ('2024-05-31', '1970-02-01', 'MXN47211', 'P61537', 'SSN646014902', 'Calle 83 #996', 'MX', 'CIF098', 'Monterrey', 'A', 'MX', 'CUST098', 'Laura', 'Laura López', FALSE, 'MEDIO', 'NL', '5523375709', 'PEP relevante', '35315'),
  ('2024-09-02', '1994-02-13', 'MXN38419', 'P85256', 'SSN592505404', 'Calle 106 #109', 'MX', 'CIF099', 'Guadalajara', 'A', 'MX', 'CUST099', 'Juan', 'Juan Pérez', FALSE, 'MEDIO', 'JAL', '5590854775', 'Cliente habitual', '47553'),
  ('2022-12-21', '1970-06-26', 'MXN81345', 'P92902', 'SSN724736372', 'Calle 75 #803', 'MX', 'CIF100', 'Tijuana', 'A', 'MX', 'CUST100', 'Sofía', 'Sofía Fernández', FALSE, 'BAJO', 'JAL', '5518022496', 'Revisión especial', '36556');


























