package by.markov.servletsTestApp.servlets;

import by.markov.servletsTestApp.models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomePageServlet", value = "/home")
public class HomePageServlet extends HttpServlet {
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
