package tw.elliot.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import tw.elliot.data.jpa.domain.Book;
import tw.elliot.data.jpa.domain.Gender;
import tw.elliot.data.jpa.domain.Person;
import tw.elliot.data.jpa.repositories.BookRepository;
import tw.elliot.data.jpa.repositories.PersonRepository;

import javax.sql.DataSource;

import static org.junit.Assert.*;


/**
 * Created by elliot on 24/02/2017.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:application-test.xml"})
public class SystemTest {
    private static final Logger logger = LoggerFactory.getLogger(SystemTest.class);

    @Autowired
    private DataSource dataSource;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PersonRepository personRepository;
    @Test
    public void initTest() {
        if (null != dataSource) {
            logger.info("ds!");
        }
        logger.info("Successed!");
    }

    @Test
    public void repositoryTest() {
        Person adam = new Person("Adam", "Lin", Gender.Male);
        Book book = new Book("ISBN-1234", "FirstBook");

        adam.addBook(book);
        this.personRepository.save(adam);

        assertEquals(1, this.bookRepository.findByAuthor_Gender(Gender.Male).size());
        assertEquals(0, this.bookRepository.findByAuthor_Gender(Gender.Female).size());

        /*
         * Using Page for pagination
         */
        Page<Book> books = this.bookRepository.findByAuthor_Gender(Gender.Male, new PageRequest(1, 10));
        logger.info("Books number is " + books.getTotalElements());

        /*
         * -- Example and ExampleMatcher --
         * Using Example.of(instance of Entity, (optional) a matcher)) to find one or many.
         *
         */
        Person example = new Person("Ad", null, null);
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("firstname", match -> match.startsWith());
        Iterable<Person> all = this.personRepository.findAll(Example.of(example, matcher));
        for (Person person : all) {
            logger.info("Peron's lastname is {}", person.getLastName());
        }

        /*
        all.forEach(person -> {
            logger.info("Peron name is {}", person.getLastName());
        });
        */
    }
}
