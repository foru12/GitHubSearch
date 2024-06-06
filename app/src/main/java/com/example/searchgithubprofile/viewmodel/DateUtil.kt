package com.example.searchgithubprofile.viewmodel

import android.annotation.SuppressLint
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

object DateUtil {
    @SuppressLint("NewApi")
    fun formatDateTime(dateTimeString: String): String {
        val formatter = DateTimeFormatter.ofPattern("MM.dd.yyyy HH:mm")
        val instant = Instant.parse(dateTimeString)
        val dateTime = instant.atZone(ZoneId.systemDefault())
        return formatter.format(dateTime)
    }
}