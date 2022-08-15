CREATE TABLE user (
  username VARCHAR(50) NOT NULL PRIMARY KEY,
  email VARCHAR(50),
  password VARCHAR(500),
  activated BOOLEAN DEFAULT FALSE,
  activationkey VARCHAR(50) DEFAULT NULL,
  resetpasswordkey VARCHAR(50) DEFAULT NULL,
  role VARCHAR(50) DEFAULT NULL
);

CREATE TABLE authority (
  name VARCHAR(50) NOT NULL PRIMARY KEY
);

CREATE TABLE user_authority (
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    FOREIGN KEY (username) REFERENCES user (username),
    FOREIGN KEY (authority) REFERENCES authority (name),
    UNIQUE INDEX user_authority_idx_1 (username, authority)
);

CREATE TABLE oauth_access_token (
  token_id VARCHAR(256) DEFAULT NULL,
  token BLOB,
  authentication_id VARCHAR(256) DEFAULT NULL,
  user_name VARCHAR(256) DEFAULT NULL,
  client_id VARCHAR(256) DEFAULT NULL,
  authentication BLOB,
  refresh_token VARCHAR(256) DEFAULT NULL,
);

CREATE TABLE oauth_refresh_token (
  token_id VARCHAR(256) DEFAULT NULL,
  token BLOB,
  authentication BLOB
);


CREATE TABLE TASK (
  id NUMBER(50),
   created_by VARCHAR(100) DEFAULT NULL,
    assigned_user VARCHAR(100) DEFAULT NULL,
     created_at date default sysdate,
     completed_at date default sysdate,
     title VARCHAR(100) DEFAULT NULL,
     completed BOOLEAN DEFAULT FALSE,
     role VARCHAR(100) DEFAULT 'Tester',
      user_name VARCHAR(100) DEFAULT NULL
);

CREATE TABLE USERDATA (
  id NUMBER(50),
   user_name VARCHAR(100) DEFAULT NULL,
    password VARCHAR(100) DEFAULT NULL,
     role VARCHAR(100) DEFAULT NULL
);