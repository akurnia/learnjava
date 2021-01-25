DROP TABLE IF EXISTS Employee;

CREATE TABLE Employee (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  firstName VARCHAR(250) NOT NULL,
  lastName VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL
);

INSERT INTO Employee (id, firstName, lastName, email) VALUES
  (10001, 'Arief', 'Kurnia', 'akurnia@pegipegi.com'),
  (10002, 'Oky', 'Irmawan', 'oky@pegipegi.com'),
  (10003, 'Vinra', 'Pandia', 'vinra@pegipegi.com');