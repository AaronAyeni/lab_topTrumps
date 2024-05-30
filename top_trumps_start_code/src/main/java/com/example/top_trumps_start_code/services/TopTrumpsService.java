package com.example.top_trumps_start_code.services;

import com.example.top_trumps_start_code.models.Card;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TopTrumpsService {

    public String checkWinner(List<Card> cards) {
        if (cards == null || cards.size() != 2) {
            return "Invalid input. Please provide exactly two cards.";
        }

        Card card1 = cards.get(0);
        Card card2 = cards.get(1);

        int card1Value = card1.getCardValue();
        int card2Value = card2.getCardValue();

        if (card1Value > card2Value) {
            return card1.getRank() + "of" + card1.getSuit() + "wins!";
        } else if (card1Value < card2Value) {
            return card2.getRank() + " of " + card2.getSuit() + " wins!";
        } else {
            return "It's a tie!";
        }
    }


}
