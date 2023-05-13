CREATE SCHEMA animals;

USE animals;

CREATE TABLE animals_type (
    idanimals_type INT AUTO_INCREMENT PRIMARY KEY,
    animal_type_name VARCHAR(20)
);

INSERT INTO animals_type (animal_type_name) VALUES ('Pet'), ('Pack_Animal');

SELECT * FROM animals_type;

CREATE TABLE pets
(
    idpets INT AUTO_INCREMENT PRIMARY KEY,
    animal_type VARCHAR (20),
    id_of_animal_type INT,
    FOREIGN KEY (id_of_animal_type) REFERENCES animals_type (idanimals_type) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO pets (animal_type, id_of_animal_type) VALUES ('Cats', 1), ('Dogs', 1), ('Hamsters', 1);

SELECT * FROM pets;

CREATE TABLE pack_animals
(
    idpack_animals INT AUTO_INCREMENT PRIMARY KEY,
    animal_type VARCHAR (20),
    id_of_animal_type INT,
    FOREIGN KEY (id_of_animal_type) REFERENCES animals_type (idanimals_type) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO pack_animals (animal_type, id_of_animal_type) VALUES ('Horses', 2), ('Camels', 2), ('Donkeys', 2);

SELECT * FROM pack_animals;

CREATE TABLE cats 
(
    idcats INT AUTO_INCREMENT PRIMARY KEY,
    id_of_animal_type INT,
    name_of_pet VARCHAR(45) NULL,
    birthday DATE,
    actions VARCHAR(45),
    FOREIGN KEY (id_of_animal_type) REFERENCES pets (idpets) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO cats (id_of_animal_type, name_of_pet, birthday, actions)
VALUES (1, 'Barsik', '2022-01-01', 'eat, sleep, meow'), (1, 'Pushistik', '2021-01-01', 'eat, sleep, meow');

SELECT * FROM cats;

CREATE TABLE dogs 
(
    iddogs INT AUTO_INCREMENT PRIMARY KEY,
    id_of_animal_type INT,
    name_of_pet VARCHAR(45) NULL,
    birthday DATE,
    actions VARCHAR(45),
    FOREIGN KEY (id_of_animal_type) REFERENCES pets (idpets) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO dogs (id_of_animal_type, name_of_pet, birthday, actions)
VALUES (2, 'Spheroid', '2023-02-02', 'eat, sleep, bark'), (2, 'Polkan', '2022-09-21', 'eat, sleep, bark');

SELECT * FROM dogs;

CREATE TABLE hamsters 
(
    idhamsters INT AUTO_INCREMENT PRIMARY KEY,
    id_of_animal_type INT,
    name_of_pet VARCHAR(45) NULL,
    birthday DATE,
    actions VARCHAR(45),
    FOREIGN KEY (id_of_animal_type) REFERENCES pets (idpets) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO hamsters (id_of_animal_type, name_of_pet, birthday, actions)
VALUES (3, 'Lucky', '2023-05-05', 'eat, sleep, running'), (3, 'Toothy', '2022-10-11', 'eat, sleep, running');

SELECT * FROM hamsters; 

CREATE TABLE horses 
(
    idhorses INT AUTO_INCREMENT PRIMARY KEY,
    id_of_animal_type INT,
    name_of_animal VARCHAR(45) NULL,
    birthday DATE,
    actions VARCHAR(45),
    FOREIGN KEY (id_of_animal_type) REFERENCES pack_animals (idpack_animals) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO horses (id_of_animal_type, name_of_animal, birthday, actions)
VALUES (1, 'Mustang', '2016-01-01', 'eat, sleep, hallop'), (1, 'Mercedes', '2015-11-01', 'eat, sleep, jump');

SELECT * FROM horses;

CREATE TABLE camels 
(
    idcamels INT AUTO_INCREMENT PRIMARY KEY,
    id_of_animal_type INT,
    name_of_animal VARCHAR(45) NULL,
    birthday DATE,
    actions VARCHAR(45),
    FOREIGN KEY (id_of_animal_type) REFERENCES pack_animals (idpack_animals) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO camels (id_of_animal_type, name_of_animal, birthday, actions)
VALUES (2, 'Mustafa', '2000-01-01', 'eat, sleep, cry'), (2, 'Uruk', '2005-01-01', 'eat, sleep, cry');

SELECT * FROM camels;

CREATE TABLE donkeys 
(
    iddonkeys INT AUTO_INCREMENT PRIMARY KEY,
    id_of_animal_type INT,
    name_of_animal VARCHAR(45) NULL,
    birthday DATE,
    actions VARCHAR(45),
    FOREIGN KEY (id_of_animal_type) REFERENCES pack_animals (idpack_animals) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO donkeys (id_of_animal_type, name_of_animal, birthday, actions)
VALUES (3, 'Iee-Haa', '2006-01-01', 'eat, sleep, be so sad'), (3, 'Donkey Hot', '2022-02-21', 'eat, sleep, Crush Windmill');

SELECT * FROM donkeys;

DELETE FROM camels LIMIT 1000;

SELECT * FROM camels;

SELECT * FROM horses
UNION ALL SELECT * FROM donkeys;

CREATE TEMPORARY TABLE allanimals AS
SELECT *, 'Cats' AS animal_type FROM cats
UNION SELECT *, 'Dogs' AS animal_type FROM dogs
UNION SELECT *, 'Hamsters' AS animal_type FROM hamsters
UNION SELECT *, 'Horses' AS animal_type FROM horses
UNION SELECT *, 'Camels' AS animal_type FROM camels
UNION SELECT *, 'Donkeys' AS animal_type FROM donkeys;

SELECT * FROM allanimals;

CREATE TABLE calc_age AS
SELECT name_of_pet, birthday, actions, animal_type, timestampdiff(month, birthday, curdate()) AS months_age
FROM allanimals;

CREATE TABLE young_animals AS
SELECT * FROM calc_age AS ca
WHERE ca.months_age BETWEEN 12 AND 36;

SELECT * FROM young_animals;

SELECT h.name_of_animal, h.birthday, h.actions, p.animal_type, ya.months_age
FROM horses h
LEFT JOIN calc_age ya ON ya.name_of_pet = h.name_of_animal
LEFT JOIN pack_animals p ON p.idpack_animals = h.id_of_animal_type
UNION
SELECT c.name_of_animal, c.birthday, c.actions, p.animal_type, ya.months_age
FROM camels c
LEFT JOIN calc_age ya ON ya.name_of_pet = c.name_of_animal
LEFT JOIN pack_animals p ON p.idpack_animals = c.id_of_animal_type
UNION
SELECT d.name_of_animal, d.birthday, d.actions, p.animal_type, ya.months_age
FROM donkeys d
LEFT JOIN calc_age ya ON ya.name_of_pet = d.name_of_animal
LEFT JOIN pack_animals p ON p.idpack_animals = d.id_of_animal_type
UNION
SELECT dg.name_of_pet, dg.birthday, dg.actions, pt.animal_type, ya.months_age
FROM dogs dg
LEFT JOIN calc_age ya ON ya.name_of_pet = dg.name_of_pet
LEFT JOIN pets pt ON pt.idpets = dg.id_of_animal_type
UNION
SELECT ct.name_of_pet, ct.birthday, ct.actions, pt.animal_type, ya.months_age
FROM cats ct
LEFT JOIN calc_age ya ON ya.name_of_pet = ct.name_of_pet
LEFT JOIN pets pt ON pt.idpets = ct.id_of_animal_type
UNION
SELECT hm.name_of_pet, hm.birthday, hm.actions, pt.animal_type, ya.months_age
FROM hamsters hm
LEFT JOIN calc_age ya ON ya.name_of_pet = hm.name_of_pet
LEFT JOIN pets pt ON pt.idpets = hm.id_of_animal_type;