<%@ page import="org.example.tphopital.model.Patient" %><%--
  Created by IntelliJ IDEA.
  User: telci
  Date: 20/06/2024
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="patients" type="java.util.ArrayList<org.example.tphopital.model.Patient>" scope="request" />
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</head>
<body>
<div class="container mt-4">
    <caption><h2>Liste des patients</h2></caption>
    <table class="table table-dark text-center align-middle">
        <tr>
            <th>Id</th>
            <th>Photo</th>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Date de naissance</th>
            <th></th>


        </tr>
        <% for (Patient p : patients) {%>
        <tr>
            <th><%= p.getId() %></th>
            <td>
                <img src="<%= p.getUrl() %>" alt="Image du produit" style="max-width: 100px; max-height: 100px;">
            </td>
            <th><%= p.getLastName() %></th>
            <th><%= p.getFirstName() %></th>
            <th><%= p.getDateOfBirth() %></th>

            <th>
                <a href="create?id=<%= p.getId() %>" class="btn btn-warning me-2">Modifier</a>
                <a href="delete?id=<%= p.getId() %>" class="btn btn-danger me-2">Supprimer</a>
                <a href="details?id=<%= p.getId() %>" class="btn btn-info">Details</a>

            </th>



        </tr>
        <% }%>
    </table>

    <div>
        <a href="create">Ajouter un patient</a>
    </div>

</div>
</body>
</html>
