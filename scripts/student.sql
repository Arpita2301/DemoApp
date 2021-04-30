use student;

show tables;


drop table student;

create table student(
stud_id varchar(30),
stud_name varchar(30),
stud_rollno varchar(10),
stud_branch varchar(30),
primary key(stud_id));

select * from student;



drop table subject;

create table subject(
sub_id varchar(30),
sub_name varchar(30),
stud_id varchar(30),
primary key(sub_id),
foreign key(stud_id)
	references student(stud_id));

select * from subject;

drop table category;

create table category(
c_id varchar(30),
c_name varchar(60),
primary key(c_id));

select * from category;



drop table products;

create table products(
p_id varchar(60),
p_name varchar(60),
c_id varchar(30),
brand_id varchar(30),
primary key(p_id),
foreign key(c_id) references category(c_id),
foreign key(brand_id) references brand(brand_id));

select * from products;


drop table brand;

create table brand(
brand_id varchar(30),
brand_name varchar(60),

primary key(brand_id)
 );

select * from brand;


drop table category_brand_mapping;

 create table category_brand_mapping(
 c_id varchar(30),
 brand_id varchar(30),
 foreign key(c_id) references category(c_id),
 foreign key(brand_id) references brand(brand_id));
select * from category_brand_mapping;

select * from category;





create table student1(
s_id varchar(60),
s_name varchar(60),
sub1 double,
sub2 double,
sub3 double,
total double,
percentage float,
primary key(s_id));


delimiter #
create trigger total_percentage1
 before insert on student.student1
for each row
 BEGIN
   Declare MESSAGE_TEXT varchar(200);
   set new.total = new.sub1 + new.sub2 + new.sub3,
   new.percentage = (new.total /300)  * 100;
   SET MESSAGE_TEXT = "Subject1:  new.sub1";
   SET MESSAGE_TEXT = "Subject2:  new.sub2";
   SET MESSAGE_TEXT = "Subject3:  new.sub3";
   SET MESSAGE_TEXT = "Total:     new.total";
   SET MESSAGE_TEXT = "Percentage:     new.total";
   END;




create trigger total_percentage
before insert on student.student1
for each row
set new.total = new.sub1 + new.sub2 + new.sub3,
new.percentage = (new.total /300)  * 100;
