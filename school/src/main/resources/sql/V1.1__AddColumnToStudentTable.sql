DO $$
    BEGIN
        BEGIN
            ALTER TABLE if exists students ADD COLUMN gender VARCHAR(6);
        EXCEPTION
            WHEN duplicate_column THEN RAISE NOTICE 'column added already exists in table.';
        END;
    END;
$$
