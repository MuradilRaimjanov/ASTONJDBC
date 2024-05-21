-- Создание базы данных
CREATE DATABASE CompanyDB;

-- Переключение на созданную базу данных
\c CompanyDB;

-- Создание таблицы Department
CREATE TABLE if not exists department
(
    id              BIGSERIAL PRIMARY KEY,
    department_name VARCHAR(100) NOT NULL
);

-- Создание таблицы Employee
CREATE TABLE if not exists employee
(
    id            BIGSERIAL PRIMARY KEY,
    first_name    VARCHAR(100) NOT NULL,
    last_name     VARCHAR(100) NOT NULL,
    department_id INT,
    passport_id INT,
    CONSTRAINT fk_employee_department_id FOREIGN KEY (department_id) REFERENCES department (id) ON DELETE SET NULL,
    CONSTRAINT fk_employee_passport_id FOREIGN KEY (passport_id) REFERENCES passport(id) ON DELETE SET NULL
);

-- Создание таблицы Project
CREATE TABLE if not exists project
(
    id           BIGSERIAL PRIMARY KEY,
    project_name VARCHAR(100) NOT NULL,
    start_date   TIMESTAMP,
    end_date     TIMESTAMP
);

-- Создание таблицы EmployeeProject для связи многие ко многим
CREATE TABLE if not exists employee_project
(
    employee_id BIGINT,
    project_id  BIGINT,
    PRIMARY KEY (employee_id, project_id),
    FOREIGN KEY (employee_id) REFERENCES employee (id) ON DELETE CASCADE,
    FOREIGN KEY (project_id) REFERENCES project (id) ON DELETE CASCADE
);

CREATE TABLE if not exists passport
(
    id BIGSERIAL PRIMARY KEY,
    passport_series VARCHAR(50) NOT NULL,
    passport_number INT NOT NULL,
    employee_id INT NOT NULL,
    CONSTRAINT fk_passport_employee_id FOREIGN KEY (employee_id) REFERENCES employee (id)
);








-- Вставка начальных данных в таблицу Department
INSERT INTO department (department_name)
VALUES ('Human Resources'),
       ('Research and Development'),
       ('Sales');

-- Вставка начальных данных в таблицу Employee
INSERT INTO employee (first_name, last_name, department_id)
VALUES ('John', 'Doe', 2),
       ('Jane', 'Smith', 3),
       ('Michael', 'Johnson', 4);


-- Вставка начальных данных в таблицу Project
INSERT INTO project (project_name, start_date, end_date)
VALUES ('Project Alpha', '2023-01-01', '2023-12-31'),
       ('Project Beta', '2023-02-01', '2023-11-30');

-- Вставка данных в таблицу EmployeeProject для связи многие ко многим
INSERT INTO employee_project (employee_id, project_id)
VALUES (1, 1),
       (2, 1),
       (2, 2),
       (3, 1),
       (3, 2),
       (4, 2);