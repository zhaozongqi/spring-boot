package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};
import com.zzq.common.pagination.Paging;

/**
 * <p>
  * ${table.comment!} 服务类
  * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

    /**
     * 查询分页数据
     * @param ${entity?uncap_first}
     */
    Paging<${entity}> findListByPage(${entity} ${entity?uncap_first} ,long size, long currentPage);


}
</#if>
