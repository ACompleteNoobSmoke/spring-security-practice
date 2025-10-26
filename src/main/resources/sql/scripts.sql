use eazybank;

create table USERS(
                      USERNAME varchar(200),
                      PASSWORD varchar(200),
                      ENABLED boolean,
                      PRIMARY KEY (USERNAME)
);

CREATE TABLE AUTHORITIES (
                             USERNAME VARCHAR(255) NOT NULL,
                             AUTHORITY VARCHAR(255) NOT NULL,
                             CONSTRAINT PK_AUTHORITIES PRIMARY KEY (USERNAME, AUTHORITY),
                             CONSTRAINT FK_AUTHORITIES_USERS FOREIGN KEY (USERNAME) REFERENCES USERS (USERNAME)
);

CREATE unique index ix_auth_username on AUTHORITIES (USERNAME, AUTHORITY);