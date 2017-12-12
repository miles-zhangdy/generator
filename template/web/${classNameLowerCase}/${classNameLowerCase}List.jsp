<#include "/macro.include"/> 
<#include "/custom.include"/> 
<#assign className = table.className>   
<#assign classNameLowerCase = className?lower_case>
<#assign classNameLower = className?uncap_first>  
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>XX管理</title>
<%@ include file="../static/top.jsp"%>
<style type="text/css">
th {
	text-align: center;
}

td {
	text-align: center;
}
</style>
</head>
<body class="fixed-left">
	<!-- Begin page -->
	<div id="wrapper">

		<!-- Top Bar Start -->
		<%@ include file="../static/header.jsp"%>
		<!-- Top Bar End -->

		<!-- ========== Left Sidebar Start ========== -->
		<%@ include file="../static/left.jsp"%>
		<!-- Left Sidebar End -->

		<!-- ============================================================== -->
		<!-- Start right Content here -->
		<!-- ============================================================== -->
		<div class="content-page">
			<!-- Start content -->
			<div class="content">
				<div class="container">

					<!-- Page-Title -->
					<div class="row">
						<div class="col-sm-12">
							<h4 class="page-title">${classNameLowerCase }</h4>
							<ol class="breadcrumb">
								<li>Ubold</li>
								<li>Tables</li>
								<li class="active">${classNameLowerCase }</li>
							</ol>
						</div>

					</div>

					<div class="row">
						<div class="col-sm-12">
							<div class="card-box">
								<form class="form-inline" id="search-frm">
									<div class="form-group col-sm-3">
										<label for="userName">XXX</label> <input type="text"
											class="form-control" id="XXX" placeholder="XXX">
									</div>
									<button type="button" class="btn btn-default"
										onclick="queryList(1, 10, true)">查询</button>
								</form>
							</div>
							<div class="card-box">
								<div class="box-icon">
									<a href="javascript:void(0)"
										class="btn btn-setting btn-round btn-default" id="addBtn">
										<i class="glyphicon glyphicon-plus">&nbsp;增加</i>
									</a> <a href="javascript:void(0)"
										class="btn btn-danger waves-effect waves-light" id="deleteBtn">
										<i class="glyphicon  glyphicon-remove">&nbsp;删除</i>
									</a>
								</div>
								<table id="datatable" class="table table-striped table-bordered">
									<thead>
										<tr>
											<th><input type="checkbox" id="checkall"></th>
										<#list table.columns as column>
											<th>${column.columnAlias}</th>
										</#list>
				                        	<th>操作</th>
										</tr>
									</thead>
									<tbody>
									</tbody>
								</table>
								<div class="row">
									<div class="col-md-12">
										<div id="pagetable" class="pagination"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- container -->
			</div>
			<!-- content -->
			<%@ include file="../static/footer.jsp"%>
		</div>
		<!-- ============================================================== -->
		<!-- End Right content here -->
		<!-- ============================================================== -->

		<!-- Right Sidebar -->

		<!-- /Right-bar -->

		<div class="modal fade" id="editModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">

			<div class="modal-dialog" style="width: 60%;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">×</button>
						<h3>XX信息</h3>
					</div>
					<form class="form-horizontal validate" id="edit-frm">
						<input type="hidden" name="id" id="id"> <input
							type="hidden" name="editFlag" id="editFlag">
						<div class="modal-body">
							<div class="col-md-6">
								<#list table.columns as column>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">${column.columnAlias}</label>
                                    <div class="col-md-10">
                                        <input type="text" class="form-control" id="${column.columnNameLower}" name="${column.columnNameLower}">
                                    </div>
                                </div>
                                </#list>
               				</div>
               				<div class="col-md-6"></div>
						</div>
						<div class="modal-footer">
							<button class="btn btn-default" data-dismiss="modal">取消</button>
							<button type="submit" class="btn btn-primary">保存</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- END wrapper -->
	<!-- Examples -->
	<script src="pages/${classNameLower }/${classNameLower }List.js"></script>
</body>
</html>