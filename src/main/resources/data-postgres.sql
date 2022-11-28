DROP DATABASE IF EXISTS fast_seasonal;

DROP TABLE IF EXISTS cv;
CREATE TABLE cv
(
    id           SERIAL PRIMARY KEY,
    name         VARCHAR,
    content_type VARCHAR,
    size         BIGINT,
    data         OID
);

DROP TABLE IF EXISTS jobseeker;
CREATE TABLE jobseeker
(
    id        SERIAL PRIMARY KEY,
    cv_id     BIGINT,
    lastname  VARCHAR(100),
    firstname VARCHAR(100),
    city      VARCHAR(100),
    job       VARCHAR(100),
    phone     VARCHAR(20),
    email     VARCHAR(100),
    keywords  VARCHAR(500), -- Split on ","
    FOREIGN KEY (cv_id) REFERENCES cv (id)
);

DROP TABLE IF EXISTS recruiter;
CREATE TABLE recruiter
(
    id          SERIAL PRIMARY KEY,
    lastname    VARCHAR(100),
    firstname   VARCHAR(100),
    company_name VARCHAR(100),
    city        VARCHAR(100),
    job         VARCHAR(100),
    phone       VARCHAR(20),
    email       VARCHAR(100)
);

DROP TABLE IF EXISTS grade;
CREATE TABLE grade
(
    recruiter BIGINT,
    jobseeker BIGINT,
    mark       INTEGER,
    comment    VARCHAR(200),
    PRIMARY KEY (recruiter, jobseeker),
    FOREIGN KEY (recruiter) REFERENCES recruiter(id),
    FOREIGN KEY (jobseeker) REFERENCES jobseeker(id)
);

DROP TABLE IF EXISTS offer CASCADE;
CREATE TABLE offer
(
    id SERIAL PRIMARY KEY,
    title  VARCHAR(100),
    description VARCHAR(1000),
    publishDay DATE,
    jobStartingDate DATE,
    location VARCHAR(100),
    jobNumber INTEGER,
    salary FLOAT,
    advantages VARCHAR(500),
    job VARCHAR(100),
    zones VARCHAR(100),
    author BIGINT,
    keywords VARCHAR(100),
    FOREIGN KEY (author) REFERENCES recruiter(id)
);

DROP TABLE IF EXISTS jobseeker_offer;
CREATE TABLE jobseeker_offer
(
    jobseeker_id BIGINT,
    offer_id BIGINT,
    FOREIGN KEY (jobseeker_id) REFERENCES jobseeker(id),
    FOREIGN KEY (offer_id) REFERENCES offer(id),
    PRIMARY KEY (jobseeker_id,offer_id)

);

);

CREATE SEQUENCE hibernate_sequence START 1;