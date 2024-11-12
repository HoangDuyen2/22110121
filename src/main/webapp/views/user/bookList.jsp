<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/10/2024
  Time: 11:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="page-wrapper">
    <div class="content">
        <div class="page-header">
            <div class="page-title">
                <h4>Book list</h4>
                <h6>View/Search Book</h6>
                <c:if test="${alertMsg != null}">
                    <p style="color: red">${alertMsg}</p>
                </c:if>
            </div>
        </div>

        <div class="card">
            <div class="card-body">
                <div class="table-top">
                    <div class="search-set">
                        <div class="search-path">
                            <a class="btn btn-filter" id="filter_search">
                                <img src="assets/img/icons/filter.svg" alt="img">
                                <span><img src="assets/img/icons/closes.svg" alt="img"></span>
                            </a>
                        </div>
                        <div class="search-input">
                            <a class="btn btn-searchset"><img src="assets/img/icons/search-white.svg" alt="img"></a>
                        </div>
                    </div>
                    <div class="wordset">
                        <ul>
                            <li>
                                <a data-bs-toggle="tooltip" data-bs-placement="top" title="pdf"><img src="assets/img/icons/pdf.svg" alt="img"></a>
                            </li>
                            <li>
                                <a data-bs-toggle="tooltip" data-bs-placement="top" title="excel"><img src="assets/img/icons/excel.svg" alt="img"></a>
                            </li>
                            <li>
                                <a data-bs-toggle="tooltip" data-bs-placement="top" title="print"><img src="assets/img/icons/printer.svg" alt="img"></a>
                            </li>
                        </ul>
                    </div>
                </div>

                <div class="card" id="filter_inputs">
                    <div class="card-body pb-0">
                        <div class="row">
                            <div class="col-lg-3 col-sm-6 col-12">
                                <div class="form-group">
                                    <input type="text" placeholder="Enter Book Name">
                                </div>
                            </div>
                            <div class="col-lg-3 col-sm-6 col-12">
                                <div class="form-group">
                                    <input type="text" placeholder="Enter Book Description">
                                </div>
                            </div>
                            <div class="col-lg-1 col-sm-6 col-12 ms-auto">
                                <div class="form-group">
                                    <a class="btn btn-filters ms-auto"><img src="assets/img/icons/search-whites.svg" alt="img"></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="table-responsive">
                    <table class="table datanew">
                        <thead>
                        <tr>
                            <th>
                                <label class="checkboxs">
                                    <input type="checkbox" id="select-all">
                                    <span class="checkmarks"></span>
                                </label>
                            </th>
                            <th>Image</th>
                            <th>Information</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="review" items="${reviews}">
                            <c:set var="book" value="${review[0]}" />
                            <c:set var="rating" value="${review[1]}" />
                            <c:set var="author" value="${review[2]}" />
                            <tr>
                                <td>
                                    <label class="checkboxs">
                                        <input type="checkbox">
                                        <span class="checkmarks"></span>
                                    </label>
                                </td>
                                <td>
                                    <a class="product-img">
                                        <img src="${pageContext.request.contextPath}/uploads/${book.coverImage}" alt="product">
                                    </a>
                                </td>
                                <td>
                                    <div>
                                        <label>Title: </label>
                                        <label>${book.title}</label>
                                    </div>
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
                                    <div>
                                        <label>Publisher: </label>
                                        <label>${book.publisher}</label>
                                    </div>
                                    <div>
                                        <label>Quantity: </label>
                                        <label>${book.quantity}</label>
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
                                </td>
                                <td>
                                    <a class="me-3" href="${pageContext.request.contextPath}/user/book-reviews?id=${book.id}">
                                        <img src="assets/img/icons/edit.svg" alt="img">
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

    </div>
</div>


