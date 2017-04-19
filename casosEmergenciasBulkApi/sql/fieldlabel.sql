CREATE TABLE fieldlabel (
	id 		INTEGER NOT NULL,
	objeto 	VARCHAR(255) NULL DEFAULT NULL,
	campo 	VARCHAR(255) NULL DEFAULT NULL,
	label 	VARCHAR(255) NULL DEFAULT NULL,
	PRIMARY KEY (id)
);

CREATE SEQUENCE fieldlabel_id_seq MINVALUE 0;
ALTER TABLE fieldlabel ALTER id SET DEFAULT nextval('fieldlabel_id_seq');
ALTER SEQUENCE fieldlabel_id_seq OWNED BY fieldlabel.id;