package com.example.quanlycongviec

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class ChiTietCongViecActivity : AppCompatActivity() {

    private lateinit var tvTenChiTiet: TextView
    private lateinit var tvMoTaChiTiet: TextView
    private lateinit var tvTrangThaiChiTiet: TextView
    private lateinit var btnChinhSua: Button

    var congViecHienTai: CongViec? = null

    // Khai báo bộ phóng đăng ký kết quả (Activity Result API)
    private val launcherChinhSua = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data
            val congViecMoi = data?.getSerializableExtra("CONG_VIEC_KET_QUA") as? CongViec
            congViecMoi?.let {
                congViecHienTai = it
                // Cập nhật lại giao diện sau khi nhận kết quả
                tvTenChiTiet.text = "Tên công việc: ${it.tenCongViec}"
                tvMoTaChiTiet.text = "Mô tả: ${it.moTa}"
                tvTrangThaiChiTiet.text = "Trạng thái: ${if (it.trangThai) "Đã hoàn thành" else "Chưa hoàn thành"}"
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_cong_viec)

        tvTenChiTiet = findViewById(R.id.tvTenChiTiet)
        tvMoTaChiTiet = findViewById(R.id.tvMoTaChiTiet)
        tvTrangThaiChiTiet = findViewById(R.id.tvTrangThaiChiTiet)
        btnChinhSua = findViewById(R.id.btnChinhSua)

        // Nhận dữ liệu đối tượng CongViec qua Intent (tích hợp Câu 4)
        congViecHienTai = intent.getSerializableExtra("OBJECT_CONG_VIEC") as? CongViec

        congViecHienTai?.let {
            tvTenChiTiet.text = "Tên công việc: ${it.tenCongViec}"
            tvMoTaChiTiet.text = "Mô tả: ${it.moTa}"
            tvTrangThaiChiTiet.text = "Trạng thái: ${if (it.trangThai) "Đã hoàn thành" else "Chưa hoàn thành"}"
        }

        // Cấu hình sự kiện nút Chỉnh sửa BÊN TRONG hàm onCreate()
        btnChinhSua.setOnClickListener {
            val intent = Intent(this, ChinhSuaCongViecActivity::class.java)
            intent.putExtra("CONG_VIEC_SUA", congViecHienTai)
            launcherChinhSua.launch(intent)
        }
    }
}