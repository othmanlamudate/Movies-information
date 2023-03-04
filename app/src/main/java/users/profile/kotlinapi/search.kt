package users.profile.kotlinapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class search : AppCompatActivity(), View.OnClickListener {
    lateinit var movie: EditText
    lateinit var search: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        movie=findViewById(R.id.movie)
        search=findViewById(R.id.search)
        search.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(movie.text.toString().length>0){
            var intent=Intent(this,MainActivity::class.java)
            intent.putExtra("search",movie.text.toString())
            startActivity(intent)

        }else{
            Toast.makeText(this,"please entre movie name",Toast.LENGTH_LONG).show()
        }
    }
}