-- Création de la table Game dans le schéma de production (APP)

CREATE TABLE APP.Game (
	id_game int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	name VARCHAR(100),
	description VARCHAR(1000),
	category VARCHAR(20),
	editor VARCHAR(50),
	author VARCHAR(50),
	publishing_year INT,
	nb_players INT,
	PRIMARY KEY (id_game)
);


-- Création de la table Game dans le schéma de test (TEST)

CREATE TABLE TEST.Game (
	id_game int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	name VARCHAR(100),
	description VARCHAR(1000),
	category VARCHAR(20),
	editor VARCHAR(50),
	author VARCHAR(50),
	publishing_year INT,
	nb_players INT,
	PRIMARY KEY (id_game)
);