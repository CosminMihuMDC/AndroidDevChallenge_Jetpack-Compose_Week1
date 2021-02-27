package ro.mdc_software.mypuppy.ui.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ro.mdc_software.mypuppy.data.Puppy
import ro.mdc_software.mypuppy.data.PuppyGenerator
import ro.mdc_software.mypuppy.ui.theme.MyPuppyTheme

/**
 * Puppy Card used in list.
 */
@Composable
fun PuppyCard(puppy: Puppy) {
    Text(text = "Hello ${puppy.name}!")
}

@Preview(showBackground = true)
@Composable
fun PuppyCardPreview() {
    MyPuppyTheme {
        PuppyCard(PuppyGenerator.pappies.random())
    }
}