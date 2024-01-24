CREATE DATABASE IF NOT EXISTS `mondryptaszeknasosnie` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE IF NOT EXISTS `mondryptaszeknasosnie`.`User` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(60) NOT NULL,
    `surname` VARCHAR(60) NOT NULL,
    `PESEL` CHAR(11) NOT NULL UNIQUE,
    `IDNumber` CHAR(10) NOT NULL UNIQUE,
    `mailAddress` VARCHAR(60) NOT NULL UNIQUE,
    `birthDate` DATE NOT NULL,
    `login` VARCHAR(60) NOT NULL,
    `password` VARCHAR(60) NOT NULL
);

CREATE TABLE IF NOT EXISTS `mondryptaszeknasosnie`.`Payment` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `title` VARCHAR(60) NOT NULL,
    `date` DATE NOT NULL,
    `amount` INT NOT NULL,
    `sender_id` INT NOT NULL,
    `receiver_id` INT NOT NULL,
    `currency` char(3) NOT NULL
);