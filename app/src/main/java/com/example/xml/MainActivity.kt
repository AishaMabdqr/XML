package com.example.xml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.IOException

class MainActivity : AppCompatActivity() {

    lateinit var details: List<StudentDetails>
    lateinit var itemList : ArrayList<String>
    lateinit var rvAdapter : RVAdapter
    lateinit var rvItem : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        itemList= ArrayList()
        rvItem = findViewById(R.id.rvItem)
        rvAdapter = RVAdapter(itemList)
        rvItem.adapter = rvAdapter
        rvItem.layoutManager = LinearLayoutManager(this)



        try{
            val parser = MyXmlPullParserHandler()
            val iStream = assets.open("studentDetails.xml")
            details = parser.parse(iStream)

            var text = ""
            for(i in details){
                text += "${i.name} \n  ${i.marks}\n"
                itemList.add(text)
            }
        }catch (e: IOException) {
            println("ISSUE: $e")
        }
    }
}