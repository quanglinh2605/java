package Models;

import java.util.ArrayList;
import java.util.List;

import entities.Answer;
import entities.Question;

public class QuestionModel {
	public List<Question> findall() {
		List<Question> questions = new ArrayList<Question>();

		// question 1
		Question question1 = new Question();
		question1.setId(1);
		question1.setContent("Question 1");
		question1.getAnswer().add(new Answer(1, "Answer 1.1", false));
		question1.getAnswer().add(new Answer(2, "Answer 1.2", false));
		question1.getAnswer().add(new Answer(3, "Answer 1.3", true));
		question1.getAnswer().add(new Answer(4, "Answer 1.4", false));
		questions.add(question1);
		// question 2
		Question question2 = new Question();
		question2.setId(2);
		question2.setContent("Question 2");
		question2.getAnswer().add(new Answer(5, "Answer 2.1", true));
		question2.getAnswer().add(new Answer(6, "Answer 2.2", false));
		question2.getAnswer().add(new Answer(7, "Answer 2.3", false));
		question2.getAnswer().add(new Answer(8, "Answer 2.4", false));
		questions.add(question2);

		Question question3 = new Question();
		question3.setId(3);
		question3.setContent("Question 3");
		question3.getAnswer().add(new Answer(9, "Answer 3.1", false));
		question3.getAnswer().add(new Answer(10, "Answer 3.2", true));
		question3.getAnswer().add(new Answer(11, "Answer 3.3", false));
		question3.getAnswer().add(new Answer(12, "Answer 3.4", false));
		questions.add(question3);

		Question question4 = new Question();
		question4.setId(4);
		question4.setContent("Question 4");
		question4.getAnswer().add(new Answer(13, "Answer 4.1", false));
		question4.getAnswer().add(new Answer(14, "Answer 4.2", true));
		questions.add(question4);

		return questions;
	}

	public int CorrectAnswer(int questionId) {
		for (Question question : findall()) {
			if (question.getId() == questionId) {
				for (Answer answer : question.getAnswer()) {
					if (answer.isCorrect()) {
						return answer.getId();
					}
				}
			}
		}
		return -1;
	}
}
