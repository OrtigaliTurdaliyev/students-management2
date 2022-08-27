package uz.pdp.studentsmanagement.students;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/add-student")
@MultipartConfig(maxFileSize = 10_000_000)
public class AddStudentsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("add-student-form.jsp").forward(req, resp);
//        req.setAttribute("courseList", CourseDao.getAllCoursesForSelect());
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int num=0;
        Student student = new Student();
        student.setFirstName(req.getParameter("firstName"));
        student.setLastName(req.getParameter("lastName"));
        student.setEmail(req.getParameter("email"));
        student.setCourse(Integer.parseInt(req.getParameter("course")));

        num= StudentDao.addStudent(student);
        if (num > 0) {
            resp.sendRedirect("/show-student");
        } else resp.sendRedirect("/add-student");

    }
}
