<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>View Users</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body class="container m-3 p-2">
    <h2>Items List</h2>
    <table class="table table-striped">
        <thead>
            <tr>
                <th>NO</th>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Category</th>
                <th>itemImageUrl</th>
                <th>Author</th>
                <th>Status</th>
                <th>Create</th>
                <th>Update</th>
                <th>
                    <!-- Use the "a" tag for links -->
                    <a class="btn btn-primary" href="/item/add">Add new Item</a>
                </th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${items}"  varStatus="loopStatus">
                <tr>
                     <td>${loopStatus.index + 1}</td>
                    <td>${item.id}</td>
                    <td>${item.itemName}</td>
                    <td>${item.itemDescription}</td>
                    <td>${item.itemPrice}</td>
                    <td>${item.itemQuantity}</td>
                    <td>${item.category.categoryName}</td>
                    <td>${item.itemImageUrl}</td>
                    <td>${item.author.firstName} ${item.author.lastName}</td>
                    <td>${item.itemStatus}</td> 
                    <td>${item.itemCreated}</td>
                    <td>${item.itemUpdated}</td>
                    <td>
                        <a class="btn btn-sm btn-warning m-1" href="/item/update?id=${item.id}">Edit</a> 
                        <a class="btn btn-sm btn-danger m-1" href="/item/delete?id=${item.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</body>
</html>
