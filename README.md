创建PgSQL的自增主键
CREATE SEQUENCE id_seq
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;

alter table user_info alter column id set default nextval('id_seq');