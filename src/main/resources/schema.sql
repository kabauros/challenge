create table route
(
   id integer auto_increment not null,
   origem varchar(50) not null,
   destino varchar(50) not null,
   distancia DECIMAL not null,
   primary key(id)
);