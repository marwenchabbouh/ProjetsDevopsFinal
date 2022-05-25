package com.esprit.examen;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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

		Date dateFin = dateFormat.parse("2022-06-23");
		Session session = new Session();
		session.setDateDebut(new Date());
		session.setDateFin(dateFin);
		session.setDuree(100l);
		session.setDescription("Formation spring boot");
		Long id = sessionService.addSession(session);
		assertEquals(1, id);
	}

	@Test

	public void affectFormateurToSession() {

		sessionService.affecterFormateurASession(2l, 1l);

		Session session = sessionService.getSessionById(1l);
	
		assertNotEquals( "ONS"	, session.getFormateur().getNom());
		

	}
}
