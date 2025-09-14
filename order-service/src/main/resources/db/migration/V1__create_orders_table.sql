create table orders
(
    id          BIGSERIAL PRIMARY KEY,
    total_price DECIMAL NOT NULL,
    quantity    INT     NOT NULL,
    placed_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    customer_id BIGINT  NOT NULL,
    event_id    BIGINT  NOT NULL
);