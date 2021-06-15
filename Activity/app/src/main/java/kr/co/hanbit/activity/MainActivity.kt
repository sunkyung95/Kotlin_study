package kr.co.hanbit.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kr.co.hanbit.activity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intent = Intent(this, SubActivity::class.java)  // 인텐스 생성
                                                // 호출할 클래스명 뒤에 '::class.java'입력해야 함

        intent.putExtra("from1", "Hello Bundle")
        intent.putExtra("from2", 2021)
        // putExtra() 메서드 사용하여 intent에 값 전달   키, 값
        // putExtra는 여러 타입을 담을 수 있음

        // binding.btnStart.setOnClickListener { startActivity(intent) }
        binding.btnStart.setOnClickListener { startActivityForResult(intent, 99) }
    }
    
    /*
        onActivityResult() 메서드의 구조
        1) requestCode: 호출 시에 메인 액티비티에서 입력하는 코드 startActivityForResult 메서드에 인텐트와 함께 입력해서 호출한 코드를 구분함
        2) resultCode: 결과 처리 후 서브 액티비티에서 입력하는 코드, 앞에서 RESULT_OK를 담아서 보냈음
        3) data: 결과 처리 후 서브 액티비티가 넘겨주는 인텐트가 담겨있음
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        
        if (resultCode == RESULT_OK) {  // 서브 액티비티에서 돌려받은 resultCode가 정상인지 체크하는 코드
            val message = data?.getStringExtra("returnValue")
            Toast.makeText(this, message, Toast.LENGTH_LONG).show() // 해당 메세지를 토스트로 화면에 보여주는 코드
            // Toast.makeText의 파라미터
            // 1) 첫번째: 화면을 위한 기본 도구인 컨텍스트가 필요한데, 액티비티가 이미 가지고 있기때문에
            //            this라고 입력하면 됨
            // 2) 두번째: 출력될 메시지를 문자열로 전달
            // 3) 세번째: 메시지가 얼마 동안 출력될지를 결정

            if(resultCode == Activity.RESULT_OK) {  // requestCode가 요청 코드와 같은 99인지 체크
                when (requestCode) {
                    99 -> {
                        val message = data?.getStringExtra("returnValue")
                        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}