DROP TABLE IF EXISTS employeetb;

DROP SEQUENCE IF EXISTS id_seq;

CREATE SEQUENCE id_seq MINVALUE 001 START 001 MAXVALUE 999;

CREATE TABLE employeetb(
    id VARCHAR(5) PRIMARY KEY NOT NULL CHECK (id ~ '^k-[000-999]+$' ) DEFAULT TO_CHAR(nextval('id_seq'::regclass),'"k-"fm000'),
    name VARCHAR(100) UNIQUE NOT NULL,
    joined_date VARCHAR(15) NOT NULL,
    call_number VARCHAR(15) NOT NULL,
    limit_reimburs NUMERIC(11, 2) NOT NULL,
    created_date VARCHAR(15) NOT NULL,
    updated_date VARCHAR(15) NOT NULL
);

SELECT * FROM employeetb;