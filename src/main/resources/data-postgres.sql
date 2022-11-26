DROP DATABASE IF EXISTS fast_seasonal;

DROP TABLE IF EXISTS cv;
CREATE TABLE cv
(
    id           serial PRIMARY KEY,
    name         VARCHAR,
    content_type VARCHAR,
    size         BIGINT,
    data         OID
);

DROP TABLE IF EXISTS jobseeker;
CREATE TABLE jobseeker
(
    id        serial PRIMARY KEY,
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
    id          serial PRIMARY KEY,
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

DROP TABLE IF EXISTS offer;
CREATE TABLE offer
(
    idOffer serial PRIMARY KEY,
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

DROP TABLE IF EXISTS jobseekerJoinOffer;
CREATE TABLE jobseekerJoinOffer
(
    idOffer BIGINT,
    idJobseeker BIGINT,
    PRIMARY KEY (idJobseeker, idOffer),
    FOREIGN KEY (idJobseeker) REFERENCES jobseeker(id),
    FOREIGN KEY (idOffer) REFERENCES offer(idOffer)

);

CREATE SEQUENCE hibernate_sequence START 1;