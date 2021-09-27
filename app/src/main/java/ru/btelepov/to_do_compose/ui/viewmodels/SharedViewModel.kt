package ru.btelepov.to_do_compose.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.btelepov.to_do_compose.data.models.ToDoTask
import ru.btelepov.to_do_compose.data.repositories.ToDoRepository
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(private val repo: ToDoRepository) : ViewModel() {

    private val _allTasks = MutableStateFlow<List<ToDoTask>>(emptyList())
    val allTasks: StateFlow<List<ToDoTask>> = _allTasks

    fun getAllTasks() {
        viewModelScope.launch {
            repo.getAllTasks.collect {
                _allTasks.value = it
            }
        }
    }


}