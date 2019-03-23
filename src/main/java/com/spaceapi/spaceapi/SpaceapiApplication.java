package com.spaceapi.spaceapi;

import com.spaceapi.spaceapi.dao.Capsule;
import com.spaceapi.spaceapi.dao.Company;
import com.spaceapi.spaceapi.dao.Headquarter;
import com.spaceapi.spaceapi.dao.Rocket;
import com.spaceapi.spaceapi.repository.CompaniesRepository;
import com.spaceapi.spaceapi.repository.HeadquartersRepository;
import com.spaceapi.spaceapi.repository.RocketsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class SpaceapiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpaceapiApplication.class, args);
	}

	@Autowired
	private CompaniesRepository companiesRepository;

	@Autowired
	private HeadquartersRepository headquartersRepository;

	@Autowired
	private RocketsRepository rocketsRepository;

	@Override
	public void run(String... args) throws Exception {

		Company company = new Company("SpaceX", "Elon Musk", new Date(), 7500,
				3,2,2, 1, 15000000000L, "SpaceX opis");
		Headquarter headquarter = new Headquarter("Siedziba SpaceX", "Rocket Road", "Hawthorne", "USA");
		company.setHeadquarter(headquarter);
		headquarter.setCompany(company);
		List<Rocket> rocketsSpaceX = new ArrayList<>();
		Rocket falcon1 = new Rocket("Falcon 1", false, 0, 20000000,
				2,4, new Date(), new Timestamp(System.currentTimeMillis()), 1d, 2d, 4d);
		Rocket falcon9 = new Rocket("Falcon 9", false, 0, 40000000,
				67,72, new Date(), new Timestamp(System.currentTimeMillis()), 1d, 2d, 4d);
		List<Capsule> capsulesSpaceX = new ArrayList<>();
		Capsule dragon = new Capsule(true, new Date(), new Timestamp(System.currentTimeMillis()), "Block 1", "Dragon", "Cargo version");
		capsulesSpaceX.add(dragon);
		dragon.setCompanyCapsule(company);
		company.setCapsules(capsulesSpaceX);
		falcon1.setCompany(company);
		falcon9.setCompany(company);
		rocketsSpaceX.add(falcon1);
		rocketsSpaceX.add(falcon9);
		company.setRockets(rocketsSpaceX);


		Company company2 = new Company("Blue Origin", "Jeff Bezos", new Date(), 2000,
				1,1,1, 1, 27000000000L, "Blue Origin opis");
		Headquarter headquarter2 = new Headquarter("Siedziba Blue Origin", "Kent", "Washington", "USA");
		List<Rocket> rocketsBlueOrigin = new ArrayList<>();
		Rocket newShepard = new Rocket("New Shepard", true, 0, 10000000,
				6,6,new Date(), new Timestamp(System.currentTimeMillis()), 1d, 2d, 4d);
		newShepard.setCompany(company2);
		rocketsBlueOrigin.add(newShepard);
		company2.setRockets(rocketsBlueOrigin);
		company2.setHeadquarter(headquarter2);
		headquarter2.setCompany(company2);

		companiesRepository.save(company);
		companiesRepository.save(company2);
	}
}