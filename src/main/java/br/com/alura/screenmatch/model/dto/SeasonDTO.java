package br.com.alura.screenmatch.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SeasonDTO(
        @JsonAlias("Title") String title,
        @JsonAlias("Season") String season,
        @JsonAlias("Episodes") List<EpisodeDTO> episodes
){
}
