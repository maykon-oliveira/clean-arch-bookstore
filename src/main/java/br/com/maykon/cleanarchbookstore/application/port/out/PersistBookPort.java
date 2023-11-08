package br.com.maykon.cleanarchbookstore.application.port.out;

import br.com.maykon.cleanarchbookstore.domain.Book;

public interface PersistBookPort {
	Book persistBook(Book book);
}
