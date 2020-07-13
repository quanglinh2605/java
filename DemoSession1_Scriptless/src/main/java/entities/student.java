package entities;

public class student {
	private String id;
	private String name;
	private String photo;
	private double score;

	public student() {
		super();
	}

	public student(String id, String name, String photo, double score) {
		super();
		this.id = id;
		this.name = name;
		this.photo = photo;
		this.score = score;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
}
