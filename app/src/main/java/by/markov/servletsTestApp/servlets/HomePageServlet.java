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
    public static List<User> userList;

    @Override
    public void init() throws ServletException {
        userList = new CopyOnWriteArrayList<>();
        userList.add(new User("defaultUserForTest", 22, "xsnxq@mi"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");
        final String name = request.getParameter("name");
        final String age = request.getParameter("age");
        final String email = request.getParameter("email");
        if (checkUser(request)) {
            doGet(request, response);
        } else {
            final User user = new User(name, Integer.valueOf(age), email);
            userList.add(user);
            System.out.println(userList);
            doGet(request, response);
        }
    }

    private boolean checkUser(HttpServletRequest request) {
        boolean result = false;
        final String name = request.getParameter("name");
        for (User user : userList) {
            if (user.getName().equals(name)) {
                result = true;
                break;
            }
        }
        return result;
    }
}
