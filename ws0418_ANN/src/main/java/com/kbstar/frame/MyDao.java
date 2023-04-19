package com.kbstar.frame;

import com.kbstar.dto.ProductDTO;

import java.util.List;

public interface MyDao<K,V> {
    public void insert(V v);
    public void delete(K k);
    public void update(V v);
    public ProductDTO select(K k);
    public List<ProductDTO> select();
}
