-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 20 Nov 2019 pada 05.43
-- Versi Server: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `datasensor`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `jenis_sensor`
--

CREATE TABLE IF NOT EXISTS `jenis_sensor` (
`id_sensor` int(11) NOT NULL,
  `kelembapan` int(11) NOT NULL,
  `suhu` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `jenis_sensor`
--

INSERT INTO `jenis_sensor` (`id_sensor`, `kelembapan`, `suhu`) VALUES
(1, 10, 15),
(3, 40, 50),
(4, 50, 100);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `jenis_sensor`
--
ALTER TABLE `jenis_sensor`
 ADD PRIMARY KEY (`id_sensor`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `jenis_sensor`
--
ALTER TABLE `jenis_sensor`
MODIFY `id_sensor` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
