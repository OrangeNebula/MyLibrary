package com.nebula.mylibrary

import org.springframework.data.repository.CrudRepository

interface BookRepository: CrudRepository<Book, Long> {
    fun findAllByOrderByAddedAtDesc(): Iterable<Book>
}

interface UserRepository: CrudRepository<User, String> {
    fun findByLogin(login: String): User?
}
