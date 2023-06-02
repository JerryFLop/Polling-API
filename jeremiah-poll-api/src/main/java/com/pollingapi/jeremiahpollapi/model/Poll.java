package com.pollingapi.jeremiahpollapi.model;

import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

// `Poll` is marked as a POJO (Plain Old Java Object) representing data to be persisted to a database.
@Entity
/*
There are no constructors defined, as the Jackson library that Spring uses,
uses the nullary constructor and setters to create objects.
 */
public class Poll {


    @Id
    @GeneratedValue
    @Column(name="POLL_ID")
    private Long id;
    // Rename field's column.
    @Column(name="QUESTION")
    @NotEmpty
    private String question;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="POLL_ID")
    @OrderBy
    @Size(min=2, max = 6)
    private Set<Option> options;

    public Long getId() {return this.id;}
    public void setId(Long id) {this.id = id;}

    public String getQuestion() {return this.question;}
    public void setQuestion(String question) {this.question = question;}

    public Set<Option> getOptions() {return this.options;}
    public void setOptions(Set<Option> options) {this.options = options;}

}
