alter table sa_user add person_id int;
alter table sa_user add constraint foreign key(person_id) references sa_person(person_id) on delete set null on update cascade;