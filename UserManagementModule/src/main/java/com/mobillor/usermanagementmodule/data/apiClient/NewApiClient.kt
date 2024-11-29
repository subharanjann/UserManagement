package com.mobillor.usermanagementmodule.data.apiClient

import com.mobillor.usermanagementmodule.data.apiService.NewApiInterface
import com.mobillor.usermanagementmodule.presentation.home.activity.StartActivity
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.X509TrustManager

object NewApiClient {

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .sslSocketFactory(createInsecureSslContext().socketFactory, createTrustAllManager())
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

    private fun createTrustAllManager(): X509TrustManager {
        return object : X509TrustManager {
            override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) {
            }

            override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {
            }

            override fun getAcceptedIssuers(): Array<X509Certificate> {
                return arrayOf()
            }
        }
    }

    private fun createInsecureSslContext(): SSLContext {
        return SSLContext.getInstance("TLS").apply {
            init(null, arrayOf(createTrustAllManager()), null)
        }
    }

    private val baseretrofit = Retrofit.Builder()

        .baseUrl(StartActivity.USR_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()


    fun getBaseService(): NewApiInterface {
        return baseretrofit.create(NewApiInterface::class.java)
    }

}