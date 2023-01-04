use entitystats;

create table positions(
position_x int NOT NULL,
position_y int NOT NULL,
unique(position_x, position_y));

create table spritePosition(
sprite_id char(3) NOT NULL ,
position_x int NOT NULL,
position_y int NOT NULL,
foreign key(sprite_id) references EntitySprite(sprite_id));

insert into spriteposition values("001", 100, 120);
insert into spriteposition values("002", 3, 0);
insert into spriteposition values("003", 3, 2);
insert into spriteposition values("004", 3, 4);
insert into spriteposition values("005", 3, 6);
insert into spriteposition values("006", 2, 2);