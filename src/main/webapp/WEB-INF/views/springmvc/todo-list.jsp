<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Your todos : ${user}</title>
</head>
<body>
<h1>Todo List for user '${user}'</h1>
<div>
    <table>
        <caption>Your todos here</caption>
        <thead>
            <tr>
                <th>Desc</th>
                <th>Target Date</th>
                <th>Done?</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${todoList}" var="todo">
            <tr>
                <td>${todo.desc}</td>
                <td>${todo.targetDate}</td>
                <td>${todo.done}</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<a class="button" href="/spring-mvc/add-todo">Add</a>


</body>
</html>