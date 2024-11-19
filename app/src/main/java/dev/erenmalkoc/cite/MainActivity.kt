package dev.erenmalkoc.cite

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity() {

    val viewModel: CiteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)
        handleIntent(intent)



    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)

        handleIntent(intent)

    }


    private fun handleIntent(intent: Intent?) {

        if (intent?.action == Intent.ACTION_SEND && intent.type == "text/plain") {
            intent.getStringExtra(Intent.EXTRA_TEXT)?.let {
                viewModel.onIntentWithTextExtra(it)
            }

        }

    }

    private fun inflateNavGraphWithArgs(cite: String) {
        findNavController(R.id.nav_host_fragment).setGraph(R.navigation.nav_graph)
    }
}