-- phpMyAdmin SQL Dump
-- version 3.4.11.1deb2+deb7u2
-- http://www.phpmyadmin.net
--
-- Host: elephant.ecs.westminster.ac.uk:3306
-- Generation Time: Mar 22, 2016 at 04:17 PM
-- Server version: 5.5.47
-- PHP Version: 5.4.45-0+deb7u2

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `w1463868_0`
--

-- --------------------------------------------------------

--
-- Table structure for table `ProductStock`
--

CREATE TABLE IF NOT EXISTS `ProductStock` (
  `Product ID` int(11) NOT NULL,
  `StockholdersID` int(11) NOT NULL,
  `Product Quantity` text COLLATE utf8_bin NOT NULL,
  `ProductStockID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ProductStockID`),
  UNIQUE KEY `PID` (`Product ID`),
  UNIQUE KEY `StockholdersID` (`StockholdersID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ProductStock`
--
ALTER TABLE `ProductStock`
  ADD CONSTRAINT `ProductStock_ibfk_1` FOREIGN KEY (`Product ID`) REFERENCES `Product Table` (`Product ID`),
  ADD CONSTRAINT `ProductStock_ibfk_2` FOREIGN KEY (`StockholdersID`) REFERENCES `Stockholders` (`StockholderID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
