CREATE DATABASE fast_seasonal;

DROP TABLE IF EXISTS jobseeker;
CREATE TABLE jobseeker(id serial PRIMARY KEY, name VARCHAR(255), population integer);