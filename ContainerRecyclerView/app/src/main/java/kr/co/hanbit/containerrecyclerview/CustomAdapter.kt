package kr.co.hanbit.containerrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kr.co.hanbit.containerrecyclerview.databinding.ItemRecyclerBinding
import java.text.SimpleDateFormat

class CustomAdapter: RecyclerView.Adapter<Holder>() {
    var listData = mutableListOf<Memo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        // inflate 파라미터의 의미
        // 1) inflater: 바인딩을 생성할 때 사용하는 인플레이터, 액티비티에서와는 다르게 LayoutInflaterfrom을 사용해서 생성해야 함
        // 2) parent: 생성되는 바인딩이 속하는 부모 뷰(레이아웃)
        // 3) attachToRoot: true일 경우 attach 해야 하는 대상으로 root를 지정하고 아래에 붙임
        //                  false일 경우 뷰의 최상위 레이아웃의 속성을 기본으로 레이아웃이 적용됨
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {  // 생성된 뷰홀더를 화면에 보여주는 메서드
        val memo = listData.get(position)
        holder.setMemo(memo)
    }
}

class Holder(val binding: ItemRecyclerBinding): RecyclerView.ViewHolder(binding.root) {

    init {  // 목록 클릭 이벤트 처리
        binding.root.setOnClickListener {
            Toast.makeText(binding.root.context, "클릭된 아이템 = ${binding.textTitle.text}", Toast.LENGTH_LONG).show()
        }
    }

    fun setMemo(memo: Memo) {   // 화면에 데이터를 세팅하는 메서드
        binding.textNo.text = "${memo.no}"
        binding.textTitle.text = memo.title

        var sdf = SimpleDateFormat("yyyy/MM/dd")
        var formattedDate = sdf.format(memo.timestamp)
        binding.textDate.text = formattedDate

    }
}