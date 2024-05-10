package com.perfumery.perfumerywebapp;

import com.perfumery.perfumerywebapp.repositories.PerfumeRepository;
import com.perfumery.perfumerywebapp.services.impl.DatabaseInitializerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class PerfumeryWebApplication {

	//perfume perfumery

	public static void main(String[] args) {
		SpringApplication.run(PerfumeryWebApplication.class, args);
	}

	private final DatabaseInitializerService databaseInitializerService;
	private final PerfumeRepository perfumeRepository;

	@EventListener
	void initializeDatabase(ContextRefreshedEvent event) {
		if (perfumeRepository.count() == 0) {
			log.info("Initialize database!");
			databaseInitializerService.populateDB();
			log.info("Database initialized!");
		}
	}
}
