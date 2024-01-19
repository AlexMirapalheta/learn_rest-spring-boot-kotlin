package com.learn.restspringbootkotlin.controller

import com.learn.restspringbootkotlin.model.Person
import com.learn.restspringbootkotlin.service.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/person"])
class PersonController {

    @Autowired
    private lateinit var service: PersonService

//    @RequestMapping(value = ["/{id}"], method = [RequestMethod.GET], produces = [MediaType.APPLICATION_JSON_VALUE])
    @GetMapping("/{id}")
    fun findById(@PathVariable(value = "id") id: Long): Person {
        return service.findById(id)
    }

//    @RequestMapping(method = [RequestMethod.GET], produces = [MediaType.APPLICATION_JSON_VALUE])
    @GetMapping
    fun findAll(): List<Person> {
        return service.findAll()
    }

//    @RequestMapping(
//        method = [RequestMethod.POST],
//        consumes = [MediaType.APPLICATION_JSON_VALUE],
//        produces = [MediaType.APPLICATION_JSON_VALUE]
//    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody person: Person): Person {
        return service.create(person)
    }

//    @RequestMapping(
//        method = [RequestMethod.PUT],
//        consumes = [MediaType.APPLICATION_JSON_VALUE],
//        produces = [MediaType.APPLICATION_JSON_VALUE]
//    )
    @PutMapping
    fun update(@RequestBody person: Person): Person {
        return service.update(person)
    }

//    @RequestMapping(
//        value = ["/{id}"],
//        method = [RequestMethod.DELETE]
//    )
    @DeleteMapping("/{id}")
    fun delete(@PathVariable(value = "id") id: Long): ResponseEntity<*> {
        service.delete(id)
        return ResponseEntity.noContent().build<Any>()
    }
}