<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
<#assign classNameLowerCase = table.classNameLowerCase>  
package ${basepackage}.dto;

import ${basepackage}.model.${className};
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class ${className}ListResp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ${className}Resp[] list;
	

}

