package com.example.postTwitter

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PostTwitterApplication

fun main(args: Array<String>) {
	runApplication<PostTwitterApplication>(*args)
}
