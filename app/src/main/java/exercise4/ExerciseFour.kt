package exercise4

import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.support.v7.app.AppCompatActivity
import android.transition.ChangeBounds
import android.transition.Transition
import android.transition.TransitionManager
import android.view.animation.OvershootInterpolator
import com.freeletics.constraintlayoutworkshop.R
import kotlinx.android.synthetic.main.exercise_4.*

class ExerciseFour : AppCompatActivity() {

    private val set1 = ConstraintSet()
    private val set2 = ConstraintSet()

    private var flag: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exercise_4)

        initializeConstraintSets()

        button.setOnClickListener {
            TransitionManager.beginDelayedTransition(layout, createTransition())
            flag = !flag
            if (flag) {
                set1.applyTo(layout)
            } else {
                set2.applyTo(layout)
            }
        }
    }


    private fun initializeConstraintSets() {
        set2.clone(this, R.layout.exercise_4_1)
        set1.clone(layout)
    }


    private fun createTransition(): Transition? {
        return ChangeBounds().apply {
            interpolator = OvershootInterpolator()
        }
    }

}
