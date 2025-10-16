package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.Serie;
import br.com.alura.screenmatch.service.SerieService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

    private final SerieService serieService;
    private final Scanner scanner;

    public ScreenmatchApplication(SerieService serieService) {
        this.serieService = serieService;
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        SpringApplication.run(ScreenmatchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Input the serie fullname");
        String serieName = scanner.nextLine();
        Serie serie = serieService.findByName(serieName);
        System.out.println(serie);

        System.out.println("\n"+ serie.getTopEpisodes(5));

        System.out.println("\n" + serie.getStatistics());


    }
}
