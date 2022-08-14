package br.com.luanftg.invitecardapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.luanftg.invitecardapp.data.InviteCard
import br.com.luanftg.invitecardapp.data.InviteCardRepository
import java.lang.IllegalArgumentException

class MainViewModel(private val inviteCardRepository: InviteCardRepository): ViewModel() {

    fun insert(inviteCard: InviteCard) {
        inviteCardRepository.insert(inviteCard)
    }

    fun getAll() : LiveData<List<InviteCard>> {
        return  inviteCardRepository.getAll()
    }
}

class MainViewModelFactory(private  val repository: InviteCardRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}