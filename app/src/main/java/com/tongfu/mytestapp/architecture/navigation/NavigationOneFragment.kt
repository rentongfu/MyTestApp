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
class NavigationOneFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_navigation_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ButterKnife.bind(this , view)
    }

    @OnClick(R.id.btn_navigation_two , R.id.btn_navigation_activity_two)
    fun onClick(view: View){
        when(view.id){
            R.id.btn_navigation_two->
                findNavController().navigate(R.id.action_navigationOneFragment_to_navigationTwoFragment)
            R.id.btn_navigation_activity_two->
                findNavController().navigate(R.id.action_navigationOneFragment_to_navigationTwoActivity)
        }


    }

}
