DO
$$
BEGIN
     ALTER TABLE sessions
     ALTER COLUMN id
     DROP IDENTITY IF EXISTS;

   INSERT INTO sessions(id,start_time,end_time,description)
   VALUES
     (1,null,null,null),
     (2,null,null,null),
     (3,null,null,null),
     (4,null,null,null),
     (5,null,null,null),
     (6,null,null,null),
     (7,null,null,null);
EXCEPTION
    WHEN undefined_column THEN RAISE NOTICE 'column  does not exist';
END
$$

