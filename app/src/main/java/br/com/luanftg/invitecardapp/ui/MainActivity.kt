package br.com.luanftg.invitecardapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.luanftg.invitecardapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy{ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListener()
    }

    private fun insertListener() {
        binding.fabAdd.setOnClickListener{
            val intent = Intent(this@MainActivity, AddInviteCardActivity::class.java)
            startActivity(intent)
        }
    }
}