package br.com.luanftg.invitecardapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import br.com.luanftg.invitecardapp.App
import br.com.luanftg.invitecardapp.R
import br.com.luanftg.invitecardapp.data.InviteCard
import br.com.luanftg.invitecardapp.databinding.ActivityAddInviteCardBinding

class AddInviteCardActivity : AppCompatActivity() {

    private val binding by lazy{ ActivityAddInviteCardBinding.inflate(layoutInflater)}
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListener()
    }

    private fun insertListener() {
        binding.btnClose.setOnClickListener() {
            finish()
        }

        binding.btnConfirm.setOnClickListener {
            val inviteCard = InviteCard(
                nome = binding.tilNome.editText?.text.toString(),
                empresa = binding.tilEmpresa.editText?.text.toString(),
                telefone = binding.tilTelefone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                fundoPersonalizado = binding.tilCor.editText?.text.toString()
            )
            mainViewModel.insert(inviteCard)
            Toast.makeText(this, R.string.label_show_sucess, Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}