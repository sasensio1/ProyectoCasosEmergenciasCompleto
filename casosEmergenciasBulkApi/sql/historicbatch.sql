CREATE TABLE HistoricBatch (
	  	id					INTEGER NOT NULL,
		process_id 			VARCHAR(255),
		sfid_record			VARCHAR(255),
		start_date			TIMESTAMP,
		end_date			TIMESTAMP,
		object				VARCHAR(255),
		operation			VARCHAR(255),
		total_records		INTEGER,
		processed_records 	INTEGER,
  		success				BOOLEAN,
		error_cause			VARCHAR(255),

	PRIMARY KEY (id)
);

CREATE SEQUENCE historicbatch_id_seq MINVALUE 0;
ALTER TABLE HistoricBatch ALTER id SET DEFAULT nextval('historicbatch_id_seq');
ALTER SEQUENCE historicbatch_id_seq OWNED BY HistoricBatch.id;