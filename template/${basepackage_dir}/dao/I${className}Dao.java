<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign classNameLowerCase = table.classNameLowerCase>  
package com.zdy.biz.${classNameLowerCase}.dao;

import ${basepackage}.model.${className};
import com.zdy.util.ISuperDao;
public interface I${className}Dao  extends ISuperDao<${className}> {
	
}
