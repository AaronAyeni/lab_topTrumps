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
        if (cards.size() < count) {
            return new ArrayList<>();
        }
        List<Card> drawnCards = new ArrayList<>(cards.subList(0, count));
        cards.removeAll(drawnCards);
        return drawnCards;
    }
    public boolean isEmpty() {
        return cards.isEmpty();
    }
}
