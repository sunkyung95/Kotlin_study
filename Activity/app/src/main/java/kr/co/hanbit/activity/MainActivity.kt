package kr.co.hanbit.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.hanbit.activity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intent = Intent(this, SubActivity::class.java)  // 인텐스 생성
                                                // 호출할 클래스명 뒤에 '::class.java'입력해야 함

        binding.btnStart.setOnClickListener { startActivity(intent) }
    }
}