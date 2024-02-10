CREATE TABLE IF NOT EXISTS addresses(
   id bigint not null  GENERATED ALWAYS AS IDENTITY,
   city VARCHAR(255) NOT NULL,
   street_name VARCHAR(255),
   street_number integer,
   building_number integer,
   post_code VARCHAR(255),
   PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS classes(
     id bigint not null  GENERATED ALWAYS AS IDENTITY,
     class_type  VARCHAR(255),
     class_number  integer,
     PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS students(
   id bigint not null  GENERATED ALWAYS AS IDENTITY,
   first_name VARCHAR(255),
   second_name VARCHAR(255),
   third_name VARCHAR(255),
   last_name VARCHAR(255),
   identification_number bigint,
   email VARCHAR(255),
   mobile VARCHAR(255),
   birth_date timestamp without time zone,
   address_id bigint,
   class_id bigint,
   PRIMARY KEY(id),
   CONSTRAINT fk_address
      FOREIGN KEY(address_id)
        REFERENCES addresses(id),
   CONSTRAINT fk_class
              FOREIGN KEY(class_id)
                REFERENCES classes(id)
);
