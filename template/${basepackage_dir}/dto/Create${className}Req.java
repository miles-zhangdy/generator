<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>  
package ${basepackage}.dto;

import java.util.Date;
import ${basepackage}.model.${className};

public class Create${className}Req{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	<#list table.columns as column>
	<#if !column.pk>
	
	private ${column.javaType} ${column.columnNameLower};
	 </#if>
	</#list>
	
<#list table.columns as column>
<#if !column.pk>
	public void set${column.columnName}(${column.javaType} ${column.columnNameLower}) {
		this.${column.columnNameLower} = ${column.columnNameLower};
	}
	
	public ${column.javaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}
	</#if>
</#list>
	
	public Create${className}Req(){
		
	}
	
	public Create${className}Req(${className} ${classNameLower}){
		if(${classNameLower} != null){
			<#list table.columns as column>
			<#if !column.pk>
				this.set${column.columnName}(${classNameLower}.get${column.columnName}());
				</#if>
			</#list>
		}
	}
	public ${className} to${className}(){
		${className}  ${classNameLower} = new ${className}();
		<#list table.columns as column>
		<#if !column.pk>
		${classNameLower}.set${column.columnName}(this.${column.columnNameLower});
		</#if>
		</#list>
		return ${classNameLower};
	}
}
