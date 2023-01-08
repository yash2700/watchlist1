package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

    HashMap<String, Movie> movieDb = new HashMap<>();

    HashMap<String, Director> directorDb = new HashMap<>();

    HashMap<String, List<String>> movieDirectorPairDb = new HashMap<>();

    public String addMovieToDb(Movie movie){

        movieDb.put(movie.getName(), movie);

        return "success";
    }

    public String addDirectorToDb(Director director){

        directorDb.put(director.getName(), director);

        return "success";
    }

    public String addMovieDirectorPairToDb(String movie, String director){

        if(movieDirectorPairDb.containsKey(director)){
            movieDirectorPairDb.get(director).add(movie);
        } else{
            movieDirectorPairDb.put(director, new ArrayList<>());
            movieDirectorPairDb.get(director).add(movie);
        }
        return "success";
    }

    public Movie getMovieByNameFromDb(String name){
        if(movieDb.containsKey(name)){
            return movieDb.get(name);
        }
        return null;
    }

    public Director getDirectorByNameFromDb(String name){
        if(directorDb.containsKey(name)){
            return directorDb.get(name);
        }
        return null;
    }
    public String getDirectorByMovieName(String name){
        for(String directorName:movieDirectorPairDb.keySet()){
            List<String> res=movieDirectorPairDb.get(directorName);
            for(String i:res)
                if(i.equals(name)) return directorName;
        }
        return null;
    }
    public List<String> getMoviesByDirectorNameFromDb(String director){
        return movieDirectorPairDb.getOrDefault(director, null);
    }

    public List<String> findAllMoviesFromDb(){
        List<String> list = new ArrayList<>();

        for(String s : movieDb.keySet()){
            list.add(s);
        }
        return list;
    }

    public String deleteDirectorByNameFromDb(String director){
        if(directorDb.containsKey(director)){
            if(movieDirectorPairDb.containsKey(director)){
                List<String> l = movieDirectorPairDb.get(director);
                for(String s : l){
                    movieDb.remove(s);
                }
                movieDirectorPairDb.remove(director);
            }
            directorDb.remove(director);
        }
        return "success";
    }

    public String deleteAllDirectorsFromDb(){
        for(String director : directorDb.keySet()){
            if(movieDirectorPairDb.containsKey(director)){
                List<String> list = movieDirectorPairDb.get(director);

                for(String m : list){
                    movieDb.remove(m);
                }
                movieDirectorPairDb.remove(director);
            }
            directorDb.remove(director);
        }
        return "success";
    }
}