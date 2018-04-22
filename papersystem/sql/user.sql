use papersystem;
CREATE TABLE IF NOT EXISTS `user` (
  `yhid` int(11) NOT NULL AUTO_INCREMENT,
  `mm` varchar(50) NOT NULL DEFAULT '0',
  `xm` varchar(50) NOT NULL DEFAULT '0',
  `xy` varchar(50) NOT NULL DEFAULT '0',
  `zy` varchar(50) NOT NULL DEFAULT '0',
  `jc` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`yhid`),
  UNIQUE KEY `xm` (`xm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
