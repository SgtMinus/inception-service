CREATE INDEX dream_status_index ON dream USING hash(status);

CREATE INDEX order_status_index ON dream_order USING hash(order_status);