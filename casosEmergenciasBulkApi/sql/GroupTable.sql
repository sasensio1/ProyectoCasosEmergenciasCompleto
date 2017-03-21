CREATE TABLE "group" (
	"id" INTEGER NOT NULL DEFAULT E'',
	"_hc_lastop" VARCHAR(32) NULL DEFAULT NULL,
	"sfid" VARCHAR(18) NULL DEFAULT NULL,
	"createddate" TIMESTAMP NULL,
	"name" VARCHAR(40) NULL DEFAULT NULL,
	"systemmodstamp" TIMESTAMP NULL,
	"_hc_err" TEXT NULL DEFAULT NULL,
	UNIQUE INDEX "UNIQUE" ("sfid")
)
;

CREATE SEQUENCE group_id_seq MINVALUE 0;
ALTER TABLE "group" ALTER id SET DEFAULT nextval('group_id_seq');
ALTER SEQUENCE group_id_seq OWNED BY group.id;