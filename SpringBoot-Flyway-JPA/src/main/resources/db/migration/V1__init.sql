
CREATE TABLE ORDER_HEADER(
    id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    order_number VARCHAR(200) NOT NULL,
    order_ref_number VARCHAR(200) NOT NULL,
    order_version INT NOT NULL,
    order_creation_date TIMESTAMP NOT NULL
);