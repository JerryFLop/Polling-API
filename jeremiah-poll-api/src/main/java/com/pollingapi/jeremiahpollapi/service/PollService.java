package com.pollingapi.jeremiahpollapi.service;

import com.pollingapi.jeremiahpollapi.exception.ResourceNotFoundException;
import com.pollingapi.jeremiahpollapi.model.Poll;
import com.pollingapi.jeremiahpollapi.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PollService {
    @Autowired
    private PollRepository pollRepository;

    public Iterable<Poll> getAllPoll(){return pollRepository.findAll();}


    public void createPoll(Poll poll){
        pollRepository.save(poll);
    }
    public void updatePoll(Poll poll,Long pollId){
verifyPoll(pollId);
        pollRepository.save(poll);

    }
    public void deletePoll(Long pollId){
        verifyPoll(pollId);
        pollRepository.deleteById(pollId);
    }

      public Optional<Poll>getPollId(Long pollId){
        verifyPoll(pollId);
          return pollRepository.findById(pollId);
    }

        protected void verifyPoll(Long pollId)throws ResourceNotFoundException{
        if(pollRepository.findById(pollId).isEmpty()){
            throw new ResourceNotFoundException("Poll with id" + pollId + " not found" );}
        }


}
