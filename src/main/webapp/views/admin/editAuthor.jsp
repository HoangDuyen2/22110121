<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/10/2024
  Time: 6:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<div class="page-wrapper">
    <div class="content">
        <div class="page-header">
            <div class="page-title">
                <h4>Edit Author</h4>
                <h6>Edit a Author</h6>
                <c:if test="${alertMsg != null}">
                    <p style="color: red">${alertMsg}</p>
                </c:if>
            </div>
        </div>

        <form action="${pageContext.request.contextPath}/admin/author-edit" method="post">
            <div class="card">
                <div class="card-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="form-group">
                                <label>Author's Name</label>
                                <input type="text" value="${author.authorName}" name="authorName">
                            </div>
                        </div>
                        <div class="col-lg-12">
                            <div class="form-group">
                                <label>Date of Birth</label>
                                <input type="date" value="${formattedDate}" name="dateOfBirth">
                            </div>
                        </div>
                        <div class="col-lg-12">
                            <div class="form-group">
                                <input type="hidden" value="${author.id}" name="id">
                            </div>
                        </div>
                        <div class="col-lg-12">
                            <button type="submit" class="btn btn-submit me-2">Submit</button>
                            <a href="${pageContext.request.contextPath}/admin/authors" class="btn btn-cancel">Cancel</a>
                        </div>
                    </div>
                </div>
            </div>
        </form>

    </div>
</div>

