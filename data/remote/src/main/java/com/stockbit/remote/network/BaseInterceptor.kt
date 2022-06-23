package com.stockbit.remote.network

import com.stockbit.remote.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class BaseInterceptor : Interceptor {

    companion object {
        private const val HEADER_AUTHORIZATION = "Authorization"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val originRequest = chain.request()
        val requestBuilder = originRequest.newBuilder()
        requestBuilder.addHeader(HEADER_AUTHORIZATION, "Apikey ${BuildConfig.API_KEY}")
        return chain.proceed(requestBuilder.build())
    }
}