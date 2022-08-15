package by.rudenko.library.dao;

import by.rudenko.library.models.Person;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PersonDAO {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public PersonDAO(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public List<Person> index() {
    String SQL = "SELECT * FROM person";
    return jdbcTemplate.query(SQL, new BeanPropertyRowMapper<>(Person.class));
  }

  public Optional<Person> show(String email) {
    return jdbcTemplate.query("Select * FROM person WHERE email=?", new Object[]{email},
        new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
  }

  public Person show(int id) {
    String SQL = "SELECT * FROM person WHERE id=?";
    return jdbcTemplate.query(SQL, new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
        .stream().findAny().orElse(null);
  }

  public void save(Person person) {
    String SQL = "INSERT INTO person (name, age, email, address) VALUES ( ?, ?, ?, ?)";
    jdbcTemplate.update(SQL, person.getName(), person.getAge(), person.getEmail(),
        person.getAddress());
  }

  public void update(int id, Person updatedPerson) {
    String SQL = "UPDATE person SET name =?, age=?, email=?, address =? WHERE id=?";
    jdbcTemplate.update(SQL, updatedPerson.getName(), updatedPerson.getAge(),
        updatedPerson.getEmail(), updatedPerson.getAddress(), id);
  }

  public void delete(int id) {
    String SQL = "DELETE FROM person WHERE id=?";
    jdbcTemplate.update(SQL, id);
  }
}
