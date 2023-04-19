package com.kbstar.dao;

import com.kbstar.dto.ProductDTO;
import com.kbstar.frame.MyDao;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements MyDao<String, ProductDTO> {

    @Override
    public void insert(ProductDTO productDTO) {

    }

    @Override
    public void delete(String s) {

    }

    @Override
    public void update(ProductDTO productDTO) {

    }

    @Override
    public ProductDTO select(String s) {
        ProductDTO product = null;
        product = new ProductDTO("id01","갤럭시폰",50,1000);
        return product;
    }

    @Override
    public List<ProductDTO> select() {
        List<ProductDTO> list = new ArrayList<>();
        list.add(new ProductDTO("id01","갤럭시폰",50,1000));
        list.add(new ProductDTO("id02","아이폰",60,2000));
        list.add(new ProductDTO("id03","팬택&큐리텔",10,2));
        return list;
    }
}
