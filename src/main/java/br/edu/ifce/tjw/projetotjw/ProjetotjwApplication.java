package br.edu.ifce.tjw.projetotjw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = { 
	"br.edu.ifce.tjw.projetotjw.controller",
	"br.edu.ifce.tjw.projetotjw.runner" 
})
public class ProjetotjwApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetotjwApplication.class, args);
	}

}
