-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 26, 2023 at 04:35 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `supermarket`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `AdID` int(11) NOT NULL,
  `AdUsername` varchar(10) NOT NULL,
  `AdAge` varchar(2) NOT NULL,
  `AdPhone` varchar(15) NOT NULL,
  `AdPass` varchar(8) NOT NULL,
  `AdEmail` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`AdID`, `AdUsername`, `AdAge`, `AdPhone`, `AdPass`, `AdEmail`) VALUES
(1, 'Khalid', '28', '0137409285', '123', 'Khalid@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `PID` int(11) NOT NULL,
  `SupID` int(11) NOT NULL,
  `Pname` varchar(25) NOT NULL,
  `Pprice` double(10,2) NOT NULL,
  `PstockQty` int(3) NOT NULL,
  `Pdetails` varchar(35) NOT NULL,
  `Pweight` double(10,2) NOT NULL,
  `Pcat` varchar(20) NOT NULL,
  `PExpDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`PID`, `SupID`, `Pname`, `Pprice`, `PstockQty`, `Pdetails`, `Pweight`, `Pcat`, `PExpDate`) VALUES
(12, 5, 'Apple ', 9.00, 50, 'Green apple', 500.00, 'Fruits', '2023-09-20'),
(13, 6, 'Fish', 30.00, 50, 'blue fish', 3000.00, 'food', '2023-12-12'),
(14, 7, 'Kiwi', 10.00, 70, 'Kiwi', 1000.00, 'Fruits', '2023-06-14'),
(16, 8, 'RICE', 20.00, 50, 'RICE', 1000.00, 'FOOD', '2023-12-09'),
(17, 5, 'Potato', 4.50, 100, 'Potato', 500.00, 'Vegetables', '2023-12-25'),
(18, 7, 'Beef', 4.00, 80, 'Beef', 1000.00, 'Food', '2023-02-05');

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `StaID` int(11) NOT NULL,
  `StaUsername` varchar(10) NOT NULL,
  `StaAge` varchar(2) NOT NULL,
  `StaPhone` varchar(15) NOT NULL,
  `StaPass` varchar(8) NOT NULL,
  `StaEmail` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`StaID`, `StaUsername`, `StaAge`, `StaPhone`, `StaPass`, `StaEmail`) VALUES
(125, 'ISRAT', '22', '0123456789', '123', 'i@gmail.com'),
(126, 'AHMED', '20', '012034444', '123', 'a@gmail.com'),
(128, 'Khalid', '28', '012222223', '123', 'k@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `SupID` int(11) NOT NULL,
  `SupName` varchar(20) NOT NULL,
  `SupAddress` varchar(40) NOT NULL,
  `SupPhone` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`SupID`, `SupName`, `SupAddress`, `SupPhone`) VALUES
(5, 'ABOHATEMA AIMAN', 'KUALA LUMPUR', '0123456789'),
(6, 'ISRAT JAHAN BHUIYAN', 'MELAKA', '098745374'),
(7, 'SIAD SALIM AHMED', 'JOHOR', '093475623'),
(8, 'AHMED TALEB', 'MELAKA ', '088544326'),
(12, 'Khalid', 'Melaka', '0211334455');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD UNIQUE KEY `AdID` (`AdID`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD UNIQUE KEY `PID` (`PID`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD UNIQUE KEY `StaID` (`StaID`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD UNIQUE KEY `SupID` (`SupID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `AdID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `PID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `staff`
--
ALTER TABLE `staff`
  MODIFY `StaID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=129;

--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `SupID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
