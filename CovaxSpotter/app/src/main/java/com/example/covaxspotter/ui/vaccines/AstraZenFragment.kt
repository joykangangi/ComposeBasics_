package com.example.covaxspotter.ui.vaccines

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.covaxspotter.R

/**
 * TODOS
 * Add binding object and inflate the layout using the binding object.
 */

class AstraZenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_astra_zen, container, false)
    }


    }
