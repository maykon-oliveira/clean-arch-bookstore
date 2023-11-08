package br.com.maykon.cleanarchbookstore.adapter.persistence;

import br.com.maykon.cleanarchbookstore.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> {
}
