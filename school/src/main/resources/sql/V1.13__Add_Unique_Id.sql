DO
$$
BEGIN
    ALTER TABLE IF EXISTS teachers
    ADD CONSTRAINT id_number_teacher_unique UNIQUE (identification_number);
    ALTER TABLE IF EXISTS students
        ADD CONSTRAINT id_number_student_unique UNIQUE (identification_number);
EXCEPTION
    WHEN undefined_column THEN RAISE NOTICE 'column day_name does not exist';
END
$$

