package kr.co.hanbit.widgetscheckbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CompoundButton
import kr.co.hanbit.widgetscheckbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    // 체크박스 선택 코드
    /*
    val listener by lazy {
        CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->  
            when (buttonView.id) {
                R.id.checkApple -> Log.d("CheckBox", "사과가 선택되었습니다.")
                R.id.checkBanana -> Log.d("CheckBox", "바나나가 선택되었습니다.")
                R.id.checkOrange -> Log.d("CheckBox", "오렌지가 선택되었습니다.")
            }
        } 
    }
     */

    // 체크박스 선택, 해제 코드
    val listener by lazy {
        CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                // 선택 코드
                when (buttonView.id) {
                    R.id.checkApple -> Log.d("CheckBox", "사과가 선택되었습니다.")
                    R.id.checkBanana -> Log.d("CheckBox", "바나나가 선택되었습니다.")
                    R.id.checkOrange -> Log.d("CheckBox", "오렌지가 선택되었습니다.")
                }
            } else {
                // 해제 코드
                when (buttonView.id) {
                    R.id.checkApple -> Log.d("CheckBox", "사과가 선택 해제되었습니다.")
                    R.id.checkBanana -> Log.d("CheckBox", "바나나가 선택 해제되었습니다.")
                    R.id.checkOrange -> Log.d("CheckBox", "오렌지가 선택 해제되었습니다.")
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        /*
        binding.checkApple.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) Log.d("CheckBox", "사과가 선택되었습니다.")
            else Log.d("CheckBox", "사과가 선택 해제되었습니다.")
        }
        */

        // 위의 코드는 모든 체크박스에 리스너를 달아줘야 함
        // 위의 코드 한줄로 변경
        binding.checkApple.setOnCheckedChangeListener (listener)
        binding.checkBanana.setOnCheckedChangeListener (listener)
        binding.checkOrange.setOnCheckedChangeListener (listener)
    }
}