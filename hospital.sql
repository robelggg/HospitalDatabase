-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 21, 2023 at 11:57 PM
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
-- Database: `hospital`
--

-- --------------------------------------------------------

--
-- Table structure for table `appointment`
--

CREATE TABLE `appointment` (
  `Appointment_Num` decimal(4,0) NOT NULL,
  `Insurance_ID` char(9) DEFAULT NULL,
  `Doc_ID` char(3) DEFAULT NULL,
  `Date_Time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `appointment`
--

INSERT INTO `appointment` (`Appointment_Num`, `Insurance_ID`, `Doc_ID`, `Date_Time`) VALUES
('1006', 'XM382748J', '435', '2023-01-09 17:15:00'),
('1007', 'XM275429L', '673', '2023-01-12 15:05:00'),
('1008', 'XM178390Y', '847', '2023-01-13 20:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `Doc_ID` char(3) NOT NULL,
  `Last_Name` varchar(20) DEFAULT NULL,
  `First_Name` varchar(20) DEFAULT NULL,
  `Specialization` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`Doc_ID`, `Last_Name`, `First_Name`, `Specialization`) VALUES
('435', 'Johnson', 'Fred', 'Dermatology'),
('673', 'Buble', 'Richard', 'Anesthesiology'),
('847', 'Jackson', 'Owen', 'Internal Medicine');

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `Insurance_ID` char(9) NOT NULL,
  `Insurance_Company` varchar(25) DEFAULT NULL,
  `Last_Name` varchar(20) DEFAULT NULL,
  `First_Name` varchar(20) DEFAULT NULL,
  `Phone_Num` char(12) DEFAULT NULL,
  `Address` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`Insurance_ID`, `Insurance_Company`, `Last_Name`, `First_Name`, `Phone_Num`, `Address`) VALUES
('XM178390Y', 'GoodHealth', 'Swan', 'Amy', '903-274-1937', '3022 New City'),
('XM275429L', 'CarePlus', 'Griffin', 'Emily', '917-498-2351', '40 Wall St.'),
('XM382748J', 'Fidelis', 'Swanson', 'Joe', '303-643-8000', '23 Fulton St.');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointment`
--
ALTER TABLE `appointment`
  ADD PRIMARY KEY (`Appointment_Num`);

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`Doc_ID`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`Insurance_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
