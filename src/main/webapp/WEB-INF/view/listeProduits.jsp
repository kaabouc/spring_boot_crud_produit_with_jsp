<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste Produits</title>
</head>
<body>
<h1>Liste des Produits</h1>


<table>
<tr>
<th>ID</th><th>Nom Produit</th><th>Prix</th><th>Date Creation</th><th>Suppression</th><th>Edition</th>
</tr>
<c:forEach items="${produits}" var="p">
<tr>
<td>${p.idProduit }</td>
<td>${p.nomProduit }</td>
<td>${p.prixProduit }</td>
<td><fmt:formatDate pattern="dd/MM/yyyy" value="${p.dateCreation}" /></td>
<td><a onclick="return confirm('Etes-vous sûr ?')" href="supprimerProduit?id=${p.idProduit
}">Supprimer</a></td>
<td><a href="modifierProduit?id=${p.idProduit }">Edit</a></td>

</tr>
</c:forEach>
<!-- supprimerProduit et modifierProduit ce sont les urls qui sont dans le controlleur-->
</table>

</body>
</html>