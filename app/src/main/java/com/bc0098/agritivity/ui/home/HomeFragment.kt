package com.bc0098.agritivity.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bc0098.agritivity.databinding.FragmentHomeBinding
import com.bc0098.agritivity.ui.panduan.PanduanActivity
import com.bc0098.agritivity.ui.petani.PetaniActivity

class HomeFragment : Fragment() {

    private lateinit var fragmentHomeBinding: FragmentHomeBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        fragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return fragmentHomeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentHomeBinding.panduan.setOnClickListener{
            val moveIntent = Intent(it.context, PanduanActivity::class.java)
            startActivity(moveIntent)
        }
        fragmentHomeBinding.petani.setOnClickListener {
            val moveIntent = Intent(it.context, PetaniActivity::class.java)
            startActivity(moveIntent)
        }
    }
}