package com.mobillor.usermanagementmodule.domain.home.util

import android.content.Context
import android.content.SharedPreferences
import com.mobillor.usermanagementmodule.R


class SessionManager (context: Context) {
    private var prefs: SharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("SessionPrefs", Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = sharedPreferences.edit()

    fun saveLoggedInStatus(isLoggedIn: Boolean) {
        editor.putBoolean("isLoggedIn", isLoggedIn)
        editor.apply()
    }

    fun isLoggedIn(): Boolean {
        return sharedPreferences.getBoolean("isLoggedIn", false)
    }

    companion object {
        const val USER_TOKEN = "user_token"
//        const val TYPE = "device_type"
    }

    /**
     * Function to save auth token
     */
    fun saveAuthToken(token: String) {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    fun savedevicetype(device: String) {
        editor.putString("device_type", device)
        editor.apply()
    }

    fun fetchdevicetype(): String? {
        return sharedPreferences.getString("device_type", null)
    }

    /**
     * Function to fetch auth token
     */
    fun fetchAuthToken(): String? {
        return prefs.getString(USER_TOKEN, null)
    }
    fun clearSession() {
        val editor = prefs.edit()
        editor.remove(USER_TOKEN)
        editor.apply()
        saveLoggedInStatus(false)
    }
}