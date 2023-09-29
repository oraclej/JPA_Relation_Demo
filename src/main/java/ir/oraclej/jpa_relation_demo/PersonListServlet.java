package ir.oraclej.jpa_relation_demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ir.oraclej.jpa_relation_demo.model.entity.Person;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "helloServlet", value = "/plist")
public class PersonListServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("localDB");
        EntityManager entityManager = factory.createEntityManager();
        Query query = entityManager.createQuery("select p from person p");
        List<Person> list = query.getResultList();
       request.setAttribute("personList", list);
       request.getRequestDispatcher("personList.jsp").forward(request, response);
    }
}