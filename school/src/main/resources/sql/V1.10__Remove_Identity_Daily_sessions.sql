DO
$$
BEGIN
   ALTER TABLE daily_sessions
   ALTER COLUMN id
   DROP IDENTITY IF EXISTS;
EXCEPTION
    WHEN undefined_column THEN RAISE NOTICE 'column  does not exist';
END
$$
