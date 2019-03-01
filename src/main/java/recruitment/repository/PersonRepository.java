package recruitment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import recruitment.domain.Person;
import recruitment.domain.PersonDTO;

/**
 * Contains all database access regarding Persons.
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface PersonRepository extends JpaRepository<Person, String> {

    /**
     * Returns the person, or user, with the specified username or null if no such user exists.
     *
     * @param username The specified username.
     * @return The person entity.
     */
    @Query(value = "SELECT * FROM Person WHERE username = ?", nativeQuery = true)
    Person getPersonByUsername(String username);

    @Override
    Person save(Person person);

}
