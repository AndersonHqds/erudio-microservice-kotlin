package com.example.restwithspringbootandkotlinerudio.services

import com.example.restwithspringbootandkotlinerudio.exceptions.ResourceNotFoundException
import com.example.restwithspringbootandkotlinerudio.model.Person
import com.example.restwithspringbootandkotlinerudio.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {
    @Autowired
    private lateinit var repository: PersonRepository
    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<Person> {
        logger.info("Finding all people!")
        return repository.findAll()
    }

    fun findById(id: Long): Person {
        return repository.findById(id).orElseThrow{ ResourceNotFoundException("No records found for this ID") }
    }

    fun create(person: Person): Person {
        logger.info("Creating one person with name ${person.firstName}")
        return repository.save(person)
    }

    fun update(person: Person): Person {
        logger.info("Updating one person with id ${person.id}")
        val entity = repository.findById(person.id).orElseThrow{ ResourceNotFoundException("No records found for this ID") }
        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender
        return repository.save(entity)
    }

    fun delete(id: Long) {
        logger.info("Updating one person with id ${id}")
        val entity = repository.findById(id).orElseThrow{ ResourceNotFoundException("No records found for this ID") }
        repository.delete(entity)
    }
}