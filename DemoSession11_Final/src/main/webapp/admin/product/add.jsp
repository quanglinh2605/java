<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<mt:admin_template title="Add category">
	<jsp:attribute name="content">
		<div class="card card-info">
              <div class="card-header">
                <h3 class="card-title">Add Product</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form enctype="multipart/form-data" action="product?action=add" method="post">
                <div class="card-body">
                  
                  <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="name">Name</label>
                    <div class="col-sm-10">
                      <input class="form-control" name="name"
								placeholder="Name">
                    </div>
                  </div>
                  
                  <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="price">Price</label>
                    <div class="col-sm-10">
                      <input class="form-control" name="price"
								placeholder="price">
                    </div>
                  </div>
                  
                  <div class="form-group row">
                    <label class="col-sm-2 col-form-label"
							for="quantity">Quantity</label>
                    <div class="col-sm-10">
                      <input class="form-control" type="number"
								name="quantity" placeholder="quantity">
                    </div>
                  </div>
                  
                  <div class="form-check">
                    <input type="checkbox" class="form-check-input"
							name="status">
                    <label class="form-check-label" for="status">Status</label>
                  </div>                 
                  <div class="form-check">
                  	<input type="checkbox" class="form-check-input"
							name="featured">
                    <label class="form-check-label" for="status">Featured</label>
                  </div>
                  <div class="form-group">
                        <label>Textarea</label>
                        <textarea class="form-control" rows="3"
							name="description" placeholder="Enter ..."></textarea>
                  </div>              
                
                <div class="form-group">
                        <label>Select</label>
                        <select class="form-control" name="category">
                         <c:forEach var="category"
								items="${ categories }">
                         	<option value="${ category.id}">${ category.name }</option>
                         </c:forEach>
                        </select>
                      </div>
                
                <div class="input-group">
                      <div class="custom-file">
                        <input type="file" class="custom-file-input"
								id="exampleInputFile" name="photo">
                        <label class="custom-file-label"
								for="exampleInputFile">Choose file</label>
                      </div>
                      <div class="input-group-append">
                        <span class="input-group-text" id="">Upload</span>
                      </div>
                    </div>
                </div>
                <!-- /.card-body -->
                <div class="card-footer">
                  <button class="btn btn-info" type="submit">Save</button>
                  </div>
                <!-- /.card-footer -->
              </form>
            </div>
	</jsp:attribute>
</mt:admin_template>