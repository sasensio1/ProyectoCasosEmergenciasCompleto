CREATE TABLE HistoricBatch (
	id 			INTEGER NOT NULL,
	sfidJob 	VARCHAR(255),
	start_date 	TIMESTAMP,
	end_date 	TIMESTAMP,
	object 		VARCHAR(255),
	operation 	VARCHAR(255),
	result 		VARCHAR(255),
	num_records	INTEGER,
	PRIMARY KEY (id)
);

CREATE SEQUENCE historicbatch_id_seq MINVALUE 0;
ALTER TABLE HistoricBatch ALTER id SET DEFAULT nextval('historicbatch_id_seq');
ALTER SEQUENCE historicbatch_id_seq OWNED BY HistoricBatch.id;