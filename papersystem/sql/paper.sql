use papersystem;
CREATE TABLE IF NOT EXISTS `paper` (
  `lwid` int(11) NOT NULL AUTO_INCREMENT,
  `lwtm` varchar(50) DEFAULT '0',
  `zhy` text NOT NULL,
  `gjc` varchar(200) NOT NULL DEFAULT '0',
  `xm` varchar(50) NOT NULL DEFAULT '0',
  `xy` varchar(50) NOT NULL DEFAULT '0',
  `zy` varchar(50) NOT NULL DEFAULT '0',
  `jc` varchar(50) NOT NULL DEFAULT '0',
  `zdls` varchar(50) NOT NULL DEFAULT '0',
  `jb` varchar(50) NOT NULL DEFAULT '0',
  `nr` longtext NOT NULL,
  `jxmsid` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`lwid`),
  KEY `FK_paper_teacher` (`jxmsid`),
  CONSTRAINT `FK_paper_teacher` FOREIGN KEY (`jxmsid`) REFERENCES `teacher` (`jxmsid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
