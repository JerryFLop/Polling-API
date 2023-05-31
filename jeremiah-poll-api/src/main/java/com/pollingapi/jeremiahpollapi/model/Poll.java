package com.pollingapi.jeremiahpollapi.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.NotFound;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity
public class Poll {

    @Id// Used to identify
    @GeneratedValue// Generate numbers when I put new things.
    @Column(name="POLL_ID")// Store it in a column.
    private Long id;

    @Column(name="QUESTION")
    private String question;

    @OneToMany(cascade=CascadeType.ALL)//Any changes will  apply to Option object
    @JoinColumn(name="POLL_ID")// connects column with the same name
    @OrderBy // Organize in a certain order
    private Set<Option> options;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public Set<Option> getOptions() {
        return options;
    }
    public void setOptions(Set<Option> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return getId() + ", " + getQuestion() + ", " + getOptions();
    }

}

