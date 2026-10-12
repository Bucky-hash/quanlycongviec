package com.example.quanlycongviec

import java.io.Serializable

data class CongViec(
    var tenCongViec: String,
    var moTa: String,
    var trangThai: Boolean = false // false: Chua hoan thanh, true: Da hoan thanh
) : Serializable {

    // Hàm trả về chuỗi thông tin công việc (Yêu cầu câu 4)
    fun layThongTinChiTiet(): String {
        val trangThaiStr = if (trangThai) "Đã hoàn thành" else "Chưa hoàn thành"
        return "Tên: $tenCongViec\nMô tả: $moTa\nTrạng thái: $trangThaiStr"
    }
}