package dev.erenmalkoc.cite.share

import android.content.Intent
import android.content.Intent.ACTION_SEND
import android.content.Intent.EXTRA_STREAM
import android.content.Intent.FLAG_GRANT_READ_URI_PERMISSION
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.core.content.FileProvider
import androidx.core.net.toUri
import androidx.core.view.drawToBitmap
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import dev.erenmalkoc.cite.CiteViewModel
import dev.erenmalkoc.cite.R
import dev.erenmalkoc.cite.databinding.FragmentShareBinding
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class ShareFragment : Fragment() {


    val viewModel: CiteViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentShareBinding.inflate(inflater)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.shareButton.setOnClickListener {
            onShareButtonClick(binding)
        }


        return binding.root

    }

    private fun onShareButtonClick(binding: FragmentShareBinding) {
        val bitmap = binding.citeLayout.drawToBitmap()

        try {
            val file = bitmap.saveToFile()
            file.share()

        }catch (ex: IOException) {
            ex.printStackTrace()
            Toast.makeText(requireContext(), R.string.problem_saving_file,LENGTH_LONG).show()
        }
    }

    private fun Bitmap.saveToFile(): File {
        var file: File? = null


        file = File(
            requireContext().externalCacheDir.toString() + File.separator + "cite.png"
        )

        file.createNewFile()

        val bos = ByteArrayOutputStream()
        compress(Bitmap.CompressFormat.PNG, 0, bos)
        val bitmapData = bos.toByteArray()


        val fos = FileOutputStream(file)
        fos.write(bitmapData)
        fos.flush()
        fos.close()
        return file


    }

    private fun File.share(){


        val uri  = FileProvider.getUriForFile(
            requireContext(),
            requireContext().packageName.toString()+".provider",
            this

        )

        val shareIntent : Intent = Intent().apply {
            action = ACTION_SEND
            putExtra(EXTRA_STREAM, uri)
            type = "image/png"
            addFlags(FLAG_GRANT_READ_URI_PERMISSION)


        }

        startActivity(Intent.createChooser(shareIntent, null))

    }






}