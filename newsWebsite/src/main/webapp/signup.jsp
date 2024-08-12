<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="includes/navbar/header-default.jsp" %>

	<main class="container">

		<c:if test="${not empty error}">
	        <div class="alert alert-danger" role="alert">${error}</div>
	    </c:if>

        <div class="container-login pt-1 pb-5 my-5">
            <h1 class="my-5 text-center">SignUp</h1>

            <div class="container form-container">
                <form action="signupUser" method="post">
                    <div class="mb-3">
                    <label for="username" class="form-label">Nome</label>
                    <input class="form-control" id="username" name="username">
                    </div>
                    <div class="mb-3">
                    <label for="email" class="form-label">Email</label>
                    <input type="email" class="form-control" id="email" name="email">
                    </div>
                    <div class="mb-3">
                    <label for="password" class="form-label">Senha</label>
                    <input type="password" class="form-control" id="password" name="password">
                    </div class="mb-3">
                    <button type="submit" class="btn btn-secondary px-4">Enviar</button>
                </form>
            </div>
        </div>
            
    </main>

<%@ include file="includes/footer/footer-default.jsp" %>