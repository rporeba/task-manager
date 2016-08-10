INSERT INTO user (email, password_hash, role)
VALUES ('demo@localhost', '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 'ADMIN');

INSERT INTO user (email, password_hash, role)
VALUES ('test@localhost', 'test', 'USER');

INSERT INTO task (id, description, details, created)
VALUES (1, 'task description 1', 'task details 1', Date '2016-07-07');
INSERT INTO task (id, description, details, created)
VALUES (2, 'task description 2', 'task details 2', Date '2013-03-09');

INSERT INTO person (idP, firstname, lastname)
VALUES (1, 'Jan', 'Nowak');

INSERT INTO person (idP, firstname, lastname)
VALUES (2, 'Marian', 'Kowalski');

