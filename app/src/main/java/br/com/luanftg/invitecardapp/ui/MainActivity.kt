package br.com.luanftg.invitecardapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import br.com.luanftg.invitecardapp.App
import br.com.luanftg.invitecardapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy{ActivityMainBinding.inflate(layoutInflater)}
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    private val adapter by lazy { InviteCardAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rvCards.adapter = adapter
        getAllInviteCard()
        insertListener()
    }

    private fun insertListener() {
        binding.fabAdd.setOnClickListener{
            val intent = Intent(this@MainActivity, AddInviteCardActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getAllInviteCard() {
        mainViewModel.getAll().observe(this) { inviteCards ->
            adapter.submitList(inviteCards)
        }
    }
}