package com.example.quanlycongviec

import android.content.Intentimport android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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

        // Ánh xạ các thành phần
        tvThongTinSinhVien = findViewById(R.id.tvThongTinSinhVien)
        edtTenCongViec = findViewById(R.id.edtTenCongViec)
        edtMoTa = findViewById(R.id.edtMoTa)
        btnTaoCongViec = findViewById(R.id.btnTaoCongViec)
        btnXemDanhSach = findViewById(R.id.btnXemDanhSach)
        // Bổ sung vào onCreate của MainActivity:
        btnTaoCongViec.setOnClickListener {
            val ten = edtTenCongViec.text.toString().trim()
            val moTa = edtMoTa.text.toString().trim()

            // Kiểm tra không cho phép tên công việc để trống (Câu 5)
            if (ten.isEmpty()) {
                edtTenCongViec.error = "Tên công việc không được để trống!"
                return@setOnClickListener
            }

            // Khởi tạo đối tượng CongViec (Câu 4)
            val congViec = CongViec(ten, moTa, false)

            // Chuyển màn hình bằng Intent (Câu 2)
            val intent = Intent(this, ChiTietCongViecActivity::class.java)
            intent.putExtra("OBJECT_CONG_VIEC", congViec)
            startActivity(intent)
        }
    }
}