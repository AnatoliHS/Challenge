<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>WebApp</title>
</head>
<body>
<script>

</script>
    <div id="top">
        <header>Inventory WebApp</header>
    </div>

    <div id="data">
        <form class="form" action="logging" method="post">
            <fieldset>
                <legend>
                <h2>Inventory</h2></legend>
            <%String id=(String)request.getAttribute("id");%>
            <input type="hidden" name="id" type="id" value="<%=id%>">
            
            <%String brand=(String)request.getAttribute("brand");%>
            <label class="brand" >Brand</label><br>
            <input class="brand2" name="brand" type="text" id="brand" value="<%=brand%>"><br>
            
            <%String productName=(String)request.getAttribute("productName");%>
            <label class="productName" >Product Name</label><br>
            <input class="productName2" name="productName" type="text" id="productName" value="<%=productName%>"><br>
            
            <%String size=(String)request.getAttribute("size");%>
            <label class="size">Size</label><br>
            <input class="size2" name = "size" type="text" value="<%=size%>"><br><br>

            <input type="submit" class="button" value="Add">

            <input type="button" class="button2" value="Cancel" onclick="window.location='logging'">
            </fieldset>         
        </form>
    </div>
    <br>
    <p>INVENTORY LIST</p><br>
    <div class= "row">
    <table class="table" style{ border="solid";}>
    <thead>
    <tr>
    <th width="100px" scope="col" class="col-2">#</th>
    <th width="100px" scope="col" class="col-2">Brand</th>
    <th width="100px" scope="col" class="col-2">Product</th>
    <th width="100px" scope="col" class="col-2">Size</th>
    <th width="100px" scope="col" class="col-2">Actions</th>
    </tr>
    </thead>
    <tbody>
    
    <%@page import="com.servlet.Product" %>
     <%@page import="java.util.UUID" %>
      <%@page import="java.util.Map" %>
      
      <%Map<UUID, Product> products = (Map<UUID, Product>)request.getAttribute("products");
      for (Map.Entry<UUID, Product> productItem : products.entrySet()) {
		String ID = productItem.getValue().getId().toString();
        String Brand = productItem.getValue().getBrand();
        String ProductName = productItem.getValue().getProductName();
        String Size = productItem.getValue().getSize();%>
        
    
    <tr>
    
    <th scope = "row"><%=ID.substring(0,8)%></th>
    <td><%=Brand%></td>
    <td><%=ProductName%></td>
    <td><%=Size%></td>
    <td>
    <a href="logging?id=<%=ID%>">Edit</a>
    <a href="logging?id=<%=ID%>&action=delete" onclick="return confirm('Are you sure?')">Delete</a>
    </td>
    </tr>
    <%}%>
    </tbody>
    </table>
    </div>
</body>
</html>