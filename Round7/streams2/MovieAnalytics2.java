import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Map;
import java.util.List;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author Jenna
 */
public class MovieAnalytics2 {
    private ArrayList<Movie> movies_;

    public MovieAnalytics2() {
        movies_ = new ArrayList<>();
    }
    
    public void populateWithData(String fileName) throws IOException {
        try (var br = new BufferedReader(new FileReader(fileName))) {
            
            List<Movie> movs = br.lines().
                    map(line -> line.split(";")).
                    map(movie -> new Movie(movie[0],Integer.valueOf(movie[1]),
                    Integer.valueOf(movie[2]), movie[3], Double.valueOf(movie[4]),
                    movie[5])).collect(Collectors.toList());
            
            movies_ = new ArrayList<Movie>(movs);
            
        }
    }
    
    public void printCountByDirector(int n) {
        Map<String,Long> movieMap = movies_.stream()
                .collect(Collectors.groupingBy(Movie::getDirector, 
                        Collectors.counting()));
        Stream<Map.Entry<String,Long>> sortedMovies = movieMap.entrySet().stream().
                sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).
                limit(n);
        
        
        sortedMovies.forEach(m -> System.out.println(String.format
        ("%s: %d movies",m.getKey(),m.getValue())));
    }
    
    public void printAverageDurationByGenre() {
        Map<String,Double> movieMap = movies_.stream().
                collect(Collectors.groupingBy(Movie::getGenre, 
                        Collectors.averagingInt(Movie::getDuration)));
        Stream<Map.Entry<String,Double>> sortedGenres = movieMap.entrySet().
                stream().sorted(Map.Entry.comparingByKey()).
                sorted(Map.Entry.comparingByValue());
        
        sortedGenres.forEach(m -> System.out.println(String.format
        ("%s: %.2f ", m.getKey(),m.getValue())));
    }
    
    public void printAverageScoreByGenre() {
        Map<String, Double> movieMap = movies_.stream().
                collect(Collectors.groupingBy(Movie::getGenre, 
                        Collectors.averagingDouble(Movie::getScore)));
        Stream<Map.Entry<String,Double>> sortedGenres = movieMap.entrySet().
                stream().sorted(Map.Entry.comparingByKey()).
                sorted(Collections.reverseOrder(Map.Entry.comparingByValue()));
        
        sortedGenres.forEach(m -> System.out.println(String.format
        ("%s: %.2f ", m.getKey(),m.getValue())));
    }
    
}
