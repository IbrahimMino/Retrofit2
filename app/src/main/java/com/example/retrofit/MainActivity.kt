package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit.adapter.RvAdapter
import com.example.retrofit.data.User
import com.example.retrofit.retrofit.ApiClient
import com.example.retrofit.retrofit.ApiInterface
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var rvAdapter: RvAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val apiCiemt = ApiClient()
        val retrofit = apiCiemt.getRetrofit()
        val apiInterface = retrofit.create(ApiInterface::class.java)

        apiInterface.getAllUsers().enqueue(object :Callback<List<User>>{
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful){
                    val data = response.body()
                         rvAdapter = RvAdapter(data!!)
                        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                        recyclerView.adapter = rvAdapter
                   }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.d("Error", t.message!!)
            }
        })

    }
}