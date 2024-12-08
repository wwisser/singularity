package org.novasky.agi.json_api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JsonApiApplication

fun main(args: Array<String>) {
	runApplication<JsonApiApplication>(*args)
}
