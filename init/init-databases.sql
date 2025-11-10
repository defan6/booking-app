SELECT 'CREATE DATABASE dev_inventory_db'
    WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'dev_inventory_db')\gexec

SELECT 'CREATE DATABASE test_inventory_db'
    WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'test_inventory_db')\gexec



SELECT 'CREATE DATABASE dev_order_db'
    WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'dev_order_db')\gexec

SELECT 'CREATE DATABASE test_order_db'
    WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'test_order_db')\gexec



SELECT 'CREATE DATABASE dev_customer_db'
    WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'dev_customer_db')\gexec

SELECT 'CREATE DATABASE test_customer_db'
    WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'test_customer_db')\gexec

