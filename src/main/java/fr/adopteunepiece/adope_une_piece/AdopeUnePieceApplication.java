package fr.adopteunepiece.adope_une_piece;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import fr.adopteunepiece.adope_une_piece.property.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})

public class AdopeUnePieceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdopeUnePieceApplication.class, args);
	}
}
