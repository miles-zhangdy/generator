<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>  
<#assign classNameLowerCase = table.classNameLowerCase>  
package ${basepackage}.dto;

import ${basepackage}.model.${className};
import java.util.Date;


public class Modify${className}Req  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	<#list table.columns as column>
	private ${column.javaType} ${column.columnNameLower};
	</#list>
	
<#list table.columns as column>
	public void set${column.columnName}(${column.javaType} ${column.columnNameLower}) {
		this.${column.columnNameLower} = ${column.columnNameLower};
	}
	
	public ${column.javaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}
</#list>

	public Modify${className}Req(){
		
	}
	
	public Modify${className}Req(${className} ${classNameLower}){
		if(${classNameLower} != null){
		<#list table.columns as column>
			this.set${column.columnName}(${classNameLower}.get${column.columnName}());
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
	
}
