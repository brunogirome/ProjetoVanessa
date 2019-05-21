-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 21-Maio-2019 às 21:30
-- Versão do servidor: 10.1.38-MariaDB
-- versão do PHP: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projetovanessa`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `areas_risco`
--

CREATE TABLE `areas_risco` (
  `AREAS_RISCO_ID_PK` int(11) NOT NULL,
  `AREAS_RISCO_X` int(11) NOT NULL,
  `AREAS_RISCO_Y` int(11) NOT NULL,
  `AREAS_RISCO_W` int(11) NOT NULL,
  `AREAS_RISCO_H` int(11) NOT NULL,
  `AREAS_RISCO_TIPO` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `eventos`
--

CREATE TABLE `eventos` (
  `EVENTO_ID_PK` int(11) NOT NULL,
  `EVENTO_TIPO` int(11) NOT NULL,
  `EVENTO_DESLOC` double NOT NULL,
  `EVENTO_ID_RUA_FK` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `rotas`
--

CREATE TABLE `rotas` (
  `ROTA_ID_PK` int(11) NOT NULL,
  `ROTA_DESC` varchar(255) NOT NULL,
  `ROTA_INI` time NOT NULL,
  `ROTA_END` time NOT NULL,
  `ROTA_USER_ID_FK` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `rota_rua`
--

CREATE TABLE `rota_rua` (
  `RUA_ROTA_ID_FK` int(11) NOT NULL,
  `ROTA_RUA_ID_FK` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `ruas`
--

CREATE TABLE `ruas` (
  `RUA_ID_PK` int(11) NOT NULL,
  `RUA_DESC` varchar(55) NOT NULL,
  `RUA_X` int(11) NOT NULL,
  `RUA_Y` int(11) NOT NULL,
  `RUA_W` int(11) NOT NULL,
  `RUA_H` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `ruas`
--

INSERT INTO `ruas` (`RUA_ID_PK`, `RUA_DESC`, `RUA_X`, `RUA_Y`, `RUA_W`, `RUA_H`) VALUES
(1, 'Célsio Garcia', 4, 3, 1190, 3),
(2, 'Rua Canadense', 4, 100, 798, 100),
(3, 'Rua América', 4, 197, 499, 197),
(4, 'Rua Galícia', 4, 295, 1191, 295),
(5, 'Rua Castela', 4, 396, 500, 396),
(6, 'Rua Montserrat', 4, 494, 200, 494),
(7, 'Rua Portugal', 697, 488, 1091, 488),
(8, 'Rua Avelar', 4, 586, 1190, 586),
(9, 'Rua Maria Kiesler', 104, 684, 401, 684),
(10, 'Av. Alan Turing', 4, 780, 1191, 780),
(11, 'Av.Grace Murray', 4, 971, 896, 971),
(12, 'Av.Pascal', 4, 1065, 1190, 1065),
(13, 'Av.Guaruja', 4, 1162, 1190, 1162),
(14, 'Av, Ortiz', 4, 4, 4, 1164),
(15, 'Rya Valência', 105, 4, 105, 297),
(16, 'Rua Eistein', 104, 494, 104, 782),
(17, 'Rua Catalã', 199, 4, 199, 685),
(18, 'Rua dos Balneares', 299, 4, 299, 296),
(19, 'Rua Napolitana', 399, 294, 399, 973),
(20, 'Rua Andaluzia', 496, 4, 496, 588),
(21, 'Rua Eniac', 505, 972, 505, 1164),
(22, 'Rua Alter', 697, 100, 697, 588),
(23, 'Rua Itália', 796, 4, 796, 196),
(24, 'Rua França', 796, 297, 796, 490),
(25, 'Rua Irlanda', 894, 4, 894, 1163),
(26, 'Rua Armênia', 1089, 4, 1089, 587),
(27, 'Av. Leonardo da Vinci', 1189, 4, 1189, 1163),
(28, 'Rua Labore', 596, 100, 596, 295);

-- --------------------------------------------------------

--
-- Estrutura da tabela `system_info`
--

CREATE TABLE `system_info` (
  `TEMPERATURA` int(11) NOT NULL,
  `VERSAO` varchar(45) NOT NULL,
  `UMIDADE_AR` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `user`
--

CREATE TABLE `user` (
  `USER_ID_PK` int(11) NOT NULL,
  `USER_NOME` varchar(45) NOT NULL,
  `USER_USERNAME` varchar(45) NOT NULL,
  `USER_PW` varchar(45) NOT NULL,
  `USER_EMAIL` varchar(45) NOT NULL,
  `USER_X` int(11) NOT NULL,
  `USER_Y` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `areas_risco`
--
ALTER TABLE `areas_risco`
  ADD PRIMARY KEY (`AREAS_RISCO_ID_PK`);

--
-- Indexes for table `eventos`
--
ALTER TABLE `eventos`
  ADD PRIMARY KEY (`EVENTO_ID_PK`),
  ADD KEY `RUA_EVENTO_idx` (`EVENTO_ID_RUA_FK`);

--
-- Indexes for table `rotas`
--
ALTER TABLE `rotas`
  ADD PRIMARY KEY (`ROTA_ID_PK`),
  ADD KEY `USER_ID_idx` (`ROTA_USER_ID_FK`);

--
-- Indexes for table `rota_rua`
--
ALTER TABLE `rota_rua`
  ADD KEY `rua_rota_idx` (`RUA_ROTA_ID_FK`),
  ADD KEY `rota_rua_idx` (`ROTA_RUA_ID_FK`);

--
-- Indexes for table `ruas`
--
ALTER TABLE `ruas`
  ADD PRIMARY KEY (`RUA_ID_PK`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`USER_ID_PK`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `areas_risco`
--
ALTER TABLE `areas_risco`
  MODIFY `AREAS_RISCO_ID_PK` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `eventos`
--
ALTER TABLE `eventos`
  MODIFY `EVENTO_ID_PK` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `rotas`
--
ALTER TABLE `rotas`
  MODIFY `ROTA_ID_PK` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ruas`
--
ALTER TABLE `ruas`
  MODIFY `RUA_ID_PK` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `USER_ID_PK` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `eventos`
--
ALTER TABLE `eventos`
  ADD CONSTRAINT `RUA_EVENTO` FOREIGN KEY (`EVENTO_ID_RUA_FK`) REFERENCES `ruas` (`RUA_ID_PK`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `rotas`
--
ALTER TABLE `rotas`
  ADD CONSTRAINT `USER_ID` FOREIGN KEY (`ROTA_USER_ID_FK`) REFERENCES `user` (`USER_ID_PK`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `rota_rua`
--
ALTER TABLE `rota_rua`
  ADD CONSTRAINT `rota_rua` FOREIGN KEY (`ROTA_RUA_ID_FK`) REFERENCES `rotas` (`ROTA_ID_PK`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `rua_rota` FOREIGN KEY (`RUA_ROTA_ID_FK`) REFERENCES `ruas` (`RUA_ID_PK`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
