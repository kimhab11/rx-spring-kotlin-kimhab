CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE  app_users
(
--     id       uuid primary key default uuid_generate_v4(),
    id serial4 primary key ,
    fullname varchar(255) not null
);
CREATE TABLE  orders
(
    id         serial4 primary key ,
    name       varchar(255) not null,
    created_at timestamp    not null default now(),
    user_id    serial4 references app_users
);