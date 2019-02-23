package com.zy.controller;

import com.zy.entities.Category;
import com.zy.entities.ProductInfo;
import com.zy.service.CategoryService;
import com.zy.service.ProductInfoService;
import com.zy.utils.ResultUtilVO;
import com.zy.viewObject.ProductInfoVO;
import com.zy.viewObject.ProductVO;
import com.zy.viewObject.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 买家商品
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductInfoService productInfoService;

    @GetMapping("/list")
    public ResultVO list(){
        //查询所有的上架商品
        List<ProductInfo> productInfoList = productInfoService.finUpAll();
        //查询类目(一次性查)
        List<Integer> categoryTypeList = new ArrayList<>();

        for (ProductInfo productInfo:productInfoList){
            categoryTypeList.add(productInfo.getCategoryType());
        }
        List<Category> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        //数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for (Category category:categoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(category.getCategoryType());
            productVO.setCategoryName(category.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo:productInfoList){
                //判断两个type是否相等
                if (productInfo.getCategoryType().equals(category.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    //spring的BeanUtils.copyProperties方法，可以把一个对象的值拷贝到另一个对象里去
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultUtilVO.success(productVOList);
        /*ResultVO resultVO = new ResultVO();
        resultVO.setData(productVOList);
        resultVO.setCode(0);
        resultVO.setMsg("success");
        return resultVO;*/
    }
}
