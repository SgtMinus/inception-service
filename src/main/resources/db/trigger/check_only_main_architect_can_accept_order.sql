CREATE OR REPLACE FUNCTION check_only_main_architect_can_accept_dream_order()
    RETURNS TRIGGER AS
$$
DECLARE
    u_role varchar(255);
BEGIN
    SELECT role
    INTO u_role
    FROM app_user
    WHERE id = NEW.mainArchitect;

    IF (u_role != 'MAIN_ARCHITECT') THEN
        RAISE EXCEPTION 'ONLY MAIN ARCHITECT CAN ACCEPT DREAM';
    END IF;

END
$$
    LANGUAGE 'plpgsql';

CREATE TRIGGER on_dream_processing_create
    AFTER INSERT
    ON dream
    FOR EACH ROW
EXECUTE FUNCTION check_only_main_architect_can_accept_dream_order();