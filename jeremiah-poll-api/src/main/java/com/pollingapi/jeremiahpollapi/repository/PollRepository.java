package com.pollingapi.jeremiahpollapi.repository;

import com.pollingapi.jeremiahpollapi.model.Poll;
import org.springframework.data.repository.CrudRepository;

public interface PollRepository extends CrudRepository<Poll,Long> {



}
