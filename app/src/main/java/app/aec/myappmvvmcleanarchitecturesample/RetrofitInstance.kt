package app.aec.myappmvvmcleanarchitecturesample

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitInstance {

    companion object {
        private var retrofit: Retrofit? = null
        private const val baseUrl = "https://jsonplaceholder.typicode.com"

        fun getService(): PostDataService? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!.create(PostDataService::class.java)
        }
    }
}