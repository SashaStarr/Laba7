package ua.lviv.iot.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Lion {
  private String name;
  private String color;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  public Lion() {

  }

  public Lion(String name, String color) {
    super();
    this.name = name;
    this.color = color;

  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
