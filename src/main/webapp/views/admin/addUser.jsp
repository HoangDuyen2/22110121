<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/10/2024
  Time: 1:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<div class="page-wrapper">
  <div class="content">
    <div class="page-header">
      <div class="page-title">
        <h4>Add User</h4>
        <h6>Create new User</h6>
        <c:if test="${alertMsg != null}">
          <p style="color: red">${alertMsg}</p>
        </c:if>
      </div>
    </div>

    <form action="${pageContext.request.contextPath}/admin/user-insert" method="post">
      <div class="card">
        <div class="card-body">
          <div class="row">
            <div class="col-lg-12">
              <div class="form-group">
                <label>Full Name</label>
                <input type="text" name="fullName">
              </div>
            </div>
            <div class="col-lg-12">
              <div class="form-group">
                <label>Email</label>
                <input type="text" name="email">
              </div>
            </div>
            <div class="col-lg-12">
              <div class="form-group">
                <label>Phone</label>
                <input type="text" name="phone">
              </div>
            </div>
            <div class="col-lg-12">
              <button type="submit" class="btn btn-submit me-2">Submit</button>
              <a href="${pageContext.request.contextPath}/admin/users" class="btn btn-cancel">Cancel</a>
            </div>
          </div>
        </div>
      </div>
    </form>

  </div>
</div>

