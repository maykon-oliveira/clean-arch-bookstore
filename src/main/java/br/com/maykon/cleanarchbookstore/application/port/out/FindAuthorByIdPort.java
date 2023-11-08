package br.com.maykon.cleanarchbookstore.application.port.out;

import br.com.maykon.cleanarchbookstore.domain.Author;

import java.util.UUID;

public interface FindAuthorByIdPort {
	Author findAuthorById(UUID uuid);

	final class AuthorNotFoundException extends RuntimeException {
	}
}
