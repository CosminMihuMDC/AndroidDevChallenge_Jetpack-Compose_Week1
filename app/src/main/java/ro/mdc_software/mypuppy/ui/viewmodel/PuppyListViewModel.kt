package ro.mdc_software.mypuppy.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ro.mdc_software.mypuppy.data.Puppy
import ro.mdc_software.mypuppy.data.PuppyGenerator

/**
 * [ViewModel] to get puppies from repository.
 */
class PuppyListViewModel : ViewModel() {

    private val puppiesMutableLiveData = MutableLiveData<List<Puppy>>()
    val puppiesLiveData: LiveData<List<Puppy>>
        get() = puppiesMutableLiveData

    init {
        viewModelScope.launch {
            // Simulate network delay.
            delay(2000)

            // Post data.
            puppiesMutableLiveData.value = PuppyGenerator.pappies
        }
    }
}