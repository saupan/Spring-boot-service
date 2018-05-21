CREATE TABLE IF NOT EXISTS `employee` (
  `id` BINARY(16) NOT NULL,
  `email` VARCHAR(32) NOT NULL,
  `name` VARCHAR(32) NOT NULL,
  `birthdate` DATE NOT NULL,
  `hobby` VARCHAR(32),
  PRIMARY KEY (`id`),
  UNIQUE (`id`,`email`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;