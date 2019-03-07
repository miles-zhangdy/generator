<#include "/macro.include"/>
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.zdy.util.Page;
import lombok.Data;

@Data
public class ${className} extends Page implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	<#list table.columns as column>
    /**
     * ${column.columnAlias!}       db_column: ${column.sqlName} 
     */	
	private ${column.javaType} ${column.columnNameLower};
	</#list>
	
	private Long[] ids;
	
<@generateConstructor className/>

	public ${className}(${className} ${classNameLower}){
		if(null != ${classNameLower}){
			<#list table.columns as column>
				this.set${column.columnName}(${classNameLower}.get${column.columnName}());
			</#list>
		}
	}
	
	public Map<String,Object> toMap(){
		HashMap<String, Object> map = new HashMap<>();
		<#list table.columns as column>
		map.put("${column.columnNameLower}",this.${column.columnNameLower});
		</#list>
		return map;
	}


}







