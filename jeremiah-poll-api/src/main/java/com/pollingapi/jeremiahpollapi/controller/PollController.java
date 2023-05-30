package com.pollingapi.jeremiahpollapi.controller;

import com.pollingapi.jeremiahpollapi.model.Poll;

import com.pollingapi.jeremiahpollapi.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
public class PollController {
    @Autowired
    private PollService pollService;

    @GetMapping("/polls")
    public Iterable<Poll> getAllPolls(){
        return pollService.getAllPoll();
    }


    @PostMapping("/polls")
    public void createPoll( @RequestBody Poll poll) {
        pollService.createPoll(poll);

    }
    @DeleteMapping("/polls/{pollId}")
    public void deletePoll(@PathVariable Long pollId){

        pollService.deletePoll(pollId);

    }
    @PutMapping("/polls/{pollId}")
    public void updatePoll(@PathVariable Long pollId , @RequestBody Poll poll){
         //save the entity
        pollService.updatePoll(poll,pollId);

    }

    @GetMapping( "/polls/{pollId}")
    public Optional<Poll>getPollById(@PathVariable Long pollId)  {
        return pollService.getPollId(pollId);




    }


    }










