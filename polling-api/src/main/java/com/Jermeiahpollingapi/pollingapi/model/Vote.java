package com.Jermeiahpollingapi.pollingapi.model;

import javax.persistence.*;

@Entity
public class Vote {
    // Primary key for entity.
    @Id
    // Generate key automatically.
    @GeneratedValue
    // Rename field's column to "VOTE_ID".
    @Column(name = "VOTE_ID")
    // Unique number identifier to distinguish `Poll` entities.
    private Long id;

    /*
    `@ManyToOne`...:
    Establish relationship between each single `Option` entity being associated with many `Vote` entities. It is unidirectional as `Option` does not declare the relationship, by which
    `Option` is unaware of the relationship, with only `Vote` being aware. Since `Vote` will be worked with directly in a controller, and not `Option`, `Vote` is what should maintain
    and update the relationship to keep everything in sync. Because of all of these factors and the @JoinColumn annotation below being here rather than in `Option`, `Vote` is
    considered the owner of the relationship, which is generally the default behavior, since it represents the "Many" side of the relationship.
    */
    @ManyToOne
    // Join column of foreign `Option ID` keys to `Vote`, with which it has a relationship, as `Vote` represents "Many", which by default, has the column joined to it.
    @JoinColumn(name = "OPTION_ID")
    // The `Option` entity that a `Vote` entity will be associated with.
    private Option option;


    public Long getId() {return this.id;}
    public void setId(Long id) {this.id = id;}

    public Option getOption() {return this.option;}
    public void setOption(Option option) {this.option = option;}


}

