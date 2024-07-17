<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>A社オンラインショッピング</title>
<link rel="stylesheet" type="text/css"
    href="${pageContext.request.contextPath}/css/style.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/loginInputCheck.js"></script>
<style>
    table {
        border-collapse: separate;
        border-spacing: 0 10px;
    }
    td {
        padding: 5px;
    }
    input[type="text"], input[type="password"] {
        width: 200px;
    }
    .radio-group {
        display: flex;
        align-items: center;
    }
    .radio-group label {
        margin-right: 10px;
    }
    .submit-button {
        margin-top: 20px;
    }
</style>
</head>
<body>
<div id="mainArea">
    <h1>会員登録</h1>
    <%-- contents start --%>
    <div id="target" style="color: red;">
        <c:forEach var="errorMessage" items="${errorMessageList}" varStatus="status">
            <p>
                <c:out value="${errorMessage}" />
            </p>
        </c:forEach>
    </div>
    <form method="post" action="${pageContext.request.contextPath}/mserv" id="chkForm">
        <table>
            <tr>
                <td>名前</td>
                <td><input type="text" name="memberName" id="memberName"></td>
            </tr>
            <tr>
                <td>性別</td>
                <td>
                    <div class="radio-group">
                        <input type="radio" id="male" name="gender" value="M">
                        <label for="male">男性</label>
                        <input type="radio" id="female" name="gender" value="F">
                        <label for="female">女性</label>
                        <input type="radio" id="other" name="gender" value="O">
                        <label for="other">その他</label>
                    </div>
                </td>
            </tr>
            <tr>
                <td>住所</td>
                <td><input type="text" name="address" id="address"></td>
            </tr>
            <tr>
                <td>電話番号</td>
                <td><input type="text" name="phone" id="phone"></td>
            </tr>
            <tr>
                <td>パスワード</td>
                <td><input type="password" name="password" id="password"></td>
            </tr>
        </table>
        <input type="hidden" name="flag" value="B0201CheckMemberAction">
        <div class="submit-button">
            <input type="submit" value="確認">
        </div>
    </form>
    <p>
        <a href="${pageContext.request.contextPath}/mserv">[トップに戻る]</a>
    </p>
    <%-- contents end --%>
</div>
</body>
</html>