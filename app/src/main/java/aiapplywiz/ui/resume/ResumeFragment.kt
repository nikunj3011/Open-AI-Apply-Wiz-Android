package aiapplywiz.ui.resume

import aiapplywiz.R
import aiapplywiz.databinding.FragmentResumeBinding
import aiapplywiz.databinding.FragmentWengineBinding
import aiapplywiz.ui.characterinfo.InfoBottomSheetFragment
import aiapplywiz.ui.common.WEngineListAdapter
import aiapplywiz.ui.wengines.WEngineViewModel
import aiapplywiz.util.autoCleared
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class ResumeFragment : Fragment() {

    private lateinit var binding: FragmentResumeBinding
    private val viewModel by viewModel<ResumeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dataBinding = FragmentResumeBinding.inflate(
            inflater,
            container,
            false
        )
        binding = dataBinding
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        var response = viewModel.weaponsLiveData
//        binding.weaponRecyclerView.layoutManager = GridLayoutManager(context, 2)
//
//        binding.imageViewWEnginesAbilityInfo.setOnClickListener {
//            val bottomSheetFragment  = InfoBottomSheetFragment()
//            val bundle = Bundle()
//            bundle.putString("info", getData())
//            bottomSheetFragment.arguments = bundle
//            bottomSheetFragment.setCancelable(true)
//            bottomSheetFragment.show(requireActivity().supportFragmentManager, InfoBottomSheetFragment::class.java.name)
//        }
    }
}