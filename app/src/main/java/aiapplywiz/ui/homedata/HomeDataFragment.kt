package aiapplywiz.ui.homedata

import aiapplywiz.R
import aiapplywiz.binding.ButtonAdapter
import aiapplywiz.binding.ScaleInOutTransformer
import aiapplywiz.binding.ScalePageTransformer
import aiapplywiz.binding.SeamlessPageTransformer
import aiapplywiz.binding.SmoothScrollAdapter
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import aiapplywiz.databinding.FragmentHomeDataBinding
import aiapplywiz.util.autoCleared
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalTime
import java.util.Calendar

class HomeDataFragment : Fragment() {

    var binding by autoCleared<FragmentHomeDataBinding>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var handler: Handler
    private lateinit var runnable: Runnable

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dataBinding = FragmentHomeDataBinding.inflate(
            inflater,
            container,
            false
        )
        binding = dataBinding
        binding.txtViewGreeting.text = getGreetingMessage()
        recyclerView = binding.recyclerView
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            adapter = SmoothScrollAdapter(requireContext())
            setHasFixedSize(true)
            itemAnimator = null
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        startAnimation()
    }

    override fun onPause() {
        super.onPause()
        stopAnimation()
    }

    private fun startAnimation() {
        handler = Handler(Looper.getMainLooper())
        runnable = object : Runnable {
            override fun run() {
                recyclerView.smoothScrollToPosition(recyclerView.adapter!!.itemCount - 1)
                handler.postDelayed(this, 5) // 30 FPS
            }
        }
        handler.post(runnable)
    }

    private fun stopAnimation() {
        handler.removeCallbacks(runnable)
    }


    private fun getGreetingMessage(): String {
        val calendar = Calendar.getInstance()
        val currentHour = calendar.get(Calendar.HOUR_OF_DAY)
        val greetingMessage = when (currentHour) {
            in 0..5 -> "Hey there, Sleepy head! 🥱"
            in 6..11 -> "Hey, Wakey Wakey! 😇"
            in 12..17 -> "Hey, Good afternoon! 🤩"
            in 18..23 -> "Hey, Good evening! 😄"
            else -> "Hello!"
        }
        return greetingMessage
    }

}