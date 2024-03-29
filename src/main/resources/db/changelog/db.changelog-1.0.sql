--changeset nkogtev:1
CREATE TABLE Team
(
    id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    team_name VARCHAR(50) NOT NULL,
    sport_type VARCHAR(50) NOT NULL,
    found_date INT NOT NULL CHECK ( found_date BETWEEN 1000 and 3000)
);

--changeset nkogtev:2
CREATE TABLE Player
(
    id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    team_id INT REFERENCES Team(id) ON DELETE SET NULL,
    first_name VARCHAR(50) NOT NULL,
    second_name VARCHAR(50) NOT NULL,
    third_name VARCHAR(50) NOT NULL,
    birth_date INT NOT NULL CHECK ( birth_date BETWEEN 1950 and 2024),
    role VARCHAR NOT NULL
);

--changeset nkogtev:3
INSERT INTO team (team_name, sport_type, found_date) VALUES ('Barcelona', 'football', 1941);
INSERT INTO team (team_name, sport_type, found_date) VALUES ('RealMadrid', 'football', 1961);
INSERT INTO team (team_name, sport_type, found_date) VALUES ('Barcelona', 'basketball', 1996);
INSERT INTO team (team_name, sport_type, found_date) VALUES ('RealMadrid', 'basketball', 1980);
INSERT INTO team (team_name, sport_type, found_date) VALUES ('ASdasda', 'asddasd', 1950);

INSERT INTO player (team_id, first_name, second_name, third_name, birth_date, role)
VALUES (1, 'Nikita', 'Kogtev', 'Sergeevich', '1996', 'forward');
INSERT INTO player (team_id, first_name, second_name, third_name, birth_date, role)
VALUES (1, 'Savva', 'Kogtev', 'Sergeevich', '2002', 'forward');
INSERT INTO player (team_id, first_name, second_name, third_name, birth_date, role)
VALUES (1, 'Sonya', 'Kogtev', 'Sergeevich', '2002', 'protect');


INSERT INTO player (team_id, first_name, second_name, third_name, birth_date, role)
VALUES (2, 'Nikita', 'Garanin', 'Marinovich', '1996', 'forward');
INSERT INTO player (team_id, first_name, second_name, third_name, birth_date, role)
VALUES (2, 'Savva', 'Garanin', 'Marinovich', '2002', 'forward');
INSERT INTO player (team_id, first_name, second_name, third_name, birth_date, role)
VALUES (2, 'Sonya', 'Garanin', 'Marinovich', '2002', 'protect');