package com.androiddev.animation_v1

import android.animation.Animator
import android.animation.AnimatorInflater
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import com.androiddev.animation_v1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var revealBounceAnim: Animator
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRevealBounceAnimation()

        //val animationFadeIn = AnimationUtils.loadAnimation(this, R.anim.bounce_at_sameposition)

        binding.bRevealBounce.setOnClickListener {
            startRevealBounceAnimation()
        }

    }
    private fun setupRevealBounceAnimation() {
        revealBounceAnim = AnimatorInflater.loadAnimator(
            this,
            R.animator.reveal_bounce
        )

        revealBounceAnim.setTarget(binding.tv)
        revealBounceAnim.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) { }
            override fun onAnimationCancel(animation: Animator?) { }

            override fun onAnimationEnd(animation: Animator?) {
                binding.tv.visibility  = View.GONE
            }

            override fun onAnimationStart(animation: Animator?) {
                binding.tv.visibility = View.VISIBLE
                binding.tv.alpha = 1f
            }
        })
    }

    private fun startRevealBounceAnimation() {
        if (!revealBounceAnim.isStarted) {
            revealBounceAnim.start()
        }
    }
}