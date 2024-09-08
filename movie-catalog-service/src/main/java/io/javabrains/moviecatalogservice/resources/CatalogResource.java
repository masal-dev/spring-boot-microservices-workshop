package io.javabrains.moviecatalogservice.resources;

import io.javabrains.moviecatalogservice.models.CatalogItem;
import io.javabrains.moviecatalogservice.models.UserRating;
import io.javabrains.moviecatalogservice.services.MovieInfo;
import io.javabrains.moviecatalogservice.services.UserRatingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {

    @Autowired
    WebClient.Builder webClientBuilder;

    private MovieInfo movieInfo;
    private UserRatingInfo userRatingInfo;

    public CatalogResource(MovieInfo movieInfo, UserRatingInfo userRatingInfo) {
        this.movieInfo = movieInfo;
        this.userRatingInfo = userRatingInfo;
    }

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        UserRating userRating = userRatingInfo.getUserRating(userId);
        return userRating.getRatings().stream()
                .map(rating -> {
                    return movieInfo.getCatalogItem(rating);
                })
                .collect(Collectors.toList());
    }


}

/*
Alternative WebClient way
Movie movie = webClientBuilder.build().get().uri("http://localhost:8082/movies/"+ rating.getMovieId())
.retrieve().bodyToMono(Movie.class).block();
*/