package com.nebula.mylibrary

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
class RepositoriesTests @Autowired constructor(
    val entityManager: TestEntityManager,
    val userRepository: UserRepository,
    val bookRepository: BookRepository,
) {

    @Test
    fun `When findById then return Book`() {
       val author = User("rednebula01018", "nebula")
        entityManager.persist(author)
        val book = Book("MyBook", "This is my book", "blah blah", author)
        entityManager.persist(book)
        entityManager.flush()

        val found = bookRepository.findById(book.id!!)

        assertThat(found.get()).isEqualTo(book)
    }

    @Test
    fun `When findById then return User`() {
        var author = User("rednebula01018", "nebula")
        entityManager.persist(author)
        entityManager.flush()

        val found = userRepository.findById(author.login)

        assertThat(found.get()).isEqualTo(author)
    }

}
