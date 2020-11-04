package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.service.CourseService;
import controller.service.ClassService;
import entity.model.Course;

import entity.model.Class;

@WebServlet(urlPatterns = { "/classpage", "/class-add", "/class-edit", "/class-delete" },loadOnStartup=1)
public class ClassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CourseService coService;
	private ClassService classService;

	@Override
	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		EntityManagerFactory EMF = null;

		Object obj = getServletContext().getAttribute("emf");// application scope
		if (obj == null) {
			EMF = Persistence.createEntityManagerFactory("jsp-jpa-student-registration");
			getServletContext().setAttribute("emf", EMF);
		} else {
			EMF = (EntityManagerFactory) obj;
		}
		coService = new CourseService(EMF.createEntityManager());
		classService = new ClassService(EMF.createEntityManager());
	}

	@Override
	public void destroy() {
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		if (emf != null && emf.isOpen())
			emf.close();

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		if ("/class-add".equals(action) || "/class-edit".equals(action)) {
			
			List<Course> colist = coService.findAll();
			req.setAttribute("courses", colist);

			if ("/course-edit".equals(action)) {
				String id = req.getParameter("courseid");
				Class classobj = classService.findById(Integer.parseInt(id));
				req.setAttribute("classes", classobj);

			}
			getServletContext().getRequestDispatcher("/class-add.jsp").forward(req, resp);
		} else if ("/classpage".equals(action)) {
			List<Class> list = classService.findAll();
			req.setAttribute("classes", list);
			getServletContext().getRequestDispatcher("/class.jsp").forward(req, resp);
		} else if ("/class-delete".equals(action)) {
			String classid = req.getParameter("classid");
			classService.delete(Integer.parseInt(classid));
			resp.sendRedirect(req.getContextPath().concat("/classpage"));
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		if ("/class-add".equals(action)) {
			String classid = req.getParameter("classid");
			String coId = req.getParameter("courseid");
			String name = req.getParameter("classname");
			String sdate = req.getParameter("startdate");
		

			Class classes = (classid == null || classid.equals("") ? new Class()
					: classService.findById(Integer.parseInt(classid)));

			classes.setName(name);
			classes.setStart_date(LocalDate.parse(sdate));
			classes.setCourse(coService.findById(Integer.parseInt(coId)));

			classService.save(classes);
			
	
			
			resp.sendRedirect(req.getContextPath().concat("/classpage"));
		}
	}

}
