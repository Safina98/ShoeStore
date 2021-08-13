package com.udacity.shoestore.shoelistfragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.squareup.picasso.Picasso
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeListViewModel
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ItemListBinding
import kotlinx.android.synthetic.main.item_list.view.*
import timber.log.Timber


class ShoeListFragment : Fragment() {

    private val viewModel :ShoeListViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
             // Inflate the layout for this fragment
        val binding:FragmentShoeListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        val myLayout: LinearLayout = binding.linear1
        binding.viewModel = viewModel

        if (!viewModel.is_login()){ findNavController().navigate(R.id.action_shoeListFragment_to_loginFragment) }
        viewModel.clear()
        viewModel.shoeList.observe(viewLifecycleOwner, Observer {
            for (i in it) {
                val view_binding  = ItemListBinding.inflate(layoutInflater, myLayout, false)
                view_binding.shoe = i
                Picasso.get().load(i.image).fit().into( view_binding.imageView2)
                myLayout.addView(view_binding.root)
            }
        })
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }
        setHasOptionsMenu(true)
        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.overflow_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,
                requireView().findNavController())||
                super.onOptionsItemSelected(item)
    }

}
