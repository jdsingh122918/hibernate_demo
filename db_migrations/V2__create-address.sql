create sequence "address_seq" start with 1;
create table address
(
    id          bigserial primary key not null,
    zipcode     varchar(5)            not null,
    city        varchar(255),
    app_user_id bigint references app_user (id)
);

