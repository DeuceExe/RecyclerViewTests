package com.example.recyclerviewlesson.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerviewlesson.R
import com.example.recyclerviewlesson.Unit
import com.example.recyclerviewlesson.UnitAdapter
import com.example.recyclerviewlesson.databinding.FragmentElfBinding

class ElfFragment : Fragment() {
    private var _bindingFrag: FragmentElfBinding? = null
    private val bindingFrag get() = _bindingFrag!!
    private val adapter = UnitAdapter()
    private val imageIdList = listOf(
        R.drawable.undead_lich,
        R.drawable.undead_sylvana,
        R.drawable.undead_deceiver,
        R.drawable.undead_gargoyle,
        R.drawable.undead_skeleton,
        R.drawable.undead_abomination,
        R.drawable.undead_acolyte,
        R.drawable.undead_arthas,
        R.drawable.undead_balnazar,
        R.drawable.undead_banshee,
        R.drawable.undead_crypt_fiend,
        R.drawable.undead_crypt_lord,
        R.drawable.undead_death_knight,
        R.drawable.undead_dreadlord,
        R.drawable.undead_frostwyrm,
        R.drawable.undead_meatwagon,
        R.drawable.elf_archer,
        R.drawable.elf_ballista,
        R.drawable.elf_cenarius,
        R.drawable.elf_dh,
        R.drawable.elf_chimera,
        R.drawable.elf_druid,
        R.drawable.elf_ent,
        R.drawable.elf_dryad,
        R.drawable.elf_faerie_dragon,
        R.drawable.elf_huntress,
        R.drawable.elf_illidan,
        R.drawable.elf_mountain_giant,
        R.drawable.elf_ridden_hippogryph,
        R.drawable.elf_warden,
        R.drawable.horde_blademaster,
        R.drawable.horde_builder,
        R.drawable.horde_catapult,
        R.drawable.horde_grom,
        R.drawable.horde_drekhar,
        R.drawable.horde_head_hunter,
        R.drawable.horde_guldan,
        R.drawable.horde_grunt,
        R.drawable.horde_kodo,
        R.drawable.horde_shadow_hunter,
        R.drawable.horde_samuro,
        R.drawable.horde_tauren,
        R.drawable.horde_shaman,
        R.drawable.horde_thrall,
        R.drawable.horde_voljin,
        R.drawable.horde_warlord,
        R.drawable.horde_wolfrider,
        R.drawable.horde_wyvern
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _bindingFrag = FragmentElfBinding.inflate(inflater, container, false)
        bindingFrag.rcView.setBackgroundResource(R.drawable.background_elf)
        init()
        return bindingFrag.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _bindingFrag = null
    }

    private fun init() {
        var subName: String
        var unitName: String

        bindingFrag.apply {
            var unit: Unit
            rcView.layoutManager = GridLayoutManager(context, 2)
            rcView.adapter = adapter

            for (n in imageIdList.indices) {
                subName = (resources.getResourceName(imageIdList[n]).substringAfter("/"))
                subName = subName.substringBefore("_")
                val filteredName = resources.getIdentifier(
                    resources.getResourceName(imageIdList[n]).substringAfterLast("/"),
                    "string",
                    context?.packageName
                )

                if(subName == "elf") {
                    unitName = if (filteredName != 0) resources.getString(filteredName) else "Error"
                    unit = Unit(imageIdList[n], unitName, R.drawable.background_elf)
                    adapter.addUnit(unit)
                }
            }
        }
    }
}