package com.kbstar.service;

import com.kbstar.dto.ProductDTO;
import com.kbstar.frame.MyDao;
import com.kbstar.frame.MyService;

import java.util.List;

public class ProductService implements MyService<String, ProductDTO> {
    MyDao<String, ProductDTO> dao;
    public ProductService(MyDao dao){
        this.dao = dao;
    }
    @Override
    public void register(ProductDTO productDTO) {
        dao.insert(productDTO);
        System.out.println(dao);
        System.out.println("상품이 등록 되었다");
    }

    @Override
    public void remove(String s) {
        dao.delete(s);
        System.out.println("상품이 삭제되었다");
    }

    @Override
    public void modify(ProductDTO productDTO) {
        dao.update(productDTO);
        System.out.println("Send Mail...");
    }

    @Override
    public ProductDTO get(String s) {
        System.out.println(s+" 상품이 조회되었다");
        return dao.select(s);
    }

    @Override
    public List<ProductDTO> get() {
        System.out.println("모든 상품을 조회했다");
        return dao.select();
    }
}
