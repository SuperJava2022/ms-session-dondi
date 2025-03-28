CREATE TABLE session (
    id SERIAL PRIMARY KEY,
    user_name VARCHAR(50),
    token VARCHAR(300),
    status BOOLEAN NOT NULL DEFAULT true,
    date_start TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    date_end TIMESTAMP

);
