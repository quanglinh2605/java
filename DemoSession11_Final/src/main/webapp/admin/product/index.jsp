<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<mt:admin_template title="Categories">
	<jsp:attribute name="content">
<c:if test="${err != null}">
		<div class="alert alert-danger alert-dismissible">
                  <button type="button" class="close"
					data-dismiss="alert" aria-hidden="true">×</button>
                  <h5>
				<i class="icon fas fa-ban"></i> Alert!</h5>
                  ${err}
     	</div>
	</c:if>
	<c:if test="${ msg != null}">
		 <div class="alert alert-info alert-dismissible">
                  <button type="button" class="close"
					data-dismiss="alert" aria-hidden="true">×</button>
                  <h5>
				<i class="icon fas fa-info"></i> Alert!</h5>
                  ${msg}
                </div>
	</c:if>  
	<div class="card">
              <div class="card-header">
                <h3 class="card-title">Category Table</h3>

                <div class="card-tools">
                  <div class="input-group input-group-sm"
						style="width: 150px;">
                    <input name="table_search"
							class="form-control float-right" type="text" placeholder="Search">

                    <div class="input-group-append">
                      <button class="btn btn-default" type="submit">
								<i class="fas fa-search"></i>
							</button>
                    </div>
                  </div>
                </div>
              </div>
              <!-- /.card-header -->
              <div class="card-body table-responsive p-0">
                <table class="table table-hover">
                  <thead>
                    <tr>
                      <th>ID</th>
                      <th>Name</th>
                      <th>Photo</th>
                      <th>Price</th>
                      <th>Actions</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach var="item" items="${ products }">
                    	<tr>
                    		<td>${ item.id }</td>
                    		<td>${ item.name }</td>
                    		<td>
                    			<img
									src="${ pageContext.request.contextPath }/assets/user/upload/${ item.photo}">
                    		</td>
                    		<td>${ item.price }</td>
                    		<td>${ item.status ? "show":"hide" }
                    		
                    	
								<td class="project-actions text-center">
                          
                          <a class="btn btn-info btn-sm"
									href="${ pageContext.request.contextPath }/admin/product?action=update&id=${ item.id }">
                              <i class="fas fa-pencil-alt">
                              </i>
                              Edit
                          </a>
                          <a class="btn btn-danger btn-sm"
									href="${ pageContext.request.contextPath }/admin/product?action=delete&id=${item.id}">
                              <i class="fas fa-trash">
                              </i>
                              Delete
                          </a>
                      </td>
							</tr>
                    </c:forEach>
                  </tbody>
                </table>
              </div>
              <!-- /.card-body -->
            </div>
</jsp:attribute>
</mt:admin_template>