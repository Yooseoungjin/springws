package com.kbstar.service;

import com.kbstar.dto.ProductDTO;
import com.kbstar.frame.MyDao;
import com.kbstar.frame.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("pservice")
public class ProductService implements MyService<String, ProductDTO> {
    @Autowired
    @Qualifier("pdao")
    MyDao<String, ProductDTO> dao;

//    아래와 같은 방식도 가능(우리는 오라클만 할꺼야! 하는경우에)
//    @Autowired
//    ProductDTO dao;

    @Override
    public void register(ProductDTO productDTO) {
            dao.insert(productDTO);
    }

    @Override
    public void remove(String s) {

    }

    @Override
    public void modify(ProductDTO productDTO) {

    }

    @Override
    public ProductDTO get(String s) {
        return null;
    }

    @Override
    public List<ProductDTO> get() {
        return null;
    }
}
