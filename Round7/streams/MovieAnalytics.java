import java.io.BufferedReader;
import java.io.FileReader;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.Collections;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author Jenna
 */
public class MovieAnalytics {
    private ArrayList<Movie> movies_;
    
    public MovieAnalytics() {
        movies_ = new ArrayList<>();
    }
    
    public static Consumer<Movie> showInfo() {
        Consumer<Movie> aMovie = (Movie x) -> {
            System.out.format("%s (By %s, %d)%n", x.getTitle(),x.getDirector(),
                    x.getReleaseYear());
            
        };
        return aMovie;
    }
    
    public void populateWithData(String fileName) throws IOException {
        try (var input = new BufferedReader(new FileReader(fileName))) {
            String line = input.readLine();
            
            while (line != null) {
                String[] parts = line.split(";");
                
                String title = parts[0];
                int releaseYear = Integer.valueOf(parts[1]);
                int duration = Integer.valueOf(parts[2]);
                String genre = parts[3];
                Double score = Double.valueOf(parts[4]);
                String director = parts[5];
                
                Movie x = new Movie(title, releaseYear, duration, genre, score,
                director);
                
                movies_.add(x);
                
                line = input.readLine();
            }
        }
    }
    
    public Stream<Movie> moviesAfter(int year) {
        Stream<Movie> movieStream = movies_.stream().
                filter(m -> m.getReleaseYear() >= year).
                sorted(Comparator.comparingInt(Movie::getReleaseYear)).
                sorted(Comparator.comparing(Movie::getTitle));
        
        return movieStream;
    }

    public Stream<Movie> moviesBefore(int year) {
        Stream<Movie> movieStream = movies_.stream().
                filter(m -> m.getReleaseYear() <= year).
                sorted(Comparator.comparingInt(Movie::getReleaseYear)).
                sorted(Comparator.comparing(Movie::getTitle));
        
        return movieStream;
    }
    
    public Stream<Movie> moviesBetween(int yearA, int yearB) {
        Stream<Movie> movieStream = movies_.stream().
                filter(m -> m.getReleaseYear() >= yearA && 
                        m.getReleaseYear() <= yearB).
                sorted(Comparator.comparingInt(Movie::getReleaseYear)).
                sorted(Comparator.comparing(Movie::getTitle));
        
        return movieStream;
    }
    
    public Stream<Movie> moviesByDirector(String director) {
        Stream<Movie> movieStream = movies_.stream().
                filter(m -> m.getDirector().equals(director)).
                sorted(Comparator.comparingInt(Movie::getReleaseYear)).
                sorted(Comparator.comparing(Movie::getTitle));
        
        return movieStream;
    }
}
