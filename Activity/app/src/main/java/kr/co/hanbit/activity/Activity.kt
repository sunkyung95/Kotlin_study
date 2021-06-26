package kr.co.hanbit.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

// 액티비티 생명 주기 메서드
class Activity : AppCompatActivity() {
    
    // onCreate(): 만들어짐
    // 액티비티가 생성됨. 실제 코드를 가장 많이 작성하는 메서드
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_)
    }
    
    // onStart(): 화면에 나타남
    // 화면에 보이기 시작함
    override fun onStart() {
        super.onStart()
    }
    
    // onResume(): 현재 실행 중
    // onResume이 호출되었다면 실행중이라는 의미
    override fun onResume() {
        super.onResume()
    }
    
    // onPause(): 화면이 가려짐
    // 액티비티 화면의 일부가 다른 액티비티에 가려짐
    override fun onPause() {
        super.onPause()
    }
    
    // onStop(): 화면이 없어짐
    // 다른 액티비티가 실행되어서 화면이 완전히 가려짐
    override fun onStop() {
        super.onStop()
    }

    // onDestory(): 종료됨
    // 종료됨
    override fun onDestroy() {
        super.onDestroy()
    }
}