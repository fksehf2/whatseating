<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form action="/api/detail" method="post">
<a id="Modal" data-bs-toggle="modal" href="#exampleModalToggle" role="button"></a>
		<div class="modal fade" id="exampleModalToggle" aria-hidden="true" aria-labelledby="exampleModalToggleLabel" tabindex="-1">
			  <div class="modal-dialog modal-dialog-centered">
			    <div class="modal-content">
			      <div class="modal-header">
			      	<c:forEach items="${detail}" var="str">
			        <h5 class="modal-title" id="exampleModalToggleLabel">${detail[i].ST_NAME }</h5>
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			        </c:forEach>
			      </div>
			      <div class="modal-body" id="modalbody">
				  <ul class="list-group list-group-horizontal">
					  <li class="list-group-item" id="store_name">소개: </li>
				  </ul>
				  <ul class="list-group list-group-horizontal-sm">
					  <li class="list-group-item" id="store_content">A second item</li>
				  </ul>
				  <ul class="list-group list-group-horizontal-md">
					  <li class="list-group-item" id="store_addr">A second item</li>
				  </ul>
				  <ul class="list-group list-group-horizontal-lg">				  
					  <li class="list-group-item" id="store_time">A second item</li>
				  </ul>
				  <ul class="list-group list-group-horizontal-lg">				  
					  <li class="list-group-item" id="store_menu">A second item</li>
				  </ul>
			      </div>
			      
			      <div class="modal-footer">
			        <button class="btn btn-outline-success btn-sm m-1" data-bs-target="#exampleModalToggle2" data-bs-toggle="modal">예약하기</button>
			      </div>
			    </div>
			  </div>
			</div>
			<div class="modal fade" id="exampleModalToggle2" aria-hidden="true" aria-labelledby="exampleModalToggleLabel2" tabindex="-1">
			  <div class="modal-dialog modal-dialog-centered">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalToggleLabel2">시간&인원을 선택하세요</h5>
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      <div class="modal-body">
			      <div class="reserv_time">
			      	<label class="form-label" for="reserv-time">Choose your reservation date</label>
				  	<input type="date" name="date" min="2022-04-12" max="2030-12-31">
				  	<label class="form-label" for="reserv-time2">Choose your reservation time</label>
				  	<input type="time" step="3600000" />
			      </div> 
				  <div class="reserv_person">
					  <label for="reserv-person">예약인원</label>
					  <select class="form-select" aria-label="Default select example" name="RESERV_PERSON">
						  <option selected>인원선택</option>
						  <option value="1">1</option>
						  <option value="2">2</option>
						  <option value="3">3</option>
						  <option value="4">4</option>
						  <option value="4">4</option>
						</select>
				  </div>
			      </div>
			      <div class="modal-footer">
			      	<button class="btn btn-primary" data-bs-target="#exampleModalToggle" data-bs-toggle="modal">Back to 1111</button>
			        <button class="btn btn-primary" data-bs-target="#exampleModalToggle3" data-bs-toggle="modal">33333</button>
			      </div>
			    </div>
			  </div>
			</div>
			<div class="modal fade" id="exampleModalToggle3" aria-hidden="true" aria-labelledby="exampleModalToggleLabel3" tabindex="-1">
			  <div class="modal-dialog modal-dialog-centered">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalToggleLabel3">Modal 33333</h5>
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      <div class="modal-body">
				 	33333
			      </div>
			      <div class="modal-footer">
			        <button class="btn btn-primary" data-bs-target="#exampleModalToggle2" data-bs-toggle="modal">Back to 2222</button>
			         <button class="btn btn-primary" data-bs-target="#exampleModalToggle4" data-bs-toggle="modal">44444</button>
			      </div>
			    </div>
			  </div>
			</div>
			<div class="modal fade" id="exampleModalToggle4" aria-hidden="true" aria-labelledby="exampleModalToggleLabel4" tabindex="-1">
			  <div class="modal-dialog modal-dialog-centered">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalToggleLabel4">Modal 44444</h5>
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      <div class="modal-body">
				 	44444
			      </div>
			      <div class="modal-footer">
			        <button class="btn btn-primary" data-bs-target="#exampleModalToggle3" data-bs-toggle="modal">Back to 3333</button>
			         <button class="btn btn-primary" data-bs-target="#exampleModalToggle4" data-bs-toggle="modal">5555</button>
			      </div>
			    </div>
			  </div>
			</div>
</form>