package kr.co.hanbit.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.hanbit.activity.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {

    val binding by lazy { ActivitySubBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.to1.text = intent.getStringExtra("from1")
        binding.to2.text = "${intent.getIntExtra("from2", 0)}"
        // get***Extra()메서드 사용하여 to1의 text에 인텐트에 담겨온 값을 from1키로 꺼내서 입력함
        // text속성은 문자열만 받기 때문에 "${}"을 사용하여 문자열로 변환해줌

        binding.btnClose.setOnClickListener {   // 액티비티 닫기 버튼 선택시 실행될 내용
            val returnIntent = Intent()
            returnIntent.putExtra("returnValue", binding.editMessage.text.toString())
            setResult(RESULT_OK, returnIntent)  // 처리한 결과값이 성공이면 returnIntent에 담긴 값을 전달함
            finish()    // 액티비티 종료 -> 메인 액티비티에 값이 전달됨
        }
    }
}