package app.aec.myappmvvmcleanarchitecturesample

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PostDataService {
    @GET("/posts")
    suspend fun getPosts(): Response<Posts>
    @GET("/posts")
    suspend fun getPostsByUserId(@Query("userId") userId: Int): Response<Posts>
    @GET("/posts/{id}")
    suspend fun getPostsById(@Path("id") id: Int): Response<PostsItem>


}