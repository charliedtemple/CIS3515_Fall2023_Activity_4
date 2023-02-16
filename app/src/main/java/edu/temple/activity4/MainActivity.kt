package edu.temple.activity4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
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
        val callBack : (Float)-> Unit = {x:Float -> textSizeDisplay.textSize = x}
        // Verify correctness by examining array values.
        val textSizes = Array(20){(it + 1) * 5}
        for(i in 0..(textSizes.size-1))
            Log.d("Array values", textSizes[i].toString())
        textSizeSelector.adapter = TextSizeAdapter(textSizes, callBack)
        textSizeSelector.layoutManager = LinearLayoutManager(this)
    }
}


/* Convert to RecyclerView.Adapter */
class TextSizeAdapter(_textSizes: Array<Int>, _callBack:(Float)->Unit) : RecyclerView.Adapter<TextSizeAdapter.TextSizeViewHolder>() {
    private val textSizes = _textSizes
    private val callBack = _callBack
    inner class TextSizeViewHolder(view: TextView) : RecyclerView.ViewHolder(view){
        val textView = view
        init {
            textView.setOnClickListener { callBack(textSizes[adapterPosition].toFloat()) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextSizeViewHolder {
        return TextSizeViewHolder(TextView(parent.context).apply{setPadding(5,20,0,20)})
    }

    override fun getItemCount(): Int {
        return textSizes.size
    }

    override fun onBindViewHolder(holder: TextSizeViewHolder, position: Int) {
        holder.textView.text = textSizes[position].toString()
        holder.textView.textSize = textSizes[position].toFloat()
    }
}