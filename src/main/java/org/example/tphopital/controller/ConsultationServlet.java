package org.example.tphopital.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.example.tphopital.model.Consultation;
import org.example.tphopital.model.Patient;
import org.example.tphopital.service.ConsultationService;
import org.example.tphopital.service.PatientService;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int patientId = Integer.parseInt(req.getParameter("patientId"));
        String idStr = req.getParameter("id");
        LocalDate dateConsultation = LocalDate.parse(req.getParameter("dateConsultation"));
        String nomMedecin = req.getParameter("nomMedecin");
        PatientService patientService = new PatientService();
        Patient patient = patientService.findById(patientId);

        Consultation consultation = new Consultation();
        consultation.setDateConsultation(dateConsultation);
        consultation.setNomMedecin(nomMedecin);
        consultation.setPatient(patient);

        ConsultationService consultationService = new ConsultationService();
        consultationService.add(dateConsultation, nomMedecin);
        if (consultation.getId() > 0) {
            System.out.println("Consultation crée avec succes");
            resp.sendRedirect(req.getContextPath() + "/consultation/list");
        } else {
            System.out.println("Échec de la création de la consultation, redirection vers le formulaire de création.");
            resp.sendRedirect(req.getContextPath() + "/consultation/create");
        }
    }

    private void newConsultation(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Consultation consultation = new Consultation();
        req.setAttribute("consultation", consultation);
        req.getRequestDispatcher("/WEB-INF/consultationForm.jsp").forward(req, resp);
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
