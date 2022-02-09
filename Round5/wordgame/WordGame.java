import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.IOException;
import java.util.TreeSet;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author Jenna
 */
public class WordGame {
    
    private ArrayList<String> words = new ArrayList<>();
    private int N;
    private WordGameState game;
    private boolean createdGame = false;

    public static class WordGameState {
        private String theWord_;
        private String gameState_;
        private int mistakes_;
        private int maxMistakes_;
        private int unknownLetters_;
        private boolean gameActive_ = false;
        private TreeSet<Character> guessedLetters_ = new TreeSet<>();
        private boolean winning_ = false;
        
        private WordGameState (int index, int mistakeLimit, ArrayList<String> list) {
            theWord_ = list.get(index);
            maxMistakes_ = mistakeLimit;
            gameActive_ = true;
            gameState_ = "_".repeat(theWord_.length());
            unknownLetters_ = theWord_.length();
            
        }
        
        private boolean hasWon() {
            
            int length = 0;
            
            for (int m = 0; m < gameState_.length(); ++m) {
                char x = gameState_.charAt(m);
                
                if (x != '_') {
                    ++length;
                }
            }
            
            if (length == gameState_.length()) {
                winning_ = true;
                gameActive_ = false;
            }
            return gameActive_;
        }
        
        private void guessLetters(char c) {
            Character value = Character.toLowerCase(c);
            
            if (guessedLetters_.contains(value)) {
                mistakes_ += 1;
            } else {
                boolean inWord = false;
                int amount = 0;
            
                for (int n = 0; n < theWord_.length(); ++n) {
                    char letter = theWord_.charAt(n);
                    

                    if (Character.compare(letter, value) == 0) {
                        unknownLetters_ -= 1;
                        String previousWord = gameState_;
                        gameState_ = previousWord.substring(0,n) + letter + 
                                previousWord.substring(n+1);
                        guessedLetters_.add(c);
                        ++amount;
                    } 
                }
                
                if (amount == 0) {
                    mistakes_ += 1;
                }
                
               if ((mistakes_ ) == (maxMistakes_+1)) {
                gameState_ = theWord_;
                } 
                
            } 
        }
        
        private void guessWord (String word) {
            
            String value = word.toLowerCase();
            
            if (value.equals(theWord_)) {
                gameState_ = theWord_;
                gameActive_ = false;
                unknownLetters_ = 0;
                
            } else {
                mistakes_ += 1;
            }
            
            if ((mistakes_ ) == (maxMistakes_+1)) {
                gameState_ = theWord_;
            }
        }
        
        public String getWord() {
            return gameState_;
        }
        
        public int getMistakes() {
            return mistakes_;
        }
        
        public int getMistakeLimit() {
            return maxMistakes_;
        }
        
        public int getMissingChars() {
            return unknownLetters_;
        }
        
        private boolean activeGame () {
            return gameActive_;
        }
        
    }
    
    public WordGame(String wordFilename) throws IOException {
        try (var input = new BufferedReader(new FileReader(wordFilename))) {
            String line = input.readLine();
            
            while (line != null) {
                words.add(line);
                
                line = input.readLine();
            }
        }
        
        N = words.size();
    }
    
    public void initGame(int wordIndex, int mistakeLimit) {
        createdGame = true;
        N = words.size();
        game = new WordGameState((wordIndex % N), mistakeLimit, words);
        
    }
    
    public  boolean isGameActive() {
        boolean state = false;
        
        if (createdGame == true) {
            state = game.activeGame();
        }
        return state;
    }
    
    public WordGameState getGameState() throws GameStateException {
        
        
        if (createdGame == true) {
            boolean gameGoing = game.activeGame();
        
        if (gameGoing == false) {
            throw new GameStateException(String.format("There is currently no "
                    + "active word game!"));
        } else {
            return game;
        }
        } else {
            throw new GameStateException(String.format("There is currently no "
                    + "active word game!"));
        }
    }
    
    public WordGameState guess(char c) throws GameStateException {
        if (createdGame == true) {
            boolean gameGoing = game.activeGame();
        
        if (gameGoing == false) {
            throw new GameStateException(String.format("There is currently no "
                    + "active word game!"));
        } else {
            game.guessLetters(c);
        }
        
        } else {
            throw new GameStateException(String.format("There is currently no "
                    + "active word game!"));
        }
        return game;
    }
    
    public WordGameState guess(String word) throws GameStateException {
        if (createdGame == true) {
            boolean gameGoing = game.activeGame();
        
        if (gameGoing == false) {
            throw new GameStateException(String.format("There is currently no "
                    + "active word game!"));
        } else {
            game.guessWord(word);
        }
        
        } else {
            throw new GameStateException(String.format("There is currently no "
                    + "active word game!"));
        }
        return game;
    }
    
}
