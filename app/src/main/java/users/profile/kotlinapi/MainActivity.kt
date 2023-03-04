package users.profile.kotlinapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import users.profile.kotlinapi.Model.Show
import users.profile.kotlinapi.viewModel.ApiService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.tvmaze.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(ApiService::class.java)


       val endpoint = "search/shows?q=golden girls" // Replace with user input
        GlobalScope.launch(Dispatchers.IO) {
            apiService.searchShows(endpoint).enqueue(object : Callback<List<Map<String, Any?>>> {
                override fun onResponse(call: Call<List<Map<String, Any?>>>, response: Response<List<Map<String, Any?>>>) {
                    if (response.isSuccessful) {
                        val shows = response.body()
                        Log.d("fffffffffffffffff",shows?.get(0)?.get("score").toString())

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
    fun  show(val img:String,val name: String,val genre:String,val rating:String,val contry:String, val summary: String)
}