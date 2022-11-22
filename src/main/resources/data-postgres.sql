CREATE DATABASE fast_seasonal;

DROP TABLE IF EXISTS jobseeker;
CREATE TABLE jobseeker
(
    id        VARCHAR(50) PRIMARY KEY,
    lastname  VARCHAR(100),
    firstname VARCHAR(100),
    city      VARCHAR(100),
    job       VARCHAR(100),
    phone     VARCHAR(20),
    email     VARCHAR(100)
);

DROP TABLE IF EXISTS recruiter;
CREATE TABLE recruiter
(
    id          VARCHAR(50) PRIMARY KEY,
    lastname    VARCHAR(100),
    firstname   VARCHAR(100),
    companyName VARCHAR(100),
    city        VARCHAR(100),
    job         VARCHAR(100),
    phone       VARCHAR(20),
    email       VARCHAR(100)
);