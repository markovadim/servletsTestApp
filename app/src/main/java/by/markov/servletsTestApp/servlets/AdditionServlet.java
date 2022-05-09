package by.markov.servletsTestApp.servlets;

import by.markov.servletsTestApp.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@WebServlet(name = "AdditionServlet", urlPatterns = "/add")
public class AdditionServlet extends HttpServlet {

    private List<User> userList;

    @Override
    public void init() {
        final Object usList = getServletContext().getAttribute("userList");
        if (usList == null) {
            System.out.println("List is empty");
            userList = new CopyOnWriteArrayList<>();
            userList.add(new User("Vadim M", 28, "markovadim@gmail.com"));
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

        if (checkUser(request)) {
            System.out.println("User is not corrected.");
        } else {
            final User user = new User(name, Integer.parseInt(age), email);
            userList.add(user);
        }
        response.sendRedirect(request.getContextPath() + "/home");
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
