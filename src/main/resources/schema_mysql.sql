SET NAMES utf8;

CREATE DATABASE spring-boot2-demo DEFAULT CHARSET 'utf8';
USE spring-boot2-demo;

DROP TABLE IF EXISTS employee;
CREATE TABLE employee (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key',
  name varchar(32) NOT NULL DEFAULT '' COMMENT 'Employee Name',
  dept varchar(32) DEFAULT '' COMMENT 'Employee Department',
  employee_no varchar(32) NOT NULL DEFAULT '' COMMENT 'Employee No.',
  created_at datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Created Datetime',
  created_by varchar(32) NOT NULL DEFAULT '' COMMENT 'Create User',
  updated_at datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Updated Datetime',
  updated_by varchar(32) NOT NULL DEFAULT '' COMMENT 'Update User',
  PRIMARY KEY (id),
  UNIQUE KEY employee_no_uindex (employee_no)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Employee Information';