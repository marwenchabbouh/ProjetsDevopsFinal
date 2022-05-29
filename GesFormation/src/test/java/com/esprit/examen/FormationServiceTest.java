package com.esprit.examen;

import static org.assertj.core.api.Assertions.assertThat;



import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Contrat;
import com.esprit.examen.entities.Formateur;
import com.esprit.examen.entities.Poste;
import com.esprit.examen.entities.TypeCours;
import com.esprit.examen.services.IFormateurService;



import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class FormationServiceTest {

	@Autowired
	private IFormateurService formateurService;

	@Test
	public void addFormateur() {
		Formateur formateur = new Formateur("trabelsi", "nawres",Poste.Ingénieur, Contrat.EXPERT,
				"Marwen.chabbouh@gmail.com", "123", false, null);

		Long id = formateurService.addFormateur(formateur);
		assertThat(id).isNotEqualTo(5);
		log.info("add succuss");
	}

	@Test
	public void listFormateurs() {

		List<Formateur> formateurs = formateurService.listFormateurs();
		assertThat(formateurs).size().isNotNull();
		

	}

	@Test
	public void nbrFormateur() {
		Long number = formateurService.nombreFormateursImpliquesDansUnCours(TypeCours.Scrum);

		assertEquals(0, number);

	}

	@Test
	public void updateFormateur() {
		Formateur k = formateurService.getFormateurById(5l);

		Formateur formateur = new Formateur(5l, "hameli", "Basma", Poste.Technicien, Contrat.EXPERT,
				"bengmrabasma@gmail.com", "123");

		Long id = formateurService.modifierFormateur(formateur);
		Formateur f = formateurService.getFormateurById(id);


		assertEquals(k.getNom(), f.getNom());

	}

	/*@Test
	public void deleteFormateur() {
		

		formateurService.supprimerFormateur(12l);

		Formateur f = formateurService.getFormateurById(12l);

		assertTrue(f == null);

		log.info("Test Delete success" );	
		


	}*/

}
