use eazybank;

create table users(
                      username varchar(200),
                      password varchar(200),
                      enabled boolean,
                      PRIMARY KEY (username)
);

CREATE TABLE authorities (
                             username VARCHAR(255) NOT NULL,
                             authority VARCHAR(255) NOT NULL,
                             CONSTRAINT pk_authorities PRIMARY KEY (username, authority),
                             CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES users (username)
);

CREATE TABLE customer (
                          id int auto_increment,
                          email varchar(255) NOT NULL,
                          pwd varchar(255) NOT NULL,
                          role varchar(50) NOT NULL,
                          primary key (id)
);

CREATE unique index ix_auth_username on authorities (username, authority);

INSERT IGNORE INTO users VALUES ("user", "{noop}userpassword", "1");
INSERT IGNORE INTO authorities VALUES ("user", "read");

INSERT IGNORE INTO users VALUES ("admin", "{bycrypt}$2a$12$bmSpNlUvo.JXQK.sf0Sz5uVy.q/WzQ9QtRhgy2HgGzwMWDJlBdyMe", "1");
INSERT IGNORE INTO authorities VALUES ("admin", "admin");

INSERT INTO customer (email, pwd, role) VALUES ("happy@example.com", "{noop}happypassword123", "read");
INSERT INTO customer (email, pwd, role) VALUES ("admin@example.com", "{bycrypt}$2a$12$bmSpNlUvo.JXQK.sf0Sz5uVy.q/WzQ9QtRhgy2HgGzwMWDJlBdyMe", "admin");

SELECT * FROM users;

drop table USERS;
drop tables users;
drop table AUTHORITIES;
drop table customer;