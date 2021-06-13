package kr.co.hanbit.widgetsratingbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.hanbit.widgetsratingbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val rating = binding.ratingBar.rating
        binding.textView.text = "$rating"       // 실행시 설정된 rating값 textView에 표시되게 하기 (맞는 문법인지는 모르겠음)

        binding.ratingBar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            binding.textView.text = "$rating"
            // rating: 현재 별점
            // fromUser: 사용자 입력 여부
        }
    }
}