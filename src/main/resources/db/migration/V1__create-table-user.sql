create table tb_user
(
    id    bigint         not null,
    login varchar unique not null,
    senha varchar        not null,
    primary key (id)
);
create sequence seq_user_id
    start 1
increment 1
owned by tb_user.id;