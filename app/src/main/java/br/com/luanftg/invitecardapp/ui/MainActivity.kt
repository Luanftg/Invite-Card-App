package br.com.luanftg.invitecardapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.luanftg.invitecardapp.R
import br.com.luanftg.invitecardapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy{ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }
}