-- phpMyAdmin SQL Dump
-- version 4.2.10
-- http://www.phpmyadmin.net
--
-- Host: localhost:3306
-- Generation Time: Nov 18, 2015 at 12:35 PM
-- Server version: 5.5.38
-- PHP Version: 5.5.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `mumScrum`
--

--
-- Dumping data for table `Employee`
--

INSERT INTO `Employee` (`id`, `address`, `enabled`, `firstName`, `lastName`, `middleName`, `password`, `phoneNumber`, `status`, `userId`) VALUES
(1, 'fa', b'1', 'Ishwor', 'Pokharel', NULL, 'test', NULL, '1', 'ishwor'),
(2, '', b'1', 'dev', 'dev', NULL, 'dev', '', NULL, 'dev'),
(3, '', b'1', 'test', 'test', NULL, 'test', '', NULL, 'test'),
(4, '', b'1', 'test', 'test', NULL, 'sm', '', NULL, 'sm');

--
-- Dumping data for table `EmployeeRole`
--

INSERT INTO `EmployeeRole` (`DTYPE`, `id`, `roleName`, `status`, `employee_id`) VALUES
('HRAdmin', 1, 'ROLE_HRAdmin', '1', 1),
('Developer', 2, 'ROLE_Developer', NULL, 2),
('Tester', 3, 'ROLE_Tester', NULL, 3),
('ScrumMaster', 4, 'ROLE_ScrumMaster', NULL, 4);

--
-- Dumping data for table `Releases`
--

INSERT INTO `Releases` (`id`, `name`, `releaseDate`) VALUES
(1, 'First Release', '2015-11-17');

--
-- Dumping data for table `Sprint`
--

INSERT INTO `Sprint` (`id`, `endDate`, `name`, `startDate`, `release_id`, `sprintList_id`) VALUES
(2, '2015-09-15', 'First Sprint', '2015-09-05', 1, NULL);

--
-- Dumping data for table `UserStory`
--

INSERT INTO `UserStory` (`id`, `description`, `devEffort`, `developer_id`, `name`, `testEffort`, `tester_id`, `sprint_id`, `userStoryList_id`) VALUES
(2, 'De', 50, 2, 'Second US', 40, 3, 2, NULL);

--
-- Dumping data for table `WorkLog`
--

INSERT INTO `WorkLog` (`id`, `TotalDevEffort`, `TotalTestEffort`, `remainingDevEffort`, `remainingTestEffort`, `status`, `workDay`, `userStory_id`) VALUES
(1, 10, 10, 40, 30, 'A', '2015-11-18 10:58:35', 2);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
