package br.com.maykon.cleanarchbookstore.adapter.persistence;

import br.com.maykon.cleanarchbookstore.application.port.out.FindBookByTitlePort;
import br.com.maykon.cleanarchbookstore.application.port.out.PersistBookPort;
import br.com.maykon.cleanarchbookstore.common.PersistenceAdapter;
import br.com.maykon.cleanarchbookstore.domain.Book;

import java.util.Optional;

@PersistenceAdapter
class BookPersistenceAdapter implements PersistBookPort, FindBookByTitlePort {
	private final BookRepository bookRepository;

	BookPersistenceAdapter(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public Book persistBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Optional<Book> findBookByTitle(String title) {
		return bookRepository.findByTitle(title);
	}
}
