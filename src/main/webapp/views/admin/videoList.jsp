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
                <h4>Video list</h4>
                <h6>View/Search Video</h6>
                <c:if test="${alertMsg != null}">
                    <p style="color: red">${alertMsg}</p>
                </c:if>
            </div>
            <div class="page-btn">
                <a href="${pageContext.request.contextPath}/admin/video-add" class="btn btn-added">
                    <img src="assets/img/icons/plus.svg" class="me-1" alt="img">Add Video
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
                                    <input type="text" placeholder="Enter Video Name">
                                </div>
                            </div>
                            <div class="col-lg-3 col-sm-6 col-12">
                                <div class="form-group">
                                    <input type="text" placeholder="Enter Video Description">
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
                        <c:forEach var="video" items="${videos}">
                            <tr>
                                <td>
                                    <label class="checkboxs">
                                        <input type="checkbox">
                                        <span class="checkmarks"></span>
                                    </label>
                                </td>
                                <td>
                                    <a class="product-img">
                                        <img src="${pageContext.request.contextPath}/uploads/${video.Poster}" alt="product">
                                    </a>
                                </td>
                                <td>
                                    <div>
                                        <label>Title: </label>
                                        <label>${video.Title}</label>
                                    </div>
                                    <div>
                                        <label>Views: </label>
                                        <label>${video.Views}</label>
                                    </div>
                                </td>
                                <td>
                                    <a class="me-3" href="${pageContext.request.contextPath}/admin/video-upload?id=${video.VideoId}">
                                        <img src="assets/img/icons/edit.svg" alt="img">
                                    </a>
                                    <a class="me-3 confirm-text" href="${pageContext.request.contextPath}/admin/video/delete?id=${video.VideoId}">
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


