package by.rudenko.library.controllers;

import by.rudenko.library.dao.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {

  private final BookDAO bookDAO;

  @Autowired
  public BookController(BookDAO bookDAO) {
    this.bookDAO = bookDAO;
  }
}
