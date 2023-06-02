package com.Jermeiahpollingapi.pollingapi.service;

import com.Jermeiahpollingapi.pollingapi.exception.ResourceNotFoundException;
import com.Jermeiahpollingapi.pollingapi.model.Poll;
import com.Jermeiahpollingapi.pollingapi.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PollService {
    @Autowired
    private PollRepository pollRepository;

    private void verifyPoll(Long pollId) throws ResourceNotFoundException {
        if (!(pollRepository.existsById(pollId))) {
            throw (new ResourceNotFoundException("Poll with ID " + pollId + " Not Found"));
        }
    }

    public Iterable<Poll> getAllPolls() {return pollRepository.findAll();}

    // Look for an existing `Poll` using its ID and return it if found
    public Poll getPoll(Long pollId) {
        verifyPoll(pollId);

        return pollRepository.findById(pollId).get();
    }

    // Create a new `Poll`, save it in pollRepository`, and return the created `Poll`
    public Poll createPoll(Poll poll) { // Save new `Poll` in `this.pollRepository`
        return pollRepository.save(poll);
    }

    // Look for an existing `Poll` using its ID, and if found, update with new field values provided and save it in `this.pollRepository`
    public void updatePoll(Long pollId, Poll poll) {
        verifyPoll(pollId);

        Poll pollToBeUpdated = pollRepository.findById(pollId).get();
        pollToBeUpdated.setQuestion(poll.getQuestion());
        pollToBeUpdated.setOptions(poll.getOptions());
        pollRepository.save(pollToBeUpdated);
    }

    // Look for an existing `Poll` using its ID and delete it from pollRepository` if found
    public void delete(Long pollId) {
        verifyPoll(pollId);

        pollRepository.deleteById(pollId);
    }



}
