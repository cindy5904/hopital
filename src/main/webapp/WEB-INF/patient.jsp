<%--
  Created by IntelliJ IDEA.
  User: telci
  Date: 20/06/2024
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="patient" type="org.example.tphopital.model.Patient" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style.css">
    <link href="https : //fonts.googleapis.com/css2?family=Playwrite+NZ:wght@100..400&display=swap" rel="stylesheet">

</head>
<body>
<div class="containerDetails">
    <div class="container2Details">
        <h2>Dossier du Patient N° <%= patient.getId()%></h2>
        <div class="sectionEnTete">

            <div class="sectionEnTeteGauche">
                <h3 class="">Nom : <%= patient.getLastName() %></h3>
                <h3>Prénom : <%= patient.getFirstName() %> </h3>
                <h4>Date de naissance : <%= patient.getDateOfBirth() %></h4>
            </div>
            <div>
                <img class="img" src="<%= patient.getUrl()%>">
            </div>
        </div>
        <hr/>
        <h2>Liste des Consultations</h2>

    </div>
</div>

</body>
</html>
