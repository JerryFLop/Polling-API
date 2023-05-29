package com.pollingapi.jeremiahpollapi.service;

import com.pollingapi.jeremiahpollapi.model.Poll;
import com.pollingapi.jeremiahpollapi.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PollService {
    @Autowired
    private PollRepository pollRepository;

    public Iterable<Poll> getStudents(){return pollRepository.findAll(); }
}
