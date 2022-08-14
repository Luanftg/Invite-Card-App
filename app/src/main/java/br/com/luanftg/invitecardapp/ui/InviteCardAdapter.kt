package br.com.luanftg.invitecardapp.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.luanftg.invitecardapp.data.InviteCard
import br.com.luanftg.invitecardapp.databinding.ItemInviteCardBinding

class InviteCardAdapter:
    ListAdapter<InviteCard, InviteCardAdapter.ViewHolder>(DiffCallback()) {

        var listenerShare: (View) -> Unit = {}


    inner class ViewHolder(
        private val binding: ItemInviteCardBinding
        ): RecyclerView.ViewHolder(binding.root) {
            fun bind (item: InviteCard) {
                binding.tvNome.text = item.nome
                binding.tvTelefone.text = item.telefone
                binding.tvEmail.text = item.email
                binding.tvEmpresa.text = item.empresa
              //  binding.mcvContent.setCardBackgroundColor(Color.parseColor(item.fundoPersonalizado))
                binding.mcvContent.setOnClickListener {
                    listenerShare(it)
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemInviteCardBinding.inflate(inflater, parent,false)
        return  ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class DiffCallback: DiffUtil.ItemCallback<InviteCard>() {
    override fun areItemsTheSame(oldItem: InviteCard, newItem: InviteCard) = oldItem == newItem

    override fun areContentsTheSame(oldItem: InviteCard, newItem: InviteCard) =
        oldItem.id == newItem.id
}