package com.janneri.aoc.util

import java.io.File
import java.net.CookieHandler
import java.net.CookieManager
import java.net.HttpCookie
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.time.Duration


object AOCClient {

    private fun getHttpClient(): HttpClient {
        CookieHandler.setDefault(CookieManager())
        val cookieManager = CookieHandler.getDefault() as CookieManager
        val sessionCookieValue = File(System.getProperty("user.home"),".adventofcode.session").readText().trim()
        val aocSessionCookie = HttpCookie("session", sessionCookieValue).apply {
            path = "/"
            version = 0
        }
        cookieManager.cookieStore.add(URI("https://adventofcode.com"), aocSessionCookie)
        return HttpClient.newBuilder()
            .cookieHandler(cookieManager)
            .connectTimeout(Duration.ofSeconds(10))
            .build()
    }

    fun downloadInput(year: Int, dayNum: Int): String {
        val client = getHttpClient()
        val req = HttpRequest.newBuilder()
            .uri(URI.create("https://adventofcode.com/$year/day/$dayNum/input"))
            .GET().build()

        return client.send(req, HttpResponse.BodyHandlers.ofString()).body().trim()
    }

}