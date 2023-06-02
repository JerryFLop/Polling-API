package com.Jermeiahpollingapi.pollingapi.controller;

import com.Jermeiahpollingapi.pollingapi.dto.OptionCount;
import com.Jermeiahpollingapi.pollingapi.dto.VoteResult;
import com.Jermeiahpollingapi.pollingapi.model.Vote;
import com.Jermeiahpollingapi.pollingapi.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@RestController
public class ComputeResultController {
    @Autowired
    private VoteRepository voteRepository;


    @GetMapping("/computeresult")
    public ResponseEntity<?> computeResult(@RequestParam Long pollId) {
        VoteResult voteResult = new VoteResult();
        Iterable<Vote> allVotes = this.voteRepository.findByPoll(pollId);

        int totalVotes = 0;
        Map<Long, OptionCount> results = new HashMap<>();
        for (Vote vote : allVotes) {
            totalVotes++;
            OptionCount optionCount = results.get(vote.getOption().getId());
            if (optionCount == null) {
                optionCount = new OptionCount();
                optionCount.setOptionId(vote.getOption().getId());
                results.put(vote.getOption().getId(), optionCount);
            }
            optionCount.setCount(optionCount.getCount() + 1);
        }

        voteResult.setTotalVotes(totalVotes);
        voteResult.setResults(results.values());

        return (new ResponseEntity<VoteResult>(voteResult, HttpStatus.OK));
    }

}
