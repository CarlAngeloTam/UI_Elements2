package com.example.ui_elements2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView


class AlbumActivity : AppCompatActivity() {


    private var arrayList1 = ArrayList<AlbumItem>()
    var images2 = intArrayOf(R.drawable.praise_songs, R.drawable.worship_album, R.drawable.happiness_love)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album)

        for(i in images2.indices){
            arrayList1.add(AlbumItem(images2[i]))
        }

        var albumAdapter1 = AlbumAdapter(arrayList1, this)

        var gridView2 = findViewById<GridView>(R.id.grid_view)
        gridView2.adapter = albumAdapter1

        gridView2.setOnItemClickListener { parent, view, position, id ->
            var intent3 = Intent(this,AlbumDetailsActivity::class.java)
            intent3.putExtra("data", arrayList1[position])
            startActivity(intent)
        }
    }
    class AlbumAdapter(
        var albumItem1: ArrayList<AlbumItem>,
        var context2: Context

    ): BaseAdapter(){

        var layoutInflater3 = context2.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var views = convertView
            if(convertView == null){
                views = layoutInflater3.inflate(R.layout.grid_item_list, parent, false)
            }

            var imageView2 = views?.findViewById<ImageView>(R.id.icons)

            imageView2?.setImageResource(albumItem1[position].icons!!)

            return views!!
        }

        override fun getItem(position: Int): Any {
            return albumItem1[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return albumItem1.size
        }

    }


}