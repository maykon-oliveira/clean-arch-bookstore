package br.com.maykon.cleanarchbookstore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private final UUID id;

	public Author(UUID id) {
		this.id = id;
	}

	/**
	 * @deprecated Framework required
	 */
	@Deprecated
	public Author() {
		this(null);
	}

	public UUID getId() {
		return id;
	}
}
