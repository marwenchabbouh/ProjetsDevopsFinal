package com.esprit.examen;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
import com.esprit.examen.services.CoursService;
import com.esprit.examen.services.ICoursService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CoursServiceTest {

	@Autowired
	private ICoursService coursService;
	
//public Cours(Long id, String description, TypeCours typeCours, String intitule)
	
	
	@Test
	public void createTest() {
		Cours cours = new Cours("Cours1",TypeCours.Informatique,"Java");
		//cours.setDescription("Cours");
		//cours.setIntitule("Java");
		//cours.setTypeCours(TypeCours.Informatique);

		Long id = coursService.addCours(cours);
		assertThat(id).isNotNull();
	}
	
	@Test
	public void updateSessionTest() {
		//Cours ca = coursService.getCoursByIdgt(5l);

		Cours cours = new Cours( 5l ,"Cours1333",TypeCours.Informatique,"Javaaaa");
		Long id = coursService.modifierCours(cours);
		Cours c = coursService.getCoursByIdgt(id);
		//assertNotEquals(c.getDescription(),ca.getDescription());
		assertThat(c).isNotNull();
		
	}
	
	/*@Test
	public void Delete() {
		 coursService.supprimerCours(6l);
		Cours cours = coursService.getCoursByIdgt(6l);
		assertNull(cours);
	}*/
	
	

	/*@Test
	public void affectSessionToCours() {

		coursService.affecterCoursASession(5l, 5l);
		Set<Session> sessions = coursService.getCours().get(0).getSessions();
		assertThat(sessions).size().isGreaterThanOrEqualTo(1);
	}*/

}
