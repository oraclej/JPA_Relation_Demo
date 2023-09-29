package ir.oraclej.jpa_relation_demo;

import ir.oraclej.jpa_relation_demo.model.entity.Car;
import ir.oraclej.jpa_relation_demo.model.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/cadd")
public class CarAddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int pid = Integer.parseInt(req.getParameter("pid"));
        String brand = req.getParameter("brand");
        Car car = new Car();
        car.setId(id);
        car.setBrand(brand);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("localDB");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Person person = entityManager.find(Person.class, pid);
        car.setPerson(person);
        entityManager.persist(car);
        tx.commit();
        entityManager.close();
        resp.sendRedirect("plist");
    }
}
