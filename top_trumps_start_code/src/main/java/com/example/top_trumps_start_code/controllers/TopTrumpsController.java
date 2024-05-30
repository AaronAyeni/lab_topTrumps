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

    @PostMapping("/startnewgame")
    public ResponseEntity<String> startNewGame(){
        topTrumpsService.startNewGame();
        return new ResponseEntity<>("New game started.", HttpStatus.OK);
    }

    @PostMapping("/play_a_round")
   public ResponseEntity<String> playRound(){
        List<Card> drawnCards = topTrumpsService.drawTwoCards();
        if (drawnCards == null || drawnCards.size() != 2){
            return new ResponseEntity<>("No cards left to play another round. Restart the game", HttpStatus.BAD_REQUEST);
        }else
        {
        String message = topTrumpsService.checkWinner(drawnCards);
        return new ResponseEntity<>(message, HttpStatus.OK);
        }
    }
}