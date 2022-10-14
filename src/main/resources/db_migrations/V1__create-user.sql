create table app_user
(
    id         bigserial primary key not null,
    first_name varchar(255)          not null,
    last_name  varchar(255)
);