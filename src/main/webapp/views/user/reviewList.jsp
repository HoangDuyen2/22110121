<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/11/2024
  Time: 10:38 PM
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

    <form action="${pageContext.request.contextPath}/user/review" method="post">
      <div class="card">
      <div class="card-body">
        <div class="row">
          <c:set var="book" value="${review[0]}" />
          <c:set var="rating" value="${review[1]}" />
          <c:set var="author" value="${review[2]}" />
          <div class="col-lg-12">
            <div class="form-group">
              <label>Title</label>
              <input type="text" value="${book.title}" name="title" readonly>
              <input type="text" value="${book.id}" name="id" hidden="hidden">

            </div>
          </div>

          <div class="col-lg-12">
            <div class="form-group">
              <label>International Standard Book Number(ISBN)</label>
              <input type="text" value="${book.isbn}" name="isbn" readonly>
            </div>
          </div>

          <div class="col-lg-12">
            <div class="form-group">
              <c:choose>
                <c:when test="${not empty book.authorList}">
                  <div>
                    <label>Authors:</label>
                    <ul>
                      <c:forEach items="${book.authorList}" var="author">
                        <li>${author.authorName}</li>
                      </c:forEach>
                    </ul>
                  </div>
                </c:when>
                <c:otherwise>
                  <div>
                    <label>No authors available</label>
                  </div>
                </c:otherwise>
              </c:choose>
            </div>
          </div>

          <div class="col-lg-12">
            <div class="form-group">
              <label>Publisher</label>
              <input type="text" value="${book.publisher}" name="publisher" readonly>
            </div>
          </div>

          <div class="col-lg-12">
            <div class="form-group">
              <label>Quantity</label>
              <input type="text" value="${book.quantity}" name="quantity" readonly>
            </div>
          </div>

          <div class="col-lg-12">
            <div class="form-group">
              <label> Book Image</label>
              <div class="image-upload">
                <img src="${pageContext.request.contextPath}/uploads/${book.coverImage}" alt="product">
              </div>
            </div>
          </div>

          <c:choose>
            <c:when test="${not empty book.ratingList}">
              <div>
                <label>Reviews:</label>
                <ul>
                  <c:forEach items="${book.ratingList}" var="review1">
                    <li>${review1.reviewText}</li>
                  </c:forEach>
                </ul>
              </div>
            </c:when>
            <c:otherwise>
              <div>
                <label>No review available</label>
              </div>
            </c:otherwise>
          </c:choose>
          <div class="col-lg-12">
            <div class="form-group">
              <label> Review</label>
              <textarea class="form-control" name="review-text"></textarea>
            </div>
          </div>
          <div class="col-lg-12">
            <button type="submit" class="btn btn-submit me-2">Submit</button>
          </div>
        </div>
      </div>
    </div>
    </form>

  </div>
</div>

