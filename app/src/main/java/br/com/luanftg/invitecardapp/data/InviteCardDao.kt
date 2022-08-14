package br.com.luanftg.invitecardapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface InviteCardDao {

    @Query("SELECT * FROM InviteCard")
    fun getAll(): LiveData<List<InviteCard>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(inviteCard: InviteCard)
}