CREATE TABLE IF NOT EXISTS sessions(
     id bigint not null  GENERATED ALWAYS AS IDENTITY,
     start_time VARCHAR(30),
     end_time VARCHAR(30),
     description VARCHAR(30),
     PRIMARY KEY(id)
);

