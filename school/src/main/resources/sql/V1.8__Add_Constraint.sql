DO
$$
BEGIN
    ALTER TABLE daily_sessions_distributed
        ADD CONSTRAINT fk_subject_teacher
        FOREIGN KEY (teacher_subject_teacher_id,subject_subject_subject_id) REFERENCES teacher_subject ;

    ALTER TABLE daily_sessions_distributed
    ADD CONSTRAINT fk_session FOREIGN KEY (session_id) REFERENCES sessions (id);

     ALTER TABLE daily_sessions_distributed
        ADD CONSTRAINT fk_class FOREIGN KEY (class_id) REFERENCES classes (id);
EXCEPTION
    WHEN undefined_column THEN RAISE NOTICE 'column  does not exist';
END
$$


