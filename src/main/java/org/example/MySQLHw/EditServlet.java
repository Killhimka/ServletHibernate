package org.example.MySQLHw;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.javabegin.hibernate.entity.Pets;
import ru.javabegin.hibernate.utils.HibernateSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@WebServlet("/editAnimal")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            Pets pet = PetDB.selectOne(id);
            if (pet!=null){
                req.setAttribute("pets",pet);
                getServletContext().getRequestDispatcher("/editAnimal.jsp").forward(req,resp);
            }
            else {
                getServletContext().getRequestDispatcher("/notfound.jsp").forward(req,resp);
            }
        }catch (Exception ex){
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(req,resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("animal");
            int age = Integer.parseInt(req.getParameter("age"));
            Pets pet = new Pets(id,name,age);
            PetDB.update(pet);
            resp.sendRedirect(req.getContextPath()+"/index3");
        } catch (Exception ex){
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(req,resp);
        }
    }
}
