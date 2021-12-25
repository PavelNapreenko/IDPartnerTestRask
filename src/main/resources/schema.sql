SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

DROP TABLE IF EXISTS rates;

CREATE TABLE IF NOT EXISTS `rates`
(
    `id`           int  NOT NULL AUTO_INCREMENT,
    `rate_name`    varchar(5) COLLATE utf8mb4_unicode_ci NOT NULL,
    `rate_value`   decimal COLLATE utf8mb4_unicode_ci NOT NULL,
    `rate_date`    datetime                              NOT NULL,
    `rate_time`    time COLLATE utf8mb4_unicode_ci NOT NULL,
    PRIMARY KEY (`id`),
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;