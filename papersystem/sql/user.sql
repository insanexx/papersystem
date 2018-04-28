use papersystem;
CREATE TABLE IF NOT EXISTS `user` (
  `yhid` int(11) NOT NULL AUTO_INCREMENT,
  `mm` varchar(50) NOT NULL DEFAULT '0' COMMENT '密码',
  `xm` varchar(50) NOT NULL DEFAULT '0' COMMENT '姓名',
  `xy` varchar(50) NOT NULL DEFAULT '0' COMMENT '学院',
  `zy` varchar(50) NOT NULL DEFAULT '0' COMMENT '专业',
  `jc` varchar(50) NOT NULL DEFAULT '0' COMMENT '届次',
  PRIMARY KEY (`yhid`),
  UNIQUE KEY `xm` (`xm`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
