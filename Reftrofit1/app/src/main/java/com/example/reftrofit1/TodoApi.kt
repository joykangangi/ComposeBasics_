package com.example.reftrofit1

import retrofit2.Response

interface TodoApi {
    fun getTodos(): Response
}