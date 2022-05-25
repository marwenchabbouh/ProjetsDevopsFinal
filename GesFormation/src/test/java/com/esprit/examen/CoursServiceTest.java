package com.esprit.examen;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Cours;
import com.esprit.examen.entities.Session;
import com.esprit.examen.entities.TypeCours;
import com.esprit.examen.repositories.CoursRepository;
import com.esprit.examen.services.ICoursService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CoursServiceTest {

	@Autowired
	private ICoursService coursService;

	@Test
	public void createTest() {
		Cours cours = new Cours();
		cours.setDescription("Cours");
		cours.setIntitule("Java");
		cours.setTypeCours(TypeCours.Informatique);

		Long id = coursService.addCours(cours);
		assertThat(id).isNotNull();
	}

	@Test
	public void affectSessionToCours() {

		coursService.affecterCoursASession(1l, 1l);
		Set<Session> sessions = coursService.getCours().get(0).getSessions();
		assertThat(sessions).size().isGreaterThanOrEqualTo(1);
	}

}
