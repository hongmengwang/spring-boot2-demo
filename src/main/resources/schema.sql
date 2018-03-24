CREATE TABLE employee (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(32),
  department_id int(11),
  employee_no varchar(32),
  created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  created_by varchar(32),
  updated_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_by varchar(32),
  PRIMARY KEY (id)
);

CREATE TABLE department (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(32),
  floor int(11),
  created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  created_by varchar(32),
  updated_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_by varchar(32),
  PRIMARY KEY (id)
);