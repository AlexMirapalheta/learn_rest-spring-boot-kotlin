package com.learn.restspringbootkotlin.service

import com.learn.restspringbootkotlin.exceptions.ResourceNotFoundException
import com.learn.restspringbootkotlin.model.Person
import com.learn.restspringbootkotlin.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PersonService {

    @Autowired
    private lateinit var repository: PersonRepository

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<Person> {
        logger.info("Find All Persons")
        return repository.findAll()
    }

    fun findById(id: Long): Person {
        logger.info("Find Person By ID : $id")
        return repository.findById(id).orElseThrow { ResourceNotFoundException("No Record Found for this ID") }
    }

    fun create(person: Person): Person {
        logger.info("Creating $person")
        return repository.save(person)
    }

    fun update(person: Person): Person {
        val entity: Person = findById(person.id)
        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender

        logger.info("Updating $entity")

        return repository.save(entity)
    }

    fun delete(id: Long) {
        val person: Person = findById(id)
        logger.info("Deleting $person")
        repository.delete(person)
    }
}