package com.jsp.stock.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.apache.kafka.common.config.types.Password;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "users")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

  @Id
  @Column(name = "id", nullable = false, unique = true, length = 36)
  private String id;


  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String password;

  public boolean isEmpty() {
    return id == null;
  }

  public User(
    String firstName,
    String lastName,
    String email,
    String password
  ) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
  }

  @Override
  public String toString() {
    return (
      "{" +
      "id:" +
      id +
      ", firstName:'" +
      firstName +
      '\'' +
      ", lastName:'" +
      lastName +
      '\'' +
      ", email:'" +
      email +
      '\'' +
      ", password:'" +
      password +
      '\'' +
      '}'
    );
  }

public boolean isEnabled() {
    return true;
}
}
