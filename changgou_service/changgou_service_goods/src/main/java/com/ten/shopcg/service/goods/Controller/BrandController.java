package com.ten.shopcg.service.goods.Controller;

import com.changgou.goods.pojo.Brand;
import com.github.pagehelper.Page;
import com.ten.shopcg.common.pojo.PageResult;
import com.ten.shopcg.common.pojo.Result;
import com.ten.shopcg.common.pojo.StatusCode;
import com.ten.shopcg.service.goods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/brand")
@RestController
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping
    public Result<List<Brand>> findList(){
        List<Brand> brandList = brandService.findList();
        return new Result<>(true, StatusCode.OK,"查询成功",brandList);
    }

    @GetMapping("/{id}")
    public Result<Brand> findById(@PathVariable("id") Integer id){
        Brand brand = brandService.findById(id);
        return new Result<>(true,StatusCode.OK,"查询成功",brand);
    }

    @PostMapping
    public Result add(@RequestBody Brand brand){
        brandService.add(brand);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable("id") Integer id,@RequestBody Brand brand){
        brand.setId(id);
        brandService.update(brand);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    @DeleteMapping("/{id}")
    public Result delById(@PathVariable("id") Integer id){
        brandService.delById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    @GetMapping("/search")
    public Result<List<Brand>> search(@RequestParam Map searchMap){
        List<Brand> list = brandService.list(searchMap);
        return new Result<>(true,StatusCode.OK,"查询成功",list);
    }

    @GetMapping("/search/{page}/{size}")
    public Result finePage(@PathVariable("page") Integer page,@PathVariable("size") Integer size){
        Page<Brand> pageInfo = brandService.findPage(page, size);
        PageResult pageResult = new PageResult(pageInfo.getTotal(),pageInfo.getResult());
        return new Result(true,StatusCode.OK,"查询成功",pageResult);
    }

    @GetMapping("/searchPage/{page}/{size}")
    public Result findPage(@RequestParam Map searchMap,@PathVariable("page") Integer page,@PathVariable("size") Integer size){
        Page pageInfo = brandService.findPage(searchMap, page, size);
        PageResult pageResult = new PageResult(pageInfo.getTotal(),pageInfo.getResult());
        return new Result(true,StatusCode.OK,"查询成功",pageResult);

    }
}
