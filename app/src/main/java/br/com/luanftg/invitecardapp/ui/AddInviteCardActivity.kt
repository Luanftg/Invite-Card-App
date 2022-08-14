package br.com.luanftg.invitecardapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.luanftg.invitecardapp.databinding.ActivityAddInviteCardBinding

class AddInviteCardActivity : AppCompatActivity() {
    private val binding by lazy{ ActivityAddInviteCardBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListener()
    }

    private fun insertListener() {
        binding.btnClose.setOnClickListener() {
            finish()
        }
    }
}