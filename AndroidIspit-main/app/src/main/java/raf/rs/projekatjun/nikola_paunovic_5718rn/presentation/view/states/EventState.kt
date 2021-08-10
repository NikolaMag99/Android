package raf.rs.projekatjun.nikola_paunovic_5718rn.presentation.view.states

sealed class EventState {

    object Loading : EventState()
    object DataFetched : EventState()
//    data class Success(var event: Events) : EventState()
    data class Error(val message: String) : EventState()
}