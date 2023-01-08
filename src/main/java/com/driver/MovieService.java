package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository mr;
    String addMovieService(Movie m){
        String res=mr.addMovieToDb(m);
        return res;
    }

    String addDirectorService(Director d){
        return mr.addDirectorToDb(d);
    }

    Movie getMovieByNameService(String name){
        return mr.getMovieByNameFromDb(name);
    }

    Director getDirectorByNameService(String name){
        return mr.getDirectorByNameFromDb(name);
    }
    List<String> findAllMoviesService(){
        return mr.findAllMoviesFromDb();
    }

    String addMovieDirectorPairService(String directorName,String movieName){
    return mr.addMovieDirectorPairToDb(directorName,movieName);
    }
    List<String> getMoviesByDirectornameService(String name){
    return mr.getMoviesByDirectorNameFromDb(name);
    }

    String deleteAllDirectorsService(){
        return mr.deleteAllDirectorsFromDb();
    }
    String deleteDirectorByNameService(String name){
        return mr.deleteDirectorByNameFromDb(name);
    }

        public String getDirectorByMovieName(String name){
           return mr.getDirectorByMovieName(name);
        }
}
