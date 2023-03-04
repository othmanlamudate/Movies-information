package users.profile.kotlinapi.viewModel

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url
import users.profile.kotlinapi.Model.Show


interface ApiService {
        @GET
        fun searchShows(@Url endpoint: String): Call<List<Map<String, Any?>>>
}


