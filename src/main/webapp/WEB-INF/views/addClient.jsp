<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/26/2022
  Time: 12:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Client</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>


<div class="container-fluid">
    <div class="container">
        <div class="col-sm-6">
            <h3 style="margin-top: 10px">Add Clint</h3>

            <%--@elvariable id="requestClientDto" type="com.example.shapla_city_limited.dto.RequestClientDto"--%>
            <form:form action="/client/add" method="POST" modelAttribute="requestClientDto">
                <div class="form-group">
                    <label for="name">Name</label>
                    <form:input type="text" name="name" id="name" path="name"  placeholder="Your Name" class="form-control form-control-lg"/>
                    <form:errors path="name" cssClass="text-danger" />
                </div>

                <div class="form-group">
                    <label for="country">Country</label>
                    <form:input type="text" class="form-control form-control-lg" path="country" placeholder="country" name="country" id="country"
                                aria-describedby="form-control form-control-lg"/>
                    <form:errors path="country" cssClass="text-danger" />
                </div>
                <div class="form-group">
                    <label for="address">Address</label>
                    <form:input type="text" class="form-control form-control-lg" path="address" placeholder="Address" name="address" id="address"/>
                    <form:errors path="address" cssClass="text-danger" />
                </div>


                <div class="form-group">
                    <label for="phoneNumber">PhoneNumber </label>
                    <form:input type="text" name="phoneNumber" path="phoneNumber"/>
                    <form:errors path="phoneNumber" cssClass="text-danger" />
                </div>

                <div class="form-group">
                    <label for="bookingDate">Booking Date</label>
                    <form:input type="date" name="bookingDate" path="bookingDate"/>
                    <form:errors path="bookingDate" cssClass="text-danger" />
                </div>



                <div class="form-group">
                    <label for="phoneNumber">buildingNo </label>
                    <form:input type="text" name="buildingNo" path="buildingNo"/>
                    <form:errors path="buildingNo" cssClass="text-danger" />
                </div>


                <div class="form-group">
                    <label for="fileNo">FileNo </label>
                    <form:input type="text" name="fileNo" path="fileNo"/>
                    <form:errors path="fileNo" cssClass="text-danger" />
                </div>


                <div class="form-group">
                    <label for="flatSize">flat Size </label>
                    <form:input type="text" name="flatSize" path="flatSize"/>
                    <form:errors path="flatSize" cssClass="text-danger" />
                </div>


                <div class="form-group">
                    <label for="contactMessenger">Contact Facebook link </label>
                    <form:input type="text" name="contactMessenger" path="contactMessenger"/>
                    <form:errors path="contactMessenger" cssClass="text-danger" />
                </div>

                <div class="form-group">
                    <label for="contactWhatsApp">Contact What's App Number </label>
                    <form:input type="text" name="contactWhatsApp" path="contactWhatsApp"/>
                    <form:errors path="contactWhatsApp" cssClass="text-danger" />
                </div>



                <br/>

                <button type="submit" class="btn btn-primary">Create</button>
            </form:form>

        </div>
    </div>
</div>

</body>
</html>
