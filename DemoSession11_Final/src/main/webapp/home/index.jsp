<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<mt:user_template>
	<jsp:attribute name="content">
                <div class="title">
                    <span class="title_icon">
                        <img src="assets/user/images/bullet1.gif" alt="" title="">
                    </span>Featured products
                </div>
	<c:forEach var="product" items="${products}">
	 <div class="feat_prod_box">

                    <div class="prod_img">
                        <a href="${pageContext.request.contextPath}/home?action=detail&id=${product.id}">
                            <img src="assets/user/upload/${product.photo }" width=100 height=100 alt="" title="" border="0">
                        </a>
                    </div>

                    <div class="prod_det_box">
                        <div class="box_top"></div>
                        <div class="box_center">
                            <div class="prod_title">${product.name }</div>
                            <p class="details">
                               ${product.description}
                            </p>
                            <a href="${pageContext.request.contextPath}/home?action=detail&id=${product.id}" class="more">- more details -</a>
                            <div class="clear"></div>
                        </div>

                        <div class="box_bottom"></div>
                    </div>
                    <div class="clear"></div>
                </div>
	</c:forEach>
               <c:if test="${news != null }">
               <div class="title">
                    <span class="title_icon">
                        <img src="assets/user/images/bullet2.gif" alt="" title="">
                    </span>New products
                </div>
                <div class="new_products">
	<c:forEach var="product" items="${news}">
	 <div class="new_prod_box">
                        <a href="${pageContext.request.contextPath}/home?action=detail&id=${product.id}">${product.name}</a>
                        <div class="new_prod_bg">
                            <span class="new_icon">
                                <img src="assets/user/images/new_icon.gif" alt="" title="">
                            </span> <a href="details.html">
                                <img src="assets/user/upload/${product.photo}" alt="" title="" class="thumb" border="0" width="100" height="100">
                            </a>
                        </div>
                    </div>
	</c:forEach>
                </div>

                <div class="clear"></div>
               </c:if>
                
	</jsp:attribute>
</mt:user_template>