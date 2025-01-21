package aiapplywiz.binding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import aiapplywiz.ui.character.CharacterFragment
import aiapplywiz.ui.bangboos.BangbooFragment
import aiapplywiz.ui.homedata.HomeDataFragment
import aiapplywiz.ui.info.InfoFragment
import aiapplywiz.ui.wengines.WEngineFragment

class HomeViewPagerAdapter(fa: FragmentActivity): FragmentStateAdapter(fa){
    override fun getItemCount(): Int {
        return 1
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> HomeDataFragment()
//            1 -> InfoFragment()
            else -> HomeDataFragment()
        }
    }

}