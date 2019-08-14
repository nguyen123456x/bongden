-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th8 14, 2019 lúc 10:58 AM
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
-- Cấu trúc bảng cho bảng `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `tenTk` varchar(30) NOT NULL,
  `mKhau` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `admin`
--

INSERT INTO `admin` (`id`, `tenTk`, `mKhau`) VALUES
(1, 'nguyen', '1'),
(2, '1', '1');

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
  `tiLeloi` float NOT NULL,
  `tgBatdau` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `bongden1`
--

INSERT INTO `bongden1` (`soLenh`, `soLo`, `donHang`, `keHoach`, `sLvao`, `sLhoanthanh`, `loiVtu`, `tiLeloi`, `tgBatdau`) VALUES
(5325, 'QDA225RQ', 'KHSX', 5000, 2000, 1960, 0.5, 1.5, '0000-00-00 00:00:00'),
(12455, '218532A5E3', 'KHSX', 10000, 7139, 7130, 0.2, 0.24, '0000-00-00 00:00:00'),
(142412, 'ACJEM2H', 'KHSX', 24124, 5553, 2777, 0.2, 0.1, '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nguoivan`
--

CREATE TABLE `nguoivan` (
  `id` int(11) NOT NULL,
  `tenNv` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `soDt` int(11) NOT NULL,
  `soNhan` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `nguoivan`
--

INSERT INTO `nguoivan` (`id`, `tenNv`, `soDt`, `soNhan`) VALUES
(1, 'Nguyễn Văn A', 412523634, 8),
(2, 'ewqrew', 12341, 2),
(3, 'fsafsadas1', 123412, 22),
(4, 'vavw', 12412, 523523),
(6, 'fsafsa', 12341, 2),
(10, 'vd', 123, 2),
(11, 'vadsv', 1, 2),
(13, 'nguyen', 213, 2),
(14, 'ngigwj', 2, 4),
(15, 'r231', 242, 3),
(16, 'fsafsadas', 123412, 22),
(17, 'fsafsadas1', 123412, 22),
(18, 'eqweqwr', 342, 23),
(19, 'rewr', 3, 2),
(20, 'nguyen', 213, 2),
(21, 'nguyen124', 213, 2),
(22, 'nguyen124', 213, 2);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `tenTk` (`tenTk`);

--
-- Chỉ mục cho bảng `nguoivan`
--
ALTER TABLE `nguoivan`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `nguoivan`
--
ALTER TABLE `nguoivan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
