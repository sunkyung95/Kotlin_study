package kr.co.hanbit.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.hanbit.fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) } // 바인딩 추가

    lateinit var listFragment:ListFragment
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setFragment()

        binding.btnSend.setOnClickListener {
            listFragment.setValue("전달할 값")
        }
    }
    
    fun setFragment() { // 프래그먼트를 액티비티에 삽입하는 코드
        // 프래그먼트를 삽입하는 과정은 하나의 트랜잭션으로 관리되기 때문에 트랜잭션 매니저를 통해
        // begin transaction > add fragment > commit transaction의 순서로 처리됨
        listFragment = ListFragment() // 프래그먼트 매니저를 통해 트랜잭션 시작

        var bundle = Bundle()
        bundle.putString("key1", "List Fragment")
        bundle.putInt("key2", 2021010)
        listFragment.arguments = bundle

        val transaction = supportFragmentManager.beginTransaction() // 시작한 트랜잭션을 변수에 저장
        transaction.add(R.id.frameLayout, listFragment)     // frameLayout을 id로 가지고 있는 레이아웃에 앞에서 생성한 listFragment를 삽입
        transaction.commit()

        // 프래그먼트를 화면에 삽입하는 메서드
        // 1) add(레이아웃, 프래그먼트): 프래그먼트를 레이아웃에 추가함
        // 2) replace(레이아웃, 프래그먼트): 레이아웃에 삽입되어 있는 프래그먼트와 교체함
        // 3) remove(프래그먼트): 지정한 프래그먼트를 제거함
    }

    fun goDetail() {    // Next버튼을 클릭했을 때 호출할 메서드
        val detailFragment = DetailFragment()

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, detailFragment)
        transaction.addToBackStack("detail")    // 스마트폰의 뒤로가기 버튼을 사용할 수 있음
        transaction.commit()
    }

    fun goBack() {  // Back버튼을 클릭하면 호출되는 메서드
        onBackPressed()
    }
}