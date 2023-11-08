package br.com.maykon.cleanarchbookstore.application.service;

import br.com.maykon.cleanarchbookstore.application.port.in.RegisterBookUS;
import br.com.maykon.cleanarchbookstore.application.port.out.FindAuthorByIdPort;
import br.com.maykon.cleanarchbookstore.application.port.out.FindBookByTitlePort;
import br.com.maykon.cleanarchbookstore.application.port.out.PersistBookPort;
import br.com.maykon.cleanarchbookstore.common.UseCase;
import br.com.maykon.cleanarchbookstore.domain.Author;
import br.com.maykon.cleanarchbookstore.domain.Book;

import java.util.UUID;

@UseCase
public class RegisterBookService implements RegisterBookUS {
	private final FindAuthorByIdPort findAuthorByIdPort;
	private final FindBookByTitlePort findBookByTitlePort;
	private final PersistBookPort persistBookPort;

	public RegisterBookService(FindAuthorByIdPort findAuthorByIdPort, FindBookByTitlePort findBookByTitlePort, PersistBookPort persistBookPort) {
		this.findAuthorByIdPort = findAuthorByIdPort;
		this.findBookByTitlePort = findBookByTitlePort;
		this.persistBookPort = persistBookPort;
	}

	@Override
	public void registerBook(RegisterBookCommand command) {
		Author author = findAuthorByIdPort.findAuthorById(command.getAuthorId());

		requireUniqueTitle(command.getBookTitle());
		requireAuthorToHavePremiumAccount(author);

		Book book = new Book(null, command.getBookTitle(), author.getId());
		persistBookPort.persistBook(book);
	}

	private void requireUniqueTitle(String title) throws NoUniqueBookTitleException {
		if (findBookByTitlePort.findBookByTitle(title).isPresent()) {
			throw new NoUniqueBookTitleException();
		}
	}

	private void requireAuthorToHavePremiumAccount(Author author) {
		// ...
	}

}
