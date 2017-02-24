package tw.elliot.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import tw.elliot.data.jpa.domain.Book;
import tw.elliot.data.jpa.repositories.BookRepository;

import javax.sql.DataSource;


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
    @Test
    public void initTest() {
        if (null != dataSource) {
            logger.info("ds!");
        }
        logger.info("Successed!");
    }

    @Test
    public void repositoryTest() {
        this.bookRepository.save(new Book("abook"));
    }
}
