<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>  
<#assign classNameLowerCase = table.classNameLowerCase>  
package ${basepackage}.dto;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import ${basepackage}.model.${className};
import com.zdy.util.Page;


import lombok.Data;

@Data
public class ${className}Req extends Page {
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
	
	public ${className}Req(){
		
	}
	
	public ${className}Req(${className}Req ${classNameLower}Req){
		if(null != ${classNameLower}Req){
			<#list table.columns as column>
				this.set${column.columnName}(${classNameLower}Req.get${column.columnName}());
			</#list>
			this.setSortName(${classNameLower}Req.getSortName());
			this.setOrder(${classNameLower}Req.getOrder());
		}
	}
	
	public ${className}Req(${className} ${classNameLower}){
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
		${classNameLower}.setIds(this.ids);
		return ${classNameLower};
	}
	
	public Map<String,Object> toMap(){
		HashMap<String, Object> map = new HashMap<>();
		<#list table.columns as column>
		map.put("${column.columnNameLower}",this.${column.columnNameLower});
		</#list>
		return map;
	}


 
	
 
}
