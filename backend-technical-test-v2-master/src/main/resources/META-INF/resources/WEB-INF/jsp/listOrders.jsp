    <%@ include file="common/header.jspf"%>
    <%@ include file="common/navigation.jspf"%>
    <div class="container">
	<h1>Orders</h1>
	<form method="post">
      <input type="text" name="keyword" th:value="${keyword}"  placeholder="Find by Name" size="50" >
      <button type="submit" class="btn btn-success" >Search</button>
      <button type="reset" class="btn btn-success" >Reset</button>
    </form>
    <c:if test="${message=='preparing'}">
        <div class="alert alert-warning" role="alert">
          Update not allowed for Orders in Preparing status.
        </div>
    </c:if>
	<table class="table">
	    <thead>
	        <tr>
                <th>Number</th>
                <th>Quantity</th>
                <th>Total</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Phone Number</th>
                <th>Status</th>
                <th></th>
	        </tr>
	    </thead>
        <tbody>
            <c:forEach items="${orders}" var="order">
                <tr>
                    <td>${order.number}</td>
                    <td>${order.pilotes}</td>
                    <td>${order.orderTotal}</td>
                    <td>${order.client.firstName}</td>
                    <td>${order.client.lastName}</td>
                    <td>${order.client.telephone}</td>
                    <td>${order.statusOrder}</td>
                    <td> <a href="update-order?id=${order.number}" class="btn btn-success">Update</a> </td>
                </tr>
            </c:forEach>
        <tbody>
    </table>
    </div>



    <%@ include file="common/footer.jspf"%>

<script type="text/javascript">
    $(document).ready(function(){
        $('button').click(function(){
            $('.alert').show()
        })
    });
</script>