--------------------------------------------------------
--  File created - Wednesday-September-14-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table ADVERTISERDETAILS
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."ADVERTISERDETAILS" 
   (	"NAME" VARCHAR2(400 BYTE), 
	"ADVERTISERID" VARCHAR2(20 BYTE), 
	"PHONENUMBER" NUMBER, 
	"ADDRESS" VARCHAR2(500 BYTE), 
	"QUESTION" VARCHAR2(400 BYTE), 
	"ANSWER" VARCHAR2(400 BYTE), 
	"PASSWORD" VARCHAR2(400 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SYSTEM" ;
