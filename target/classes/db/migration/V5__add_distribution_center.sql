ALTER TABLE product ADD COLUMN IF NOT EXISTS distribution_center TEXT;

UPDATE product
SET distribution_center = CASE floor(random()*3)::int
  WHEN 0 THEN 'Mogi das Cruzes'
  WHEN 1 THEN 'Recife'
  ELSE      'Porto Alegre'
END
WHERE distribution_center IS NULL;
