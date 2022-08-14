package br.com.luanftg.invitecardapp

import android.app.Application
import br.com.luanftg.invitecardapp.data.AppDatabase
import br.com.luanftg.invitecardapp.data.InviteCardRepository

class App: Application() {
    val database by lazy {AppDatabase.getDatabase(this)}
    val repository by lazy {InviteCardRepository(database.inviteDao())}
}