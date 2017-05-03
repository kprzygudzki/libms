package pl.przygudzki.libms.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class BookId implements Serializable {

	private UUID id;

	private BookId(UUID id) {
		this.id = id;
	}

	static BookId generate() {
		return new BookId(UUID.randomUUID());
	}

	public BookId() {
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		BookId bookId = (BookId) o;

		return id != null ? id.equals(bookId.id) : bookId.id == null;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

}
