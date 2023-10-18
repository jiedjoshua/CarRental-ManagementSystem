-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 18, 2023 at 06:06 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `carrentaldb`
--

-- --------------------------------------------------------

--
-- Table structure for table `rentedcars`
--

CREATE TABLE `rentedcars` (
  `id` int(11) NOT NULL,
  `carid` int(11) NOT NULL,
  `username` varchar(250) NOT NULL,
  `month` varchar(250) NOT NULL,
  `day` varchar(250) NOT NULL,
  `year` varchar(250) NOT NULL,
  `endmonth` varchar(250) NOT NULL,
  `endday` varchar(250) NOT NULL,
  `endyear` varchar(250) NOT NULL,
  `total` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `rentedcars`
--

INSERT INTO `rentedcars` (`id`, `carid`, `username`, `month`, `day`, `year`, `endmonth`, `endday`, `endyear`, `total`) VALUES
(31, 2, 'admin2', 'October', '5', '2023', 'October', '6', '2023', 2500);

-- --------------------------------------------------------

--
-- Table structure for table `sedan`
--

CREATE TABLE `sedan` (
  `id` int(11) NOT NULL,
  `Brand` varchar(250) NOT NULL,
  `model` varchar(250) NOT NULL,
  `color` varchar(250) NOT NULL,
  `transmission` varchar(250) NOT NULL,
  `price` varchar(250) NOT NULL,
  `availability` varchar(250) NOT NULL,
  `seat` varchar(250) NOT NULL,
  `fuel` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sedan`
--

INSERT INTO `sedan` (`id`, `Brand`, `model`, `color`, `transmission`, `price`, `availability`, `seat`, `fuel`) VALUES
(1, 'Toyota', 'Vios ', 'Silver Metallic', 'Manual', '2000', 'Available', '5', 'Gasoline'),
(2, 'Toyota', 'Vios', 'Black', 'Automatic', '2500', 'Available', '5', 'Gasoline'),
(3, 'Toyota', 'Altis', 'Celestial Black', 'Automatic', '3000', 'Available', '5', 'Gasoline'),
(4, 'Mitsubishi', 'Mirage GLX', 'Titanium Grey', 'Manual', '2000', 'Available', '5', 'Gasoline'),
(5, 'Honda', 'Civic', 'Platinum White Pearl', 'CVT', '2800', 'Available', '5', 'Gasoline'),
(6, 'Mitsubishi', 'Mirage GLX', 'Red Metallic', 'CVT', '2500', 'Available', '5', 'Gasoline');

-- --------------------------------------------------------

--
-- Table structure for table `suv`
--

CREATE TABLE `suv` (
  `id` int(11) NOT NULL,
  `brand` varchar(250) NOT NULL,
  `model` varchar(250) NOT NULL,
  `color` varchar(250) NOT NULL,
  `transmission` varchar(250) NOT NULL,
  `price` varchar(250) NOT NULL,
  `availability` varchar(250) NOT NULL,
  `seat` varchar(250) NOT NULL,
  `fuel` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `suv`
--

INSERT INTO `suv` (`id`, `brand`, `model`, `color`, `transmission`, `price`, `availability`, `seat`, `fuel`) VALUES
(20, 'Toyota', 'Innova E', 'Silver Metallic', 'Manual', '2500', 'Available', '8', 'Diesel'),
(21, 'Toyota', 'Innova G', 'Phantom Brown Metallic', 'Automatic', '2900', 'Available', '7', 'Diesel'),
(22, 'Toyota', 'Fortuner 4x2', 'Silver Metallic', 'Automatic', '3000', 'Available', '7', 'Diesel'),
(23, 'Toyota', 'Fortuner 4x4', 'Attitude black', 'Automatic', '3400', 'Available', '7', 'Diesel'),
(24, 'Ford', 'Territory ', 'Panther Black', 'Automatic', '1900', 'Available', '5', 'Unleaded'),
(25, 'Mitsubishi', 'Xpander Cross', 'Quartz White', 'Automatic', '1700', 'Available', '7', 'Gasoline'),
(26, 'Nissan', 'Terra 4x2', 'Brilliant Silver', 'Manual', '2000', 'Available', '7', 'Diesel');

-- --------------------------------------------------------

--
-- Table structure for table `userinfo`
--

CREATE TABLE `userinfo` (
  `id` int(11) NOT NULL,
  `username` varchar(250) NOT NULL,
  `fname` varchar(250) NOT NULL,
  `lname` varchar(250) NOT NULL,
  `mNum` varchar(250) NOT NULL,
  `licno` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `userinfo`
--

INSERT INTO `userinfo` (`id`, `username`, `fname`, `lname`, `mNum`, `licno`) VALUES
(9, 'admin2', 'admin2', 'admin2', '12345678900', '123');

-- --------------------------------------------------------

--
-- Table structure for table `usertable`
--

CREATE TABLE `usertable` (
  `id` int(11) NOT NULL,
  `username` varchar(250) NOT NULL,
  `password` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `usertable`
--

INSERT INTO `usertable` (`id`, `username`, `password`) VALUES
(1, 'admin', 'admin'),
(20, 'admin2', 'admin2'),
(25, 'hans', 'hans');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `rentedcars`
--
ALTER TABLE `rentedcars`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sedan`
--
ALTER TABLE `sedan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `suv`
--
ALTER TABLE `suv`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `userinfo`
--
ALTER TABLE `userinfo`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usertable`
--
ALTER TABLE `usertable`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `rentedcars`
--
ALTER TABLE `rentedcars`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `sedan`
--
ALTER TABLE `sedan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `suv`
--
ALTER TABLE `suv`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `userinfo`
--
ALTER TABLE `userinfo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `usertable`
--
ALTER TABLE `usertable`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
