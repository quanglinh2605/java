<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<mt:admin_template title="Update">
	<jsp:attribute name="content">
		<div class="card card-info">
              <div class="card-header">
                <h3 class="card-title">Update</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form action="category?action=update" method="post">
                <div class="card-body">
                  <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="name">Name</label>
                    <div class="col-sm-10">
                    	<input type="hidden" name="id" value="${category.id }">
                      <input class="form-control" name="name" value="${category.name }" >
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