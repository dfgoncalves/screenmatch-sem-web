package br.com.alura.screenmatch.model;

import br.com.alura.screenmatch.model.dto.SeasonDTO;
import br.com.alura.screenmatch.model.dto.SerieDTO;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Serie {

    private String title;
    private LocalDate year;
    private String genre;
    private String language;
    private Double rating;
    private Long votes;
    private Integer totalSeasons;
    private List<Season> seasons;

    public Serie(SerieDTO serieDTO, List<SeasonDTO> seasonsDTO) {
        this.title = serieDTO.title();
        this.genre = serieDTO.genre();
        this.language = serieDTO.language();
        try {
            this.year = LocalDate.parse(serieDTO.year());
        } catch (RuntimeException e) {
            this.year = null;
        }
        try {
            this.rating = Double.valueOf(serieDTO.rating());
        } catch (NumberFormatException e) {
            this.rating = 0.0;
        }
        try {
            this.votes = Long.valueOf(serieDTO.votes());
        } catch (NumberFormatException e) {
            this.votes = 0L;
        }
        this.totalSeasons = serieDTO.totalSeasons();
        this.seasons = new ArrayList<>();
        seasonsDTO.forEach(s -> seasons.add(new Season(s)));
    }

    @Override
    public String toString() {
        return "Serie{" +
                "\n\ttitle='" + title + '\'' +
                "\n\t year=" + year +
                "\n\t genre='" + genre + '\'' +
                "\n\t language='" + language + '\'' +
                "\n\t rating=" + rating +
                "\n\t votes=" + votes +
                "\n\t totalSeasons=" + totalSeasons +
                "\n\t seasons=" + seasons +
                "\n}";
    }

    public List<Episode> getTopEpisodes(Integer amount) {
        List<Episode> episodes = new ArrayList<>();
        episodes = this.seasons.stream()
                .flatMap(s -> s.getEpisodes().stream())
                .sorted(Comparator.comparing(Episode::getRating).reversed())
                .limit(amount)
                .collect(Collectors.toList());
        return episodes;
    }

    public List<Episode> getEpisodeByTitle(String title) {
        List<Episode> episodes = this.seasons.stream()
                .flatMap(s -> s.getEpisodes().stream())
                .filter(e -> e.getTitle().toLowerCase().contains(title))
                .collect(Collectors.toList());
        return episodes;
    }

    public List<Episode> getEpisodeByYear(Integer year) {
//        LocalDate dataBusca = LocalDate.of(ano, 1, 1);
//        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//
//        episodios.stream()
//                .filter(e -> e.getDataLancamento() != null && e.getDataLancamento().isAfter(dataBusca))
//                .forEach(e -> System.out.println(
//                        "Temporada: " + e.getTemporada() +
//                                " Episódio: " + e.getTitulo() +
//                                " Data lançamento: " + e.getDataLancamento()
//
//                ));

        return null;
    }

    public Season getBestSeason() {
        //        Map<Integer, Double> avaliacoesPorTemporada = episodios.stream()
//                .filter(e -> e.getAvaliacao() > 0.0)
//                .collect(Collectors.groupingBy(Episodio::getTemporada, Collectors.averagingDouble(Episodio::getAvaliacao)));
//        System.out.println(avaliacoesPorTemporada);
        return null;
    }

    public DoubleSummaryStatistics getStatistics() {
        return this.seasons.stream()
                .flatMap(s -> s.getEpisodes().stream())
                .filter(e -> e.getRating() > 0)
                .collect(Collectors.summarizingDouble(Episode::getRating));
    }

}
