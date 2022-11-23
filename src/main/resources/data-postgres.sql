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

DROP TABLE IF EXISTS grade;
CREATE TABLE grade
(
    FOREIGN KEY (idRecruiter) REFERENCES recruiter(id),
    FOREIGN KEY (idJobseeker) REFERENCES jobseeker(id),
    mark       FLOAT,
    comment    VARCHAR(200),
    PRIMARY KEY (idRecruiter, idJobseeker)
);

CREATE SEQUENCE hibernate_sequence START 1;