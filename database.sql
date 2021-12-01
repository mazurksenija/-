CREATE TABLE `colleague` (
  `idcolleague` int NOT NULL,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `position` varchar(45) NOT NULL,
  `fk_id_pr` varchar(45) NOT NULL,
  PRIMARY KEY (`idcolleague`),
  KEY `fk_id_pr_idx` (`fk_id_pr`),
  CONSTRAINT `fk_id_pr` FOREIGN KEY (`fk_id_pr`) REFERENCES `project` (`pr_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `customer` (
  `id_customer` int NOT NULL,
  `name_org` varchar(45) NOT NULL,
  `fk_cust_pr` varchar(45) NOT NULL,
  PRIMARY KEY (`id_customer`),
  KEY `fk_id_pr_idx` (`fk_cust_pr`),
  CONSTRAINT `fk_cust_pr` FOREIGN KEY (`fk_cust_pr`) REFERENCES `project` (`pr_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `project` (
  `pr_name` varchar(45) NOT NULL,
  `lead` varchar(45) NOT NULL,
  `about` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`pr_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `requirement` (
  `id_requirement` int NOT NULL,
  `type` varchar(45) NOT NULL,
  `info` varchar(200) NOT NULL,
  `start_time` varchar(45) NOT NULL,
  `end_time` varchar(45) NOT NULL,
  `fk_pr_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id_requirement`),
  KEY `fk_pr_name_idx` (`fk_pr_name`),
  CONSTRAINT `fk_pr_name` FOREIGN KEY (`fk_pr_name`) REFERENCES `project` (`pr_name`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user` (
  `iduser` int NOT NULL,
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
