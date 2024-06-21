package org.example.tphopital.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.tphopital.service.ConsultationService;

import java.io.IOException;

@MultipartConfig(maxFileSize = 1024*1024*10)
@WebServlet(name="consultation", value="/consultation/*")
public class ConsultationServlet extends HttpServlet {
    private ConsultationService consultationService;

    @Override
    public void init() throws ServletException {
        consultationService = new ConsultationService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        switch (path) {
            case "/create":
                newConsultation(req,resp);
                break;
            case "/update":
                editConsultation(req,resp);
                break;
            case "/delete":
                deleteConsultation(req,resp);
                break;
            case "/details":
                detailConsultation(req,resp);
                break;
            case "/list" :
                allConsultation(req,resp);
                break;
            default:
                resp.sendRedirect("index.jsp");
        }
    }

    private void newConsultation(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void editConsultation(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void deleteConsultation(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void detailConsultation(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void allConsultation(HttpServletRequest req, HttpServletResponse resp) {
    }
}
