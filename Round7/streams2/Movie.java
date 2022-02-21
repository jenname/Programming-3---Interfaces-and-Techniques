import java.util.List;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author Jenna
 */
public class Movie {
    private String title_;
    private int year_;
    private int duration_;
    private String genre_;
    private double score_;
    private String direc_;

    public Movie(String title, int releaseYear, int duration, String genre, 
            double score, String director) {
        title_ = title;
        year_ = releaseYear;
        duration_ = duration;
        genre_ = genre;
        score_ = score;
        direc_ = director;
        
    }
    
    public String getTitle() {
        return title_;
    }
    
    public int getReleaseYear() {
        return year_;
    }
    
    public int getDuration() {
        return duration_;
    }
    
    public String getGenre() {
        return genre_;
    }
    
    public double getScore() {
        return score_;
    }
    
    public String getDirector() {
        return direc_;
    }
}
