-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th8 23, 2019 lúc 05:19 AM
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
  `idAd` int(11) NOT NULL,
  `tenTk` varchar(30) NOT NULL,
  `mKhau` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `admin`
--

INSERT INTO `admin` (`idAd`, `tenTk`, `mKhau`) VALUES
(1, 'nguyen', '1'),
(2, '1', '1');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bongden1`
--

CREATE TABLE `bongden1` (
  `session` int(11) NOT NULL,
  `soNhan` int(11) NOT NULL,
  `tgChay` datetime NOT NULL,
  `tgNgung` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `bongden1`
--

INSERT INTO `bongden1` (`session`, `soNhan`, `tgChay`, `tgNgung`) VALUES
(1, 0, '0000-00-00 00:00:00', '0000-00-00 00:00:00'),
(2, 0, '0000-00-00 00:00:00', '0000-00-00 00:00:00'),
(3, 0, '0000-00-00 00:00:00', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `donhang`
--

CREATE TABLE `donhang` (
  `tenDh` text NOT NULL,
  `keHoach` int(11) NOT NULL,
  `tgBatdau` datetime NOT NULL,
  `tgHoanthanh` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lo`
--

CREATE TABLE `lo` (
  `tgBatdau` datetime NOT NULL,
  `idLo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `lo`
--

INSERT INTO `lo` (`tgBatdau`, `idLo`) VALUES
('0000-00-00 00:00:00', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nguoivan`
--

CREATE TABLE `nguoivan` (
  `idNv` int(11) NOT NULL,
  `tenNv` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `soDt` int(11) NOT NULL,
  `soNhan` int(11) NOT NULL,
  `tenTk` text NOT NULL,
  `matKhau` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `nguoivan`
--

INSERT INTO `nguoivan` (`idNv`, `tenNv`, `soDt`, `soNhan`, `tenTk`, `matKhau`) VALUES
(1, 'Nguyễn Văn A', 412523634, 8, 'NVA', '123'),
(2, 'ewqrew', 12341, 2, 'ew', 'ew'),
(6, 'fsafsa', 12341, 2, '', ''),
(10, 'vd', 123, 2, '', ''),
(13, 'nguyen', 213, 2, '', ''),
(14, 'ngigwj', 2, 4, '', ''),
(15, 'r231', 242, 3, '', ''),
(16, 'fsafsadas', 123412, 22, '', ''),
(17, 'fsafsadas1', 123412, 22, '', ''),
(18, 'eqweqwr', 342, 23, '', ''),
(19, 'rewr', 3, 2, '', ''),
(20, 'nguyen', 213, 2, '', ''),
(21, 'nguyen124', 213, 2, '', ''),
(22, 'nguyen124', 213, 2, '', ''),
(23, 'ac', 123, 2, 'abc', '2');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `idSp` int(30) NOT NULL,
  `tgRa1` datetime NOT NULL,
  `diem1` int(11) NOT NULL,
  `trangThai1` text NOT NULL,
  `tgRa2` datetime NOT NULL,
  `diem2` int(11) NOT NULL,
  `trangThai2` text NOT NULL,
  `tgRa3` datetime NOT NULL,
  `diem3` int(11) NOT NULL,
  `trangThai3` text NOT NULL,
  `tgRa4` datetime NOT NULL,
  `diem4` int(11) NOT NULL,
  `trangThai4` int(11) NOT NULL,
  `tgRa5` datetime NOT NULL,
  `diem5` int(11) NOT NULL,
  `trangThai5` text CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`idSp`, `tgRa1`, `diem1`, `trangThai1`, `tgRa2`, `diem2`, `trangThai2`, `tgRa3`, `diem3`, `trangThai3`, `tgRa4`, `diem4`, `trangThai4`, `tgRa5`, `diem5`, `trangThai5`) VALUES
(1, '2019-08-14 22:12:11', 0, '', '2019-08-14 08:08:06', 0, '', '2019-08-14 00:00:00', 0, '', '2019-08-14 14:05:00', 0, 0, '0000-00-00 00:00:00', 0, '20');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`idAd`);

--
-- Chỉ mục cho bảng `bongden1`
--
ALTER TABLE `bongden1`
  ADD PRIMARY KEY (`session`);

--
-- Chỉ mục cho bảng `lo`
--
ALTER TABLE `lo`
  ADD PRIMARY KEY (`idLo`);

--
-- Chỉ mục cho bảng `nguoivan`
--
ALTER TABLE `nguoivan`
  ADD PRIMARY KEY (`idNv`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`idSp`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `admin`
--
ALTER TABLE `admin`
  MODIFY `idAd` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `bongden1`
--
ALTER TABLE `bongden1`
  MODIFY `session` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `lo`
--
ALTER TABLE `lo`
  MODIFY `idLo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `nguoivan`
--
ALTER TABLE `nguoivan`
  MODIFY `idNv` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `idSp` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
