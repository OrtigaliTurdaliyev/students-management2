package uz.pdp.studentsmanagement.students;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/show-student")
public class ShowStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> allStudent= StudentDao.getAllStudent();
        req.setAttribute("students",allStudent);
        req.getRequestDispatcher("show-student.jsp").forward(req, resp);
    }
}
