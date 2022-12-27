package com.elcodee.twoway_databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.elcodee.twoway_databinding.databinding.ActivityChallengeBinding

class Challenge : AppCompatActivity() {
    private lateinit var binding: ActivityChallengeBinding
    private lateinit var challenge: ChallengeViewModel
    private lateinit var ViewModelFactory: VmFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_challenge)
        ViewModelFactory = VmFactory(125)
        challenge = ViewModelProvider(this, ViewModelFactory).get(ChallengeViewModel::class.java)

        binding.myViewModel = challenge

        challenge.totalData.observe(this, Observer {
            binding.resultTextView.text = it.toString()
        })

        binding.apply {
            insertButton.setOnClickListener {
                challenge.setTotal(inputEditText.text.toString().toInt())
            }
        }
    }
}