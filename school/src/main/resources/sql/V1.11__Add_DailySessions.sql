DO
$$
BEGIN
   INSERT INTO daily_sessions (id, day_name)
   VALUES
     (1,'SATURDAY'),
     (2,'SUNDAY'),
     (3,'MONDAY'),
     (4,'TUESDAY'),
     (5,'WEDNESDAY'),
     (6,'THURSDAY');
EXCEPTION
    WHEN undefined_column THEN RAISE NOTICE 'column  does not exist';
END
$$

