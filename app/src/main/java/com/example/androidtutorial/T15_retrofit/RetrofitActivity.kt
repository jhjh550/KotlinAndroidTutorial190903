package com.example.androidtutorial.T15_retrofit

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtutorial.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MyTypicodeInterface{
    @GET("posts")
    fun getPosts(): Call<List<MyPost>>
}

data class MyPost(val userId:Int, val id:Int, val title:String,
                  val body:String)

class RetrofitActivity : AppCompatActivity() {

    lateinit var myTypicode: MyTypicodeInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        myTypicode = retrofit.create(MyTypicodeInterface::class.java)
    }

    private fun getPosts(){
        val call = myTypicode.getPosts()
        call.enqueue(object : Callback<List<MyPost>>{
            override fun onFailure(call: Call<List<MyPost>>, t: Throwable) {

            }

            override fun onResponse(call: Call<List<MyPost>>, response: Response<List<MyPost>>) {
                if(response.isSuccessful == false){
                    Toast.makeText(this@RetrofitActivity, "error : ${response.code()}",
                        Toast.LENGTH_SHORT).show()
                    return
                }
                val posts = response.body()
            }

        })
    }
}
