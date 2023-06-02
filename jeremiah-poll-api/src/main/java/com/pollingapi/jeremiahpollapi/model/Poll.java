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


    // Primary key for entity.
    @Id
    // Generate key automatically.
    @GeneratedValue
    // Rename field's column.
    @Column(name = "POLL_ID")
    // Unique number identifier to distinguish `Poll` entities.
    private Long id;

    // Rename field's column.
    @Column(name = "QUESTION")
    /*
    Validation annotation checked by @Valid annotation:
    Ensure that field is not null and that its size is greater than 0.
    */
    @NotEmpty
    // Question that will be voted about.
    private String question;

    /*
    `@OneToMany`...:
    Establish relationship between each single `Poll` entity being associated with many `Option` entities.
    It is unidirectional as `Option` does not declare the relationship, by which `Option` is unaware of the
    relationship, with only `Poll` being aware. Since `Poll` will be worked with directly in a controller, and not
    `Option`, `Poll` is what should maintain and update the relationship to keep everything in sync. Because of all of
    these factors and the @JoinColumn annotation below being here rather than in `Option`, `Poll` is considered the
    owner of the relationship, which is generally not the default behavior, since it represents the "One" side of the
    relationship and generally ownership belongs to the "Many" side.

    ...`CascadeType.All`:
    If a `Poll` is persisted, merged, removed, etc., the same operation will be applied to the associated `Option`
    entities.
    */
    @OneToMany(cascade = CascadeType.ALL)
    /*
    Join column of foreign `Poll ID` keys to `Option`, with which it has a relationship, as `Option` represents "Many",
    which by default, has the column joined to it.
    */
    @JoinColumn(name = "POLL_ID")
    // Order by value field in ascending order.
    @OrderBy
    /*
    Validation annotation checked by @Valid annotation:
    Ensure that field's size is between 2 and 6, inclusively.
    */
    @Size(min=2, max=6)
    // Set chosen because each single `Poll` entity can be related to many `Option` entities, which should be unique.
    private Set<Option> options;


    public Long getId() {return this.id;}
    public void setId(Long id) {this.id = id;}

    public String getQuestion() {return this.question;}
    public void setQuestion(String question) {this.question = question;}

    public Set<Option> getOptions() {return this.options;}
    public void setOptions(Set<Option> options) {this.options = options;}


}

