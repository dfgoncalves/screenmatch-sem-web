package br.com.alura.screenmatch.model;

import br.com.alura.screenmatch.model.dto.EpisodeDTO;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Episode {

    private String title;
    private Integer number;
    private Double rating;
    private LocalDate released;

    public Episode(EpisodeDTO dto) {
        this.title = dto.title();
        this.number = dto.number();

        try{
            this.rating = Double.valueOf(dto.rating());
        } catch (NumberFormatException e) {
            this.rating = 0.0;
        }
        try{
            this.released = LocalDate.parse(dto.released());
        } catch (DateTimeParseException ex){
            this.released = null;
        }
    }

    @Override
    public String toString() {
        return "Episode{" +
                "title='" + title + '\'' +
                ", number=" + number +
                ", rating='" + rating + '\'' +
                ", released='" + released + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public Integer getNumber() {
        return number;
    }

    public Double getRating() {
        return rating;
    }

    public LocalDate getReleased() {
        return released;
    }
}
