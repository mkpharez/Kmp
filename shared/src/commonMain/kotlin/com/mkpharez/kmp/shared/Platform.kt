package com.mkpharez.kmp.shared

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
