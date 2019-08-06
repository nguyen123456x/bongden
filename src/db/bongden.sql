-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th8 02, 2019 lúc 06:33 AM
-- Phiên bản máy phục vụ: 10.1.36-MariaDB
-- Phiên bản PHP: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `bongden`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bongden`
--

CREATE TABLE `bongden` (
  `soLenh` int(11) NOT NULL,
  `soLo` varchar(30) NOT NULL,
  `donHang` varchar(30) NOT NULL,
  `keHoach` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `bongden`
--

INSERT INTO `bongden` (`soLenh`, `soLo`, `donHang`, `keHoach`) VALUES
(41235, '218532A5E3', '12E2D51', 19099),
(41235, '218532A5E3', '12E2D51', 19099),
(0, 'd12', '21d12', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bongden1`
--

CREATE TABLE `bongden1` (
  `soLenh` int(11) NOT NULL,
  `soLo` varchar(30) NOT NULL,
  `donHang` varchar(30) NOT NULL,
  `keHoach` int(11) NOT NULL,
  `sLvao` int(11) NOT NULL,
  `sLhoanthanh` int(11) NOT NULL,
  `loiVtu` float NOT NULL,
  `tiLeloi` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `bongden1`
--

INSERT INTO `bongden1` (`soLenh`, `soLo`, `donHang`, `keHoach`, `sLvao`, `sLhoanthanh`, `loiVtu`, `tiLeloi`) VALUES
(12455, '218532A5E3', 'KHSX', 10000, 7139, 7130, 0.2, 0.24),
(142412, 'ACJEM2H', 'KHSX', 24124, 5553, 2777, 0.2, 0.1),
(5325, 'QDA225RQ', 'KHSX', 5000, 2000, 1960, 0.5, 1.5);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `bongden1`
--
ALTER TABLE `bongden1`
  ADD UNIQUE KEY `soLo` (`soLo`),
  ADD UNIQUE KEY `soLenh` (`soLenh`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
