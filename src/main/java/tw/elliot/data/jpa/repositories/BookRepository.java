package tw.elliot.data.jpa.repositories;

import org.springframework.data.repository.CrudRepository;
import tw.elliot.data.jpa.domain.Book;

/**
 * Created by elliot on 24/02/2017.
 */
public interface BookRepository extends CrudRepository<Book, Integer> {
}
