package users.profile.kotlinapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import users.profile.kotlinapi.Carte
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import users.profile.kotlinapi.Model.Show
import users.profile.kotlinapi.Model.Shows
import users.profile.kotlinapi.viewModel.ApiService

class MainActivity : AppCompatActivity() {
    private lateinit var lsv:ListView
    lateinit var adapter:Carte
    var ss= Shows()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lsv=findViewById(R.id.lsv)
        val intent=this.intent
        val search=intent.getStringExtra("search")
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.tvmaze.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(ApiService::class.java)


       val endpoint = "search/shows?q="+search
        GlobalScope.launch(Dispatchers.IO) {
            apiService.searchShows(endpoint).enqueue(object : Callback<List<Map<String, Any?>>> {
                override fun onResponse(call: Call<List<Map<String, Any?>>>, response: Response<List<Map<String, Any?>>>) {
                    if (response.isSuccessful) {
                        val shows = response.body()
                        if(shows!=null) {
                            shows.forEach { show ->
                                val showMap = show["show"] as Map<String, Any?>
                                val name = showMap["name"].toString()
                                val genre = showMap["genres"].toString()
                                val rating = showMap["rating"]?.let { (it as Map<String, Any?>)["average"] }.toString()
                                val country = (showMap["network"]?.let { (it as Map<String, Any?>)["country"] })?.let { (it as Map<String, Any?>)["name"] }.toString()
                                val summary = showMap["summary"].toString()
                                val imgurl = showMap["image"]?.let { (it as Map<String, Any?>)["original"] }.toString()
                                Log.d("Show", "Name: $name")
                                Log.d("Show", "Genre: $genre")
                                Log.d("Show", "Rating: $rating")
                                Log.d("Show", "Country: $country")
                                Log.d("Show", "Summary: $summary")
                                Log.d("Show", "Summary: $imgurl")
                                Log.d("Show", "Summary: $showMap")
                                show(imgurl,
                                    name, genre ,
                                    rating, country,summary
                                )

                            }
                            try {
                                Design(ss)
                            }catch (e:Exception){
                                e.printStackTrace()
                            }
                        }
                    } else {
                        Log.e("Error", "Request failed with code ${response.code()}")
                    }
                }
                override fun onFailure(call: Call<List<Map<String, Any?>>>, t: Throwable) {
                    // Handle error here
                    Log.e("Error", t.message ?: "Unknown error")
                }

            })
        }
   }
    fun  show(img:String,name: String,genre:String,rating:String,contry:String,summary: String){
        var show=Show(img,name, genre, rating, contry, summary)
        ss.ajouter(show)
    }

    fun Design(s:Shows){
      /*var liste=ArrayList<HashMap<String,Any>>()
      for(i in s.getListShow()){
          var h=HashMap<String,Any>()
          h.put("img",i.img)
          h.put("name",i.name)
          h.put("genre",i.genre)
          h.put("rating",i.rating)
          h.put("country",i.contry)
          h.put("summary",i.summary)
          liste.add(h)
      }*/
        adapter= Carte(this,s)
        lsv.adapter=adapter



    }


}


