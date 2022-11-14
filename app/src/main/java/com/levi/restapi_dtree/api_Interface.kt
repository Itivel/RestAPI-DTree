package com.levi.restapi_dtree

import retrofit2.call

interface api_Interface {

    @GET(value:"get_group1")
    fun getData(): call<List<dataGroup1Item>>
}