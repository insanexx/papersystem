use papersystem;
CREATE TABLE IF NOT EXISTS `admin` (
  `glyid` int(11) NOT NULL AUTO_INCREMENT,
  `xm` varchar(50) NOT NULL DEFAULT '0',
  `mm` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`glyid`),
  UNIQUE KEY `xm` (`xm`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO `admin` (`glyid`, `xm`, `mm`) VALUES
	(1, 'root', 'Y6nw6nu5gFB5a2SehUgYRQ==');
