package by.markov.servletsTestApp.servlets;

import by.markov.servletsTestApp.models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@WebServlet(name = "HomePageServlet", value = "/home")
public class HomePageServlet extends HttpServlet {
    private List<User> userList;

    @Override
    public void init() throws ServletException {
        userList = new CopyOnWriteArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("Users", userList);
        request.getRequestDispatcher("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
