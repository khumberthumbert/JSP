<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:forEach var="prod" items="${prodlist }">
<div class="col mb-5">
	<div class="card h-100">
		<!-- Sale badge-->
		<div class="badge bg-dark text-white position-absolute"
			style="top: 0.5rem; right: 0.5rem">Sale</div>
		<!-- Product image-->
		<a href="prodMain.do?prodCode=${prod.productCode}"><img class="card-img-top"
			src="images/${prod.attachFile }" alt="..." /></a>
		<!-- Product details-->
		<div class="card-body p-4">
			<div class="text-center">
				<!-- Product name-->
				<h5 class="fw-bolder"><a href="prodMain.do?prodCode=${prod.productCode}">${prod.productName }</a></h5>
				<!-- Product reviews-->
				<div class="d-flex justify-content-center small text-warning mb-2">
					<c:forEach begin="1" end="${prod.productGrade }">
						<div class="bi-star-fill"></div>
					</c:forEach>
				</div>
				<!-- Product price-->
				<span class="text-muted text-decoration-line-through">${prod.productPrice }</span>
				${prod.productSale }
			</div>
		</div>
		<!-- Product actions-->
		<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
			<div class="text-center">
				<a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a>
			</div>
		</div>
	</div>
</div>
</c:forEach>