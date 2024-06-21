package org.example.tphopital.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.tphopital.model.User;
import org.example.tphopital.service.UserService;

import java.io.IOException;

@WebServlet(name = "user", value = "/user/*")
public class UserServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        switch (path) {
            case "/pagesignup":
                signUpPage(req,resp);
                break;
            case "/signup":
                signUp(req,resp);
                break;
            case "/pagesignin":
                signinPage(req,resp);
                break;
            case "/signin":
                signIn(req,resp);
                break;
            default:
                resp.sendRedirect("index.jsp");
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    private void signUpPage(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/signup.jsp").forward(request,response);
    }

    private void signUp(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
        String email = request.getParameter("inputEmail");
        String password = request.getParameter("inputPassword");
        String name = request.getParameter("inputName");
        userService.signUp(name,email,password);
        response.sendRedirect("pagesignin");

    }

    private void signinPage(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/signin.jsp").forward(request,response);
    }

    private void signIn(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
        String email = request.getParameter("inputEmail");
        String password = request.getParameter("inputPassword");

        User user = userService.signIn(email,password);
        if(user != null){
            HttpSession session = request.getSession();
            session.setAttribute("isLogged",true);
            session.setAttribute("user",user);
            response.sendRedirect(getServletContext().getContextPath()+"/patient/list");

        }else {
            response.sendRedirect("index.jsp");
        }
    }
}
