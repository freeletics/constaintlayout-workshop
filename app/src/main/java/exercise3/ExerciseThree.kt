package exercise3

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.transition.TransitionManager
import com.freeletics.constraintlayoutworkshop.R
import kotlinx.android.synthetic.main.exercise_3.*
import java.util.*


private const val DELAY = 1000L
private const val UPDATE_TITLE = 1337

class ExerciseThree : AppCompatActivity() {


    private val random = Random()

    private val handler = @SuppressLint("HandlerLeak")
    object : Handler() {
        override fun handleMessage(msg: Message?) {
            when (msg?.what) {
                UPDATE_TITLE -> {
                    TransitionManager.beginDelayedTransition(layout)
                    line1.text = "${getString(R.string.title)} ${"*".repeat(random.nextInt(6))}"
                    scheduleUpdate()
                }
                else -> super.handleMessage(msg)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exercise_3)
    }

    override fun onResume() {
        super.onResume()
        scheduleUpdate()
    }

    private fun scheduleUpdate() {
        handler.sendEmptyMessageDelayed(UPDATE_TITLE, DELAY)
    }

    override fun onPause() {
        super.onPause()
        handler.removeMessages(UPDATE_TITLE)
    }
}
