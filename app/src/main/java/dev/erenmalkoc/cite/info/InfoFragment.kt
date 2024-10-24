package dev.erenmalkoc.cite.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.navigateUp
import dev.erenmalkoc.cite.CiteViewModel
import dev.erenmalkoc.cite.databinding.FragmentInfoBinding

class InfoFragment : Fragment() {
    val viewModel: CiteViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentInfoBinding.inflate(inflater)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel


        setUpNextButton(binding)
        return binding.root
    }

    private fun setUpNextButton(binding: FragmentInfoBinding) {
        binding.nextButton.setOnClickListener { view ->

            findNavController().navigate(InfoFragmentDirections.actionInfoFragmentToPreviewFragment())


        }

    }
}