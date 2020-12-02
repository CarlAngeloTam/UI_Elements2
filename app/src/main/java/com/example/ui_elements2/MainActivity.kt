package com.example.ui_elements2



import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import com.google.android.material.snackbar.Snackbar
import android.content.Intent as Intent1


val listOfMusics = arrayListOf<String>()


class MainActivity : AppCompatActivity() {



    private val musicsArray = arrayOf("Shape of You", "Despacito", "Faded",
            "Remember When", "Thunder", "The Prayer" , "Time to say Goodbye", "Beauty and the Beast",
            "Moment", "Someone like you" , "Rolling in the Deep", "My Heart Will Go On" ,
            "Dance Monkey", "Lucky", "Im yours")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val adapter1 = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, musicsArray)
        val musicsQueueListView = findViewById<ListView>(R.id.songsQueueListView)
        musicsQueueListView.adapter = adapter1

        registerForContextMenu(musicsQueueListView)

    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater1 = menuInflater
        inflater1.inflate(R.menu.songs_menu, menu)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater1 = menuInflater
        inflater1.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.go_to_songs -> {
                true
            }
            R.id.go_to_albums -> {

                startActivity(Intent1(this, AlbumActivity::class.java))
                true
            }
            R.id.go_to_queues -> {

                startActivity(Intent1(this, SongsQueueActivity::class.java))
                true



            }



            else -> super.onOptionsItemSelected(item)
        }
    }


    override fun onContextItemSelected(item: MenuItem): Boolean {

        return when(item.itemId) {

            R.id.add_to_queue -> {
                val info1 = item.menuInfo as AdapterContextMenuInfo
                listOfMusics.add(musicsArray[info1.position])
                true
                val snackbar1 = Snackbar.make(this.findViewById(R.id.songsQueueListView),
                        "Navigate To Queue", Snackbar.LENGTH_LONG)
                snackbar1.setAction("Go", View.OnClickListener {
                    startActivity(Intent1(this, SongsQueueActivity::class.java))
                })
                snackbar1.show()


                true
            }
            else-> super.onContextItemSelected(item)

        }
    }
}

