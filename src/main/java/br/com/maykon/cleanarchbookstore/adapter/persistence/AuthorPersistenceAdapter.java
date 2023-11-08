package br.com.maykon.cleanarchbookstore.adapter.persistence;

import br.com.maykon.cleanarchbookstore.application.port.out.FindAuthorByIdPort;
import br.com.maykon.cleanarchbookstore.common.AuthorNotFoundException;
import br.com.maykon.cleanarchbookstore.common.PersistenceAdapter;
import br.com.maykon.cleanarchbookstore.domain.Author;

import java.util.UUID;

@PersistenceAdapter
class AuthorPersistenceAdapter implements FindAuthorByIdPort {
	private final AuthorRepository authorRepository;

	AuthorPersistenceAdapter(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	@Override
	public Author findAuthorById(UUID id) {
		return authorRepository.findById(id).orElseThrow(AuthorNotFoundException::new);
	}
}
