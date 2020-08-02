<%--
  Created by IntelliJ IDEA.
  User: matsta25
  Date: 8/2/20
  Time: 7:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>
            CRM
        </h2>
    </div>

    <div id="container">
        <div id="content">

            <button type="button"
                    class="add-button"
                    onclick="window.location.href='showFormForAdd'; return false;">
                Add Customer
            </button>

            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Actions</th>
                </tr>

                <c:forEach var="tempCustomer" items="${customers}">

                    <c:url var="updateLink" value="/customer/showFormForUpdate">
                        <c:param name="customerId" value="${tempCustomer.id}"/>
                    </c:url>

                    <c:url var="deleteLink" value="/customer/showFormForDelete">
                        <c:param name="customerId" value="${tempCustomer.id}"/>
                    </c:url>


                    <tr>
                        <td> ${tempCustomer.firstName}</td>
                        <td> ${tempCustomer.lastName}</td>
                        <td> ${tempCustomer.email}</td>
                        <td>
                            <a href="${updateLink}">Update</a> |
                            <a href="${deleteLink}" onclick="if (!(confirm('Are you sure?'))) return false;">Delete</a>
                        </td>
                    </tr>

                </c:forEach>
            </table>
        </div>
    </div>

</div>

</body>
</html>
