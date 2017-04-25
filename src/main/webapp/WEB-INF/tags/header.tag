<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="header-container">
    <div class="signin">
        <c:choose>
            <c:when test="${not empty username}">
                <a href="/profile">${username}</a>
                <a href="/signOut">Sign Out</a>
            </c:when>
            <c:otherwise>
                <a href="/registration">Register</a>
                <a href="/signIn">Sign In</a>
            </c:otherwise>
        </c:choose>
    </div>
    <div class="menu">
        <a href="/">Home</a>
    </div>
</div>