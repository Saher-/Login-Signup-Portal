DROP TABLE login_auth;
DROP SEQUENCE seq_id;

CREATE TABLE login_auth (
  ID     NUMBER(19,0) PRIMARY KEY NOT NULL,
  UsrName   VARCHAR2 (50) NOT NULL UNIQUE,
  Pin       VARCHAR2 (50) NOT NULL,
  Email     VARCHAR2 (50) NOT NULL,
  Phone     INTEGER NOT NULL,
  Dob       Date,
  Pref1     VARCHAR2 (50),
  Pref2     VARCHAR2 (50),
  Pref3     VARCHAR2 (50),
  Pref4     VARCHAR2 (50),
  Pref5     VARCHAR2 (50),
  Pref6     VARCHAR2 (50),
  Pref7     VARCHAR2 (50),
  Pref8     VARCHAR2 (50),
  Pref9     VARCHAR2 (50),
  Pref10    VARCHAR2 (50),
  Pref11    VARCHAR2 (50),
  Pref12    VARCHAR2 (50),
  Lang1     VARCHAR2 (50),
  Lang2     VARCHAR2 (50),
  Lang3     VARCHAR2 (50)
);

CREATE SEQUENCE seq_id
MINVALUE 1
START WITH 1
INCREMENT BY 1
NOMAXVALUE
CACHE 10;