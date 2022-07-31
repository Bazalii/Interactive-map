create table ChairDbModel
(
    id          uuid   not null,
    coordinateX float8 not null,
    coordinateY float8 not null,
    creator     varchar(255),
    height      int4   not null,
    legsAmount  int4   not null,
    primary key (id)
);

create table TableDbModel
(
    id          uuid   not null,
    color       varchar(255),
    coordinateX float8 not null,
    coordinateY float8 not null,
    creator     varchar(255),
    length      int4   not null,
    width       int4   not null,
    primary key (id)
);

create table UserDbModel
(
    id       uuid not null,
    name     varchar(255),
    nickname varchar(255),
    role     int4,
    surname  varchar(255),
    primary key (id)
);

create table WallDbModel
(
    id          uuid   not null,
    coordinateX float8 not null,
    coordinateY float8 not null,
    creator     varchar(255),
    length      int4   not null,
    width       int4   not null,
    primary key (id)
);