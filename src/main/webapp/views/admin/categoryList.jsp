<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/10/2024
  Time: 5:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<div class="page-wrapper">
    <div class="content">
        <div class="page-header">
            <div class="page-title">
                <h4>User list</h4>
                <h6>View/Search User</h6>
            </div>
            <div class="page-btn">
                <a href="${pageContext.request.contextPath}/admin/category-add" class="btn btn-added">
                    <img src="assets/img/icons/plus.svg" class="me-1" alt="img">Add Category
                </a>
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
                                    <input type="text" placeholder="Enter Author Name">
                                </div>
                            </div>
                            <div class="col-lg-3 col-sm-6 col-12">
                                <div class="form-group">
                                    <input type="text" placeholder="Enter Author Description">
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
                            <th>Images</th>
                            <th>Information</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="category" items="${categories}">
                            <tr>
                                <td>
                                    <label class="checkboxs">
                                        <input type="checkbox">
                                        <span class="checkmarks"></span>
                                    </label>
                                </td>
                                <td>
                                    <a class="product-img">
                                        <img src="${pageContext.request.contextPath}/uploads/${category.Images}" alt="product">
                                    </a>
                                </td>
                                <td>
                                    <div>
                                        <label>Category id: </label>
                                        <label>${category.CategoryId}</label>
                                    </div>
                                    <div>
                                        <label>Category name: </label>
                                        <label>${category.CategoryName}</label>
                                    </div>
                                    <div>
                                        <label>Category code: </label>
                                        <label>${category.CategoryNode}</label>
                                    </div>
                                    <div>
                                        <label>Status: </label>
                                        <label>${category.Status}</label>
                                    </div>
                                </td>
                                <td>
                                    <a class="me-3" href="${pageContext.request.contextPath}/admin/category-upload?id=${category.CategoryId}">
                                        <img src="assets/img/icons/edit.svg" alt="img">
                                    </a>
                                    <a class="me-3 confirm-text" href="${pageContext.request.contextPath}/admin/category/delete?id=${category.CategoryId}">
                                        <img src="assets/img/icons/delete.svg" alt="img">
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

