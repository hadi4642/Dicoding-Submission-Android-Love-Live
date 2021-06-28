package com.recoder.lovelive

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.net.ConnectivityManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.recoder.lovelive.databinding.ActivityDetailBinding
import com.recoder.lovelive.model.LoveLive
import java.lang.Exception
import java.lang.IllegalStateException

@SuppressLint("SetJavaScriptEnabled")
class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_LOVE_LIVE = "extra_love_live"
    }

    private var mediaPlayer: MediaPlayer ?= null
    private lateinit var handler : Handler
    private lateinit var detailBinding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        setContentView(detailBinding.root)
        handler = Handler(Looper.getMainLooper())
        supportActionBar?.title = "Detail Character"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Memanggil fungsi untuk cek device apakah terkoneksi dengan internet
        if(isConnect()){
            // Jika terkoneksi, tampilkan konten detail
            handler.postDelayed({

                val data = intent.getParcelableExtra<LoveLive>(EXTRA_LOVE_LIVE)


                // Set Warna sesuai karakter masing-masing
                when(data?.name){
                    "Ayumu Uehara" -> setBackground(R.color.ayumu_secondary, R.color.ayumu)
                    "Kasumi Nakasu" -> setBackground(R.color.kasumi_secondary, R.color.kasumi)
                    "Setsuna Yuki" -> setBackground(R.color.setsuna_secondary, R.color.setsuna)
                    "Ai Miyashita" -> setBackground(R.color.ai_secondary, R.color.ai)
                    "Emma Verde" -> setBackground(R.color.emma_secondary, R.color.emma)
                    "Rina Tennoji" -> setBackground(R.color.rina_secondary, R.color.rina)
                    "Kanata Konoe" -> setBackground(R.color.kanata_secondary, R.color.kanata)
                    "Shizuku Osaka" -> setBackground(R.color.shizuku_secondary, R.color.shizuku)
                    "Karin Asaka" -> setBackground(R.color.karin_secondary, R.color.karin)
                    else -> setBackground(R.color.yu_secondary, R.color.yu)
                }

                Glide.with(this@DetailActivity)
                    .load(data?.photo)
                    .into(detailBinding.ivPhoto)

                Glide.with(this@DetailActivity)
                    .load(data?.icon)
                    .into(detailBinding.ivIcon)

                with(detailBinding){
                        tvName.text = data?.name
                        tvCV.text = "CV : ${data?.cv}"
                        tvYear.text = data?.year.toString()
                        tvBirthday.text = data?.birthday
                        tvBloodType.text = data?.bloodType
                        tvHeight.text = "${data?.height} cm"
                        tvDescription.text = data?.description
                        tvBackground.text = data?.background
                        tvPersonality.text = data?.personality
                        tvSongName.text = data?.songName
                        tvReferences.text = data?.references

                        fabShare.setOnClickListener {
                            val intent = Intent(Intent.ACTION_SEND)
                            intent.putExtra(Intent.EXTRA_TEXT, ("${data?.name} is one of the main characters of Love Live! Nijigasaki High School Idol Club. \nRead more in ${data?.references}"))
                            intent.type = "text/plain"
                            startActivity(Intent.createChooser(intent, "Send To"))
                        }

                        detailBinding.tvReferences.setOnClickListener {
                            val intent = Intent(Intent.ACTION_VIEW)
                            intent.data = Uri.parse(data?.references)
                            startActivity(intent)
                        }
                    }

                    if(data?.video?.isNotEmpty()!!){
                        with(detailBinding){
                            webView.settings.javaScriptEnabled = true
                            webView.settings.domStorageEnabled
                            webView.loadUrl("https://www.youtube.com/embed/${data.video}")
                        }
                    }else{
                        with(detailBinding){
                            labelVideo.visibility = View.GONE
                            webView.visibility = View.GONE
                            frameLayout.visibility = View.GONE
                        }
                    }

                    val url = data.songFile
                    playMusic(url)

                    detailBinding.progress.visibility = View.GONE


            }, 0)

        }else{
            // Tampilkan Toast ketika device tidak terkoneksi dengan internet
            Toast.makeText(this, "Device tidak terhubung dengan internet", Toast.LENGTH_LONG).show()
        }
    }

    private fun playMusic(url: String?) {
        val seekBar = detailBinding.seekBar
        val playButton = detailBinding.playButton

        try {
            mediaPlayer = MediaPlayer.create(this, Uri.parse(url))
            seekBar.max = mediaPlayer?.duration!!
            detailBinding.tvEndTime.text = mediaPlayer!!.duration.toSongTime()
            playButton.setOnClickListener {
                if (mediaPlayer?.isPlaying!!){
                    mediaPlayer?.pause()
                    playButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_play_circle))
                }else{
                    mediaPlayer?.start()
                    playButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_pause_circle))
                }
            }
            handler.postDelayed(object : Runnable{
                override fun run() {
                    try {
                        seekBar.progress = mediaPlayer?.currentPosition!!
                        handler.postDelayed(this, 1000)
                    }catch (e: Exception){
                        Log.e("Exception", "${e.message}")
                    }
                }
            }, 0)

            mediaPlayer?.setOnCompletionListener {
                mediaPlayer?.isLooping
                mediaPlayer?.start()
            }

            mediaPlayer?.prepareAsync()


        }catch (e: NullPointerException){
            Log.e("Null Exception", "${e.message}")
            with(detailBinding){
                labelSong.visibility = View.GONE
                viewGroupSong.visibility = View.GONE
            }
        }catch (e: IllegalStateException){
            Log.e("Illegal State Exception", "${e.message}")
        }


        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val currentTime = progress.toSongTime()
                detailBinding.tvStartTime.text = currentTime

                if(fromUser){
                    mediaPlayer?.seekTo(progress)
                    seekBar?.progress = progress
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
    }

    override fun onPause() {
        super.onPause()
        try {
            if(mediaPlayer?.isPlaying!!){
                mediaPlayer?.pause()
            }
        } catch (e: NullPointerException){
            Log.e("Null Pointer", "${e.message}")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.stop()
        mediaPlayer = null
    }

    override fun onResume() {
        super.onResume()
        try {
            if (!mediaPlayer?.isPlaying!! && mediaPlayer?.currentPosition!! > 1){
                mediaPlayer?.start()
                detailBinding.playButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_pause_circle))
            }
        } catch (e: NullPointerException){
            Log.e("Null Exception", "${e.message}")
        }

    }


    private fun setBackground(background: Int, colorText: Int ){
        with(detailBinding){
            vBackground.setBackgroundResource(background)
            tvName.setBackgroundResource(colorText)
            tvCV.setTextColor(ContextCompat.getColor(this@DetailActivity, colorText))
        }
    }

    private fun Int.toSongTime(): String {
        var elapsedTime: String?
        val minutes = this / 1000 / 60
        val seconds = this / 1000 % 60
        elapsedTime = "$minutes:"
        if (seconds < 10){
            elapsedTime += "0"
        }
        elapsedTime += seconds
        return elapsedTime
    }

    private fun isConnect() : Boolean{
        val connect : ConnectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        return  connect.activeNetworkInfo != null && connect.activeNetworkInfo!!.isConnected
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}