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

import controller.service.ClassService;
import controller.service.RegistrationService;
import controller.service.StudentService;

import entity.model.Registration;
import entity.model.Student;
import entity.model.Class;




@WebServlet(urlPatterns = { "/regpage","/reg-add",  "/reg-edit", "/reg-delete" },loadOnStartup=1)
public class RegistrationController extends HttpServlet{


	private static final long serialVersionUID = 1L;
	private RegistrationService regService;
	private StudentService stuService;
	private ClassService classService;
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		EntityManagerFactory EMF=null;
		Object obj=getServletContext().getAttribute("emf");//application scope
		if(obj==null) {
			EMF=Persistence.createEntityManagerFactory("jsp-jpa-student-registration");
			getServletContext().setAttribute("emf", EMF);
		}else {
			EMF=(EntityManagerFactory) obj;
		}
		stuService=new StudentService(EMF.createEntityManager());
		classService=new ClassService(EMF.createEntityManager());
		regService=new RegistrationService(EMF.createEntityManager());
		
	}
	@Override
		public void destroy() {
			EntityManagerFactory emf=(EntityManagerFactory) getServletContext().getAttribute("emf");
			if(emf!=null && emf.isOpen()) {
				emf.close();
			}
		}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action=req.getServletPath();
		if("/reg-add".equals(action)||"/reg-edit".equals(action)) {
			
			
			List<Student> stulist=stuService.findAll();
		
			req.setAttribute("student", stulist);
			
		
		
			List<Class> classlist=classService.findAll();
	
			req.setAttribute("classes", classlist);
			
			if("/reg-edit".equals(action)) {
		
				String id=req.getParameter("regid");
				
			
				Registration obj=regService.findById(Integer.parseInt(id));
		
				
				req.setAttribute("registrations", obj);
				
				
			}
			
		
			getServletContext().getRequestDispatcher("/registration-add.jsp").forward(req,resp);
		
		}else if("/regpage".equals(action)) {
	
			List<Registration> list=regService.findAll();
			
	
			req.setAttribute("registrations",list);
	
			getServletContext().getRequestDispatcher("/registration.jsp").forward(req,resp);
		}else if("/reg-delete".equals(action)) {
		
			String id=req.getParameter("regid");
			
		
			
			regService.delete(Integer.parseInt(id));
			//redirect page
			resp.sendRedirect(req.getContextPath().concat("/regpage"));
		}
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String action=req.getServletPath();
			if("/reg-add".equals(action)) {
				//get data from request
				String regid=req.getParameter("regid");
				String sId=req.getParameter("stuid");
				String cId=req.getParameter("classid");
				String rdate=req.getParameter("regdate");
				String amt=req.getParameter("amt");
			
				System.out.println("SId:"+sId);
				Registration reg=(regid==null || regid.equals("") ? new Registration():regService.findById(Integer.parseInt(regid)));
				reg.setStudent(stuService.findById(Integer.parseInt(sId)));
				
				reg.setClasses(classService.findById(Integer.parseInt(cId)));
				reg.setRegDate(LocalDate.parse(rdate));
				reg.setPaidAmt(Integer.parseInt(amt));
				
			
				regService.save(reg);
				
				resp.sendRedirect(req.getContextPath().concat("/regpage"));
				
			}
	}

}
