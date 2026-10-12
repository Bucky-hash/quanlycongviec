package com.example.quanlycongviec

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ChinhSuaCongViecActivity : AppCompatActivity() {

    private lateinit var edtSuaTen: EditText
    private lateinit var edtSuaMoTa: EditText
    private lateinit var chkTrangThai: CheckBox
    private lateinit var btnLuu: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chinh_sua_cong_viec)

        edtSuaTen = findViewById(R.id.edtSuaTen)
        edtSuaMoTa = findViewById(R.id.edtSuaMoTa)
        chkTrangThai = findViewById(R.id.chkTrangThai)
        btnLuu = findViewById(R.id.btnLuu)

        // Nhận dữ liệu cũ để hiển thị lên form sửa
        val congViec = intent.getSerializableExtra("CONG_VIEC_SUA") as? CongViec
        congViec?.let {
            edtSuaTen.setText(it.tenCongViec)
            edtSuaMoTa.setText(it.moTa)
            chkTrangThai.isChecked = it.trangThai
        }

        btnLuu.setOnClickListener {
            val tenMoi = edtSuaTen.text.toString().trim()
            val moTaMoi = edtSuaMoTa.text.toString().trim()
            val trangThaiMoi = chkTrangThai.isChecked

            if (tenMoi.isEmpty()) {
                edtSuaTen.error = "Tên không được để trống!"
                return@setOnClickListener
            }

            val congViecDaSua = CongViec(tenMoi, moTaMoi, trangThaiMoi)

            // Trả dữ liệu về bằng Intent kết quả
            val resultIntent = Intent().apply {
                putExtra("CONG_VIEC_KET_QUA", congViecDaSua)
            }
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}