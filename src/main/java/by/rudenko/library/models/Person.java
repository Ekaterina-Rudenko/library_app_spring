package by.rudenko.library.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Person {
  private int id;

  @NotEmpty(message = "Name should not be empty")
  @Size(min = 2, max = 100, message = "Name should be between 2 and 100")
  @Pattern(regexp = "[A-Z]\\w+ [A-Z]\\w+", message = "Your name should be int this format: Name Surname")
  private String fullName;

  @Min(value = 1900, message = "Year of birth should be greater than 1900")
  private int yearOfBirth;

  public Person(String fullName, int yearOfBirth) {
    this.fullName = fullName;
    this.yearOfBirth = yearOfBirth;
  }

  public Person() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public int getYearOfBirth() {
    return yearOfBirth;
  }

  public void setYearOfBirth(int yearOfBirth) {
    this.yearOfBirth = yearOfBirth;
  }
}
