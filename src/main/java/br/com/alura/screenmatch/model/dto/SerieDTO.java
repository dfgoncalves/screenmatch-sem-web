package br.com.alura.screenmatch.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SerieDTO(
        @JsonAlias("Title") String title,
        @JsonAlias("Year") String year,
        @JsonAlias("Genre") String genre,
        @JsonAlias("Language") String language,
        @JsonAlias("imdbRating") String rating,
        @JsonAlias("imdbVotes") String votes,
        @JsonAlias("totalSeasons") int totalSeasons) {
}

