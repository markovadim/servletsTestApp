package by.markov.servletsTestApp.servlets;

import by.markov.servletsTestApp.models.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteUserServlet", value = "/delete")
public class DeleteServlet extends HttpServlet {
    private List<User> userList;

    @Override
    public void init() {
        final Object usList = getServletContext().getAttribute("userList");
        if (usList == null) {
            throw new IllegalStateException("List is not initialize.");
        } else {
            this.userList = (List<User>) usList;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        userList.removeIf(user -> user.getName().equals(req.getParameter("name")));
        resp.sendRedirect(req.getContextPath() + "/home");
    }
}
