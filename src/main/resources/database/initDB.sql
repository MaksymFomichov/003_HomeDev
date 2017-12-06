CREATE TABLE IF NOT EXISTS developers (
  id   BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50) UNIQUE NOT NULL
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTSskills (
  id    BIGINT AUTO_INCREMENT PRIMARY KEY,
  skill VARCHAR(50) UNIQUE NOT NULL
)ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTSprojects (
  id      BIGINT AUTO_INCREMENT PRIMARY KEY,
  project VARCHAR(50) UNIQUE NOT NULL
)ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTScompanies (
  id      BIGINT AUTO_INCREMENT PRIMARY KEY,
  company VARCHAR(50) UNIQUE NOT NULL
)ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTScustomers (
  id       BIGINT AUTO_INCREMENT PRIMARY KEY,
  customer VARCHAR(50) UNIQUE NOT NULL
)ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `developers_skills` (
  `developers_id` BIGINT,
  `skills_id`     BIGINT,
  PRIMARY KEY (`developers_id`, `skills_id`),
  CONSTRAINT fk_id_developer FOREIGN KEY (developers_id) REFERENCES developers (id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT fk_id_skill FOREIGN KEY (skills_id) REFERENCES skills (id) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `developers_projects` (
  `developers_id` BIGINT,
  `projects_id`   BIGINT,
  PRIMARY KEY (`developers_id`, `projects_id`),
  CONSTRAINT fk_id_developer_project FOREIGN KEY (developers_id) REFERENCES developers(id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT fk_id_project FOREIGN KEY (projects_id) REFERENCES projects(id) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `companies_projects` (
  `companies_id` BIGINT,
  `projects_id`  BIGINT,
  PRIMARY KEY (`companies_id`, `projects_id`),
  CONSTRAINT fk_id_company FOREIGN KEY (companies_id) REFERENCES companies(id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT fk_id_project_company FOREIGN KEY (projects_id) REFERENCES projects(id) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `customers_projects` (
  `customers_id` BIGINT,
  `projects_id`  BIGINT,
  PRIMARY KEY (`customers_id`, `projects_id`),
  CONSTRAINT fk_id_customer FOREIGN KEY (customers_id) REFERENCES customers(id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT fk_id_project_customer FOREIGN KEY (projects_id) REFERENCES projects(id) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = InnoDB;