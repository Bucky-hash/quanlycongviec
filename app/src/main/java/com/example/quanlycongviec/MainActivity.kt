package com.example.quanlycongviec

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvThongTinSinhVien: TextView
    private lateinit var edtTenCongViec: EditText
    private lateinit var edtMoTa: EditText
    private lateinit var btnTaoCongViec: Button
    private lateinit var btnXemDanhSach: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ánh xạ các thành phần giao diện
        tvThongTinSinhVien = findViewById(R.id.tvThongTinSinhVien)
        edtTenCongViec = findViewById(R.id.edtTenCongViec)
        edtMoTa = findViewById(R.id.edtMoTa)
        btnTaoCongViec = findViewById(R.id.btnTaoCongViec)
        btnXemDanhSach = findViewById(R.id.btnXemDanhSach)

        // Hiển thị thông tin sinh viên (Bạn có thể thay đổi họ tên và mã SV của mình vào đây)
        tvThongTinSinhVien.text = "Họ tên: Nguyễn Bảo Phúc\nMã SV: 22115053122101\nLớp HP: Lập trình Android"

        // Xử lý sự kiện khi nhấn nút "Tạo công việc"
        btnTaoCongViec.setOnClickListener {
            val ten = edtTenCongViec.text.toString().trim()
            val moTa = edtMoTa.text.toString().trim()

            // Kiểm tra không cho phép tên công việc để trống (Yêu cầu Câu 5)
            if (ten.isEmpty()) {
                edtTenCongViec.error = "Tên công việc không được để trống!"
                edtTenCongViec.requestFocus()
                return@setOnClickListener
            }

            // Khởi tạo đối tượng CongViec (Yêu cầu Câu 4)
            val congViec = CongViec(ten, moTa, false)

            // Chuyển màn hình và truyền dữ liệu bằng Intent (Yêu cầu Câu 2)
            val intent = Intent(this, ChiTietCongViecActivity::class.java)
            intent.putExtra("OBJECT_CONG_VIEC", congViec)
            startActivity(intent)
        }

        // Xử lý sự kiện nút Xem danh sách công việc (nếu phát triển mở rộng sau này)
        btnXemDanhSach.setOnClickListener {
            Toast.makeText(this, "Chức năng xem danh sách đang phát triển", Toast.LENGTH_SHORT).show()
        }
    }
}