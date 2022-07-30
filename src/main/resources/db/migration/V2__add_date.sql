ALTER TABLE link ADD COLUMN date_added timestamp;

UPDATE link SET date_added = NOW() - INTERVAL '1 DAY';

ALTER TABLE link ALTER COLUMN date_added SET NOT NULL;