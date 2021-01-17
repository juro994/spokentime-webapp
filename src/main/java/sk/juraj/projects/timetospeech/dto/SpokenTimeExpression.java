package sk.juraj.projects.timetospeech.dto;

public class SpokenTimeExpression {
	
	private String text;
	
	public SpokenTimeExpression() {
		
	}
 	
	public SpokenTimeExpression(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	

}
