    <%@ include file="common/header.jspf"%>
    <%@ include file="common/navigation.jspf"%>
    <c:if test="${message=='phoneNumber'}">
        <div class="alert alert-warning" role="alert">
          Enter a valid phone number.
        </div>
    </c:if>
    <div class="container">
	    <h1>Enter Order Details </h1>
        <form:form method="post" modelAttribute="order">
            <fieldset class="mb-3">
                <form:label path="deliveryAddress.street">Street</form:label>
                <form:input type="text" path="deliveryAddress.street" required="required"/>
                <form:errors path="deliveryAddress.street" cssClass="text-warning"/>
            </fieldset>

            <fieldset class="mb-3">
                <form:label path="deliveryAddress.postcode">Postcode</form:label>
                <form:input type="text" path="deliveryAddress.postcode" required="required"/>
                <form:errors path="deliveryAddress.postcode" cssClass="text-warning"/>
            </fieldset>

            <fieldset class="mb-3">
                <form:label path="deliveryAddress.city">City</form:label>
                <form:input type="text" path="deliveryAddress.city" required="required"/>
                <form:errors path="deliveryAddress.city" cssClass="text-warning"/>
            </fieldset>

            <fieldset class="mb-3">
                <form:label path="deliveryAddress.country">Country</form:label>
                <form:input type="text" path="deliveryAddress.country" required="required"/>
                <form:errors path="deliveryAddress.country" cssClass="text-warning"/>
            </fieldset>

            <fieldset class="mb-3">
                <form:label path="pilotes">Pilotes Quantity</form:label>
                <form:select path="pilotes">
                    <form:option value="5" label="5"/>
                    <form:option value="10" label="10"/>
                    <form:option value="15" label="15"/>
                </form:select>
            </fieldset>

            <fieldset class="mb-3">
                <form:label path="client.firstName">First Name</form:label>
                <form:input type="text" path="client.firstName" required="required"/>
                <form:errors path="client.firstName" cssClass="text-warning"/>
            </fieldset>

            <fieldset class="mb-3">
                <form:label path="client.lastName">Last Name</form:label>
                <form:input type="text" path="client.lastName" required="required"/>
                <form:errors path="client.lastName" cssClass="text-warning"/>
            </fieldset>

            <fieldset class="mb-3">
                <form:label path="client.telephone">Telephone</form:label>
                <form:input type="text" path="client.telephone" required="required"/>
                <form:errors path="client.telephone" cssClass="text-warning"/>
            </fieldset>

            <form:input type="hidden" path="number"/>
            <form:input type="hidden" path="orderTotal"/>
            <form:input type="hidden" path="statusOrder"/>
            <form:input type="hidden" path="client.id"/>
            <form:input type="hidden" path="deliveryAddress.id"/>
            <form:input type="hidden" path="creationDateTime"/>

            <input type="submit" class="btn btn-success"/>
        </form:form>
    </div>

    <%@ include file="common/footer.jspf"%>
