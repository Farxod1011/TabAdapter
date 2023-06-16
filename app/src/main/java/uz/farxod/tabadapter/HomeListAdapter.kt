package uz.farxod.tabadapter

import android.app.LauncherActivity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.farxod.tabadapter.databinding.CustomItemBinding
import uz.farxod.tabadapter.databinding.FragmentListBinding

class HomeListAdapter(private val list: List<ListItem>): RecyclerView.Adapter<HomeListAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: CustomItemBinding): RecyclerView.ViewHolder(binding.root){
        fun onBind(item: ListItem){
            binding.textTitle.text = item.title
            binding.textDescription.text = item.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = CustomItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }
}