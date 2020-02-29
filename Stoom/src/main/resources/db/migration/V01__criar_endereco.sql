CREATE TABLE endereco (
 ID_Autor integer CONSTRAINT pk_id_autor PRIMARY KEY,
 streetName varchar(30) NOT NULL, 
 number NUMERIC NOT NULL,
 complement  varchar(40) NOT NULL, 
 neighbourhood varchar(40) NOT NULL,
 city varchar(40) NOT NULL,
 country varchar(30) NOT NULL,
 state varchar(40) NOT NULL,
 zipcode varchar(20) NOT NULL,
 latitude NUMERIC NOT NULL,
 longitude NUMERIC NOT NULL,
);

