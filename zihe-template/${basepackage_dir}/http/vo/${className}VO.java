<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
<#assign classNameLowerCase = table.classNameLowerCase>  
package com.zdy.${classNameLowerCase}.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import ${basepackage}.model.${className};
import com.zdy.util.Page;

public class ${className}VO extends Page implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	<#list table.columns as column>
    /**
     * ${column.columnAlias!}       db_column: ${column.sqlName} 
     */	
	private ${column.javaType} ${column.columnNameLower};
	</#list>
	
	private Long[] ids;
	
	public void setIds(Long[] ids){
		this.ids = ids;
	}
	
	public Long[] getIds(){
		return this.ids;
	}
	

	public ${className}VO(){
		
	}
	
	public ${className}VO(${className}VO ${classNameLower}VO){
		if(null != ${classNameLower}VO){
			<#list table.columns as column>
				this.set${column.columnName}(${classNameLower}VO.get${column.columnName}());
			</#list>
		}
	}
	
	public ${className}VO(${className} ${classNameLower}){
		if(null != ${classNameLower}){
			<#list table.columns as column>
				this.${column.columnNameLower} = ${classNameLower}.get${column.columnName}();
			</#list>
		}
	}
	
	public ${className} to${className}(){
		${className}  ${classNameLower} = new ${className}();
		<#list table.columns as column>
		${classNameLower}.set${column.columnName}(this.${column.columnNameLower});
		</#list>
		return ${classNameLower};
	}
	public Map<String,Object> toMap(){
		HashMap<String, Object> map = new HashMap<>();
		<#list table.columns as column>
		map.put("${column.columnNameLower}",this.${column.columnNameLower});
		</#list>
		return map;
	}
	
<@generateJavaColumns/>

 
}

<#macro generateJavaColumns>
	<#list table.columns as column>
		
	public void set${column.columnName}(${column.javaType} value) {
		this.${column.columnNameLower} = value;
	}
	
	public ${column.javaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}
	</#list>
</#macro>
