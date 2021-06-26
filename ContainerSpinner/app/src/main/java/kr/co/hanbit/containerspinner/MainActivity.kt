package kr.co.hanbit.containerspinner

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kr.co.hanbit.containerspinner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        
        var data = listOf("- 선택하세요 -", "1월", "2월", "3월", "4월", "5월", "6월")
        var adapter = ArrayAdapter<String>(this, R.layout.simple_expandable_list_item_1, data)  // 데이터와 스피너를 연결해줄 클래스

        binding.spinner.adapter = adapter   // 어댑터를 스피너 위젯에 연결
        
        /*
            onItemSelectedListener: 스피너를 선택하는 동작을 인식하는 리스너
         */
        binding.spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {   // 사용자가 스피너를 선택하면 선택한 값을 선택 결과에 보여주는 코드
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,  // 사용자가 스피너에서 선택을 하면 몇 번째 아이템인지 알려주는 파라미터
                id: Long
            ) {
                binding.result.text = data.get(position)    // position값으로 data의 해당 위치에 있는 문자 값을 선택 결과 텍스트뷰에 입력하는 코드
            }

        }
    }
}