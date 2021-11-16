package com.example.covaxspotter.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.covaxspotter.R
import com.example.covaxspotter.databinding.FragmentVaccinesBinding

class VaccinesFragment : Fragment() {
    private var _binding: FragmentVaccinesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentVaccinesBinding.inflate(inflater, container, false )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cardPhizer.setOnClickListener {
            val action = VaccinesFragmentDirections.actionVaccinesFragmentToPfizerFragment()
            findNavController().navigate(action)
        }
        /**
         * Add click listeners and directions for:
         * ->Astrazeneca
         * ->Jonhsons & Johnsons
         * ->Moderna
         * ->Sinopharm
         */

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}