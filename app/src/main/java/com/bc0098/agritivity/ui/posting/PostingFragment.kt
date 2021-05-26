package com.bc0098.agritivity.ui.posting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bc0098.agritivity.R

class PostingFragment : Fragment() {

    private lateinit var postingViewModel: PostingViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        postingViewModel =
                ViewModelProvider(this).get(PostingViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_posting, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        postingViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}