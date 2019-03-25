package com.ols.data.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY, setterVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY)
@MappedSuperclass
public class EntitySuperclass {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column
  @JsonProperty // ??? Do we want this exposed?
  private long id;

  @Column
  @JsonProperty
  private String attribute;

  @Column
  @JsonProperty
  private String secondAttribute;

  @Pattern(regexp = "^[0-9]+$", message = "Must not be null or must be numeric")
  @Size(min = 0, max = 12, message = "Must be between {min} and {max} characters long")
  @Column
  @JsonProperty
  private String validationTest;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getAttribute() {
    return attribute;
  }

  public void setAttribute(String attribute) {
    this.attribute = attribute;
  }

  public String getSecondAttribute() {
    return secondAttribute;
  }

  public void setSecondAttribute(String secondAttribute) {
    this.secondAttribute = secondAttribute;
  }

  public String getValidationTest() {
    return validationTest;
  }

  public void setValidationTest(String validationTest) {
    this.validationTest = validationTest;
  }
}

