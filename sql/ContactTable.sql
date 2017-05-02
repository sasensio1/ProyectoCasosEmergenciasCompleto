CREATE TABLE "contact" (
	"department" VARCHAR(80) NULL DEFAULT NULL,
	"identitynumber__c" VARCHAR(255) NULL DEFAULT NULL,
	"typepointofdeliveryrelationship__c" VARCHAR(255) NULL DEFAULT NULL,
	"sf4twitter__twitter_follower_count__c" DOUBLE PRECISION NULL DEFAULT NULL,
	"ownerid" VARCHAR(18) NULL DEFAULT NULL,
	"sfid" VARCHAR(18) NULL DEFAULT NULL,
	"createdbyid" VARCHAR(18) NULL DEFAULT NULL,
	"repeatedcases__c" BOOLEAN NULL DEFAULT NULL,
	"contacttype__c" VARCHAR(255) NULL DEFAULT NULL,
	"isdeleted" BOOLEAN NULL DEFAULT NULL,
	"firstname" VARCHAR(40) NULL DEFAULT NULL,
	"concatenatecontacaddress__c" VARCHAR(1300) NULL DEFAULT NULL,
	"systemmodstamp" TIMESTAMP NULL,
	"sf4twitter__twitter_bio__c" VARCHAR(255) NULL DEFAULT NULL,
	"contactaddress__c" VARCHAR(18) NULL DEFAULT NULL,
	"sf4twitter__origin__c" VARCHAR(255) NULL DEFAULT NULL,
	"concatenatename__c" VARCHAR(1300) NULL DEFAULT NULL,
	"preferredchannelcontact__c" VARCHAR(255) NULL DEFAULT NULL,
	"secondaryphone__c" VARCHAR(40) NULL DEFAULT NULL,
	"id" INTEGER NOT NULL DEFAULT NULL,
	"identifycertificatenumberseries__c" DOUBLE PRECISION NULL DEFAULT NULL,
	"_hc_lastop" VARCHAR(32) NULL DEFAULT NULL,
	"vip__c" BOOLEAN NULL DEFAULT NULL,
	"fatherslastname__c" VARCHAR(1300) NULL DEFAULT NULL,
	"companyid__c" VARCHAR(255) NULL DEFAULT NULL,
	"phone" VARCHAR(40) NULL DEFAULT NULL,
	"fullname__c" VARCHAR(1300) NULL DEFAULT NULL,
	"sf4twitter__fcbk_username__c" VARCHAR(255) NULL DEFAULT NULL,
	"relationshipdetail__c" VARCHAR(255) NULL DEFAULT NULL,
	"sf4twitter__influencer_type__c" VARCHAR(255) NULL DEFAULT NULL,
	"identitytype__c" VARCHAR(255) NULL DEFAULT NULL,
	"sf4twitter__influencer__c" VARCHAR(255) NULL DEFAULT NULL,
	"name" VARCHAR(121) NULL DEFAULT NULL,
	"account__company__c" VARCHAR(255) NULL DEFAULT NULL,
	"secondaryemail__c" VARCHAR(80) NULL DEFAULT NULL,
	"lastmodifiedbyid" VARCHAR(18) NULL DEFAULT NULL,
	"additionalphone__c" VARCHAR(40) NULL DEFAULT NULL,
	"mobilephone" VARCHAR(40) NULL DEFAULT NULL,
	"motherslastname__c" VARCHAR(255) NULL DEFAULT NULL,
	"accountid" VARCHAR(18) NULL DEFAULT NULL,
	"sf4twitter__twitter_user_id__c" VARCHAR(255) NULL DEFAULT NULL,
	"personsegment__c" VARCHAR(255) NULL DEFAULT NULL,
	"sf4twitter__contact_source__c" VARCHAR(80) NULL DEFAULT NULL,
	"_hc_err" TEXT NULL DEFAULT NULL,
	"longtel2__c" DOUBLE PRECISION NULL DEFAULT NULL,
	"sf4twitter__twitter_username__c" VARCHAR(50) NULL DEFAULT NULL,
	"jobemail__c" VARCHAR(80) NULL DEFAULT NULL,
	"sf4twitter__fcbk_user_id__c" VARCHAR(255) NULL DEFAULT NULL,
	"masterrecordid" VARCHAR(18) NULL DEFAULT NULL,
	"email" VARCHAR(80) NULL DEFAULT NULL,
	"associatedaccounttype__c" VARCHAR(1300) NULL DEFAULT NULL,
	"createddate" TIMESTAMP NULL,
	"birthdate" DATE NULL DEFAULT NULL,
	PRIMARY KEY ("sfid")

)
;

COMMENT ON COLUMN "contact"."department" IS E'';
COMMENT ON COLUMN "contact"."identitynumber__c" IS E'';
COMMENT ON COLUMN "contact"."typepointofdeliveryrelationship__c" IS E'';
COMMENT ON COLUMN "contact"."sf4twitter__twitter_follower_count__c" IS E'';
COMMENT ON COLUMN "contact"."ownerid" IS E'';
COMMENT ON COLUMN "contact"."sfid" IS E'';
COMMENT ON COLUMN "contact"."createdbyid" IS E'';
COMMENT ON COLUMN "contact"."repeatedcases__c" IS E'';
COMMENT ON COLUMN "contact"."contacttype__c" IS E'';
COMMENT ON COLUMN "contact"."isdeleted" IS E'';
COMMENT ON COLUMN "contact"."firstname" IS E'';
COMMENT ON COLUMN "contact"."concatenatecontacaddress__c" IS E'';
COMMENT ON COLUMN "contact"."systemmodstamp" IS E'';
COMMENT ON COLUMN "contact"."sf4twitter__twitter_bio__c" IS E'';
COMMENT ON COLUMN "contact"."contactaddress__c" IS E'';
COMMENT ON COLUMN "contact"."sf4twitter__origin__c" IS E'';
COMMENT ON COLUMN "contact"."concatenatename__c" IS E'';
COMMENT ON COLUMN "contact"."preferredchannelcontact__c" IS E'';
COMMENT ON COLUMN "contact"."secondaryphone__c" IS E'';
COMMENT ON COLUMN "contact"."id" IS E'';
COMMENT ON COLUMN "contact"."identifycertificatenumberseries__c" IS E'';
COMMENT ON COLUMN "contact"."_hc_lastop" IS E'';
COMMENT ON COLUMN "contact"."vip__c" IS E'';
COMMENT ON COLUMN "contact"."fatherslastname__c" IS E'';
COMMENT ON COLUMN "contact"."companyid__c" IS E'';
COMMENT ON COLUMN "contact"."phone" IS E'';
COMMENT ON COLUMN "contact"."fullname__c" IS E'';
COMMENT ON COLUMN "contact"."sf4twitter__fcbk_username__c" IS E'';
COMMENT ON COLUMN "contact"."relationshipdetail__c" IS E'';
COMMENT ON COLUMN "contact"."sf4twitter__influencer_type__c" IS E'';
COMMENT ON COLUMN "contact"."identitytype__c" IS E'';
COMMENT ON COLUMN "contact"."sf4twitter__influencer__c" IS E'';
COMMENT ON COLUMN "contact"."name" IS E'';
COMMENT ON COLUMN "contact"."account__company__c" IS E'';
COMMENT ON COLUMN "contact"."secondaryemail__c" IS E'';
COMMENT ON COLUMN "contact"."lastmodifiedbyid" IS E'';
COMMENT ON COLUMN "contact"."additionalphone__c" IS E'';
COMMENT ON COLUMN "contact"."mobilephone" IS E'';
COMMENT ON COLUMN "contact"."motherslastname__c" IS E'';
COMMENT ON COLUMN "contact"."accountid" IS E'';
COMMENT ON COLUMN "contact"."sf4twitter__twitter_user_id__c" IS E'';
COMMENT ON COLUMN "contact"."personsegment__c" IS E'';
COMMENT ON COLUMN "contact"."sf4twitter__contact_source__c" IS E'';
COMMENT ON COLUMN "contact"."_hc_err" IS E'';
COMMENT ON COLUMN "contact"."longtel2__c" IS E'';
COMMENT ON COLUMN "contact"."sf4twitter__twitter_username__c" IS E'';
COMMENT ON COLUMN "contact"."jobemail__c" IS E'';
COMMENT ON COLUMN "contact"."sf4twitter__fcbk_user_id__c" IS E'';
COMMENT ON COLUMN "contact"."masterrecordid" IS E'';
COMMENT ON COLUMN "contact"."email" IS E'';
COMMENT ON COLUMN "contact"."associatedaccounttype__c" IS E'';
COMMENT ON COLUMN "contact"."createddate" IS E'';
COMMENT ON COLUMN "contact"."birthdate" IS E'';

CREATE SEQUENCE contact_id_seq MINVALUE 0;
ALTER TABLE contact ALTER id SET DEFAULT nextval('contact_id_seq');
ALTER SEQUENCE contact_id_seq OWNED BY contact.id;

