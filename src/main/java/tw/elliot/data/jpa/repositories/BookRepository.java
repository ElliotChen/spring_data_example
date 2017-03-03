package tw.elliot.data.jpa.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tw.elliot.data.jpa.domain.Book;
import tw.elliot.data.jpa.domain.Gender;

import java.util.List;

/**
 * Created by elliot on 24/02/2017.
 */
@RepositoryRestResource(path = "book")
public interface BookRepository extends JpaRepository<Book, Long> {
    /**
     * sample _ find by fields
     * @param name
     * @return
     */
    public List<Book> findByName(String name);

    public Book findByIsbn(String isbn);

    /*
    Test search by a not exist field;
    public List<Book> findByNotExistField(String field);
    */
    /**
     * sample _ find by field's property
     * @param gender
     * @return
     */
    public List<Book> findByAuthor_Gender(Gender gender);
    /*
    public Page<Book> findByAuthor_Gender(Gender gender, Pageable pageable);
    */
}
