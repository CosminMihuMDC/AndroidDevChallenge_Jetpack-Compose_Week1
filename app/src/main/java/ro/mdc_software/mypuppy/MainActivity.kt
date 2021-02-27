package ro.mdc_software.mypuppy

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import ro.mdc_software.mypuppy.ui.components.PuppyList
import ro.mdc_software.mypuppy.ui.theme.MyPuppyTheme
import ro.mdc_software.mypuppy.ui.viewmodel.PuppyListViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel = PuppyListViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyPuppyTheme {
                Main(viewModel)
            }
        }
    }
}

@Composable
private fun Main(viewModel: PuppyListViewModel) {
    Surface(color = MaterialTheme.colors.background) {
        val puppies by viewModel.puppiesLiveData.observeAsState(listOf())
        PuppyList(puppies = puppies)
    }
}
