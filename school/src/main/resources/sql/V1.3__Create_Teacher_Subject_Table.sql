CREATE TABLE IF NOT EXISTS teacher_subject(
     teacher_id bigint not null,
     subject_id bigint not null,
     number_taken_class integer,
     PRIMARY KEY(teacher_id,subject_id)
);

