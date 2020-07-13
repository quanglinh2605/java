package Business;

import Dao.CategoryDAO;
import Models.Course;
import Models.Courses;
import Models.Trainer;
import Models.Trainers;

public class CategoryBusiness {
	private Trainers dstrainer;

	public void setdstrainer(Trainers value) {
		this.dstrainer = value;
	}

	public Trainers getdstrainer() {
		return dstrainer;
	}

	private Courses dscourse;

	public void setdscourse(Courses value) {
		this.dscourse = value;
	}

	public Courses getdscourse() {
		return dscourse;
	}

	private CategoryDAO dao = new CategoryDAO();

	public void GetGarbageTrainer() {
		dao.GetAllTrainer(1);
		dstrainer = new Trainers();
		for (Trainer train : dao.getdstrainer()) {
			int count = dao.CheckTrainer(train.getid());
			if (count == 0) {
				dstrainer.add(train);
			}
		}
	}

	public void GetGarbageCourse() {
		dao.GetAllCourse(1);
		dscourse = new Courses();
		for (Course course : dao.getdscourse()) {
			int count = dao.CheckCourse(course.getid());
			if (count == 0) {
				dscourse.add(course);
			}
		}
	}

	public void SearchGarbage(String name, String title) {
		switch (title) {
		case "trainer":
			dao.GetTrainerByName(name, 1);
			dstrainer = new Trainers();
			for (Trainer train : dao.getdstrainer()) {
				int count = dao.CheckCourse(train.getid());
				if (count == 0) {
					dstrainer.add(train);
				}
			}
			break;
		case "course":
			dao.GetCourseByName(name, 1);
			dscourse = new Courses();
			for (Course course : dao.getdscourse()) {
				int count = dao.CheckCourse(course.getid());
				if (count == 0) {
					dscourse.add(course);
				}
			}
			break;
		default:
			break;
		}
	}
}
