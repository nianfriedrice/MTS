package model;

import controller.DatabaseConnector;

import java.util.ArrayList;

/**
 * Created by NortonWEI on 3/3/2017.
 */
public class Movie {
    private int movieId = 0;
    private String name = "";
    private String imageUrl = "";
    private String description = "";
    private String language = "";
    private boolean if3D = false;
    private int length = 0;
    private String category = "";
    private String director = "";
    private String starring = "";
    private String releaseDate = "";
    private String offDate = "";
    private float score = 0;

    public Movie(String name, String imageUrl, String description, String language, boolean if3D, int length, String category, String director, String starring, String releaseDate, String offDate) {
        setId();
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
        this.language = language;
        this.if3D = if3D;
        this.length = length;
        this.category = category;
        this.director = director;
        this.starring = starring;
        this.releaseDate = releaseDate;
        this.offDate = offDate;
    }

    public Movie(int movieId, String name, String imageUrl, String description, String language, boolean if3D, int length, String category, String director, String starring, String releaseDate, String offDate, float score) {
        this.movieId = movieId;
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
        this.language = language;
        this.if3D = if3D;
        this.length = length;
        this.category = category;
        this.director = director;
        this.starring = starring;
        this.releaseDate = releaseDate;
        this.offDate = offDate;
        this.score = score;
    }

    private void setId() {
        boolean ifBreak = false;
        DatabaseConnector databaseConnector = new DatabaseConnector();
        ArrayList<Integer> movieIdList = databaseConnector.listId("MOVIE");
        for (int i=0; i<movieIdList.size(); i++) {
            if (movieIdList.get(i) != i) {
                movieId = i;
                ifBreak = true;
                break;
            }
        }
        if (!ifBreak) {
            if (!movieIdList.isEmpty()) {
                movieId = movieIdList.get(movieIdList.size()-1) + 1;
            }
        }
    }

    public int getMovieId() {
        return movieId;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public String getLanguage() {
        return language;
    }

    public boolean isIf3D() {
        return if3D;
    }

    public int getLength() {
        return length;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public String getStarring() {
        return starring;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getOffDate() {
        return offDate;
    }

    public float getScore() {
        return score;
    }
    
<<<<<<< HEAD
    public void setImageUrl(String url) {
=======
    public void setImageUrl(String url){
>>>>>>> refs/remotes/origin/rachel
        imageUrl = url;
    }
}
