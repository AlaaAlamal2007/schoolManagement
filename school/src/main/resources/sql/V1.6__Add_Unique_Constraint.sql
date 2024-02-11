DO
$$
BEGIN
    ALTER TABLE IF EXISTS daily_sessions
    ADD CONSTRAINT day_name_unique UNIQUE (day_name);
EXCEPTION
    WHEN undefined_column THEN RAISE NOTICE 'column day_name does not exist';
END
$$
