create database bloodnetwork;

CREATE USER sysman IDENTIFIED BY 'sysman'; 
grant usage on *.* to sysman@localhost identified by 'sysman'; 
grant all privileges on bloodnetwork.* to sysman@localhost;


CREATE TABLE bloodnetwork.REGISTERED_USERS (FB_ID VARCHAR(30) NOT NULL, 
		BLOOD_GRP VARCHAR(30) NOT NULL,
		AVAILABILITY VARCHAR(30));
		
		
CREATE  TABLE bloodnetwork.LOCATION (

  FACEBOOK_ID VARCHAR(30) NOT NULL ,

  LOCATION_ID VARCHAR(30) NOT NULL ,

  LOCATION VARCHAR(45) NOT NULL );
  
  
  
  CREATE  TABLE bloodnetwork.EMPLOYERS (

  FACEBOOK_ID VARCHAR(30) NOT NULL ,

  EMPLOYER_ID VARCHAR(30) NULL ,

  EMPLOYER_NAME VARCHAR(45) NULL );