package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.QuestionModel;

@WebServlet("/question")
public class QuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QuizServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		QuestionModel questionModel = new QuestionModel();
		request.setAttribute("questions", questionModel.findall());
		request.setAttribute("p", "../question/index.jsp");
		request.getRequestDispatcher("templates/mytemplate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		QuestionModel questionModel = new QuestionModel();
		String[] questionIds = request.getParameterValues("questionId");
		int score = 0;
		if (questionIds != null) {
			for (String questionId : questionIds) {
				String answerId = request.getParameter("question_" + questionId);
				if (answerId != null) {
					int SelectedAnswer = Integer.parseInt(answerId);
					if (SelectedAnswer == questionModel.CorrectAnswer(Integer.parseInt(questionId))) {
						score++;
					}
				}
			}
		}
		request.setAttribute("score", score);
		request.setAttribute("p", "../question/result.jsp");
		request.getRequestDispatcher("templates/mytemplate.jsp").forward(request, response);
	}
}
