package com.example.khmelnytskyi.ui

import androidx.lifecycle.ViewModel
import com.example.khmelnytskyi.database.Database
import com.example.khmelnytskyi.model.InterestPoint
import com.example.khmelnytskyi.model.PointUISate
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PointViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(PointUISate())
    val uiState:StateFlow<PointUISate> = _uiState.asStateFlow()

    lateinit var currentList:List<InterestPoint>
    fun setType(pointTypes: PointTypes){
        _uiState.update {
            currentState->
            currentState.copy(currentType = pointTypes)
        }
        when(pointTypes){
            PointTypes.Park-> {
                currentList = Database.parks
            }
            PointTypes.Restaurant->{
                currentList = Database.restaurants
            }
            PointTypes.Cafe->{
                currentList = Database.cafes
            }
            else -> null
        }
    }

    fun resetType(){
        _uiState.value = PointUISate()
    }

}