package com.esprit.examen;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Session;
import com.esprit.examen.services.ISessionService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SessionServiceTest {
	

	@Autowired
	private ISessionService sessionService;
	
	
	@Test
	public void createSession() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Date dateDebut = dateFormat.parse("2021-05-15");
		Date dateFin = dateFormat.parse("2021-05-18");

		Session session = new Session();
		session.setDateDebut(dateDebut);
		session.setDateFin(dateFin);
		session.setDuree(100l);
		session.setDescription("Test et spring");
		Long id = sessionService.addSession(session);
		//assertEquals(15, id);
		assertThat(id).isNotNull();
	}
/*	
	@Test
	public void deleteSession() {
		sessionService.supprimerSession(14l);
		Session s = sessionService.getSessionById(14l);
				assertTrue(s == null);
		
	}
*/
	@Test

	public void affectFormateurToSession() {

		sessionService.affecterFormateurASession(8l, 8l);

		Session session = sessionService.getSessionById(8l);
	
		assertEquals( "trabelsi"	, session.getFormateur().getNom());
		

	}
	//	public Session(Long id, Date dateDebut, Date dateFin, Long duree, String description) 

	@Test
	public void modifierSession () throws ParseException {
		Session k = sessionService.getSessionById(5l);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Session session = new Session(5l,dateFormat.parse("2021-05-15"),dateFormat.parse("2021-05-15"),114l,"loooooool");
		long id = sessionService.modifierSession(session);
		Session s = sessionService.getSessionById(id)	;
		assertEquals(k.getDuree(), s.getDuree());
	}
}
