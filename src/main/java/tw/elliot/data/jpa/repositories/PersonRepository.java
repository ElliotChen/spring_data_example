package tw.elliot.data.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tw.elliot.data.jpa.domain.Person;

import java.util.List;

/**
 * Created by elliot on 01/03/2017.
 */
@RepositoryRestResource(path = "person")
public interface PersonRepository extends JpaRepository<Person, Long> {

    public List<Person> findByFirstNameAndLastName(String firstName, String lastName);
}
