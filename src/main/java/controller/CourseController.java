package controller;

import java.io.IOException;
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
import entity.model.Course;

@WebServlet({  "/course-add","/coursepage", "/course-edit", "/course-delete" })
public class CourseController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CourseService coService;

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
	}

	@Override
	public void destroy() {
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		if (emf != null && emf.isOpen())
			emf.close();

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		if ("/course-add".equals(action)) {
			String courseid = req.getParameter("courseid");
			String name = req.getParameter("coursename");
			String fees = req.getParameter("fees");
			String duration = req.getParameter("duration");
			String level = req.getParameter("level");

			Course c=(courseid==null || courseid.equals("") ? new Course():coService.findById(Integer.parseInt(courseid)));
			c.setName(name);
			c.setFees(Integer.parseInt(fees));
			c.setDuration(duration);
			c.setLevel(level);
			
			req.setAttribute("course", c);
			coService.save(c);
			resp.sendRedirect(req.getContextPath().concat("/coursepage"));
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		if ("/course-add".equals(path)||"/course-edit".equals(path))  {
			
			List<Course> list = coService.findAll();
			req.setAttribute("course", list);
			
		 if ("/course-edit".equals(path)) {
			String coId = req.getParameter("courseid");

			Course co = coService.findById(Integer.parseInt(coId));

			req.setAttribute("course", co);
		}

			getServletContext().getRequestDispatcher("/course-add.jsp").forward(req, resp);
		}else if("/coursepage".equals(path)) {
		
			List<Course> list=coService.findAll();
			
		
			req.setAttribute("course",list);
			//forward
			getServletContext().getRequestDispatcher("/course.jsp").forward(req,resp);
		} else if ("/course-delete".equals(path)) {
			String id = req.getParameter("courseid");
			coService.delete(Integer.parseInt(id));
			resp.sendRedirect(req.getContextPath().concat("/coursepage"));
		}
	}

}
