DROP DATABASE IF EXISTS fast_seasonal;

DROP TABLE IF EXISTS jobseeker;
CREATE TABLE jobseeker
(
    id        serial PRIMARY KEY,
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
    id          serial PRIMARY KEY,
    lastname    VARCHAR(100),
    firstname   VARCHAR(100),
    companyName VARCHAR(100),
    city        VARCHAR(100),
    job         VARCHAR(100),
    phone       VARCHAR(20),
    email       VARCHAR(100)
);

DROP TABLE IF EXISTS JOBSEEKERJOINOFFER;
CREATE TABLE JOBSEEKERJOINOFFER
(
    foreign key jsId references jobseeker(id),
    foreign key offerId references offer(idOffer),
    primary key (jsId,offerId)

);
CREATE SEQUENCE hibernate_sequence START 1;