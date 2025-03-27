CREATE TABLE session (
    id SERIAL PRIMARY KEY,
    user_name VARCHAR(50),
    token VARCHAR(300),
    status boolean NOT NULL DEFAULT true,
    fecha_start TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    fecha_end TIMESTAMP

);
