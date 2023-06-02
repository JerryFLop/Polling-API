package com.Jermeiahpollingapi.pollingapi.repository;

import com.Jermeiahpollingapi.pollingapi.model.Poll;
import org.springframework.data.repository.CrudRepository;

public interface PollRepository extends CrudRepository<Poll,Long> {
}
