CREATE TABLE "user" (
	"sfid" VARCHAR(18) NULL DEFAULT NULL,
	"id" INTEGER NOT NULL DEFAULT E'',
	"createddate" TIMESTAMP NULL,
	"systemmodstamp" TIMESTAMP NULL,
	"_hc_err" TEXT NULL DEFAULT NULL,
	"_hc_lastop" VARCHAR(32) NULL DEFAULT NULL,
	"name" VARCHAR(121) NULL DEFAULT NULL,
	UNIQUE INDEX "UNIQUE" ("sfid")
)
;

CREATE SEQUENCE user_id_seq MINVALUE 0;
ALTER TABLE user ALTER id SET DEFAULT nextval('user_id_seq');
ALTER SEQUENCE user_id_seq OWNED BY user.id;

