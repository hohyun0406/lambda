--Soccer JPA 버전

show tables;

CREATE TABLE board(
        id INT NOT NULL AUTO_INCREMENT,
        title VARCHAR(20) NOT NULL,
content VARCHAR(100) NULL,
writer VARCHAR(20) NOT NULL,
register_date  VARCHAR(20),
CONSTRAINT board_pk PRIMARY KEY(id)
);

select * from board;
insert into articles(title, content,writer)
values ('테스트 제목','테스트글','제임스');
select * from board;
commit;
select * from articles;

rename table board to aticles;
show tables;

CREATE TABLE users (
        id INT AUTO_INCREMENT PRIMARY KEY,
        username VARCHAR(20) NOT NULL,
password VARCHAR(20) NOT NULL,
name VARCHAR(20),
phone VARCHAR(20),
job VARCHAR(20),
height VARCHAR(20),
weight VARCHAR(20)
);

DROP TABLE users;
DROP TABLE board;
DROP TABLE stadium;
DROP TABLE schedule;
DROP TABLE team;
DROP TABLE board;


CREATE TABLE stadium(
        id INTEGER NOT NULL AUTO_INCREMENT,
        stadium_name VARCHAR(40) NOT NULL,
hometeam_id VARCHAR(10) NOT NULL,
seat_count INTEGER NOT NULL,
address  VARCHAR(60) NOT NULL,
ddd  VARCHAR(10) NOT NULL,
tel  VARCHAR(10) NOT NULL,
PRIMARY KEY(id)
);

CREATE TABLE schedule(
        id INTEGER NOT NULL AUTO_INCREMENT,
        gubun VARCHAR(10) NOT NULL,
hometeam_id VARCHAR(10) NOT NULL,
awayteam_id VARCHAR(10) NOT NULL,
home_score INTEGER NOT NULL,
away_score INTEGER NOT NULL,
stadium_id INTEGER NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY (stadium_id) REFERENCES stadium (id)
        );

CREATE TABLE team(
        id INTEGER NOT NULL AUTO_INCREMENT,
        region_name VARCHAR(10) NOT NULL,
team_name VARCHAR(40) NOT NULL,
e_team_name VARCHAR(50) NOT NULL,
orig_yyyy VARCHAR(10) NOT NULL,
zip_code1 VARCHAR(10) NOT NULL,
zip_code2 VARCHAR(10) NOT NULL,
address VARCHAR(80) NOT NULL,
ddd VARCHAR(10) NOT NULL,
tel VARCHAR(10) NOT NULL,
fax VARCHAR(10) NOT NULL,
homepage VARCHAR(50) NOT NULL,
owner VARCHAR(10) NOT NULL,
stadium_id INTEGER NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY (stadium_id) REFERENCES stadium (id)
        );

CREATE TABLE player(
        id INTEGER NOT NULL AUTO_INCREMENT,
        player_name VARCHAR(20) NOT NULL,
e_player_name VARCHAR(40) NOT NULL,
nickname VARCHAR(30) NOT NULL,
join_yyyy VARCHAR(10) NOT NULL,
position VARCHAR(10) NOT NULL,
back_no INTEGER NOT NULL,
nation VARCHAR(20) NOT NULL,
birth_date DATE NOT NULL,
solar VARCHAR(10) NOT NULL,
height VARCHAR(10) NOT NULL,
weight VARCHAR(10) NOT NULL,
team_id INTEGER NOT NULL,
CONSTRAINT id PRIMARY KEY(id)
FOREIGN KEY (team_id) REFERENCES team (id)
        );