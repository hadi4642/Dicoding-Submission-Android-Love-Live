package com.recoder.lovelive.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.recoder.lovelive.DetailActivity
import com.recoder.lovelive.R
import com.recoder.lovelive.databinding.ItemLoveLiveBinding
import com.recoder.lovelive.model.LoveLive

class LoveLiveAdapter(private var listLoveLive : ArrayList<LoveLive>) : RecyclerView.Adapter<LoveLiveAdapter.LoveLiveViewHolder>() {

    inner class LoveLiveViewHolder(private val itemLoveLiveBinding: ItemLoveLiveBinding) : RecyclerView.ViewHolder(itemLoveLiveBinding.root) {
        fun bindItem(loveLive: LoveLive) {
            // Set Nama & Deskripsi Karakter
            with(itemLoveLiveBinding){
                tvName.text = loveLive.name
                tvDescription.text = loveLive.description
            }

            // Set Gambar Thumbnail Character
            Glide.with(itemView)
                .load(loveLive.thumbnail)
                .apply(RequestOptions.circleCropTransform())
                .into(itemLoveLiveBinding.ivThumbnail)

            // Set Bingkai Karakter sesuai dengan Nama
            when(loveLive.name){
                "Ayumu Uehara" -> setThumbnail(R.drawable.circle_ayumu)
                "Kasumi Nakasu" -> setThumbnail(R.drawable.circle_kasumi)
                "Setsuna Yuki" -> setThumbnail(R.drawable.circle_setsuna)
                "Ai Miyashita" -> setThumbnail(R.drawable.circle_ai)
                "Emma Verde" -> setThumbnail(R.drawable.circle_emma)
                "Rina Tennoji" -> setThumbnail(R.drawable.circle_rina)
                "Kanata Konoe" -> setThumbnail(R.drawable.circle_kanata)
                "Shizuku Osaka" -> setThumbnail(R.drawable.circle_shizuku)
                "Karin Asaka" -> setThumbnail(R.drawable.circle_karin)
            }

            // Pindah ke Detail Activity ketika item diklik
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_LOVE_LIVE, loveLive)
                itemView.context.startActivity(intent)
            }

        }

        // Fungsi set Bingkai
        private fun setThumbnail(circle: Int) {
            itemLoveLiveBinding.rlThumbnail.setBackgroundResource(circle)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoveLiveViewHolder {
        val adapter = ItemLoveLiveBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LoveLiveViewHolder(adapter)
    }

    override fun onBindViewHolder(holder: LoveLiveViewHolder, position: Int) {
        holder.bindItem(listLoveLive[position])
    }

    override fun getItemCount(): Int = listLoveLive.size
}