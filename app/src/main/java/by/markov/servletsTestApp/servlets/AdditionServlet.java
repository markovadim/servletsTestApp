package by.markov.servletsTestApp.servlets;

import by.markov.servletsTestApp.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdditionServlet", urlPatterns = "/add")
public class AdditionServlet extends HttpServlet {

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
        request.getRequestDispatcher("/pages/add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF8");
        final String name = request.getParameter("name");
        final String age = request.getParameter("age");
        final String email = request.getParameter("email");

        if (checkUserName(request) || checkUserAge(request)) {
            System.out.println("User Name or age is not corrected.");
        } else {
            final User user = new User(name, Integer.parseInt(age), email);
            userList.add(user);
        }
        response.sendRedirect(request.getContextPath() + "/home");
    }

    private boolean checkUserName(HttpServletRequest request) {
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

    private boolean checkUserAge(HttpServletRequest request) {
        boolean result = false;
        final String age = request.getParameter("age");
        if (Integer.parseInt(age) <= 0) {
            result = true;
        }
        return result;
    }
}
