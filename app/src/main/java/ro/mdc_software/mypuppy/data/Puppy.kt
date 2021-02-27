package ro.mdc_software.mypuppy.data

/**
 * Puppy data model.
 */
data class Puppy(
    val name: String,
    val breed: String,
    val age: Int,
    val image: String? = null,
    val description: String? = null,
)