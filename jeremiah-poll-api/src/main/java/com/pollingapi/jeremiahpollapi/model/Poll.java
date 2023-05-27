package com.pollingapi.jeremiahpollapi.model;

import javax.persistence.*;
import java.util.Set;
@Entity
public class Poll {
    @Id // Used to identify
    @GeneratedValue  // Generate numbers when I put new things.
    @Column(name="POLL_ID") // Store it in a column.
    private long id;
    @Column(name="QUESTION")
    private String question;
      @OneToMany(cascade = CascadeType.ALL)  //Any changes will  apply to Option object
      @JoinColumn(name="POLL_ID") // connects column with the same name
      @OrderBy // Organize in a certain order
      private Set<Option> options;

      public Poll() {
      }

    public Poll(long id, String question, Set<Option> options) {
        this.id = id;
        this.question = question;
        this.options = options;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}
