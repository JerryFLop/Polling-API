package com.pollingapi.jeremiahpollapi.controller;

import java.net.URI;
import java.util.Optional;


import com.pollingapi.jeremiahpollapi.exception.ResourceNotFoundException;
import com.pollingapi.jeremiahpollapi.model.Poll;
import com.pollingapi.jeremiahpollapi.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;


@RestController
public class PollController {

    @Autowired
    private PollRepository pollRepository;

   @PostMapping("/polls")
    public ResponseEntity<?> createPoll(@Valid @RequestBody Poll poll) {
        poll = pollRepository.save(poll);

        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPollUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(poll.getId()).toUri();
        responseHeaders.setLocation(newPollUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value="/polls", method=RequestMethod.GET)
    public ResponseEntity<Iterable<Poll>> getAllPolls() {
        Iterable<Poll> allPolls = pollRepository.findAll();
        return new ResponseEntity<>(allPolls, HttpStatus.OK);
    }

    @RequestMapping(value="/polls/{pollId}", method=RequestMethod.GET)
    public ResponseEntity<?> getPoll(@PathVariable Long pollId) {
        verifyPoll(pollId);
       Poll p = pollRepository.findById(pollId).get();
       return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @PutMapping("/polls/{pollId}")
    public ResponseEntity<?> updatePoll(@RequestBody Poll poll, @PathVariable Long pollId) {
        // Save the entity
    verifyPoll(pollId);
    Poll pollToBeUpdate = this.pollRepository.findById(pollId).get();
    pollToBeUpdate.setQuestion(poll.getQuestion());
    pollToBeUpdate.setOptions(pollToBeUpdate.getOptions());
    this.pollRepository.save(pollToBeUpdate);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/polls/{pollId}", method=RequestMethod.DELETE)
    public ResponseEntity<?> deletePoll(@PathVariable Long pollId) {
    verifyPoll(pollId);
        pollRepository.deleteById(pollId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    protected void verifyPoll(Long pollId) throws ResourceNotFoundException {
        if (!(this.pollRepository.existsById(pollId))) {
            throw new ResourceNotFoundException("Poll with id " + pollId + " not found");
        }
    }
}











