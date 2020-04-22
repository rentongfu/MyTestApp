package com.tongfu.mytestapp.architecture.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import butterknife.ButterKnife
import butterknife.OnClick

import com.tongfu.mytestapp.R

/**
 * A simple [Fragment] subclass.
 */
class NavigationTwoFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_navigation_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        ButterKnife.bind(this , view)
        super.onViewCreated(view, savedInstanceState)
    }
    @OnClick(R.id.btn_fragment_one)
    fun onClick(view:View){
        if(view.id == R.id.btn_fragment_one){
            findNavController().navigate(R.id.action_navigationTwoFragment_to_navigationOneFragment)
        }
    }

}
