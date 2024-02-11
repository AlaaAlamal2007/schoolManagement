DO
$$
BEGIN
    ALTER TABLE classes
    DROP COLUMN If EXISTS teacher_id,
    DROP COLUMN If EXISTS subject_id;
EXCEPTION
    WHEN undefined_column THEN RAISE NOTICE 'column  does not exist';
END
$$

