package io.github.kobakei.kotlinexample.ui.main

import android.content.Context
import android.databinding.ObservableList
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import io.github.kobakei.kotlinexample.databinding.MainItemBinding
import io.github.kobakei.kotlinexample.di.ActivityComponent
import io.github.kobakei.kotlinexample.model.entity.User

/**
 * Created by keisukekobayashi on 2017/04/14.
 */
class MainAdapter(
        val context: Context,
        val injector: ActivityComponent,
        val items: ObservableList<User>): RecyclerView.Adapter<MainViewHolder>() {

    init {
        items.addOnListChangedCallback(object : ObservableList.OnListChangedCallback<ObservableList<User>>() {
            override fun onChanged(users: ObservableList<User>) {
                notifyDataSetChanged()
            }

            override fun onItemRangeChanged(users: ObservableList<User>, i: Int, i1: Int) {
                notifyItemRangeChanged(i, i1)
            }

            override fun onItemRangeInserted(users: ObservableList<User>, i: Int, i1: Int) {
                notifyItemRangeInserted(i, i1)
            }

            override fun onItemRangeMoved(users: ObservableList<User>, i: Int, i1: Int, i2: Int) {
                notifyItemMoved(i, i1)
            }

            override fun onItemRangeRemoved(users: ObservableList<User>, i: Int, i1: Int) {
                notifyItemRangeRemoved(i, i1)
            }
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = MainItemBinding.inflate(inflater, parent, false)
        binding.viewModel = injector.mainItemViewModel()
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder?, position: Int) {
        val binding = holder!!.binding as MainItemBinding
        binding.viewModel.user.set(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}