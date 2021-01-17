package sk.juraj.projects.timetospeech.controller;

import java.time.LocalTime;
import java.util.Locale;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sk.juraj.projects.spokentime.converter.SpokenTimeConverterFactory;
import sk.juraj.projects.timetospeech.dto.SpokenTimeExpression;

@RestController
@RequestMapping("/api")
public class TimeToSpeechController {
	
	@GetMapping(produces = "application/json")
	public SpokenTimeExpression getSpokenTime(@RequestParam("time") String timeString) {
		var converter = SpokenTimeConverterFactory.getInstance(Locale.UK);
		var time = LocalTime.parse(timeString);
		var timeConverter = converter.convert(time);
		var spokenTimeExpression = new SpokenTimeExpression(timeConverter);
		return spokenTimeExpression;
	}

}
