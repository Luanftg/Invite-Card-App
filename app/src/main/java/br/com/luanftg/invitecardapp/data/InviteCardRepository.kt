package br.com.luanftg.invitecardapp.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class InviteCardRepository(private val dao: InviteCardDao) {

    fun insert(inviteCard: InviteCard) = runBlocking {
        launch(Dispatchers.IO) {
            dao.insert(inviteCard)
        }
    }

    fun getAll() = dao.getAll()
}