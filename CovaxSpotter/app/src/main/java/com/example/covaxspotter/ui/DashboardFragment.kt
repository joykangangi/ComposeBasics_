package com.example.covaxspotter.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.covaxspotter.R
import com.example.covaxspotter.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {
   private var _binding:FragmentDashboardBinding? = null //current instance of views
    private val binding get() = _binding!! //return the current instance

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment & bind to binding
       _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vacCenter.setOnClickListener {
            val action = DashboardFragmentDirections.actionDashboardFragmentToCountiesFragment()
            findNavController().navigate(action)
        }
            binding.vacInfo.setOnClickListener {
                val action = DashboardFragmentDirections.actionDashboardFragmentToVaccinesFragment()
                findNavController().navigate(action)
            }
        }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}