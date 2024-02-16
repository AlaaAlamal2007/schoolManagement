DO
$$
BEGIN
    ALTER TABLE If exists teacher_subject
        ADD CONSTRAINT fk_teacher
        FOREIGN KEY (teacher_id) REFERENCES teachers (id);
     ALTER TABLE If exists teacher_subject
            ADD CONSTRAINT fk_subject
            FOREIGN KEY (subject_id) REFERENCES subjects (id);
EXCEPTION
    WHEN undefined_column THEN RAISE NOTICE 'column  does not exist';
END
$$



