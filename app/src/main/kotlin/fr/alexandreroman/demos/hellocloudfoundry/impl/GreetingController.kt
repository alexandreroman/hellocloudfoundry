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

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/greeting")
class GreetingController(private val config: GreetingConfig) {
    @GetMapping
    fun getGreeting(@RequestParam("name") name: String?): GreetingResponse {
        val targetName = if (name.isNullOrEmpty()) "world" else name
        val message = String.format(config.pattern, targetName)
        return GreetingResponse(message)
    }
}
