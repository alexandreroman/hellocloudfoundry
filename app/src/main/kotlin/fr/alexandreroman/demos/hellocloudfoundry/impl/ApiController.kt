/*
 * Hello Cloud Foundry - a simple Kotlin app using Spring Boot deployed on Cloud Foundry
 * Copyright (C) 2018 Alexandre Roman
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package fr.alexandreroman.demos.hellocloudfoundry.impl

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
class ApiController(private val config: ApiConfig) {
    @GetMapping("/api")
    fun getInfos(): ApiResponse {
        return createApiResponse()
    }

    @GetMapping("/api.js", produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseBody
    fun getInfosAsJavascript(): String {
        val api = createApiResponse()
        return """
            apiEndpoint="${api.endpoint}";
            """.trimIndent()
    }

    private fun createApiResponse(): ApiResponse {
        val endpoint =
                if (config.endpoint.isNullOrEmpty())
                    ServletUriComponentsBuilder.fromCurrentContextPath().toUriString()
                else config.endpoint
        return ApiResponse(endpoint)
    }
}
