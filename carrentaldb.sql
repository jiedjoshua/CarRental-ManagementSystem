-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 07, 2023 at 12:33 PM
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
  `username` varchar(250) NOT NULL,
  `brand` varchar(250) NOT NULL,
  `model` varchar(250) NOT NULL,
  `transmission` varchar(250) NOT NULL,
  `month` varchar(250) NOT NULL,
  `day` varchar(250) NOT NULL,
  `year` varchar(250) NOT NULL,
  `endmonth` varchar(250) NOT NULL,
  `endday` varchar(250) NOT NULL,
  `endyear` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `rentedcars`
--

INSERT INTO `rentedcars` (`id`, `username`, `brand`, `model`, `transmission`, `month`, `day`, `year`, `endmonth`, `endday`, `endyear`) VALUES
(9, 'admin2', 'Toyota', 'Vios ', 'Manual', 'January	', '1', '2023', 'January	', '2', '2023');

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
  `availability` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sedan`
--

INSERT INTO `sedan` (`id`, `Brand`, `model`, `color`, `transmission`, `price`, `availability`) VALUES
(1, 'Toyota', 'Vios ', 'Silver Metallic', 'Manual', '2000', 'Not Available'),
(2, 'Toyota', 'Vios', 'Black', 'Automatic', '2500', 'Available'),
(3, 'Toyota', 'Altis', 'Celestial Black', 'Automatic', '3000', 'Available'),
(4, 'Mitsubishi', 'Mirage GLX', 'Titanium Grey', 'Manual', '2000', 'Available'),
(6, 'Honda', 'Civic', 'Platinum White Pearl', 'CVT', '2800', 'Available'),
(7, 'Mitsubishi', 'Mirage GLX', 'Red Metallic', 'CVT', '2500', 'Available');

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
  `availability` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `suv`
--

INSERT INTO `suv` (`id`, `brand`, `model`, `color`, `transmission`, `price`, `availability`) VALUES
(1, 'Toyota', 'Innova E', 'Silver Metallic', 'Manual', '2500', 'Available'),
(2, 'Toyota', 'Innova G', 'Phantom Brown Metallic', 'Automatic', '2900', 'Available'),
(3, 'Toyota', 'Fortuner 4x2', 'Silver Metallic', 'Automatic', '3000', 'Available'),
(4, 'Toyota', 'Fortuner 4x4', 'Attitude black', 'Automatic', '3400', 'Available'),
(5, 'Nissan', 'Terra 4x2', 'Brilliant Silver', 'Manual', '2000', 'Available'),
(6, 'Mitsubishi', 'Xpander Cross', 'Quartz White', 'Automatic', '1700', 'Available'),
(7, 'Ford', 'Territory ', 'Panther Black', 'Automatic', '1900', 'Available');

-- --------------------------------------------------------

--
-- Table structure for table `userinfo`
--

CREATE TABLE `userinfo` (
  `id` int(11) NOT NULL,
  `username` varchar(250) NOT NULL,
  `fname` varchar(250) NOT NULL,
  `lname` varchar(250) NOT NULL,
  `mNum` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `userinfo`
--

INSERT INTO `userinfo` (`id`, `username`, `fname`, `lname`, `mNum`) VALUES
(6, 'jied', 'jied', 'jied', '12345678900'),
(8, 'josh', 'josh', 'josh', '12345678900'),
(9, 'admin2', 'admin2', 'admin2', '12345678900');

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
(20, 'admin2', 'admin2');

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `sedan`
--
ALTER TABLE `sedan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `suv`
--
ALTER TABLE `suv`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `userinfo`
--
ALTER TABLE `userinfo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `usertable`
--
ALTER TABLE `usertable`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
