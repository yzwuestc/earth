CREATE TABLE incident (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          description VARCHAR(255),
                          create_time TIMESTAMP,
                          update_time TIMESTAMP,
                          deleted BOOLEAN,
                          status VARCHAR(50)
);