package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzq.common.pagination.Paging;

/**
 * <p>
  * ${table.comment!} 服务实现类
  * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

    @Override
    public Paging<${entity}> findListByPage(${entity} ${entity?uncap_first}, long size, long currentPage){
      Page<${entity}> page = new Page<>();
      page.setSize(size);
      page.setCurrent(currentPage);
      LambdaQueryWrapper<${entity}> wrapper = new QueryWrapper<${entity}>().lambda();
      IPage<${entity}> iPage = baseMapper.selectPage(page,wrapper);
      return new Paging<>(iPage);

    }
}
</#if>