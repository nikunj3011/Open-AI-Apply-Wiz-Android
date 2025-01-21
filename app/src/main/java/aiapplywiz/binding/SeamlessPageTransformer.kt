package aiapplywiz.binding

import android.view.View
import androidx.viewpager2.widget.ViewPager2

class SeamlessPageTransformer : ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        page.apply {
            when {
                position < -1 -> {
                    alpha = 0f
                }
                position <= 0 -> {
                    alpha = 1f
                    translationX = 0f
                }
                position <= 1 -> {
                    alpha = 1 - position
                    translationX = -width * position
                }
                else -> {
                    alpha = 0f
                }
            }
        }
    }
}