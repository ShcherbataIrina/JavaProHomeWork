CREATE TABLE  IF NOT EXISTS accounts(
    id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    uid varchar(40) UNIQUE,
    iban varchar(30)UNIQUE,
    balance integer,
    person_id integer REFERENCES persons(id)
 );
