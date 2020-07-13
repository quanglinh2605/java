<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<mt:admin_template title="Add category">
	<jsp:attribute name="content">
		<div class="card card-info">
              <div class="card-header">
                <h3 class="card-title">Add Category</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form action="category?action=add" method="post">
                <div class="card-body">
                  <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="inputEmail3">Name</label>
                    <div class="col-sm-10">
                      <input class="form-control" name="name" placeholder="Name">
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