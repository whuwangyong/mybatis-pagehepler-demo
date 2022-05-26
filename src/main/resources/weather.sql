-- auto-generated definition
create table weather
(
    id          int auto_increment
        primary key,
    city        varchar(20) null,
    date        date        null,
    weather     varchar(20) null,
    temperature int         null
);

