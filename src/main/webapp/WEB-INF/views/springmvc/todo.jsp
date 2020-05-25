<html>
<head>
    <title>Add todo</title>
</head>
<body>
<form action="/spring-mvc/add-todo" method="POST">
    Description : <input name="desc" type="text" />
    is Done : <select name="isDone">
                <option value="true">Done</option>
                <option value="false">Not Done</option>
            </select>
    <input type="submit" value="add" />
</form>
</body>
</html>