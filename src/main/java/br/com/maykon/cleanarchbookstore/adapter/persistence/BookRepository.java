package br.com.maykon.cleanarchbookstore.adapter.persistence;

import br.com.maykon.cleanarchbookstore.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

interface BookRepository extends JpaRepository<Book, UUID> {
	Optional<Book> findByTitle(String title);
}
