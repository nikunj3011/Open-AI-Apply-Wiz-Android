package aiapplywiz.binding

import android.view.View
import androidx.viewpager2.widget.ViewPager2

class ScaleInOutTransformer : ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        page.apply {
            val scaleFactor = when {
                position < -1 -> 0f
                position <= 0 -> 1f
                position <= 1 -> 1 - position
                else -> 0f
            }

            scaleX = scaleFactor
            scaleY = scaleFactor
        }
    }
}