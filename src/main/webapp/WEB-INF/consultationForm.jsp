<%--
  Created by IntelliJ IDEA.
  User: telci
  Date: 21/06/2024
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="consultation" type="org.example.tphopital.model.Consultation" scope="request" />
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Créer une consultation</h2>
<form action="${pageContext.request.contextPath}/consultation/create" method="post">
    <label for="dateConsultation">Date de la consultation :</label>
    <input type="date" id="dateConsultation" name="dateConsultation"><br><br>

    <label for="nomMedecin">Nom du médecin :</label>
    <input type="text" id="nomMedecin" name="nomMedecin" required><br><br>

    <input type="submit" value="Créer">
</form>
</body>
</html>
