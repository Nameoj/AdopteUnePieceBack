package fr.adopteunepiece.adope_une_piece;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.adopteunepiece.adope_une_piece.property.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})

public class AdopeUnePieceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdopeUnePieceApplication.class, args);
	}
}
