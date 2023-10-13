-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 13, 2023 at 07:40 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `carrental`
--

-- --------------------------------------------------------

--
-- Table structure for table `suv`
--

CREATE TABLE `suv` (
  `id` int(11) NOT NULL,
  `suvid` int(11) NOT NULL,
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

INSERT INTO `suv` (`id`, `suvid`, `brand`, `model`, `color`, `transmission`, `price`, `availability`, `seat`, `fuel`) VALUES
(1, 10, 'Toyota', 'Innova E', 'Silver Metallic', 'Manual', '2500', 'Available', '8', 'Diesel'),
(2, 20, 'Toyota', 'Innova G', 'Phantom Brown Metallic', 'Automatic', '2900', 'Available', '7', 'Diesel'),
(3, 30, 'Toyota', 'Fortuner 4x2', 'Silver Metallic', 'Automatic', '3000', 'Available', '7', 'Diesel'),
(4, 40, 'Toyota', 'Fortuner 4x4', 'Attitude black', 'Automatic', '3400', 'Available', '7', 'Diesel'),
(5, 50, 'Nissan', 'Terra 4x2', 'Brilliant Silver', 'Manual', '2000', 'Available', '7', 'Diesel'),
(6, 60, 'Mitsubishi', 'Xpander Cross', 'Quartz White', 'Automatic', '1700', 'Available', '7', 'Gasoline'),
(7, 70, 'Ford', 'Territory ', 'Panther Black', 'Automatic', '1900', 'Available', '5', 'Unleaded');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `suv`
--
ALTER TABLE `suv`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `suv`
--
ALTER TABLE `suv`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
