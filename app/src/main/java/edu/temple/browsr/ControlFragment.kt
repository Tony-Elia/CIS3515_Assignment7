package edu.temple.browsr

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText

class ControlFragment : Fragment() {
    private val viewModel: LinkViewModel by lazy {
        ViewModelProvider(requireActivity())[LinkViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_control, container, false).apply {
            val controlActions = requireActivity() as PageFragment.ControlActions
            findViewById<View>(R.id.go).setOnClickListener {
                viewModel.setLink(findViewById<TextInputEditText>(R.id.text).text.toString())
            }
            findViewById<View>(R.id.back).setOnClickListener {
                controlActions.back()
            }
            findViewById<View>(R.id.forward).setOnClickListener {
                controlActions.forward()
            }

            viewModel.getLink().observe(requireActivity()) {
                findViewById<TextInputEditText>(R.id.text).setText(it)
            }
        }
    }
}