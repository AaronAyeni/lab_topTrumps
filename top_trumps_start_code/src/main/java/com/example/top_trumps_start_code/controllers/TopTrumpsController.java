package com.example.top_trumps_start_code.controllers;

import com.example.top_trumps_start_code.models.Card;
import com.example.top_trumps_start_code.services.TopTrumpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
@RequestMapping("/toptrumps")
public class TopTrumpsController {

    @Autowired
    TopTrumpsService topTrumpsService;

    @PostMapping("/compare")
   public ResponseEntity<String> checkWinner(@RequestBody List<Card> cards){
        String message = topTrumpsService.checkWinner(cards);
        return new ResponseEntity<>(message, HttpStatus.OK);

    }
}