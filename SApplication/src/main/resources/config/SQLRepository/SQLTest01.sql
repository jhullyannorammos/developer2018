create database fazenda_db;
drop database provasql;


CREATE TABLE IF NOT EXISTS application.country (
  `sigla` char(2) NOT NULL,
  `iso3` char(3) NOT NULL,
  `numcode` smallint(6) NOT NULL,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`sigla`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS application.federation (
  `id` int(2) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `sigla` varchar(2) NOT NULL DEFAULT '',
  `nome` varchar(20) NOT NULL DEFAULT '',
  `country` char(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS application.city (
  `id` int(4) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `federation` varchar(4) NOT NULL DEFAULT '',
  `nome` varchar(50) NOT NULL DEFAULT '',
  UNIQUE KEY `id` (`id`),
  KEY `id_2` (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9715 DEFAULT CHARSET=utf8;