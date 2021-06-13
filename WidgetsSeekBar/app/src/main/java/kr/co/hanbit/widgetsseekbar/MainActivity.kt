package kr.co.hanbit.widgetsseekbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kr.co.hanbit.widgetsseekbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }     // 추가한 코드

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)    // 수정한 코드

        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            /*
                onProgressChange의 파라미터
                1) seekBar: 리스너가 동작하고 있는 시크바 위젯
                2) progress: 현재 시크바의 현재 progress값
                3) formUser: 사용자 터치 여부
                             (코드에서 시크바를 움직일 수도 있기 때문에 사용자의 터치에 의해 동작하는 것인지를 알기 위한 값)
             */
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.textView.text = "$progress"
                // textView의 text속성
                // 문자열만 입력이 가능함
                // "$" -> 쌍따옴표 안에 $변수 를 넣는 형태로 입력해야 함
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
    }
}