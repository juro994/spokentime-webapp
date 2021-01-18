package sk.juraj.projects.timetospeech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sk.juraj.projects.timetospeech.dto.SpokenTimeExpression;
import sk.juraj.projects.timetospeech.service.TimeToSpeechService;

@RestController
@RequestMapping("/api")
public class TimeToSpeechController {
	
	@Autowired
	private TimeToSpeechService service;
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<SpokenTimeExpression> getSpokenTime(@RequestParam("time") String timeString) {
		return ResponseEntity.ok(service.getSpokenTime(timeString));
	}

}
