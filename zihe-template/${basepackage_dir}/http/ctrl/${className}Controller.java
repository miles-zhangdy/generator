<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
<#assign classNameLowerCase = table.classNameLowerCase>  
package com.zdy.${classNameLowerCase}.ctrl;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zdy.biz.${classNameLowerCase}.dto.Create${className}Req;
import com.zdy.biz.${classNameLowerCase}.dto.${className}Req;
import com.zdy.biz.${classNameLowerCase}.dto.${className}Resp;
import com.zdy.biz.${classNameLowerCase}.dto.Modify${className}Req;
import com.zdy.biz.${classNameLowerCase}.service.I${className}Service;
import com.zdy.common.Constant;
import com.zdy.common.model.SessionUser;
import com.zdy.demand.vo.DemandVO;
import com.zdy.exception.MyException;
import com.zdy.util.BaseController;
import com.zdy.util.BaseList;
import com.zdy.util.Result;
import com.zdy.util.ServiceResult;

@Controller
@RequestMapping("/${classNameLower}/*")
public class ${className}Controller extends BaseController {
	
	@Resource
	private I${className}Service ${classNameLowerCase}Service;

	@RequestMapping(value = "/to${classNameLowerCase}page")
	public ModelAndView to${className}Page() {
		ModelAndView mv = new ModelAndView("${classNameLower}/${classNameLower}List");

		return mv;
	}
	
	@RequestMapping(value = "/find${classNameLowerCase}list")
	@ResponseBody
	public Result find${className}List(${className}VO vo) throws MyException {
		Result res = null;
		try {
			${className}Req d = new ${className}Req(vo.to${className}());
			d.setBeginIndex((vo.getPage() - 1) * vo.getPageSize());
			d.setPage(vo.getPage());
			d.setPageSize(vo.getPageSize());
			ServiceResult<BaseList<${className}Resp>> serviceResult = ${classNameLowerCase}Service.find${className}ListByPageNo(d);
			if (serviceResult.isSuccess()) {
				res = new Result(true, serviceResult.getBusinessObject());
			} else {
				return new Result(false, "获取数据错误");
			}
		} catch (Exception e) {
			throw new MyException("获取列表错误", e);
		}
		return res;
	}
	
	@RequestMapping(value = "/add${classNameLowerCase}")
	@ResponseBody
	public Result add${className}(${className}VO vo) throws MyException {
		Result res = null;
		try {
			HttpSession session = getSession();
			SessionUser sessionUser = (SessionUser) session.getAttribute(Constant.ENVIRONMENT_USER);
			vo.setCreateUser(sessionUser.getId());
			ServiceResult<${className}Resp> serviceResult = ${classNameLowerCase}Service
					.save(new Create${className}Req(vo.to${className}()));
			if (serviceResult != null && serviceResult.isSuccess()) {
				res = new Result(true, serviceResult.getMsg());
			} else {
				res = new Result(false, "添加失败");
			}
		} catch (Exception e) {
			throw new MyException("添加信息异常", e);
		}
		return res;
	}
	
	@RequestMapping(value = "/delete${classNameLowerCase}")
	@ResponseBody
	public Result delete${className}(String id) throws MyException {
		Result res = null;
		try {
			${className}Req req = new ${className}Req();
			String[] array = id.split(",");
			Long[] a = new Long[array.length];
			int i = 0;
			for (String str : array) {
				a[i++] = Long.parseLong(str);
			}
			req.setIds(a);
			ServiceResult<${className}Resp> serviceResult = ${classNameLowerCase}Service.delete(req);
			if (serviceResult.isSuccess()) {
				res = new Result(true, serviceResult.getMsg());
			} else {
				return new Result(false, serviceResult.getMsg());
			}
		} catch (Exception e) {
			throw new MyException("删除数据异常", e);
		}
		return res;
	}

	@RequestMapping(value = "/modify${classNameLowerCase}")
	@ResponseBody
	public Result modify${className}(${className}VO vo) throws MyException {
		Result res = null;
		try {
			ServiceResult<${className}Resp> serviceResult = ${classNameLowerCase}Service.update(new Modify${className}Req(vo.to${className}()));
			if (serviceResult.isSuccess()) {
				res = new Result(true, serviceResult.getMsg());
			} else {
				return new Result(false, serviceResult.getMsg());
			}
		} catch (Exception e) {
			throw new MyException("修改数据异常", e);
		}
		return res;
	}
	
	@RequestMapping(value = "/get${classNameLowerCase}")
	@ResponseBody
	public Result getUser(Long id) throws MyException {
		Result res = null;
		try {
			${className}Req req = new ${className}Req();
			req.setId(id);
			ServiceResult<${className}Resp> serviceResult = ${classNameLowerCase}Service.getById(req);
			if (serviceResult.isSuccess()) {
				res = new Result(true, serviceResult.getBusinessObject());
			} else {
				return new Result(false, serviceResult.getMsg());
			}
		} catch (Exception e) {
			throw new MyException("获取数据异常", e);
		}
		return res;
	}
		
}
