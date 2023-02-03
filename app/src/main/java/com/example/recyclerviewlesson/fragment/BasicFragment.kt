package com.example.recyclerviewlesson.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.recyclerviewlesson.R
import com.example.recyclerviewlesson.databinding.FragmentBasicBinding
import com.example.recyclerviewlesson.databinding.FragmentElfBinding

class BasicFragment : Fragment() {
    private var _bindingFrag: FragmentBasicBinding? = null
    private val bindingFrag get() = _bindingFrag!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _bindingFrag = FragmentBasicBinding.inflate(inflater, container, false)
        return bindingFrag.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val controller = findNavController()
        bindingFrag.apply {
            btnElf.setOnClickListener { controller.navigate(R.id.elfFragment) }
            btnHorde.setOnClickListener { controller.navigate(R.id.hordeFragment) }
            btnUndead.setOnClickListener { controller.navigate(R.id.undeadFragment) }
            btnRace.setOnClickListener {  controller.navigate(R.id.racesFragment) }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _bindingFrag = null
    }
}