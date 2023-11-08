package br.com.maykon.cleanarchbookstore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private final UUID id;
	private final String title;
	private final UUID authorId;

	public Book(UUID id, String title, UUID authorId) {
		this.id = id;
		this.title = title;
		this.authorId = authorId;
	}

	/**
	 * @deprecated Framework required
	 */
	@Deprecated
	public Book() {
		this(null, null, null);
	}
}
