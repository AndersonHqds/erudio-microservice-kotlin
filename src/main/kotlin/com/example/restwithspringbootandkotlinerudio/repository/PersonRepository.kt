package com.example.restwithspringbootandkotlinerudio.repository

import com.example.restwithspringbootandkotlinerudio.model.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : JpaRepository<Person, Long?>