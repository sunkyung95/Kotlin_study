package kr.co.hanbit.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.co.hanbit.fragment.databinding.FragmentListBinding

class ListFragment : Fragment() {

    var mainActivity: MainActivity? = null
    lateinit var binding:FragmentListBinding

    /*
        리사이클러뷰의 onCreateViewHolder() 메서드처럼 동작함
        액티비티가 프래그먼트를 요청하면 onCreateView() 메서드를 통해 뷰를 만들어서 보여줌
        
        * onCreateView의 파라미터
        1) inflater: 레이아웃 파일을 로드하기 위한 레이아웃 인플레이터를 기본으로 제공
        2) container: 프래그먼트 레이아웃이 배치되는 부모 레이아웃 (액티비티의 레이아웃)
        3) savedInstanceState: 상태 값 저장을 위한 보조 도구, 액티비티의 onCreate의 파라미터와 동일하게 동작
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,    // inflate메서드는 리사이클러뷰에서와 동일하게 동작함
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_list, container, false) --> inflater로 생성한 뷰를 바로 리턴하는 구조
        
        binding = FragmentListBinding.inflate(inflater, container, false)
        binding.btnNext.setOnClickListener{ mainActivity?.goDetail() }

        binding.textTitle.text = arguments?.getString("key1")
        binding.textValue.text = "${arguments?.getInt("key2")}"

        return  binding.root
        // 바인딩으로 생성한 후 레이아웃에 있는 btnNext 버튼에 리스너를 등록한 후에 binding root를 리턴함
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if(context is MainActivity) mainActivity = context
    }

    fun setValue(value: String) {
        binding.textFromActivity.text = value
    }
}