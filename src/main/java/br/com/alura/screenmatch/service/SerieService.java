package br.com.alura.screenmatch.service;

import br.com.alura.screenmatch.model.Serie;
import br.com.alura.screenmatch.model.dto.SeasonDTO;
import br.com.alura.screenmatch.model.dto.SerieDTO;
import br.com.alura.screenmatch.repository.SerieApiClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService {

    private final SerieApiClient serieApiClient;

    public SerieService(SerieApiClient serieApiClient) {
        this.serieApiClient = serieApiClient;
    }

    public Serie findByName(String serieName) {
        SerieDTO serieDTO = serieApiClient.findSerieInfo(serieName);
        List<SeasonDTO> seasonsDTO = serieApiClient.findSeasonsInfo(serieDTO);
        return new Serie(serieDTO, seasonsDTO);
    }

}
