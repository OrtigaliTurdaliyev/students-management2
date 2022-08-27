package uz.pdp.studentsmanagement.students;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/edit-student")
public class EditStudentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Student studentById = StudentDao.getStudentById(Integer.parseInt(id));
        req.setAttribute("students", studentById);
        req.getRequestDispatcher("update-student-form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String firsName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String course = req.getParameter("course");

        Student student = Student.builder()
                .id( Integer.parseInt(id))
                .firstName(firsName)
                .lastName(lastName)
                .email(email)
                .course(Integer.parseInt(course))
                .build();

        int status = StudentDao.updateStudent(student);
        if (status > 0)
            resp.sendRedirect("/show-student");
        else
            resp.sendRedirect("/edit-student");
    }
}
