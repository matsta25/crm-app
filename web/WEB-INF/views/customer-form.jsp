<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fomr" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>customer-form</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>CRM</h2>
    </div>
</div>

<div id="container">
    Add Customer

    <form:form action="saveCustomer" modelAttribute="customer" method="POST">
        <fomr:hidden path="id" />

        firstName: <form:input path="firstName"/>
        <br><br>
        lastName: <form:input path="lastName"/>
        <br><br>
        email: <form:input path="email"/>
        <br><br>
        <button type="submit">save</button>
    </form:form>

    <br><br>

    <a href="${pageContext.request.contextPath}/customer/list"><- Go back</a>
</div>

</body>
</html>
