package entities;

public class Answer {
	private int id;
	private String content;
	private boolean correct;

	public Answer() {
		super();
	}

	public Answer(int id, String content, boolean correct) {
		super();
		this.id = id;
		this.content = content;
		this.correct = correct;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

}
