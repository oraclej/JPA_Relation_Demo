package ir.oraclej.jpa_relation_demo;

import ir.oraclej.jpa_relation_demo.model.entity.Car;
import ir.oraclej.jpa_relation_demo.model.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/pcars")
public class CarList extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("localDB");
        EntityManager entityManager = factory.createEntityManager();
        Person person = entityManager.find(Person.class, id);
        List<Car> carList = person.getCars();
        req.setAttribute("carList", carList);
        req.setAttribute("person", person);
        req.getRequestDispatcher("carList.jsp").forward(req, resp);
    }
}
