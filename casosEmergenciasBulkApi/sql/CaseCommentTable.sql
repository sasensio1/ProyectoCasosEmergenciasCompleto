CREATE TABLE "casecomment" (
	"createddate" TIMESTAMP NULL,
	"systemmodstamp" TIMESTAMP NULL,
	"lastmodifieddate" TIMESTAMP NULL,
	"createdbyid" VARCHAR(18) NULL DEFAULT NULL,
	"commentbody" VARCHAR(4000) NULL DEFAULT NULL,
	"parentid" VARCHAR(18) NULL DEFAULT NULL,
	"isdeleted" BOOLEAN NULL DEFAULT NULL,
	"lastmodifiedbyid" VARCHAR(18) NULL DEFAULT NULL,
	"ispublished" BOOLEAN NULL DEFAULT NULL,
	"_hc_lastop" VARCHAR(32) NULL DEFAULT NULL,
	"_hc_err" TEXT NULL DEFAULT NULL,
	"sfid" VARCHAR(18) NULL DEFAULT NULL,
	"id" INTEGER NOT NULL DEFAULT E'',
	UNIQUE INDEX "UNIQUE" ("sfid")
)
;

CREATE SEQUENCE casecomment_id_seq MINVALUE 0;
ALTER TABLE casecomment ALTER id SET DEFAULT nextval('casecomment_id_seq');
ALTER SEQUENCE casecomment_id_seq OWNED BY casecomment.id;