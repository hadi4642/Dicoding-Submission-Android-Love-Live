package com.recoder.lovelive

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.recoder.lovelive.adapter.LoveLiveAdapter
import com.recoder.lovelive.databinding.ActivityMainBinding
import com.recoder.lovelive.model.LoveLive
import com.recoder.lovelive.repository.LoveLiveData


class MainActivity : AppCompatActivity() {

    private var backPressedTime: Long = 0
    private lateinit var backToast: Toast
    private var list: ArrayList<LoveLive> = arrayListOf()
    private lateinit var mainBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        setContentView(mainBinding.root)

        // Tampilkan Informasi di Toast ketika aplikasi pertama kali dijalankan
        val pref: SharedPreferences = this.getSharedPreferences("PREF", 0)
        val editor = pref.edit()
        val firstRun = pref.getBoolean("firstRun", true)
        if (firstRun) {
            Log.i("onCreate: ", "first time")
            editor.putBoolean("firstRun", false)
            editor.apply()
            Toast.makeText(this, "Aplikasi ini membutuhkan koneksi internet untuk melihat detail dari character", Toast.LENGTH_LONG).show()
        }

        list.addAll(LoveLiveData.listData)

        mainBinding.rvLoveLive.layoutManager = LinearLayoutManager(this)
        val loveLiveAdapter = LoveLiveAdapter(list)
        mainBinding.rvLoveLive.adapter = loveLiveAdapter


    }

    // Fungsi Menampilkan Dialog
    private fun showDialog(){
        val view = View.inflate(this@MainActivity, R.layout.layout_dialog, null)

        val builder = AlertDialog.Builder(this@MainActivity)
        builder.setView(view)

        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        val btn = view.findViewById<Button>(R.id.btnOk)
        btn.setOnClickListener {
            dialog.dismiss()
        }
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val displayWidth = displayMetrics.widthPixels
        val layoutParams = WindowManager.LayoutParams()
        layoutParams.copyFrom(dialog.window!!.attributes)
        val dialogWindowWidth = (displayWidth * 0.96f).toInt()
        layoutParams.width = dialogWindowWidth
        dialog.window!!.attributes = layoutParams
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_profile, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.menuProfile -> {
            startActivity(Intent(this, ProfileActivity::class.java))
            true
        }
        R.id.menuInfo -> {
            showDialog()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        backToast = Toast.makeText(this, "Klik Sekali lagi untuk keluar", Toast.LENGTH_SHORT)
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel()
            super.onBackPressed()
            return
        } else {
            backToast.show()
        }
        backPressedTime = System.currentTimeMillis()

    }
}