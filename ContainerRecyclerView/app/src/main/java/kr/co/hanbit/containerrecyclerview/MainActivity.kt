package kr.co.hanbit.containerrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kr.co.hanbit.containerrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        fun loadData(): MutableList<Memo> { // 100개의 가상 데이터를 만드는 코드
            val data: MutableList<Memo> = mutableListOf()

            for(no in 1..100) {
                val title = "이것이 안드로이드다 ${no}"
                val date = System.currentTimeMillis()

                var memo = Memo(no, title, date)
                data.add(memo)
            }
            return data
        }

        val data:MutableList<Memo> = loadData()

        var adapter = CustomAdapter()
        adapter.listData = data

        binding.recyclerView.adapter = adapter  // 속성에 생성할 어댑터를 연결

        binding.recyclerView.layoutManager = LinearLayoutManager(this)  // 리사이클러뷰를 화면에 보여주는 형태를 결정
        // 레이아웃 매니저의 종류
        // 1) LinearLayoutManager
        // - 세로 스크롤: 기본으로 세로 스크롤을 함, 생성자에 컨텍스트 1개만 입력하면 됨
        //               LinearLayoutManager(this)
        // - 가로 스크롤: 컬럼 개수를 지정해서 개수만큼 그리드 형태로 목록을 생성함, 리니어 레이아웃 매니저의 두번째 파라미터에 가로 스크롤 옵션을 설정
        //               LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        // 2) GridLayoutManager
        //    데이터의 사이즈에 따라 그리드의 크기가 결정됨
        //    두 번째 파라미터에 한 줄에 몇 개의 아이템을 표시할 건지 개수를 설정
        //    GridLayoutManager(this, 3)
        // 3) StaggeredGridLayoutManager
        // - 세로 스크롤: 컨텍스트를 사용하지 않으므로 this를 넘기지 않아도 됨
        //               첫 번째 파라미터에는 한 줄에 표시되는 아이템의 개수, 두 번째 파라미터에는 세로 방향을 설정함
        //               StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        // - 가로 스크롤: 두 번째 파라미터에 가로 방향을 설정함
        //               StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL)


    }
}