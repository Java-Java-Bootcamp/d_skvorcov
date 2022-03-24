CREATE TABLE IF NOT EXISTS students (
    id    		VARCHAR(10)		PRIMARY KEY,
    login   varchar(45) not null,
    first_name	VARCHAR(200) 	NOT NULL,
    last_name	VARCHAR(200)	NOT null,
    birthday date not null
    );
