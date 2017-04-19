CREATE TABLE picklists (
	id			INTEGER NOT NULL,
	objeto		VARCHAR(255) NULL DEFAULT NULL,
	campo		VARCHAR(255) NULL DEFAULT NULL,
	codigo		VARCHAR(255) NULL DEFAULT NULL,
	valor		VARCHAR(255) NULL DEFAULT NULL,
	PRIMARY KEY (id)
);

CREATE SEQUENCE picklists_id_seq MINVALUE 0;
ALTER TABLE picklists ALTER id SET DEFAULT nextval('picklists_id_seq');
ALTER SEQUENCE picklists_id_seq OWNED BY picklists.id;
