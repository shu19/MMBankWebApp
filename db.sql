CREATE DATABASE  bankapp_db;

CREATE TABLE account (account_id int AUTO_INCREMENT PRIMARY KEY,
						account_hn varchar(20),
						 account_bal double,
						 salary boolean,
						 odLimit double,
						 type varchar(2)
						);
						
