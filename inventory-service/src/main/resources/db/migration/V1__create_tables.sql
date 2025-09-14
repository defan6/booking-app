CREATE TABLE venues
(
    id             BIGSERIAL PRIMARY KEY,
    name           VARCHAR(255) NOT NULL,
    address        VARCHAR(255) NOT NULL,
    total_capacity INT          NOT NULL
);

CREATE TABLE events
(
    id             BIGSERIAL PRIMARY KEY,
    name           VARCHAR(255) NOT NULL,
    total_capacity INT          NOT NULL,
    left_capacity  INT          NOT NULL,
    venue_id       BIGINT       NOT NULL,
    CONSTRAINT fk_event_venue FOREIGN KEY (venue_id) REFERENCES venues (id) ON DELETE CASCADE
);