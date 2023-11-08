package br.com.maykon.cleanarchbookstore.adapter.web;

import br.com.maykon.cleanarchbookstore.application.port.in.RegisterBookUS;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BookController {
	private final RegisterBookUS registerBook;

	public BookController(RegisterBookUS registerBook) {
		this.registerBook = registerBook;
	}

	@GetMapping
	public ResponseEntity<?> registerBook() {
		RegisterBookUS.RegisterBookCommand command = new RegisterBookUS.RegisterBookCommand("may", UUID.fromString("276aeeaa-6697-4677-b5a0-3adf18c3d6b6"));
		registerBook.registerBook(command);
		return ResponseEntity.ok().build();
	}
}
