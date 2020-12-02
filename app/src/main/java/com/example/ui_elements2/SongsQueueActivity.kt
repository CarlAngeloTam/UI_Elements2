package com.example.ui_elements2

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView

import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.getSystemService



lateinit var notificationManager: NotificationManager
lateinit var notificationChannel: NotificationChannel
lateinit var builder: Notification.Builder
private val channelId="com.example.uielements2"
private val description="Notification"
class SongsQueueActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_songs_queue)

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val Intent1 = Intent(this, SongsQueueActivity::class.java)
        val pendingIntent2 =
            PendingIntent.getActivity(this, 0, Intent1, PendingIntent.FLAG_UPDATE_CURRENT)

        var list: List<String>? = listOfMusics

        if (list.orEmpty().isEmpty() && (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)) {
            notificationChannel =
                NotificationChannel(channelId, description, NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.GREEN
            notificationChannel.enableVibration(false)
            notificationManager.createNotificationChannel(notificationChannel)

            builder = Notification.Builder(this, channelId)
                .setContentTitle("UIElementsPart 2 Notification")
                .setContentText("The Queue is Empty")
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.mipmap.ic_launcher))
                .setContentIntent(pendingIntent2)

        } else {
            builder = Notification.Builder(this)
                .setContentTitle("test")
                .setContentText("Notification")
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.mipmap.ic_launcher))
                .setContentIntent(pendingIntent2)
        }
        notificationManager.notify(1234, builder.build())




        val adapter2 = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listOfMusics)
        val musicsList = findViewById<ListView>(R.id.songsQueued)
        musicsList.adapter = adapter2
        registerForContextMenu(musicsList)


    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.remove, menu)
    }



    override fun onContextItemSelected(item: MenuItem): Boolean {

        return when(item.itemId) {

            R.id.remove_songs -> {
                val info4 = item.menuInfo as AdapterView.AdapterContextMenuInfo
                listOfMusics.removeAt(info4.position)
                true
                finish()
                overridePendingTransition(0, 0)
                startActivity(intent)
                overridePendingTransition(0, 0)
                Toast.makeText(baseContext, "Song Removed" , Toast.LENGTH_SHORT ).show()
                true

                return true

            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}


