create database event;

use event;

create table player(player_id int not null, player_name varchar(255), age varchar(10), team_id int);

create table team(team_id int not null, team_name varchar(255), country varchar(100), match_id int);

create table match_event(match_id int not null, match_name varchar(255), match_duration varchar(100));