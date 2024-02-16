CREATE TABLE IF NOT EXISTS teachers(
   id bigint not null  GENERATED ALWAYS AS IDENTITY,
   first_name VARCHAR(255),
   second_name VARCHAR(255),
   third_name VARCHAR(255),
   last_name VARCHAR(255),
   identification_number bigint,
   email VARCHAR(255),
   mobile VARCHAR(255),
   gender VARCHAR(6),
   birth_date timestamp without time zone,
   address_id bigint,
   PRIMARY KEY(id),
   CONSTRAINT fk_address
      FOREIGN KEY(address_id)
        REFERENCES addresses(id)
);
CREATE TABLE IF NOT EXISTS subjects(
     id bigint not null  GENERATED ALWAYS AS IDENTITY,
     name VARCHAR(255) unique,
     description VARCHAR(255),
     PRIMARY KEY(id)
);

