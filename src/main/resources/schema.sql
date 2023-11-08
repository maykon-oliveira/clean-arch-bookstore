drop table if exists author cascade;
drop table if exists book cascade;
create table author (id uuid not null, primary key (id));
create table book (author_id uuid, id uuid not null, title varchar(255), primary key (id));