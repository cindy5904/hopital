package org.example.tphopital.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.tphopital.model.Consultation;
import org.example.tphopital.model.Patient;
import org.example.tphopital.service.ConsultationService;
import org.example.tphopital.service.PatientService;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@MultipartConfig(maxFileSize = 1024*1024*10)
@WebServlet(name="patient", value="/patient/*")
public class PatientServlet extends HttpServlet {
    private PatientService patientService;
    private ConsultationService consultationService;

    @Override
    public void init() throws ServletException {
        patientService = new PatientService();
        consultationService = new ConsultationService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        boolean logged = (session.getAttribute("isLogged") != null) ? (boolean) session.getAttribute("isLogged"): false ;
//
//        if(logged) {
            String path = req.getPathInfo();
            switch (path) {
                case "/create":
                    newPatient(req,resp);
                    break;
                case "/update":
                    editPatient(req,resp);
                    break;
                case "/delete":
                    deletePatient(req,resp);
                    break;
                case "/details":
                    detailPatient(req,resp);
                    break;
                case "/list" :
                    allPatient(req,resp);
                    break;
                default:
                    resp.sendRedirect("index.jsp");
            }
//        } else {
//            resp.sendRedirect(getServletContext().getContextPath()+"/user/pagesignin");
//        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        String lastName = req.getParameter("lastName");
        String firstName = req.getParameter("firstName");
        LocalDate dateOfBirth = LocalDate.parse(req.getParameter("dateOfBirth"));

        System.out.println("Paramètres reçus : " + "id: " + idStr + ", lastName: " + lastName + ", firstName: " + firstName + ", dateOfBirth: " + dateOfBirth);

        String uploadPath = getServletContext().getRealPath("/") + "image";
        File file = new File(uploadPath);
        if (!file.exists()) {
            file.mkdir();
        }

        Part image = req.getPart("image");
        String fileName = image.getSubmittedFileName();
        image.write(uploadPath + File.separator + fileName);

        String imageUrl = req.getContextPath() + "/image/" + fileName;

        Patient patient = patientService.add(lastName, firstName, dateOfBirth, imageUrl);
        if (patient.getId() > 0) {
            System.out.println("Patient créé avec succès, redirection vers la liste des patients.");
            resp.sendRedirect(req.getContextPath() + "/patient/list");
        } else {
            System.out.println("Échec de la création du patient, redirection vers le formulaire de création.");
            resp.sendRedirect(req.getContextPath() + "/patient/create");
        }
    }

    private void allPatient(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("patients",patientService.findAll());
        req.getRequestDispatcher("/WEB-INF/patients.jsp").forward(req,resp);
    }

    private void detailPatient(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("id")  != null){
            int id = Integer.parseInt(req.getParameter("id"));
            Patient patient = patientService.findById(id);
            List<Consultation> consultations = patient.getConsultations();
            req.setAttribute("consultations", consultations);
            req.setAttribute("patient",patient);

            req.getRequestDispatcher("/WEB-INF/patient.jsp").forward(req,resp);
        }else {
            req.setAttribute("patients",patientService.findAll());
            req.getRequestDispatcher("/WEB-INF/patients.jsp").forward(req,resp);
        }
    }


    private void deletePatient(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Patient product = patientService.findById(id);
        if(product != null){
            patientService.delete(id);
        }
        resp.sendRedirect("list");
    }

    private void editPatient(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void newPatient(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Patient patient = new Patient();
        req.setAttribute("patient", patient);
        req.getRequestDispatcher("/WEB-INF/patientForm.jsp").forward(req, resp);
    }
    
}
