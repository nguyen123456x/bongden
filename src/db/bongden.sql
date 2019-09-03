-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th9 03, 2019 lúc 04:38 AM
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
  `tgNgung` datetime NOT NULL,
  `idNv` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `bongden1`
--

INSERT INTO `bongden1` (`session`, `soNhan`, `tgChay`, `tgNgung`, `idNv`) VALUES
(2, 0, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 1),
(3, 0, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `donhang`
--

CREATE TABLE `donhang` (
  `idDh` int(11) NOT NULL,
  `tenDh` text NOT NULL,
  `keHoach` int(11) NOT NULL,
  `tgBatdau` date NOT NULL,
  `tgHoanthanh` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `donhang`
--

INSERT INTO `donhang` (`idDh`, `tenDh`, `keHoach`, `tgBatdau`, `tgHoanthanh`) VALUES
(4, 'FAW2', 12412, '2019-09-10', '2019-09-04'),
(7, 'XJ5K', 50000, '3915-11-02', '3916-01-02'),
(9, '125rR', 1666, '2019-09-04', '2019-09-13');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lo`
--

CREATE TABLE `lo` (
  `tgBatdau` datetime NOT NULL,
  `idLo` int(11) NOT NULL,
  `session` int(11) NOT NULL,
  `idDh` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `muc1`
--

CREATE TABLE `muc1` (
  `maSp` int(11) NOT NULL,
  `tenSp` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `mucsp`
--

CREATE TABLE `mucsp` (
  `idLo` int(11) NOT NULL,
  `maSp` int(30) NOT NULL,
  `sLvao` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `matKhau` text NOT NULL,
  `idAd` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `nguoivan`
--

INSERT INTO `nguoivan` (`idNv`, `tenNv`, `soDt`, `soNhan`, `tenTk`, `matKhau`, `idAd`) VALUES
(1, 'Nguyễn Văn A', 412523634, 8, 'NVA', '123', 1),
(2, 'ewqrew', 12341, 2, 'ew', 'ew', 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `idSp` int(30) NOT NULL,
  `tgRa1` datetime NOT NULL,
  `loi1` float NOT NULL,
  `diem1` int(11) NOT NULL,
  `trangThai1` text NOT NULL,
  `tgRa2` datetime NOT NULL,
  `loi2` float NOT NULL,
  `diem2` int(11) NOT NULL,
  `trangThai2` text NOT NULL,
  `tgRa3` datetime NOT NULL,
  `loi3` float NOT NULL,
  `diem3` int(11) NOT NULL,
  `trangThai3` text NOT NULL,
  `tgRa4` datetime NOT NULL,
  `loi4` float NOT NULL,
  `diem4` int(11) NOT NULL,
  `trangThai4` int(11) NOT NULL,
  `tgRa5` datetime NOT NULL,
  `loi5` float NOT NULL,
  `diem5` int(11) NOT NULL,
  `trangThai5` text CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sp1`
--

CREATE TABLE `sp1` (
  `idSp` int(11) NOT NULL,
  `idLo` int(11) NOT NULL,
  `maSp` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `xuat1`
--

CREATE TABLE `xuat1` (
  `idSp` int(11) NOT NULL,
  `tgRa2` datetime NOT NULL,
  `trangThai2` text NOT NULL,
  `tgHoanthanh` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  ADD PRIMARY KEY (`session`),
  ADD KEY `idNv` (`idNv`);

--
-- Chỉ mục cho bảng `donhang`
--
ALTER TABLE `donhang`
  ADD PRIMARY KEY (`idDh`);

--
-- Chỉ mục cho bảng `lo`
--
ALTER TABLE `lo`
  ADD PRIMARY KEY (`idLo`),
  ADD KEY `session` (`session`),
  ADD KEY `idDh` (`idDh`);

--
-- Chỉ mục cho bảng `muc1`
--
ALTER TABLE `muc1`
  ADD PRIMARY KEY (`maSp`);

--
-- Chỉ mục cho bảng `mucsp`
--
ALTER TABLE `mucsp`
  ADD KEY `idLo` (`idLo`),
  ADD KEY `maSp` (`maSp`);

--
-- Chỉ mục cho bảng `nguoivan`
--
ALTER TABLE `nguoivan`
  ADD PRIMARY KEY (`idNv`),
  ADD KEY `idAd` (`idAd`),
  ADD KEY `idAd_2` (`idAd`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`idSp`);

--
-- Chỉ mục cho bảng `sp1`
--
ALTER TABLE `sp1`
  ADD PRIMARY KEY (`idSp`),
  ADD KEY `idLo` (`idLo`),
  ADD KEY `maSp` (`maSp`);

--
-- Chỉ mục cho bảng `xuat1`
--
ALTER TABLE `xuat1`
  ADD PRIMARY KEY (`idSp`),
  ADD KEY `tgRa2` (`tgRa2`);

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
-- AUTO_INCREMENT cho bảng `donhang`
--
ALTER TABLE `donhang`
  MODIFY `idDh` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT cho bảng `lo`
--
ALTER TABLE `lo`
  MODIFY `idLo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `muc1`
--
ALTER TABLE `muc1`
  MODIFY `maSp` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `nguoivan`
--
ALTER TABLE `nguoivan`
  MODIFY `idNv` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `idSp` int(30) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `sp1`
--
ALTER TABLE `sp1`
  MODIFY `idSp` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `xuat1`
--
ALTER TABLE `xuat1`
  MODIFY `idSp` int(11) NOT NULL AUTO_INCREMENT;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `bongden1`
--
ALTER TABLE `bongden1`
  ADD CONSTRAINT `bongden1_ibfk_1` FOREIGN KEY (`idNv`) REFERENCES `nguoivan` (`idNv`);

--
-- Các ràng buộc cho bảng `lo`
--
ALTER TABLE `lo`
  ADD CONSTRAINT `lo_ibfk_1` FOREIGN KEY (`idDh`) REFERENCES `donhang` (`idDh`),
  ADD CONSTRAINT `lo_ibfk_2` FOREIGN KEY (`session`) REFERENCES `bongden1` (`session`);

--
-- Các ràng buộc cho bảng `mucsp`
--
ALTER TABLE `mucsp`
  ADD CONSTRAINT `mucsp_ibfk_1` FOREIGN KEY (`idLo`) REFERENCES `lo` (`idLo`),
  ADD CONSTRAINT `mucsp_ibfk_2` FOREIGN KEY (`maSp`) REFERENCES `muc1` (`maSp`);

--
-- Các ràng buộc cho bảng `nguoivan`
--
ALTER TABLE `nguoivan`
  ADD CONSTRAINT `nguoivan_ibfk_1` FOREIGN KEY (`idAd`) REFERENCES `admin` (`idAd`);

--
-- Các ràng buộc cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `sanpham_ibfk_2` FOREIGN KEY (`idSp`) REFERENCES `sp1` (`idSp`);

--
-- Các ràng buộc cho bảng `sp1`
--
ALTER TABLE `sp1`
  ADD CONSTRAINT `sp1_ibfk_1` FOREIGN KEY (`idLo`) REFERENCES `lo` (`idLo`),
  ADD CONSTRAINT `sp1_ibfk_2` FOREIGN KEY (`maSp`) REFERENCES `muc1` (`maSp`);

--
-- Các ràng buộc cho bảng `xuat1`
--
ALTER TABLE `xuat1`
  ADD CONSTRAINT `xuat1_ibfk_1` FOREIGN KEY (`idSp`) REFERENCES `sanpham` (`idSp`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
