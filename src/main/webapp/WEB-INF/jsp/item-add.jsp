<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Add Item</title>
            <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    </head>
<body class="container m-3 p-2">
    <a class="btn btn-primary my-3" href="/item/view-all">view Items</a>
   
        <c:if test="${addItemSuccess}">
            <div>Successfully added Items with ID: ${item.id}</div>
        </c:if>
            <div>${message}</div>

    
        <c:url var="add_item_url" value="/item/add"/>
           <div class="container">
        <form:form action="${add_item_url}" method="post" modelAttribute="item" enctype="multipart/form-data">
    <div class="row my-3">
            <div class="col-md-4">
                <form:label path="itemName" class="form-label" >Name: </form:label> 
                <form:input type="text" path="itemName"  class="form-control"/>
            </div>
            <div class="col-md-4">
                <form:label path="itemPrice" class="form-label" >Price: </form:label> 
                <form:input type="number" path="itemPrice"  class="form-control"/>
            </div>
            <div class="col-md-4">
                <form:label path="itemQuantity" class="form-label" >Quantity:</form:label> 
                <form:input type="number" path="itemQuantity"  class="form-control"/>
            </div> 
    </div>       
    <div class="row my-3">
            <div class="col-md-4"> 
                <form:label path="category" class="form-label">category:</form:label>
                <form:select path="category" class="form-control">
                    <form:option value="" label="Select a category" />
                    <c:forEach var="category" items="${categories}">
                        <form:option value="${category.id}" label="${category.categoryName}" />
                    </c:forEach>
                </form:select>

            </div> 
            <div class="col-md-4"> 
                <form:label path="itemStatus" class="form-label" >Status:</form:label> 
                <form:select path="itemStatus" class="form-control">
                    <form:option value="" label="Select a Status" />
                    <form:option value="Available" label="Available" />
                    <form:option value="Non Available" label="Non Available" />
                    <form:option value="Out of Stock" label="Out of Stock" />
                </form:select>
            </div>
            <div class="col-md-4">
                <label class="form-label">Image File</label>
               <input type="file" class="form-control" name="image" accept="image/*" class="form-control-file" id="imageInput" />
            </div>

     </div> 
     <div class ="row">
     <div class="col-md-4"></div>
     <div class="col-md-4"></div>
        <img id="uploadedImage" class="img-fluid col-sm-6" alt="Uploaded Image"  width="auto" height="50px">
     </div>
     <div class="row my-3">  
            <form:label path="itemDescription" class="form-label" >Description:</form:label> 
            <form:textarea path="itemDescription" class="form-control"/>
        </div>
            
           
          
            <button type="submit" class="btn btn-primary m-3">submit</button>
        </form:form>
        </div> 
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <!-- Include JavaScript file -->
        <script type="text/javascript" src="/static/js/inputImage.js"></script>
        <script>
        imageInput("imageInput","uploadedImage");
        </script>
    </body>
</html>
