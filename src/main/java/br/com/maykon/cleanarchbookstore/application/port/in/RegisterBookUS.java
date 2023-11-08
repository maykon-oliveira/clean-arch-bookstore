package br.com.maykon.cleanarchbookstore.application.port.in;

import br.com.maykon.cleanarchbookstore.common.SelfValidating;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public interface RegisterBookUS {
	void registerBook(RegisterBookCommand command) throws NoUniqueBookTitleException;

	final class RegisterBookCommand extends SelfValidating<RegisterBookCommand> {
		@NotEmpty
		private final String bookTitle;
		@NotNull
		private final UUID authorId;

		public RegisterBookCommand(String bookTitle, UUID authorId) {
			this.bookTitle = bookTitle;
			this.authorId = authorId;
			validateSelf();
		}

		public String getBookTitle() {
			return bookTitle;
		}

		public UUID getAuthorId() {
			return authorId;
		}
	}

	final class NoUniqueBookTitleException extends RuntimeException {
	}
}
