package com.levi.restapi_dtree

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://exercise-646d.restdb.io/apps/swagger/?url=https://exercise-646d.restdb.io/rest/_swagger.json#/group-1/"

class MainActivity : AppCompatActivity() {

        lateinit var layerAdapter: layerAdapter
        lateinit var linearLayoutManager: linearLayoutManager

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            recyclerview_users.setHasFixedSize(true)
            linearLayoutManager = linearLayoutManager(context: this)
            recyclerview_users.LayoutManager = LinearLayoutManager

        getMyData();
    }

    private fun getMyData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(api_Interface::class.java)
        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object: Callback<List<dataGroup1Item>?> {
            override fun onResponse(
                call: Call<List<dataGroup1Item>?>,
                response: Response<List<dataGroup1Item>?>
            )
            val responseBody = response.body()!!

            layerAdapter = layerAdapter(basecontext, responseBody)
            myAdapter.notifyDataSetChanged()
            recyclerview_user.adapter = layer


            }

            txtId.text = myStringBuilder
        }
            override fun onFailure(call: Call<List<dataGroup1Item>?>, t: Throwable){
                Log.d(tag: "MainActivity": "onFailure"+t.message)
            }
        })

    }
}