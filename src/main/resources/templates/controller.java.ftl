package ${package.Controller};

import com.zzq.common.api.ApiResult;
import com.zzq.common.api.ApiCode;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import ${package.Service}.${table.serviceName};
import ${package.Entity}.${entity};
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * <p>
  * ${table.comment!} 前端控制器
  * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@Api(tags = {"${table.comment!}"})
@RestController
<#else>
@Controller
</#if>@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>class ${table.controllerName}<#if superControllerClass??>:${superControllerClass}()</#if><#else><#if superControllerClass??>public class ${table.controllerName} extends ${superControllerClass}{<#else>public class ${table.controllerName} {</#if>

    private Logger log = LoggerFactory.getLogger(getClass());
    @Resource
    private ${table.serviceName} ${(table.serviceName)?uncap_first};

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "${entity?uncap_first}", value = "${entity?uncap_first}实体"),
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping("${entity?uncap_first}Page")
    public ApiResult findListByPage(@RequestBody ${entity} ${entity?uncap_first},
                                   @RequestParam Integer size,
                                   @RequestParam Integer currentPage){
        try {
            return ApiResult.ok(${(table.serviceName)?uncap_first}.findListByPage(${entity?uncap_first},size,currentPage));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ApiResult.fail(ApiCode.FAIL);
        }
    }

    @ApiOperation(value = "新增数据")
    @PostMapping()
    public ApiResult add(@RequestBody ${entity} ${entity?uncap_first}){
        try {
            return ApiResult.ok(${(table.serviceName)?uncap_first}.save(${entity?uncap_first}));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ApiResult.fail(ApiCode.FAIL);
        }
    }

    @ApiOperation(value = "删除数据")
    @DeleteMapping("{id}")
    public ApiResult delete(@RequestParam("id") Long id){
        try {
            return ApiResult.ok(${(table.serviceName)?uncap_first}.removeById(id));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ApiResult.fail(ApiCode.FAIL);
        }
    }

    @ApiOperation(value = "更新数据")
    @PutMapping()
    public ApiResult update(@RequestBody ${entity} ${entity?uncap_first}){
        try {
            return ApiResult.ok(${(table.serviceName)?uncap_first}.updateById(${entity?uncap_first}));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ApiResult.fail(ApiCode.FAIL);
        }
    }
}
</#if>