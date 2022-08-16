package by.rudenko.library.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {
  private int id;

  @NotEmpty(message = "Title shouldn't be empty")
  @Size(min = 2, max = 100, message = "Title should have size from 2 to 100 characters")
  private String title;

  @NotEmpty(message = "Author shouldn't be empty")
  @Size(min = 2, max = 100, message = "Author should have size from 2 to 100 characters")
  private String author;

/*  @NotEmpty(message = "Year shouldn't be empty")*/
  private int year;

  public Book(int id, String title, String author, int year) {
    this.title = title;
    this.author = author;
    this.year = year;
  }

  public Book() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }
}
