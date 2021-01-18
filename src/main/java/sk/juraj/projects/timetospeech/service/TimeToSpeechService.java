package sk.juraj.projects.timetospeech.service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.stereotype.Service;

import sk.juraj.projects.spokentime.converter.SpokenTimeConverterFactory;
import sk.juraj.projects.timetospeech.dto.SpokenTimeExpression;

@Service
public class TimeToSpeechService {
	
	public SpokenTimeExpression getSpokenTime(String timeString) {
		var converter = SpokenTimeConverterFactory.getInstance(Locale.UK);
		var formatter = DateTimeFormatter.ofPattern("H:m");
		var time = LocalTime.parse(timeString, formatter);
		var timeConverter = converter.convert(time);
		var spokenTimeExpression = new SpokenTimeExpression(timeConverter);
		return spokenTimeExpression;
	}

}
