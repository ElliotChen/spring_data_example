package tw.elliot.data.jpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import tw.elliot.data.jpa.domain.Book;

import java.util.List;

/**
 * Created by elliot on 24/02/2017.
 */
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
    /**
     * sample _ find by fields
     * @param name
     * @return
     */
    public List<Book> findByName(String name);
}
