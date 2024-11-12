<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/10/2024
  Time: 6:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<div class="page-wrapper">
  <div class="content">
    <div class="page-header">
      <div class="page-title">
        <h4>Edit Book</h4>
        <h6>Edit a Book</h6>
        <c:if test="${alertMsg != null}">
          <p style="color: red">${alertMsg}</p>
        </c:if>
      </div>
    </div>

    <form action="${pageContext.request.contextPath}/admin/book-edit" method="post" enctype="multipart/form-data">
      <div class="card">
        <div class="card-body">
          <div class="row">
            <div class="col-lg-12">
              <div class="form-group">
                <label>Title</label>
                <input type="text" value="${book.title}" name="title">
              </div>
              <input type="text" value="${book.id}" name="id" hidden="hidden">
            </div>
            <div class="col-lg-12">
              <div class="form-group">
                <label>International Standard Book Number(ISBN)</label>
                <input type="text" value="${book.isbn}" name="isbn">
              </div>
            </div>

            <div class="col-lg-12">
              <div class="form-group">
                <c:choose>
                  <c:when test="${not empty book.authorList}">
                    <div>
                      <label>Author</label>
                      <ul>
                        <c:forEach items="${book.authorList}" var="author">
                          <input type="text" value="${author.authorName}" name="author">
                        </c:forEach>
                      </ul>
                    </div>
                  </c:when>
                  <c:otherwise>
                    <input type="text" value="" name="author">
                  </c:otherwise>
                </c:choose>
              </div>
            </div>
            <div class="col-lg-12">
              <div class="form-group">
                <label>Publisher</label>
                <input type="text" value="${book.publisher}" name="publisher">
              </div>
            </div>
            <div class="col-lg-12">
              <div class="form-group">
                <label>Publish Date</label>
                <input type="date" value="${book.publishDate}" name="publishDate">
              </div>
            </div>
            <div class="col-lg-12">
              <div class="form-group">
                <label>Price</label>
                <input type="text" value="${book.price}" name="price">
              </div>
            </div>
            <div class="col-lg-12">
              <div class="form-group">
                <label>Quantity</label>
                <input type="text" value="${book.quantity}" name="quantity">
              </div>
            </div>
            <div class="col-lg-12">
              <div class="form-group">
                <label>Description</label>
                <textarea class="form-control" name="description" >${book.description}</textarea>
              </div>
            </div>
            <div class="col-lg-12">
              <div class="form-group">
                <label> Book Image</label>
                <div class="image-upload">
                  <input type="file" name="oldImage" value="${book.coverImage}" hidden="hidden">
                  <img src="${pageContext.request.contextPath}/uploads/${book.coverImage}" alt="product">

                  <div class="image-uploads">
                    <input type="file" name="coverImage">
                    <img src="assets/img/icons/upload.svg" alt="img">
                    <h4>Drag and drop a file to upload</h4>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-lg-12">
              <button type="submit" class="btn btn-submit me-2">Submit</button>
              <a href="${pageContext.request.contextPath}/admin/books" class="btn btn-cancel">Cancel</a>
            </div>
          </div>
        </div>
      </div>
    </form>

  </div>
</div>
