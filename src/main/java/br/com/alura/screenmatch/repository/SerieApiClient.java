package br.com.alura.screenmatch.repository;

import br.com.alura.screenmatch.model.dto.SeasonDTO;
import br.com.alura.screenmatch.model.dto.SerieDTO;
import br.com.alura.screenmatch.service.ApiConsumer;
import br.com.alura.screenmatch.service.DataConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SerieApiClient {

    private static final String ADDRESS_SERIE = "https://www.omdbapi.com/?t=%s&apikey=6585022c";
    private static final String ADDRESS_SEASON = "https://www.omdbapi.com/?t=%s&season=%d&apikey=6585022c";
    private final ApiConsumer apiConsumer;
    private final DataConverter converter;

    public SerieApiClient(ApiConsumer apiConsumer, DataConverter dataConverter){
        this.apiConsumer = apiConsumer;
        this.converter = dataConverter;
    }


    public SerieDTO findSerieInfo(String name) {
        String formattedName = name.replace(" ", "+");
        var json = apiConsumer.getData(String.format(ADDRESS_SERIE, formattedName));
        return converter.getData(json, SerieDTO.class);
    }


    public List<SeasonDTO> findSeasonsInfo(SerieDTO serieDTO) {
        String formattedName = serieDTO.title().replace(" ", "+");
        List<SeasonDTO> seasons = new ArrayList<>();

        for (int i = 1; i <= serieDTO.totalSeasons(); i++) {
            String json = apiConsumer.getData(String.format(ADDRESS_SEASON, formattedName, i));
            SeasonDTO seasonDTO = converter.getData(json, SeasonDTO.class);
            seasons.add(seasonDTO);
        }
        return seasons;
    }
}
