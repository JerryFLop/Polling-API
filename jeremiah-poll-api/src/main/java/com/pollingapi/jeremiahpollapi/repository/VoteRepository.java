package com.pollingapi.jeremiahpollapi.repository;

import com.pollingapi.jeremiahpollapi.model.Vote;
import org.springframework.data.repository.CrudRepository;

public interface VoteRepository extends CrudRepository<Vote,Long> {

}
