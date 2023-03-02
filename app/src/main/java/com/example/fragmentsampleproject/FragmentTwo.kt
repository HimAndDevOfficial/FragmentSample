package com.example.fragmentsampleproject

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmentsampleproject.`interface`.ButtonClickInterface
import com.example.fragmentsampleproject.databinding.FragmentOneBinding
import com.example.fragmentsampleproject.databinding.FragmentTwoBinding

class FragmentTwo : Fragment() {

    private lateinit var binding: FragmentTwoBinding
    private var listenerFragmentThree: ButtonClickInterface? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTwoBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val questionNumber = requireArguments().getInt("questionNumber")
        Log.d("AnyData",questionNumber.toString())

        when(questionNumber)
        {
            1-> {
                binding.fragmentDetail.text = getString(R.string.what_is_fragment)
                binding.buttonAtFragmentTwo.text="Tell me more about fragment"
            }

            2 -> {
                binding.fragmentDetail.text = getString(R.string.fragments_benefits)
                binding.buttonAtFragmentTwo.text="Tell more fragment benefits"
            }
            3 -> {
                binding.fragmentDetail.text = getString(R.string.fragments_communication)
                binding.buttonAtFragmentTwo.text="Tell another way to communicate"
            }
        }

        binding.buttonAtFragmentTwo.setOnClickListener {
            listenerFragmentThree?.updateAtFragmentThree(questionNumber)
        }

        return root
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MainActivity) {      // context instanceof YourActivity
            listenerFragmentThree =
                context // = (YourActivity) context
        } else {
            throw ClassCastException(
                context.toString()
                        + " must implement ButtonClickInterface.questionnumber"
            )
        }
    }
}