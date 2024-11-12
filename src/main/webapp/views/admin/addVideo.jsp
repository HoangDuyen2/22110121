<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/10/2024
  Time: 5:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<div class="page-wrapper">
  <div class="content">
    <div class="page-header">
      <div class="page-title">
        <h4>Add Video</h4>
        <h6>Create new Video</h6>
        <c:if test="${alertMsg != null}">
          <p style="color: red">${alertMsg}</p>
        </c:if>
      </div>
    </div>

    <form action="${pageContext.request.contextPath}/admin/video-insert" method="post" enctype="multipart/form-data">
      <div class="card">
        <div class="card-body">
          <div class="row">
            <div class="col-lg-12">
              <div class="form-group">
                <label>VideoId: </label>
                <input type="text" name="VideoId">
              </div>
            </div>
            <div class="col-lg-12">
              <div class="form-group">
                <label>Title</label>
                <input type="text" name="title">
              </div>
            </div>
            <div class="col-lg-12">
              <div class="form-group">
                <label>Views</label>
                <input type="text" name="views">
              </div>
            </div>
            <div class="col-lg-12">
              <div class="form-group">
                <label>CategoryId</label>
                <input type="text" name="CategoryId">
              </div>
            </div>
            <div class="col-lg-12">
              <div class="form-group">
                <label>Description</label>
                <textarea class="form-control" name="description"></textarea>
              </div>
            </div>
            <div class="col-lg-12">
              <div class="form-group">
                <label> Poster</label>
                <div class="image-upload">
                  <input type="file" name="poster">
                  <div class="image-uploads">
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
