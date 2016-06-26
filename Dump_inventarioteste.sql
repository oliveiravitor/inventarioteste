-- MySQL dump 10.13  Distrib 5.7.9, for Win32 (AMD64)
--
-- Host: 127.0.0.1    Database: inventarioteste
-- ------------------------------------------------------
-- Server version	5.6.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `administrador`
--

DROP TABLE IF EXISTS `administrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administrador` (
  `idAdministrador` int(11) NOT NULL AUTO_INCREMENT,
  `nomeCompletoAdmin` varchar(60) NOT NULL,
  `matriculaAdmin` int(11) NOT NULL,
  `telefoneAdmin` varchar(15) NOT NULL,
  `emailAdmin` varchar(45) NOT NULL,
  `statusAdmin` enum('A','I') NOT NULL DEFAULT 'A',
  `senhaAdmin` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`idAdministrador`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrador`
--

LOCK TABLES `administrador` WRITE;
/*!40000 ALTER TABLE `administrador` DISABLE KEYS */;
/*!40000 ALTER TABLE `administrador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datadescarte`
--

DROP TABLE IF EXISTS `datadescarte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `datadescarte` (
  `idDataDescarte` int(11) NOT NULL AUTO_INCREMENT,
  `idEquip` int(11) NOT NULL,
  `dataDescarte` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idDataDescarte`),
  KEY `fk_dataDescarte_Equipamento_idx` (`idEquip`),
  CONSTRAINT `fk_dataDescarte_Equipamento` FOREIGN KEY (`idEquip`) REFERENCES `equipamento` (`idEquip`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datadescarte`
--

LOCK TABLES `datadescarte` WRITE;
/*!40000 ALTER TABLE `datadescarte` DISABLE KEYS */;
/*!40000 ALTER TABLE `datadescarte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `endereco` (
  `idendereco` int(11) NOT NULL AUTO_INCREMENT,
  `logradouroEndereco` varchar(60) NOT NULL,
  `numeroEndereco` varchar(10) NOT NULL,
  `complementoEndereco` varchar(45) DEFAULT NULL,
  `bairroEndereco` varchar(45) NOT NULL,
  `cidadeEndereco` varchar(45) NOT NULL,
  `cepEndereco` varchar(10) NOT NULL,
  `estadoEndereco` char(2) NOT NULL,
  `statusEndereco` enum('A','I') NOT NULL DEFAULT 'A',
  PRIMARY KEY (`idendereco`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` VALUES (1,'Av. Miguel Varlez','666','','Centro','Caraguatatuba','11660-000','SP','A'),(2,'Av. do Estado','100','BLOCO A','Centro','S?úo Paulo','04567-323','SP','A'),(3,'rua 5','118','','martim','caragua','11660-000','SP','A'),(4,'rua X','111','','Barranco Baixo','Caragua','11660-000','SP','A'),(5,'rua Y','3456','','Lapa','Rio de Janeiro','87324-675','RJ','A'),(6,'wwwwwwwww','2222','sssssss','sssssssss','ssssssss','333333333','AP','A'),(7,'ee','333','ddd','ddd','dd','3333','AC','A');
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipamento`
--

DROP TABLE IF EXISTS `equipamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipamento` (
  `idEquip` int(11) NOT NULL AUTO_INCREMENT,
  `idUsuarioFinal` int(11) NOT NULL,
  `idLocalidade` int(11) NOT NULL,
  `idFornecedor` int(11) NOT NULL,
  `tipoEquip` enum('A','D','N','I') NOT NULL,
  `origemEquip` enum('L','P') NOT NULL,
  `modeloEquip` varchar(25) NOT NULL,
  `numSerieEquip` varchar(25) NOT NULL,
  `numSerieGabineteEquip` varchar(25) NOT NULL,
  `numSerieMouseEquip` varchar(25) NOT NULL,
  `numSerieTecladoEquip` varchar(25) NOT NULL,
  `numSerieMonitorEquip` varchar(45) NOT NULL,
  `dataEntradaEquip` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `statusEquip` enum('U','L','M','D') NOT NULL DEFAULT 'L',
  `equipamentocol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idEquip`),
  UNIQUE KEY `numSerieEquip_UNIQUE` (`numSerieEquip`),
  KEY `fk_Equipamento_usuarioFinal1_idx` (`idUsuarioFinal`),
  KEY `fk_Equipamento_localidade1_idx` (`idLocalidade`),
  KEY `fk_Equipamento_fornecedor1_idx` (`idFornecedor`),
  CONSTRAINT `fk_Equipamento_fornecedor1` FOREIGN KEY (`idFornecedor`) REFERENCES `fornecedor` (`idFornecedor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Equipamento_localidade1` FOREIGN KEY (`idLocalidade`) REFERENCES `localidade` (`idLocalidade`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Equipamento_usuarioFinal1` FOREIGN KEY (`idUsuarioFinal`) REFERENCES `usuariofinal` (`idUsuarioFinal`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipamento`
--

LOCK TABLES `equipamento` WRITE;
/*!40000 ALTER TABLE `equipamento` DISABLE KEYS */;
INSERT INTO `equipamento` VALUES (1,1,1,2,'N','P','I7','DEU34256436BR','','','','','2015-12-04 15:05:18','L',NULL),(2,1,1,3,'A','L','I3','344365JABE341BR','','434356BJADE','34136T2345JADE','','2015-12-04 15:06:06','L',NULL),(3,1,1,1,'I','P','EPSON-LX810','3425465EP343810L','','','','','2015-12-04 15:06:32','L',NULL),(4,1,1,3,'D','L','I5','435314JD234','34525423JD1','345441364R1JD2','EWTRTGRJD3','32145154JD4','2015-12-04 15:07:03','L',NULL),(5,1,1,3,'A','L','I3','JD214345BRE','','3243215JD234BRE','234235345KDBRE','','2015-12-04 15:08:56','L',NULL),(6,1,1,1,'I','L','CANNON XYZ','CNB3445432BR','','','','','2015-12-04 15:10:40','L',NULL),(7,1,1,2,'N','P','i7','4355','','','','','2016-06-25 02:59:18','L',NULL),(8,1,1,1,'D','L','eeeeeeee','eeeeeeeeee','eeeeeeeeee','eeeee','e','eeeeeeee','2016-06-25 02:59:39','L',NULL);
/*!40000 ALTER TABLE `equipamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `equipamentoallinone`
--

DROP TABLE IF EXISTS `equipamentoallinone`;
/*!50001 DROP VIEW IF EXISTS `equipamentoallinone`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `equipamentoallinone` AS SELECT 
 1 AS `idEquip`,
 1 AS `tipoEquip`,
 1 AS `origemEquip`,
 1 AS `modeloEquip`,
 1 AS `numSerieEquip`,
 1 AS `numSerieGabineteEquip`,
 1 AS `numSerieMouseEquip`,
 1 AS `numSerieTecladoEquip`,
 1 AS `numSerieMonitorEquip`,
 1 AS `dataEntradaEquip`,
 1 AS `statusEquip`,
 1 AS `idFornecedor`,
 1 AS `idEnderecoFornecedor`,
 1 AS `nomeContatoFornecedor`,
 1 AS `nomeFornecedor`,
 1 AS `emailFornecedor`,
 1 AS `telefoneFornecedor`,
 1 AS `statusFornecedor`,
 1 AS `idLocalidade`,
 1 AS `idEnderecoLocal`,
 1 AS `identificacaoLocal`,
 1 AS `setorLocal`,
 1 AS `statusLocal`,
 1 AS `idUsuarioFinal`,
 1 AS `nomeUsuario`,
 1 AS `matriculaUsuario`,
 1 AS `emailUsuario`,
 1 AS `telefoneUsuario`,
 1 AS `StatusUsuario`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `equipamentodesktop`
--

DROP TABLE IF EXISTS `equipamentodesktop`;
/*!50001 DROP VIEW IF EXISTS `equipamentodesktop`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `equipamentodesktop` AS SELECT 
 1 AS `idEquip`,
 1 AS `tipoEquip`,
 1 AS `origemEquip`,
 1 AS `modeloEquip`,
 1 AS `numSerieEquip`,
 1 AS `numSerieGabineteEquip`,
 1 AS `numSerieMouseEquip`,
 1 AS `numSerieTecladoEquip`,
 1 AS `numSerieMonitorEquip`,
 1 AS `dataEntradaEquip`,
 1 AS `statusEquip`,
 1 AS `idFornecedor`,
 1 AS `idEnderecoFornecedor`,
 1 AS `nomeContatoFornecedor`,
 1 AS `nomeFornecedor`,
 1 AS `emailFornecedor`,
 1 AS `telefoneFornecedor`,
 1 AS `statusFornecedor`,
 1 AS `idLocalidade`,
 1 AS `idEnderecoLocal`,
 1 AS `identificacaoLocal`,
 1 AS `setorLocal`,
 1 AS `statusLocal`,
 1 AS `idUsuarioFinal`,
 1 AS `nomeUsuario`,
 1 AS `matriculaUsuario`,
 1 AS `emailUsuario`,
 1 AS `telefoneUsuario`,
 1 AS `StatusUsuario`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `equipamentofull`
--

DROP TABLE IF EXISTS `equipamentofull`;
/*!50001 DROP VIEW IF EXISTS `equipamentofull`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `equipamentofull` AS SELECT 
 1 AS `idEquip`,
 1 AS `tipoEquip`,
 1 AS `origemEquip`,
 1 AS `modeloEquip`,
 1 AS `numSerieEquip`,
 1 AS `numSerieGabineteEquip`,
 1 AS `numSerieMouseEquip`,
 1 AS `numSerieTecladoEquip`,
 1 AS `numSerieMonitorEquip`,
 1 AS `dataEntradaEquip`,
 1 AS `statusEquip`,
 1 AS `idFornecedor`,
 1 AS `idEnderecoFornecedor`,
 1 AS `nomeContatoFornecedor`,
 1 AS `nomeFornecedor`,
 1 AS `emailFornecedor`,
 1 AS `telefoneFornecedor`,
 1 AS `statusFornecedor`,
 1 AS `idLocalidade`,
 1 AS `idEnderecoLocal`,
 1 AS `identificacaoLocal`,
 1 AS `setorLocal`,
 1 AS `statusLocal`,
 1 AS `idUsuarioFinal`,
 1 AS `nomeUsuario`,
 1 AS `matriculaUsuario`,
 1 AS `emailUsuario`,
 1 AS `telefoneUsuario`,
 1 AS `StatusUsuario`,
 1 AS `ipRedeConfig`,
 1 AS `hostRedeConfig`,
 1 AS `dataDescarte`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `equipamentoimpressora`
--

DROP TABLE IF EXISTS `equipamentoimpressora`;
/*!50001 DROP VIEW IF EXISTS `equipamentoimpressora`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `equipamentoimpressora` AS SELECT 
 1 AS `idEquip`,
 1 AS `tipoEquip`,
 1 AS `origemEquip`,
 1 AS `modeloEquip`,
 1 AS `numSerieEquip`,
 1 AS `numSerieGabineteEquip`,
 1 AS `numSerieMouseEquip`,
 1 AS `numSerieTecladoEquip`,
 1 AS `numSerieMonitorEquip`,
 1 AS `dataEntradaEquip`,
 1 AS `statusEquip`,
 1 AS `idFornecedor`,
 1 AS `idEnderecoFornecedor`,
 1 AS `nomeContatoFornecedor`,
 1 AS `nomeFornecedor`,
 1 AS `emailFornecedor`,
 1 AS `telefoneFornecedor`,
 1 AS `statusFornecedor`,
 1 AS `idLocalidade`,
 1 AS `idEnderecoLocal`,
 1 AS `identificacaoLocal`,
 1 AS `setorLocal`,
 1 AS `statusLocal`,
 1 AS `idUsuarioFinal`,
 1 AS `nomeUsuario`,
 1 AS `matriculaUsuario`,
 1 AS `emailUsuario`,
 1 AS `telefoneUsuario`,
 1 AS `StatusUsuario`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `equipamentonotebook`
--

DROP TABLE IF EXISTS `equipamentonotebook`;
/*!50001 DROP VIEW IF EXISTS `equipamentonotebook`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `equipamentonotebook` AS SELECT 
 1 AS `idEquip`,
 1 AS `tipoEquip`,
 1 AS `origemEquip`,
 1 AS `modeloEquip`,
 1 AS `numSerieEquip`,
 1 AS `numSerieGabineteEquip`,
 1 AS `numSerieMouseEquip`,
 1 AS `numSerieTecladoEquip`,
 1 AS `numSerieMonitorEquip`,
 1 AS `dataEntradaEquip`,
 1 AS `statusEquip`,
 1 AS `idFornecedor`,
 1 AS `idEnderecoFornecedor`,
 1 AS `nomeContatoFornecedor`,
 1 AS `nomeFornecedor`,
 1 AS `emailFornecedor`,
 1 AS `telefoneFornecedor`,
 1 AS `statusFornecedor`,
 1 AS `idLocalidade`,
 1 AS `idEnderecoLocal`,
 1 AS `identificacaoLocal`,
 1 AS `setorLocal`,
 1 AS `statusLocal`,
 1 AS `idUsuarioFinal`,
 1 AS `nomeUsuario`,
 1 AS `matriculaUsuario`,
 1 AS `emailUsuario`,
 1 AS `telefoneUsuario`,
 1 AS `StatusUsuario`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `fornecedor`
--

DROP TABLE IF EXISTS `fornecedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fornecedor` (
  `idFornecedor` int(11) NOT NULL AUTO_INCREMENT,
  `idEnderecoFornecedor` int(11) NOT NULL,
  `nomeContatoFornecedor` varchar(45) NOT NULL,
  `nomeFornecedor` varchar(45) NOT NULL,
  `emailFornecedor` varchar(45) NOT NULL,
  `telefoneFornecedor` varchar(15) NOT NULL,
  `statusFornecedor` enum('A','I') NOT NULL DEFAULT 'A',
  PRIMARY KEY (`idFornecedor`),
  KEY `fk_fornecedor_endereco1_idx` (`idEnderecoFornecedor`),
  CONSTRAINT `fk_fornecedor_endereco1` FOREIGN KEY (`idEnderecoFornecedor`) REFERENCES `endereco` (`idendereco`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fornecedor`
--

LOCK TABLES `fornecedor` WRITE;
/*!40000 ALTER TABLE `fornecedor` DISABLE KEYS */;
INSERT INTO `fornecedor` VALUES (1,1,'João Batista','Patrimonio - estoque TI','patrimonioti@suaempresa.com','12-98888-7777','A'),(2,2,'Fulano','D?®u Computadores','fulano@deucomp.com.br','11-3245-9867','A'),(3,5,'Beutrano','JADE','vendas@jade.com.br','21-3455-5647','A'),(4,6,'wwwwwwww','wwwwwwwwww','wwwwwww','11111111111','A');
/*!40000 ALTER TABLE `fornecedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `localidade`
--

DROP TABLE IF EXISTS `localidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `localidade` (
  `idLocalidade` int(11) NOT NULL AUTO_INCREMENT,
  `idEnderecoLocal` int(11) NOT NULL,
  `identificacaoLocal` varchar(45) NOT NULL,
  `setorLocal` varchar(45) NOT NULL,
  `statusLocal` enum('A','I') NOT NULL DEFAULT 'A',
  PRIMARY KEY (`idLocalidade`),
  KEY `fk_localidade_endereco1_idx` (`idEnderecoLocal`),
  CONSTRAINT `fk_localidade_endereco1` FOREIGN KEY (`idEnderecoLocal`) REFERENCES `endereco` (`idendereco`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localidade`
--

LOCK TABLES `localidade` WRITE;
/*!40000 ALTER TABLE `localidade` DISABLE KEYS */;
INSERT INTO `localidade` VALUES (1,1,'Estoque TI','TI','A'),(2,3,'Desenvolvimento','TI','A'),(3,4,'Contabilidade','Administraçãoo','A'),(4,7,'ee','ee','A');
/*!40000 ALTER TABLE `localidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manipula`
--

DROP TABLE IF EXISTS `manipula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manipula` (
  `idAdministrador` int(11) NOT NULL,
  `idEquip` int(11) NOT NULL,
  `dataEntrada` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idAdministrador`,`idEquip`),
  KEY `fk_administrador_has_Equipamento_Equipamento1_idx` (`idEquip`),
  KEY `fk_administrador_has_Equipamento_administrador1_idx` (`idAdministrador`),
  CONSTRAINT `fk_administrador_has_Equipamento_Equipamento1` FOREIGN KEY (`idEquip`) REFERENCES `equipamento` (`idEquip`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_administrador_has_Equipamento_administrador1` FOREIGN KEY (`idAdministrador`) REFERENCES `administrador` (`idAdministrador`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manipula`
--

LOCK TABLES `manipula` WRITE;
/*!40000 ALTER TABLE `manipula` DISABLE KEYS */;
/*!40000 ALTER TABLE `manipula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `redeconfig`
--

DROP TABLE IF EXISTS `redeconfig`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `redeconfig` (
  `idRedeConfig` int(11) NOT NULL AUTO_INCREMENT,
  `idEquip` int(11) NOT NULL,
  `ipRedeConfig` varchar(15) NOT NULL,
  `hostRedeConfig` varchar(20) NOT NULL,
  PRIMARY KEY (`idRedeConfig`),
  KEY `fk_redeConfig_Equipamento1_idx` (`idEquip`),
  CONSTRAINT `fk_redeConfig_Equipamento1` FOREIGN KEY (`idEquip`) REFERENCES `equipamento` (`idEquip`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `redeconfig`
--

LOCK TABLES `redeconfig` WRITE;
/*!40000 ALTER TABLE `redeconfig` DISABLE KEYS */;
/*!40000 ALTER TABLE `redeconfig` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `termoresponsabilidade`
--

DROP TABLE IF EXISTS `termoresponsabilidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `termoresponsabilidade` (
  `numTermo` int(11) NOT NULL,
  `idEquip` int(11) NOT NULL,
  `idUsuarioFinal` int(11) NOT NULL,
  `dataInicioTermo` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dataTerminoTermo` date DEFAULT NULL,
  PRIMARY KEY (`numTermo`),
  KEY `fk_termoResponsabilidade_usuarioFinal1_idx` (`idUsuarioFinal`),
  KEY `fk_termoResponsabilidade_equipamento1_idx` (`idEquip`),
  CONSTRAINT `fk_termoResponsabilidade_equipamento1` FOREIGN KEY (`idEquip`) REFERENCES `equipamento` (`idEquip`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_termoResponsabilidade_usuarioFinal1` FOREIGN KEY (`idUsuarioFinal`) REFERENCES `usuariofinal` (`idUsuarioFinal`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `termoresponsabilidade`
--

LOCK TABLES `termoresponsabilidade` WRITE;
/*!40000 ALTER TABLE `termoresponsabilidade` DISABLE KEYS */;
/*!40000 ALTER TABLE `termoresponsabilidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuariofinal`
--

DROP TABLE IF EXISTS `usuariofinal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuariofinal` (
  `idUsuarioFinal` int(11) NOT NULL AUTO_INCREMENT,
  `nomeUsuario` varchar(60) NOT NULL,
  `matriculaUsuario` int(11) NOT NULL,
  `emailUsuario` varchar(45) NOT NULL,
  `telefoneUsuario` varchar(15) NOT NULL,
  `statusUsuario` enum('A','I') NOT NULL DEFAULT 'A',
  PRIMARY KEY (`idUsuarioFinal`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuariofinal`
--

LOCK TABLES `usuariofinal` WRITE;
/*!40000 ALTER TABLE `usuariofinal` DISABLE KEYS */;
INSERT INTO `usuariofinal` VALUES (1,'Estoque',1,'estoque@suaempresa.com','12-3888-8888','A'),(2,'Gil',2,'gil@empresa.com.br','12-3882-8955','A'),(3,'Rosbervaldo',3,'rbsv@empresa.com.br','12-3887-8888','A'),(4,'eeeeeeeee',33333,'eeeeeeee','3333333333','A');
/*!40000 ALTER TABLE `usuariofinal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `equipamentoallinone`
--

/*!50001 DROP VIEW IF EXISTS `equipamentoallinone`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = cp850 */;
/*!50001 SET character_set_results     = cp850 */;
/*!50001 SET collation_connection      = cp850_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `equipamentoallinone` AS select `e`.`idEquip` AS `idEquip`,`e`.`tipoEquip` AS `tipoEquip`,`e`.`origemEquip` AS `origemEquip`,`e`.`modeloEquip` AS `modeloEquip`,`e`.`numSerieEquip` AS `numSerieEquip`,`e`.`numSerieGabineteEquip` AS `numSerieGabineteEquip`,`e`.`numSerieMouseEquip` AS `numSerieMouseEquip`,`e`.`numSerieTecladoEquip` AS `numSerieTecladoEquip`,`e`.`numSerieMonitorEquip` AS `numSerieMonitorEquip`,`e`.`dataEntradaEquip` AS `dataEntradaEquip`,`e`.`statusEquip` AS `statusEquip`,`f`.`idFornecedor` AS `idFornecedor`,`f`.`idEnderecoFornecedor` AS `idEnderecoFornecedor`,`f`.`nomeContatoFornecedor` AS `nomeContatoFornecedor`,`f`.`nomeFornecedor` AS `nomeFornecedor`,`f`.`emailFornecedor` AS `emailFornecedor`,`f`.`telefoneFornecedor` AS `telefoneFornecedor`,`f`.`statusFornecedor` AS `statusFornecedor`,`l`.`idLocalidade` AS `idLocalidade`,`l`.`idEnderecoLocal` AS `idEnderecoLocal`,`l`.`identificacaoLocal` AS `identificacaoLocal`,`l`.`setorLocal` AS `setorLocal`,`l`.`statusLocal` AS `statusLocal`,`u`.`idUsuarioFinal` AS `idUsuarioFinal`,`u`.`nomeUsuario` AS `nomeUsuario`,`u`.`matriculaUsuario` AS `matriculaUsuario`,`u`.`emailUsuario` AS `emailUsuario`,`u`.`telefoneUsuario` AS `telefoneUsuario`,`u`.`statusUsuario` AS `StatusUsuario` from (((((`equipamento` `e` join `fornecedor` `f` on((`e`.`idFornecedor` = `f`.`idFornecedor`))) join `localidade` `l` on((`e`.`idLocalidade` = `l`.`idLocalidade`))) join `usuariofinal` `u` on((`e`.`idUsuarioFinal` = `u`.`idUsuarioFinal`))) left join `redeconfig` `r` on((`r`.`idEquip` = `e`.`idEquip`))) left join `datadescarte` `d` on((`d`.`idEquip` = `e`.`idEquip`))) where (`e`.`tipoEquip` = 'A') group by `e`.`idEquip` order by `e`.`idEquip` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `equipamentodesktop`
--

/*!50001 DROP VIEW IF EXISTS `equipamentodesktop`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = cp850 */;
/*!50001 SET character_set_results     = cp850 */;
/*!50001 SET collation_connection      = cp850_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `equipamentodesktop` AS select `e`.`idEquip` AS `idEquip`,`e`.`tipoEquip` AS `tipoEquip`,`e`.`origemEquip` AS `origemEquip`,`e`.`modeloEquip` AS `modeloEquip`,`e`.`numSerieEquip` AS `numSerieEquip`,`e`.`numSerieGabineteEquip` AS `numSerieGabineteEquip`,`e`.`numSerieMouseEquip` AS `numSerieMouseEquip`,`e`.`numSerieTecladoEquip` AS `numSerieTecladoEquip`,`e`.`numSerieMonitorEquip` AS `numSerieMonitorEquip`,`e`.`dataEntradaEquip` AS `dataEntradaEquip`,`e`.`statusEquip` AS `statusEquip`,`f`.`idFornecedor` AS `idFornecedor`,`f`.`idEnderecoFornecedor` AS `idEnderecoFornecedor`,`f`.`nomeContatoFornecedor` AS `nomeContatoFornecedor`,`f`.`nomeFornecedor` AS `nomeFornecedor`,`f`.`emailFornecedor` AS `emailFornecedor`,`f`.`telefoneFornecedor` AS `telefoneFornecedor`,`f`.`statusFornecedor` AS `statusFornecedor`,`l`.`idLocalidade` AS `idLocalidade`,`l`.`idEnderecoLocal` AS `idEnderecoLocal`,`l`.`identificacaoLocal` AS `identificacaoLocal`,`l`.`setorLocal` AS `setorLocal`,`l`.`statusLocal` AS `statusLocal`,`u`.`idUsuarioFinal` AS `idUsuarioFinal`,`u`.`nomeUsuario` AS `nomeUsuario`,`u`.`matriculaUsuario` AS `matriculaUsuario`,`u`.`emailUsuario` AS `emailUsuario`,`u`.`telefoneUsuario` AS `telefoneUsuario`,`u`.`statusUsuario` AS `StatusUsuario` from (((((`equipamento` `e` join `fornecedor` `f` on((`e`.`idFornecedor` = `f`.`idFornecedor`))) join `localidade` `l` on((`e`.`idLocalidade` = `l`.`idLocalidade`))) join `usuariofinal` `u` on((`e`.`idUsuarioFinal` = `u`.`idUsuarioFinal`))) left join `redeconfig` `r` on((`r`.`idEquip` = `e`.`idEquip`))) left join `datadescarte` `d` on((`d`.`idEquip` = `e`.`idEquip`))) where (`e`.`tipoEquip` = 'D') group by `e`.`idEquip` order by `e`.`idEquip` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `equipamentofull`
--

/*!50001 DROP VIEW IF EXISTS `equipamentofull`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = cp850 */;
/*!50001 SET character_set_results     = cp850 */;
/*!50001 SET collation_connection      = cp850_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `equipamentofull` AS select `e`.`idEquip` AS `idEquip`,`e`.`tipoEquip` AS `tipoEquip`,`e`.`origemEquip` AS `origemEquip`,`e`.`modeloEquip` AS `modeloEquip`,`e`.`numSerieEquip` AS `numSerieEquip`,`e`.`numSerieGabineteEquip` AS `numSerieGabineteEquip`,`e`.`numSerieMouseEquip` AS `numSerieMouseEquip`,`e`.`numSerieTecladoEquip` AS `numSerieTecladoEquip`,`e`.`numSerieMonitorEquip` AS `numSerieMonitorEquip`,`e`.`dataEntradaEquip` AS `dataEntradaEquip`,`e`.`statusEquip` AS `statusEquip`,`f`.`idFornecedor` AS `idFornecedor`,`f`.`idEnderecoFornecedor` AS `idEnderecoFornecedor`,`f`.`nomeContatoFornecedor` AS `nomeContatoFornecedor`,`f`.`nomeFornecedor` AS `nomeFornecedor`,`f`.`emailFornecedor` AS `emailFornecedor`,`f`.`telefoneFornecedor` AS `telefoneFornecedor`,`f`.`statusFornecedor` AS `statusFornecedor`,`l`.`idLocalidade` AS `idLocalidade`,`l`.`idEnderecoLocal` AS `idEnderecoLocal`,`l`.`identificacaoLocal` AS `identificacaoLocal`,`l`.`setorLocal` AS `setorLocal`,`l`.`statusLocal` AS `statusLocal`,`u`.`idUsuarioFinal` AS `idUsuarioFinal`,`u`.`nomeUsuario` AS `nomeUsuario`,`u`.`matriculaUsuario` AS `matriculaUsuario`,`u`.`emailUsuario` AS `emailUsuario`,`u`.`telefoneUsuario` AS `telefoneUsuario`,`u`.`statusUsuario` AS `StatusUsuario`,`r`.`ipRedeConfig` AS `ipRedeConfig`,`r`.`hostRedeConfig` AS `hostRedeConfig`,`d`.`dataDescarte` AS `dataDescarte` from (((((`equipamento` `e` join `fornecedor` `f` on((`e`.`idFornecedor` = `f`.`idFornecedor`))) join `localidade` `l` on((`e`.`idLocalidade` = `l`.`idLocalidade`))) join `usuariofinal` `u` on((`e`.`idUsuarioFinal` = `u`.`idUsuarioFinal`))) left join `redeconfig` `r` on((`r`.`idEquip` = `e`.`idEquip`))) left join `datadescarte` `d` on((`d`.`idEquip` = `e`.`idEquip`))) group by `e`.`idEquip` order by `e`.`idEquip` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `equipamentoimpressora`
--

/*!50001 DROP VIEW IF EXISTS `equipamentoimpressora`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = cp850 */;
/*!50001 SET character_set_results     = cp850 */;
/*!50001 SET collation_connection      = cp850_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `equipamentoimpressora` AS select `e`.`idEquip` AS `idEquip`,`e`.`tipoEquip` AS `tipoEquip`,`e`.`origemEquip` AS `origemEquip`,`e`.`modeloEquip` AS `modeloEquip`,`e`.`numSerieEquip` AS `numSerieEquip`,`e`.`numSerieGabineteEquip` AS `numSerieGabineteEquip`,`e`.`numSerieMouseEquip` AS `numSerieMouseEquip`,`e`.`numSerieTecladoEquip` AS `numSerieTecladoEquip`,`e`.`numSerieMonitorEquip` AS `numSerieMonitorEquip`,`e`.`dataEntradaEquip` AS `dataEntradaEquip`,`e`.`statusEquip` AS `statusEquip`,`f`.`idFornecedor` AS `idFornecedor`,`f`.`idEnderecoFornecedor` AS `idEnderecoFornecedor`,`f`.`nomeContatoFornecedor` AS `nomeContatoFornecedor`,`f`.`nomeFornecedor` AS `nomeFornecedor`,`f`.`emailFornecedor` AS `emailFornecedor`,`f`.`telefoneFornecedor` AS `telefoneFornecedor`,`f`.`statusFornecedor` AS `statusFornecedor`,`l`.`idLocalidade` AS `idLocalidade`,`l`.`idEnderecoLocal` AS `idEnderecoLocal`,`l`.`identificacaoLocal` AS `identificacaoLocal`,`l`.`setorLocal` AS `setorLocal`,`l`.`statusLocal` AS `statusLocal`,`u`.`idUsuarioFinal` AS `idUsuarioFinal`,`u`.`nomeUsuario` AS `nomeUsuario`,`u`.`matriculaUsuario` AS `matriculaUsuario`,`u`.`emailUsuario` AS `emailUsuario`,`u`.`telefoneUsuario` AS `telefoneUsuario`,`u`.`statusUsuario` AS `StatusUsuario` from (((((`equipamento` `e` join `fornecedor` `f` on((`e`.`idFornecedor` = `f`.`idFornecedor`))) join `localidade` `l` on((`e`.`idLocalidade` = `l`.`idLocalidade`))) join `usuariofinal` `u` on((`e`.`idUsuarioFinal` = `u`.`idUsuarioFinal`))) left join `redeconfig` `r` on((`r`.`idEquip` = `e`.`idEquip`))) left join `datadescarte` `d` on((`d`.`idEquip` = `e`.`idEquip`))) where (`e`.`tipoEquip` = 'I') group by `e`.`idEquip` order by `e`.`idEquip` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `equipamentonotebook`
--

/*!50001 DROP VIEW IF EXISTS `equipamentonotebook`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = cp850 */;
/*!50001 SET character_set_results     = cp850 */;
/*!50001 SET collation_connection      = cp850_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `equipamentonotebook` AS select `e`.`idEquip` AS `idEquip`,`e`.`tipoEquip` AS `tipoEquip`,`e`.`origemEquip` AS `origemEquip`,`e`.`modeloEquip` AS `modeloEquip`,`e`.`numSerieEquip` AS `numSerieEquip`,`e`.`numSerieGabineteEquip` AS `numSerieGabineteEquip`,`e`.`numSerieMouseEquip` AS `numSerieMouseEquip`,`e`.`numSerieTecladoEquip` AS `numSerieTecladoEquip`,`e`.`numSerieMonitorEquip` AS `numSerieMonitorEquip`,`e`.`dataEntradaEquip` AS `dataEntradaEquip`,`e`.`statusEquip` AS `statusEquip`,`f`.`idFornecedor` AS `idFornecedor`,`f`.`idEnderecoFornecedor` AS `idEnderecoFornecedor`,`f`.`nomeContatoFornecedor` AS `nomeContatoFornecedor`,`f`.`nomeFornecedor` AS `nomeFornecedor`,`f`.`emailFornecedor` AS `emailFornecedor`,`f`.`telefoneFornecedor` AS `telefoneFornecedor`,`f`.`statusFornecedor` AS `statusFornecedor`,`l`.`idLocalidade` AS `idLocalidade`,`l`.`idEnderecoLocal` AS `idEnderecoLocal`,`l`.`identificacaoLocal` AS `identificacaoLocal`,`l`.`setorLocal` AS `setorLocal`,`l`.`statusLocal` AS `statusLocal`,`u`.`idUsuarioFinal` AS `idUsuarioFinal`,`u`.`nomeUsuario` AS `nomeUsuario`,`u`.`matriculaUsuario` AS `matriculaUsuario`,`u`.`emailUsuario` AS `emailUsuario`,`u`.`telefoneUsuario` AS `telefoneUsuario`,`u`.`statusUsuario` AS `StatusUsuario` from (((((`equipamento` `e` join `fornecedor` `f` on((`e`.`idFornecedor` = `f`.`idFornecedor`))) join `localidade` `l` on((`e`.`idLocalidade` = `l`.`idLocalidade`))) join `usuariofinal` `u` on((`e`.`idUsuarioFinal` = `u`.`idUsuarioFinal`))) left join `redeconfig` `r` on((`r`.`idEquip` = `e`.`idEquip`))) left join `datadescarte` `d` on((`d`.`idEquip` = `e`.`idEquip`))) where (`e`.`tipoEquip` = 'N') group by `e`.`idEquip` order by `e`.`idEquip` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-25  0:06:16
