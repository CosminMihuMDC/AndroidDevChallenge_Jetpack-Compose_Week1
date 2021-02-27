package ro.mdc_software.mypuppy.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ro.mdc_software.mypuppy.data.Puppy
import ro.mdc_software.mypuppy.data.PuppyGenerator
import ro.mdc_software.mypuppy.ui.theme.MyPuppyTheme

/**
 * Puppy list on main screen.
 */
@Composable
fun PuppyList(puppies: List<Puppy>) {
    LazyColumn {
        items(puppies) { puppy ->
            PuppyCard(puppy = puppy)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PuppyListPreview() {
    MyPuppyTheme {
        PuppyList(PuppyGenerator.pappies)
    }
}