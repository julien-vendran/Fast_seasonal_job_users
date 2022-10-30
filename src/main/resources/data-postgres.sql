CREATE DATABASE fast_seasonal;

DROP TABLE IF EXISTS jobseeker;
CREATE TABLE jobseeker
(
    id         serial PRIMARY KEY,
    last_name  VARCHAR(100),
    first_name VARCHAR(100),
    city       VARCHAR(100),
    job        VARCHAR(100),
    phone      VARCHAR(20),
    email      VARCHAR(100)
);