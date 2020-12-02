package com.example.ui_elements2

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog

class AlbumDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_details)

        var albumItems: AlbumItem = intent.getSerializableExtra("data") as AlbumItem
        var viewImage1 = findViewById<ImageView>(R.id.icon_details)
        var viewText2 = findViewById<TextView>(R.id.icon_name)

        if(albumItems.icons == R.drawable.praise_songs) {
            viewImage1.setImageResource(albumItems.icons!!)

            val musicsArray = mutableListOf("Shape of You", "Despacito", "Faded",
                "Remember When", "Thunder")
            val adapter2 = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, musicsArray)
            val albumMusics = findViewById<ListView>(R.id.album_songs)
            albumMusics.adapter = adapter2

            albumMusics.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
                val dialogAlert = AlertDialog.Builder(this)
                dialogAlert.setMessage("Do you want to remove this song from list?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
                        val removeMusic = musicsArray[position]
                        musicsArray.remove(removeMusic)
                        adapter2.notifyDataSetChanged()

                    })
                    .setNegativeButton("No", DialogInterface.OnClickListener {
                            dialog, which ->
                        dialog.cancel()
                    })
                val alert = dialogAlert.create()
                alert.setTitle("Alert! Deleting Song")
                alert.show()
            }// item listener
        }


        else if(albumItems.icons == R.drawable.worship_album){
            viewImage1.setImageResource(albumItems.icons!!)
            viewText2.text = "Rain"

            val songsArray =mutableListOf( "The Prayer" , "Time to say Goodbye", "Beauty and the Beast", "Moment",
                "Someone like you" , "Rolling in the Deep", "My Heart Will Go On")
            val adapter3 = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, songsArray)
            val albumMusics = findViewById<ListView>(R.id.album_songs)
            albumMusics.adapter = adapter3
            albumMusics.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
                val dialogAlert = AlertDialog.Builder(this)
                dialogAlert.setMessage("Do you want to remove this song from list?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
                        val removeMusic = songsArray[position]
                        songsArray.remove(removeMusic)
                        adapter3.notifyDataSetChanged()

                    })
                    .setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
                        dialog.cancel()
                    })
                val alert = dialogAlert.create()
                alert.setTitle("Alert! Deleting Song")
                alert.show()
            }
        }
        else if(albumItems.icons == R.drawable.happiness_love){
            viewImage1.setImageResource(albumItems.icons!!)
            viewText2.text = "Dance Monkey"

            val musicsArray = mutableListOf("Dance Monkey", "Lucky", "Im yours")
            val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, musicsArray)
            val albumMusics = findViewById<ListView>(R.id.album_songs)
            albumMusics.adapter = adapter
            albumMusics.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
                val dialogAlert = AlertDialog.Builder(this)
                dialogAlert.setMessage("Do you want to remove this song from list?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
                        val removeMusic = musicsArray[position]
                        musicsArray.remove(removeMusic)
                        adapter.notifyDataSetChanged()

                    })
                    .setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
                        dialog.cancel()
                    })
                val alert = dialogAlert.create()
                alert.setTitle("Alert! Deleting Song")
                alert.show()
            }

        }
    }

}
