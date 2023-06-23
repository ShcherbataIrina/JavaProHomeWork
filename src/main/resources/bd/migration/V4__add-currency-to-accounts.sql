ALTER TABLE IF NOT EXISTS accounts
ADD COLUMN currency varchar(5);

UPDATE accounts
SET currency = 'UAH';

ALTER TABLE accounts
ALTER COLUMN currency SET NOT NULL;
