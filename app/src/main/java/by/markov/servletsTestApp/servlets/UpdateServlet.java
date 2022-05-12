package by.markov.servletsTestApp.servlets;

import by.markov.servletsTestApp.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UpdateServlet", urlPatterns = "/update")
public class UpdateServlet extends HttpServlet {
    private List<User> userList;
    private String currentUserMail;

    @Override
    public void init() {
        final Object usList = getServletContext().getAttribute("userList");
        if (usList == null) {
            throw new IllegalStateException("List is not initialize");
        } else {
            this.userList = (List<User>) usList;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        for (User user : userList) {
            if (user.getName().equals(req.getParameter("name"))) {
                currentUserMail = user.getEmail();
            }
        }
        req.getRequestDispatcher("/pages/update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final String newUserMail = req.getParameter("email");
        for (User user : userList) {
            if (user.getEmail().equals(currentUserMail)) {
                user.setEmail(newUserMail);
            }
        }
        resp.sendRedirect(req.getContextPath() + "/home");
    }
}
