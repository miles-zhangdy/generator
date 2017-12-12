<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
<#assign classNameLowerCase = table.classNameLowerCase>  
package ${basepackage}.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;





import ${basepackage}.dao.I${className}Dao;
import com.zdy.biz.demand.dto.CreateDemandReq;
import ${basepackage}.dto.${className}Req;
import ${basepackage}.dto.${className}Resp;
import ${basepackage}.dto.Modify${className}Req;
import ${basepackage}.model.${className};
import ${basepackage}.service.I${className}Service;
import com.zdy.util.BaseList;
import com.zdy.util.ServiceResult;

import annotation.ReadDataSource;
import annotation.WriteDataSource;

@Service
public class ${className}ServiceImpl implements I${className}Service {

	@Resource
	private I${className}Dao ${table.classNameFirstLower}Dao; 	

	@ReadDataSource
	@Override
	public ServiceResult<BaseList<${className}Resp>> find${className}ListByPageNo(${className}Req req) {
		ServiceResult<BaseList<${className}Resp>> result = new ServiceResult<BaseList<${className}Resp>>();
		if (req == null) {
			return result.error("查询条件不能为空");
		}

		List<${className}> baseList = ${table.classNameFirstLower}Dao.findList(req.to${className}());
		int totalRows = ${table.classNameFirstLower}Dao.count(req.to${className}());
		int pageSize = req.getPageSize();
		int totalPage = totalRows % pageSize > 0 ? totalRows / pageSize + 1 : totalRows / pageSize + 1;

		List<${className}Resp> list = new ArrayList<${className}Resp>();
		if (!CollectionUtils.isEmpty(baseList)) {
			for (${className} temp : baseList) {
				if (temp == null) {
					continue;
				}
				list.add(new ${className}Resp(temp));
			}
		}

		BaseList<${className}Resp> ${table.classNameFirstLower}List = new BaseList<${className}Resp>();
		${table.classNameFirstLower}List.setList(list);
		${table.classNameFirstLower}List.setCurPage(req.getPage());
		${table.classNameFirstLower}List.setPageSize(pageSize);
		${table.classNameFirstLower}List.setTotalPage(totalPage);
		${table.classNameFirstLower}List.setTotalRows(totalRows);
		return result.success(${table.classNameFirstLower}List);
	}
	@WriteDataSource
	@Transactional
	@Override
	public ServiceResult<${className}Resp> save(Create${className}Req req) {
		ServiceResult<${className}Resp> result = new ServiceResult<${className}Resp>();
		if (req == null) {
			return result.error("保存对象不能为空");
		}
		${className} d = req.to${className}();

		int count = ${table.classNameFirstLower}Dao.save(d);
		if (count == 0) {
			return result.error("保存失败");
		}
		return result.success();
	}
	
	@WriteDataSource
	@Transactional
	@Override
	public ServiceResult<${className}Resp> delete(${className}Req req) {
		ServiceResult<${className}Resp> result = new ServiceResult<${className}Resp>();
		if (req == null || ObjectUtils.isEmpty(req.getIds())) {
			return result.error("删除条件不能为空");
		}

		int count = ${table.classNameFirstLower}Dao.delete(req.to${className}());
		if (count == 0) {
			return result.error("删除失败");
		}
		return result.success();
	}
	
	@WriteDataSource
	@Transactional
	@Override
	public ServiceResult<${className}Resp> update(Modify${className}Req req) {

		ServiceResult<${className}Resp> result = new ServiceResult<${className}Resp>();
		if (req == null) {
			return result.error("修改条件不能为空");
		}
		int count = ${table.classNameFirstLower}Dao.update(req.to${className}());
		if (count == 0) {
			return result.error("修改失败");
		}
		return result.success();
	}

	@Override
	public ServiceResult<${className}Resp> deleteById(${className}Req req) {

		return null;
	}

	@ReadDataSource
	@Override
	public ServiceResult<${className}Resp> getById(${className}Req req) {
		ServiceResult<${className}Resp> result = new ServiceResult<${className}Resp>();
		if (req == null || req.getId() == null) {
			return result.error("查询条件不能为空");
		}
		${className} ${className} = ${table.classNameFirstLower}Dao.getById(req.getId());
		if(${className} == null || ${className}.getId() == null){
			return result.error("获取失败");
		}
		return result.success(new ${className}Resp(${className}));
	}

	
}
