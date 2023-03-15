package com.example.demo;

//import java.sql.Date;

//import com.vaadin.flow.component.template.Id;

//import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Book {
  @Id
  @GeneratedValue
  private Long id;

  private String title;
  private String author;
  private String publicationDate;
  private Integer bookSize;


  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return this.author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getPublicationDate() {
    return this.publicationDate;
  }

  public void setPublicationDate(String publicationDate) {
    this.publicationDate = publicationDate;
  }

  public Integer getBookSize() {
    return this.bookSize;
  }

  public void setBookSize(Integer bookSize) {
    this.bookSize = bookSize;
  }

}
