package by.markov.servletsTestApp.servlets;

import by.markov.servletsTestApp.models.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@WebListener
public class ContextServlet implements ServletContextListener {

    private List<User> userList;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        final ServletContext servletContext = sce.getServletContext();
        userList = new CopyOnWriteArrayList<>();
        servletContext.setAttribute("userList", userList);
    }
}
