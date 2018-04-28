use papersystem;
CREATE TABLE IF NOT EXISTS `teacher` (
  `jxmsid` int(11) NOT NULL AUTO_INCREMENT,
  `xm` varchar(50) NOT NULL DEFAULT '0',
  `mm` varchar(50) NOT NULL DEFAULT '0',
  `xy` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`jxmsid`),
  UNIQUE KEY `xm` (`xm`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
