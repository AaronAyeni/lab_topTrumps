package com.example.top_trumps_start_code.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        Suit[] suits = Suit.values();
        Rank[] ranks = Rank.values();
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                this.cards.add(new Card(ranks[j], suits[i]));
            }
        }
        Collections.shuffle(this.cards);
    }

    public List<Card> getCards() {
        return cards;
    }

    public List<Card> drawCards(int count) {
        // Check if there are fewer cards in the deck than the requested count
        if (cards.size() < count) {
            // If not enough cards, return an empty list
            return new ArrayList<>();
        }
        // Create a list to hold the drawn cards
        List<Card> drawnCards = new ArrayList<>();

        //copy the first 'count' cards from the deck to the drawnCards list
        for (int i = 0; i < count; i++) {
            drawnCards.add(cards.get(i));
        }

        // Remove the drawn cards from the deck using a loop
        for (int i = 0; i < count; i++) {
            cards.remove(0); // Remove the first card in the list repeatedly
        }

        // Return the list of drawn cards
        return drawnCards;
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
}
