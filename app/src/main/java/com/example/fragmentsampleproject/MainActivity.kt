package com.example.fragmentsampleproject

import android.graphics.Insets.add
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.fragmentsampleproject.`interface`.ButtonClickInterface
import com.example.fragmentsampleproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ButtonClickInterface {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


//Let's add fragment programmatically
// The fragment-ktx module provides a commit block that automatically
// calls beginTransaction and commit for you.
// implementation 'androidx.navigation:navigation-fragment-ktx:2.5.3'
        if(savedInstanceState==null)
        {

            val bundle = bundleOf("questionNumber" to 1)
            supportFragmentManager.commit {
                add<FragmentTwo>(R.id.fragmentContainerViewTwo, args = bundle)
                setReorderingAllowed(true)
            }
        }
    }

    override fun updateQuestionNumber(questionNumber: Int) {
        val bundle = bundleOf("questionNumber" to questionNumber)
        supportFragmentManager.commit {
            replace<FragmentTwo>(R.id.fragmentContainerViewTwo, args = bundle)
            setReorderingAllowed(true)
        }
    }
}