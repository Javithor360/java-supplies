-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jul 29, 2024 at 03:31 AM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `farmacia`
--

-- --------------------------------------------------------

--
-- Table structure for table `insumos`
--

CREATE TABLE `insumos` (
                           `id` int NOT NULL,
                           `name` varchar(100) NOT NULL,
                           `quantity` int NOT NULL,
                           `price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `insumos`
--

INSERT INTO `insumos` (`id`, `name`, `quantity`, `price`) VALUES
                                                              (1, 'Aspirinas', 101, 4.99),
                                                              (2, 'Paracetamol', 200, 2.49),
                                                              (3, 'Ibuprofeno', 150, 3.99),
                                                              (5, 'Omeprazol', 50, 9.99),
                                                              (6, 'Loratadina', 120, 7.49),
                                                              (7, 'Simvastatina', 70, 15.49),
                                                              (8, 'Metformina', 100, 6.99),
                                                              (9, 'Atorvastatina', 90, 10.99),
                                                              (12, 'Losartan', 130, 11.49),
                                                              (14, 'Claritromicina', 85, 14.99),
                                                              (18, 'Metoprolol', 110, 9.99),
                                                              (20, 'Tamsulosina', 60, 12.49),
                                                              (22, 'Enalapril', 130, 7.99),
                                                              (23, 'Ranitidina', 140, 6.49),
                                                              (24, 'Ketorolaco', 120, 4.49),
                                                              (26, 'Prednisona', 80, 10.99),
                                                              (30, 'Cetirizina', 100, 6.99),
                                                              (31, 'Carbamazepina', 60, 12.99),
                                                              (32, 'Bromhexina', 110, 4.99),
                                                              (33, 'Doxiciclina', 85, 11.49),
                                                              (35, 'Nitrofurantoína', 80, 10.49),
                                                              (36, 'Hidralazina', 100, 8.99),
                                                              (37, 'Levofloxacina', 90, 12.99),
                                                              (38, 'Lisinopril', 130, 11.49),
                                                              (40, 'Verapamilo', 110, 14.99),
                                                              (41, 'Amiodarona', 120, 15.49),
                                                              (42, 'Captopril', 140, 7.49),
                                                              (44, 'Propranolol', 150, 6.49),
                                                              (45, 'Nifedipina', 60, 10.99),
                                                              (47, 'Pininfarina', 999, 0.12),
                                                              (48, 'Cofal', 24, 15.5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `insumos`
--
ALTER TABLE `insumos`
    ADD UNIQUE KEY `id` (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `insumos`
--
ALTER TABLE `insumos`
    MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
