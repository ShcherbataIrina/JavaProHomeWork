ALTER TABLE  accounts
ADD COLUMN IF NOT EXISTS currency varchar(5);

UPDATE accounts
SET currency = 'UAH';

ALTER TABLE accounts
ALTER COLUMN currency SET NOT NULL;
