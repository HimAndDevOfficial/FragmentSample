package com.example.fragmentsampleproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.fragmentsampleproject.databinding.FragmentThreeBinding

class FragmentThree : Fragment() {

    private lateinit var binding: FragmentThreeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        parentFragmentManager.commit {
            add<NestedFragmentOne>(R.id.nestedFragmentOne)
            setReorderingAllowed(true)
        }

        parentFragmentManager.commit {
            add<NestedFragmentTwo>(R.id.nestedFragmentTwo)
            setReorderingAllowed(true)
        }

        // Inflate the layout for this fragment
       binding= FragmentThreeBinding.inflate(inflater,container,false)
        val root:View = binding.root

        val questionNumber = requireArguments().getInt("questionNumber")

        when(questionNumber){
            1 -> binding.textAtfragmentThree.text="Fragment is not as heavy as activity and better choice"

            2-> binding.textAtfragmentThree.text="Fragment is testable"

            3->binding.textAtfragmentThree.text="Viewmodel is another to communicate between fragment"
        }

        return root
    }


}