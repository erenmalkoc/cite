package dev.erenmalkoc.cite.preview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import dev.erenmalkoc.cite.CiteViewModel
import dev.erenmalkoc.cite.databinding.FragmentPreviewBinding


class PreviewFragment : Fragment() {

    val viewModel : CiteViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentPreviewBinding.inflate(inflater)

        binding.viewModel = viewModel
        binding.viewBinding= PreviewViewBinding(viewModel)
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root

    }


}