-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 04, 2018 at 09:46 AM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `18sulorenwetzel`
--
drop database if exists `18sulorenwetzel`;
create database `18sulorenwetzel`;
use `18sulorenwetzel`
-- --------------------------------------------------------

--
-- Table structure for table `persons`
--

CREATE TABLE `persons` (
  `EmployeeID` int(1) NOT NULL,
  `FirstName` varchar(50) NOT NULL,
  `MiddleName` varchar(20) DEFAULT NULL,
  `LastName` varchar(50) NOT NULL,
  `BirthDate` date NOT NULL,
  `HireDate` date NOT NULL,
  `Salary` decimal(10,2) DEFAULT NULL,
  `Rate` decimal(10,2) DEFAULT NULL,
  `AvgWeeklyHours` decimal(10,2) DEFAULT NULL,
  `EmployeeType` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `persons`
--

INSERT INTO `persons` (`EmployeeID`, `FirstName`, `MiddleName`, `LastName`, `BirthDate`, `HireDate`, `Salary`, `Rate`, `AvgWeeklyHours`, `EmployeeType`) VALUES
(1, 'Loren', 'R', 'Wetzel', '1981-08-09', '2018-08-07', NULL, NULL, NULL, 'None'),
(3, 'Ashton', 'M', 'Wetzel', '2015-02-14', '2018-02-26', '150000.00', NULL, NULL, 'Salary'),
(16, 'Romeo', 'R', 'Wetzel', '2002-04-25', '2010-04-30', NULL, '25.23', '40.00', 'Hourly'),
(37, 'Loren', 'R', 'Wetzel', '1981-08-09', '1999-08-01', NULL, '9.00', '20.00', 'Hourly'),
(65, 'Aaron', 'A', 'Aaronson', '1980-01-01', '2013-01-02', '100000.00', NULL, NULL, 'Salary'),
(66, 'Erin', 'E', 'Erinson', '1980-01-01', '2012-01-01', '75000.00', NULL, NULL, 'Salary'),
(734, 'Roy', '', 'Batty', '2016-01-08', '2016-01-09', NULL, '15.86', '30.00', 'Hourly'),
(1313, 'Beatrix', '', 'Kiddo', '1976-02-28', '2003-10-10', NULL, '13.50', '18.00', 'Hourly'),
(1337, 'Molly', '', 'Millions', '1984-07-01', '2000-04-18', NULL, '19.25', '30.00', 'Hourly'),
(1985, 'Marty', '', 'McFly', '1968-06-12', '1885-01-01', '50000.00', NULL, NULL, 'Salary'),
(2000, 'Paul', 'Muad\'Dib', 'Atreides', '1965-04-04', '1984-05-05', NULL, '2.00', '29.00', 'Hourly'),
(2001, 'Some', 'One', 'Else', '1999-07-07', '2018-08-27', NULL, NULL, NULL, 'None');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `persons`
--
ALTER TABLE `persons`
  ADD PRIMARY KEY (`EmployeeID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `persons`
--
ALTER TABLE `persons`
  MODIFY `EmployeeID` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2008;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
