CREATE TABLE IF NOT EXISTS daily_sessions(
     id bigint not null  GENERATED ALWAYS AS IDENTITY,
     day_name  VARCHAR(255),
     PRIMARY KEY(id)
);
CREATE TABLE IF NOT EXISTS daily_sessions_distributed(
     teacher_subject_teacher_id bigint not null,
     teacher_subject_subject_id bigint not null,
     class_id bigint not null,
     session_id bigint not null,
     daily_sessions_id bigint,
     PRIMARY KEY(teacher_subject_teacher_id,teacher_subject_subject_id,class_id,session_id),
     CONSTRAINT fk_daily_sessions
                   FOREIGN KEY(daily_sessions_id)
                     REFERENCES daily_sessions(id)
);
