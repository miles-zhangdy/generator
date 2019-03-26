<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign classNameLowerCase = table.classNameLowerCase>  
package ${daopackage}.${classNameLowerCase};

import ${basepackage}.model.${className};
import com.zihe.util.ISuperDao;
public interface I${className}Dao  extends ISuperDao<${className}> {
	
}
