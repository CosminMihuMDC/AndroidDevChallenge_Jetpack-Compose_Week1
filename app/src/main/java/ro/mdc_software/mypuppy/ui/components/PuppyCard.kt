package ro.mdc_software.mypuppy.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.chrisbanes.accompanist.coil.CoilImage
import ro.mdc_software.mypuppy.data.Puppy
import ro.mdc_software.mypuppy.data.PuppyGenerator
import ro.mdc_software.mypuppy.ui.theme.MyPuppyTheme

/**
 * Puppy Card used in list.
 */
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun PuppyCard(puppy: Puppy, modifier: Modifier = Modifier) {
    var descriptionVisible by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
            .padding(10.dp)
            .clickable { descriptionVisible = !descriptionVisible }
    ) {
        Column {
            Row {
                puppy.image?.let {
                    CoilImage(
                        modifier = Modifier
                            .width(100.dp)
                            .height(80.dp),
                        data = it,
                        contentDescription = null,
                        fadeIn = true,
                        contentScale = ContentScale.Crop,
                    )
                }

                Column(modifier = Modifier.padding(10.dp)) {
                    Text(
                        text = puppy.name,
                        style = MaterialTheme.typography.h6
                    )
                    Text(
                        text = "${puppy.age} years • ${puppy.breed}",
                        style = MaterialTheme.typography.subtitle1
                    )
                }
            }

            puppy.description?.let {
                AnimatedVisibility(visible = descriptionVisible) {
                    Text(text = it, modifier = Modifier.padding(10.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PuppyCardPreview() {
    MyPuppyTheme {
        PuppyCard(PuppyGenerator.pappies.random())
    }
}