package ro.mdc_software.mypuppy.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.chrisbanes.accompanist.coil.CoilImage
import ro.mdc_software.mypuppy.R
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

    Card(modifier = modifier.padding(10.dp)) {
        Column {
            Row {
                puppy.image?.let {
                    PuppyImage(it)
                }

                Column(modifier = Modifier.padding(10.dp)) {
                    Text(
                        text = puppy.name,
                        style = MaterialTheme.typography.h6,
                        maxLines = 1
                    )
                    Text(
                        text = stringResource(
                            id = R.string.puppies_details,
                            puppy.age,
                            puppy.breed
                        ),
                        style = MaterialTheme.typography.subtitle1,
                        maxLines = 2
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_up_24),
                    contentDescription = "",
                    modifier = Modifier.clickable { descriptionVisible = !descriptionVisible },
                    colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
                )
            }

            puppy.description?.let {
                AnimatedVisibility(visible = descriptionVisible) {
                    Text(
                        text = it,
                        modifier = Modifier.padding(10.dp),
                        style = MaterialTheme.typography.caption
                    )
                }
            }
        }
    }
}

@Composable
private fun PuppyImage(imageUrl: String) {
    CoilImage(
        modifier = Modifier
            .width(100.dp)
            .height(80.dp),
        data = imageUrl,
        contentDescription = null,
        fadeIn = true,
        contentScale = ContentScale.Crop,
        loading = {
            Box(Modifier.fillMaxSize()) {
                Image(
                    modifier = Modifier
                        .size(50.dp)
                        .align(Alignment.Center),
                    painter = painterResource(id = R.drawable.ic_dog),
                    contentDescription = null
                )
            }
        },
        error = {
            Box(Modifier.fillMaxSize()) {
                Image(
                    modifier = Modifier
                        .size(50.dp)
                        .align(Alignment.Center),
                    painter = painterResource(id = R.drawable.ic_dog),
                    contentDescription = null
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PuppyCardPreview() {
    MyPuppyTheme {
        PuppyCard(PuppyGenerator.pappies.random())
    }
}