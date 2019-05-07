create table product (
  id                             varchar(36),  -- uuid
  -- -------------------------------------------------
  name          	 			 varchar(50),
  price_per_uom           	 	 decimal(15,2),
  quantity                  	 integer,
  uom							 varchar(10),
  -- -------------------------------------------------
  manufactured_year              integer,
  created_on                 	 timestamp,
  primary key (id)
);

