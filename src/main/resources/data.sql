DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS stocks;


CREATE  TABLE users (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(80) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1);
  
  
CREATE TABLE stocks(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	price DECIMAL(13,2) NOT NULL, 
	stocksymbol VARCHAR(45) NOT NULL,
	stockname VARCHAR(45) NOT NULL,
	dividend TINYINT NOT NULL DEFAULT 1
	
);
--  
--CREATE TABLE user_roles (
--  user_role_id int(11) NOT NULL AUTO_INCREMENT,
--  username varchar(45) NOT NULL,
--  role varchar(45) NOT NULL,
--  PRIMARY KEY (user_role_id),
--  UNIQUE KEY uni_username_role (role,username),
--  KEY fk_username_idx (username),
--  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username));
  
INSERT INTO users(id,username,password,enabled)
VALUES (1,'bryan','password', true);
INSERT INTO users(id,username,password,enabled)
VALUES (2,'naveen','password', true);


INSERT INTO stocks(id, price, stocksymbol, stockname, dividend) VALUES
(1,24.00,'ABC','alphabet',false);
INSERT INTO stocks(id, price, stocksymbol, stockname, dividend) VALUES
(2,234.00,'BAC','bank of america',false);
INSERT INTO stocks(id, price, stocksymbol, stockname, dividend) VALUES
(3,4.00,'PLUG','plug appliance',false);


--
--INSERT INTO user_roles (username, role)
--VALUES ('priya', 'ROLE_USER');
--INSERT INTO user_roles (username, role)
--VALUES ('priya', 'ROLE_ADMIN');
--INSERT INTO user_roles (username, role)
--VALUES ('naveen', 'ROLE_USER');