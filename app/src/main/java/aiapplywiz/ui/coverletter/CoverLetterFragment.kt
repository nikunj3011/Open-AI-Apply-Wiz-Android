package aiapplywiz.ui.coverletter

import aiapplywiz.R
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class CoverLetterFragment : Fragment() {

    companion object {
        fun newInstance() = CoverLetterFragment()
    }

    private val viewModel: CoverLetterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_cover_letter, container, false)
    }
}