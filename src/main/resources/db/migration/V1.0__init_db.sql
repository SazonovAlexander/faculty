create table party
(
    id serial primary key,
    number int not null,
    year int not null
);

create table teacher
(
    id serial primary key,
    full_name varchar not null,
    email varchar not null unique,
    degree varchar not null
);

create table classroom
(
    id serial primary key,
    floor int not null,
    number int not null
);


create table course
(
    id serial primary key,
    name varchar not null unique
);


create table student
(
    id serial primary key,
    full_name varchar not null,
    email varchar not null unique,
    address varchar not null,
    party_id int not null,
    foreign key (party_id) references party (id)
);

create table exam
(
    id serial primary key,
    date date not null,
    party_id int not null,
    course_id int not null,
    classroom_id int not null,

    foreign key (party_id) references party (id),
    foreign key (course_id) references course (id),
    foreign key (classroom_id) references classroom (id)
);

create table student_exam
(
    student_id int,
    exam_id int,
    grade int not null,

    primary key (student_id, exam_id)
);

create table schedule
(
    party_id int,
    course_id int,
    classroom_id int,
    teacher_id int,
    day varchar not null,
    time varchar not null,

    primary key (party_id, course_id, classroom_id, teacher_id)
);
