package edu.temple.activity4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var textSizeSelector: RecyclerView
    lateinit var textSizeDisplay: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Trying to create array of integers that are multiples of 5
        textSizeDisplay = findViewById(R.id.textSizeDisplayTextView)
        textSizeSelector = findViewById(R.id.recyclerView)
        // Verify correctness by examining array values.
        val textSizes = Array(20){(it + 1) * 5}
        for(i in 1..textSizes.size)
            Log.d("Array values", textSizes[i].toString())
    }
}


/* Convert to RecyclerView.Adapter */
class TextSizeAdapter : RecyclerView.Adapter<TextSizeAdapter.TextSizeViewHolder>() {
    class TextSizeViewHolder(view:View) : RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextSizeViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: TextSizeViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}