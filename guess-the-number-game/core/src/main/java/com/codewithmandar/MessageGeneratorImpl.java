package com.codewithmandar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator{

    private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    @Autowired
    private Game game;
    private int guessCount = 6;

    @PostConstruct
    public void init(){
        log.debug("Game = {} ",game);
    }

    @Override
    public String getMainMessage() {
        return "Number is between " +
                game.getSmallest() +
                " and "+
                game.getBiggest();
    }

    @Override
    public String getResultMessage() {
        if(game.isGameWon()){
            return "You guessed it! The number was " + game.getNumber();
        }else if(game.isGameLost()){
            return "You lost. The number was " + game.getNumber();
        }else if(!game.isValidNumberRange()){
            return "Invalid number range";
        } else if (game.getRemainingGuesses() == guessCount) {
            return "What is your First Guess ? ";
        }else {
            String direction = "Lower";

            if(game.getGuess() < game.getNumber()){
                direction = "Higher";
            }
            return direction + "!You have " + game.getRemainingGuesses() + " guess left ";
        }

    }
}
