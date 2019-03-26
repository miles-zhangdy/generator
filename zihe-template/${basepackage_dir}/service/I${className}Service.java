<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
<#assign classNameLowerCase = table.classNameLowerCase>  
package ${basepackage}.service;

import com.zdy.biz.${classNameLower}.dto.Create${className}Req;
import com.zdy.biz.${classNameLower}.dto.${className}Req;
import com.zdy.biz.${classNameLower}.dto.${className}Resp;
import com.zdy.biz.${classNameLower}.dto.Modify${className}Req;
import com.zdy.util.BaseList;
import com.zdy.util.ServiceResult;

public interface I${className}Service {
	
	ServiceResult<BaseList<${className}Resp>> find${className}ListByPageNo(${className}Req req);
	
	ServiceResult<${className}Resp> save(Create${className}Req req);
	
	ServiceResult<${className}Resp> update(Modify${className}Req req);
	
	ServiceResult<${className}Resp> getById(${className}Req req);
	
}
