package uz.farxod.tabadapter.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import uz.farxod.tabadapter.HomeListAdapter
import uz.farxod.tabadapter.ListItem
import uz.farxod.tabadapter.R
import uz.farxod.tabadapter.databinding.FragmentListBinding
private const val ARG_PARAM1 = "param1"
class ListFragment : Fragment(R.layout.fragment_list) {


    private val list: MutableList<ListItem> = ArrayList()

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private var listAdapter: HomeListAdapter? = null

    private var param1: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentListBinding.bind(view)
        list.addAll(getData(param1))
        listAdapter = HomeListAdapter(list)
        binding.recyclerview.adapter = listAdapter
    }


    fun getData(index: Int): List<ListItem>{
        when(index){
            0 -> {
                return listOf(
                    ListItem("Animal1", "Anim descr.. 1"),
                    ListItem("Animal2", "Anim descr.. 2"),
                    ListItem("Animal3", "Anim descr.. 3")
                )
            }
            1 -> {
                return listOf(
                    ListItem("Car 1", "Car descr..1"),
                    ListItem("Car 2", "Car descr..2"),
                    ListItem("Car 3", "Car descr..3"),
                    ListItem("Car 4", "Car descr..4")
                )
            }
        }
        return emptyList()
    }
    companion object{
        @JvmStatic
        fun newInctance(id: Int) =
            ListFragment().apply{
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, id)
                }
            }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}