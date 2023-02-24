package com.example.fragmentsampleproject

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmentsampleproject.`interface`.ButtonClickInterface
import com.example.fragmentsampleproject.databinding.ActivityMainBinding
import com.example.fragmentsampleproject.databinding.FragmentOneBinding

class FragmentOne : Fragment() {

    private lateinit var binding: FragmentOneBinding
    private var listener: ButtonClickInterface? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOneBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.whatIsFragment.setOnClickListener {
            listener?.updateQuestionNumber(1)
        }

        binding.fragmentBenefits.setOnClickListener {
            listener?.updateQuestionNumber(2)
        }

        binding.howFragmentCommunicate.setOnClickListener {
            listener?.updateQuestionNumber(3)
        }

        return root
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MainActivity) {      // context instanceof YourActivity
            listener =
                 context // = (YourActivity) context
        } else {
            throw ClassCastException(
                context.toString()
                        + " must implement ButtonClickInterface.questionnumber"
            )
        }
    }

}