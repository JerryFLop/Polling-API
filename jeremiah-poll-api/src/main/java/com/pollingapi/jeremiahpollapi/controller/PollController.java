package com.pollingapi.jeremiahpollapi.controller;

import com.pollingapi.jeremiahpollapi.model.Poll;
import com.pollingapi.jeremiahpollapi.repository.PollRepository;
import com.pollingapi.jeremiahpollapi.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PollController {
    @Autowired
    private PollRepository pollRepository;
    @Autowired
    private PollService pollService;

    @GetMapping("/polls")
    public Iterable<Poll> getAllPolls(){
        return pollService.getStudents();
    }

//    public ResponseEntity<Iterable<Poll>> getAllPolls(){
//        Iterable<Poll> allPolls = pollRepository.findAll();
//        return new ResponseEntity<>(pollRepository.findAll(), HttpStatus.OK);

    @PostMapping("/polls")
    public ResponseEntity<?> createPoll(@RequestBody Poll poll){
        poll = pollRepository.save(poll);
        return new ResponseEntity<>(null,HttpStatus.CREATED);
    }



}
