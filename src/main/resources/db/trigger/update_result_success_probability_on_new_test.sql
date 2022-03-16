CREATE OR REPLACE FUNCTION update_result_probability()
    RETURNS TRIGGER AS
$$
DECLARE
    old_probability float;
    dream_id bigint;
BEGIN
    SELECT d.resultSuccessProbability, d.id INTO old_probability, dream_id FROM dream d
        LEFT JOIN dream_strategy ds ON d.id = ds.dream
        WHERE ds.id = NEW.dreamStrategy;

    IF (old_probability < NEW.dreamStrategyChainSuccessProbability) THEN
        UPDATE dream SET resultSuccessProbability = NEW.dreamStrategyChainSuccessProbability WHERE id = dream_id;
    END IF;
END
$$
    LANGUAGE 'plpgsql';

CREATE TRIGGER on_test_create
    AFTER INSERT
    ON dream_strategy_test
    FOR EACH ROW
EXECUTE FUNCTION update_result_probability();