<%--
  Created by IntelliJ IDEA.
  User: telci
  Date: 20/06/2024
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="patient" type="org.example.tphopital.model.Patient" scope= "request"/>
<html>
<head>
    <title>Formulaire patient</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</head>
<body>
<main class="container">
    <div class="my-3 row">
        <div class="col-8 offset-2 p-3 rounded text-bg-dark">
            <h1 class="fw-light">Ajouter un patient</h1>
            <hr>
            <form action="<%= request.getContextPath() %>/patient" method="post" enctype="multipart/form-data">
                <div class="mb-3">
                    <label for="lastName" class="form-label">Nom:</label>
                    <input type="text" name="lastName" id="lastName" class="form-control">
                </div>
                <div class="mb-3">
                    <label for="firstName" class="form-label">Prénom:</label>
                    <input type="text" name="firstName" id="firstName" class="form-control">
                </div>
                <div class="mb-3">
                    <label for="dateOfBirth" class="form-label">Date de naissance:</label>
                    <input type="date" name="dateOfBirth" id="dateOfBirth" class="form-control">
                </div>

                <div class = "mb-3">
                    <input type="file" name="image">
                </div>
                <div>

                </div>
                <hr>
                <div class="text-end">

                    <button class="btn btn-outline-success"><i class="bi bi-plus-circle"></i>Envoyer</button>

                </div>
            </form>
        </div>
    </div>
</main>
</body>
</html>
