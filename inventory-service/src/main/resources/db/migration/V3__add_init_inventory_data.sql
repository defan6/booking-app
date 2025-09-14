INSERT INTO venues (name, address, total_capacity)
VALUES ('vk', 'lenina 24', 100000),
       ('yandex', 'lenina 36', 910000);

INSERT INTO events (name, total_capacity, left_capacity, venue_id, ticket_price)
VALUES ('vk-fest', 10000, 10000, 1, 20),
       ('om', 7000, 7000, 2, 10);
