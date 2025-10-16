package br.com.alura.screenmatch.model;

import br.com.alura.screenmatch.model.dto.EpisodeDTO;
import br.com.alura.screenmatch.model.dto.SeasonDTO;

import java.util.ArrayList;
import java.util.List;

public class Season {
    private String title;
    private Integer season;
    private List<Episode> episodes;

    public Season(SeasonDTO dto) {
        this.title = dto.title();
        try {
            this.season = Integer.valueOf(dto.season());
        } catch (NumberFormatException e) {
            this.season = 0;
        }
        this.episodes = new ArrayList<>();
        dto.episodes().forEach(e -> episodes.add(new Episode(e)));
    }

    @Override
    public String toString() {
        return "\n\t\tSeason{" +
                "title='" + title + '\'' +
                ", season=" + season +
                ", episodes=" + episodes +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public Integer getSeason() {
        return season;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }
}