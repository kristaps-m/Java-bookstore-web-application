package com.example.demo;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout{
  private BookRepository bookRepository;
  private TextField title = new TextField("Title");
  private TextField author = new TextField("Author");
  private TextField publicationDate = new TextField("Publication Date");
  private Grid<Book> grid = new Grid<>(Book.class);
  private Binder<Book> binder = new Binder<>(Book.class);


  public MainView(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
    add(new H1("Welcome to my Bookstore."));

    grid.setColumns("title", "author", "publicationDate"); // ,"bookSize"
    add(getFrom(), grid);
    refrechGrid();
  }


  private Component getFrom() {
    var layout = new HorizontalLayout();
    layout.setAlignItems(Alignment.BASELINE);
    var addButton = new Button("Add");
    addButton.addClickShortcut(Key.ENTER);
    addButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
    layout.add(title, author, publicationDate, addButton); // bookSize

    binder.bindInstanceFields(this);

    addButton.addClickListener(click -> {
      try {
        var book = new Book();
        binder.writeBean(book);
        bookRepository.save(book);
        binder.readBean(new Book());
        refrechGrid();

      } catch (Exception e) {
        // TODO: handle exception
      }
    });
    
    return layout;
  }

  private void refrechGrid() {
    grid.setItems(bookRepository.findAll());
  }
}
