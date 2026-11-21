-- Optional: the app creates this automatically (createDatabaseIfNotExist=true).
-- Run this only if you want to create the database manually.
CREATE DATABASE IF NOT EXISTS swynex_db;
USE swynex_db;

-- The table is created by Hibernate automatically. For reference:
-- CREATE TABLE students (
--   id BIGINT AUTO_INCREMENT PRIMARY KEY,
--   name VARCHAR(255) NOT NULL,
--   email VARCHAR(255) NOT NULL UNIQUE,
--   course VARCHAR(255) NOT NULL,
--   age INT NOT NULL
-- );
