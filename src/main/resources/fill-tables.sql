INSERT INTO jobseeker(cv_id, lastname, firstname, city, region, job, phone, email, keywords)
VALUES (null, 'Vendran', 'Julien', 'Aubignan', 'PACA', 'Etudiant', '076000000', 'julien@mail.com', 'serieux, nuit, equipe, fete, petanque, danser, chanter, manger');
INSERT INTO jobseeker(cv_id, lastname, firstname, city, region, job, phone, email, keywords)
VALUES (null, 'Amarine', 'Ophélie', 'Le vigan', 'Occitanie', 'Etudiant', '076000000', 'ophelie@mail.com', 'petanque, manger, sport, chanter, bouger, construire');
INSERT INTO jobseeker(cv_id, lastname, firstname, city, region, job, phone, email, keywords)
VALUES (null, 'Destaing', 'Cécile', 'Montpellier', 'Occitanie', 'Etudiant', '076000000', 'cecile@mail.com', 'petanque, pastis, sport, chanter, bouger, velo, radonnée');

INSERT INTO recruiter(lastname, firstname, company_name, city, job, phone, email)
VALUES ('Bofi', 'Nicolas', 'Les flots bleus', 'Palavas les flots', 'Patron', '0404044040', 'nicolas@mail.com');
INSERT INTO recruiter(lastname, firstname, company_name, city, job, phone, email)
VALUES ('Paget', 'Arnaud', 'Motors & Camping', 'Montpellier', 'Patron', '0404044040', 'arnaud@mail.com');
INSERT INTO recruiter(lastname, firstname, company_name, city, job, phone, email)
VALUES ('Laroui', 'Marouan', 'Camping paradise', 'Avignon', 'Patron', '0404044040', 'marouan@mail.com');

INSERT INTO offer(title, description, publish_day, job_starting_date, city, region, jobnumber, salary, advantages, job, zones, author, keywords)
VALUES ('Technicien de surface', 'Assurer le nettoyage du camping', '01/12/2023', '01/07/2023', 'Montpellier', 'Occitanie', 1, 900, '', 'Nettoyer le camping', '', 2, 'petanque, pastis, sport, chanter, bouger, velo, radonnée');
INSERT INTO offer(title, description, publish_day, job_starting_date, city, region, jobnumber, salary, advantages, job, zones, author, keywords)
VALUES ('Technicien de surface toilette', 'Assurer le nettoyage dezs toilettes du camping', '01/12/2023', '01/07/2023', 'Montpellier', 'Occitanie', 1, 1000, '', 'Nettoyer le camping', '', 2, 'petanque, pastis, sport, chanter, bouger, velo, radonnée');
INSERT INTO offer(title, description, publish_day, job_starting_date, city, region, jobnumber, salary, advantages, job, zones, author, keywords)
VALUES ('Technicien de surface', 'Assurer le nettoyage du camping', '01/12/2023', '01/07/2023', 'Le vigan', 'Occitanie', 1, 1500, '', 'Nettoyer le camping', '', 3, 'petanque, manger, sport, chanter, bouger, construire');
INSERT INTO offer(title, description, publish_day, job_starting_date, city, region, jobnumber, salary, advantages, job, zones, author, keywords)
VALUES ('Technicien de surface', 'Assurer le nettoyage du camping', '01/12/2023', '01/07/2023', 'Avignon', 'PACA', 1, 1500, '', 'Nettoyer le camping', '', 3, 'petanque, manger, sport, chanter, bouger, construire');

INSERT INTO grade(recruiter, jobseeker, mark, comment) VALUES (3, 1, 5, 'Serious worker ! Keep going !');
INSERT INTO grade(recruiter, jobseeker, mark, comment) VALUES (2, 1, 2, 'Work seriously ... 3 hours a day');
INSERT INTO grade(recruiter, jobseeker, mark, comment) VALUES (1, 1, 1, 'Spend more time drinking coffee than working ...');
