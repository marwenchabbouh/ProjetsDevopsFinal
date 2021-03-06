package com.esprit.examen.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esprit.examen.entities.Session;
import com.esprit.examen.repositories.SessionRepository;

@Service
public class SessionService implements ISessionService{

	@Autowired
	SessionRepository sessionRepository;
	@Override
	public Long addSession(Session session) {
		sessionRepository.save(session);
		return session.getId();
	}

	@Override
	public Long modifierSession(Session session) {
		sessionRepository.save(session);
		return session.getId();
	}

	@Override
	public void supprimerSession(Long sessionId) {
		sessionRepository.deleteById(sessionId);
	}

	@Override
	public void affecterFormateurASession(Long formateurId, Long sessionId) {
			
		
		
		//Session session = sessionRepository.findById(sessionId).orElse(null);
		//Formateur formateur = new Formateur();
		//formateur.setId(formateurId);
		//session.setFormateur(formateur);
		
		//sessionRepository.save(session);
		
	}

	@Override
	public Session getSessionById(Long sessionId) {
		// TODO Auto-generated method stub
		return sessionRepository.findById(sessionId).orElse(null);
	}

}
