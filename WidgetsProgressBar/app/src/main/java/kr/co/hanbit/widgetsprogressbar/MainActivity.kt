package kr.co.hanbit.widgetsprogressbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kr.co.hanbit.widgetsprogressbar.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        /*
        Thread.sleep(3000)  // 3000 밀리초 = 3초
        // Thread.sleep() 메서드: 지정된 시간 동안 다음 코드 실행되지 않음
        showProgress(false)
        */

        /*
        thread(start=true) {    // 위의 코드에서 thread(start=true) 함수 사용
            Thread.sleep(3000)
            showProgress(false)
        }
        // 함수 블록 안의 코드가 모두 백그라운드에서 동작함
        // -> 3초간 프로그래스바가 동작하다 앱이 죽음

        // UI와 관련된 모든 코드는 메인 스레드에서 실행되어야 하는데
        // showProgress 메서드를 백그라운드에서 호출하기 때문에 앱이 강제종료됨
         */

        thread(start=true) {
            Thread.sleep(3000)
            runOnUiThread {     // showProgress 메서드만 메인 스레드에서 실행하도록함
                showProgress(false)
            }
        }
        // 3초간 프로그래스바가 동작하다가 없어짐
    }
    
    fun showProgress(show: Boolean) {
        if(show) {
            // 위젯의 visibillity 속성이 VISIBLE인 경우 -> 화면에 나타남
            binding.progressLayout.visibility = View.VISIBLE
        } else {
            // 위젯의 visibillity 속성이 GONE 경우 -> 화면에서 사라짐
            binding.progressLayout.visibility = View.GONE
        }
    }

    /*
        VISIBLE: 현재 보이는 상태
        INVISIBLE: 현재 안보이는 상태
                   보이지는 않지만 공간을 차지하고 있음
        GONE: 현재 안보이는 상태
              공간도 차지하지 않음
     */
}