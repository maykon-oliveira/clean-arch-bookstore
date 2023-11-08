package br.com.maykon.cleanarchbookstore.application.port.out;

import br.com.maykon.cleanarchbookstore.domain.Book;

import java.util.Optional;

public interface FindBookByTitlePort {
	Optional<Book> findBookByTitle(String title);
}
