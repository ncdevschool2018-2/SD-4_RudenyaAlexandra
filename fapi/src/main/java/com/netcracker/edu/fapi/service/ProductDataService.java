package com.netcracker.edu.fapi.service;
import com.netcracker.edu.fapi.entity.ProductViewModel;
import com.netcracker.edu.fapi.service.impl.RestPageImpl;
import org.springframework.data.domain.PageImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ProductDataService {
    List<ProductViewModel> getAll();
    ProductViewModel getProductById(Long id);
    ProductViewModel saveProduct(ProductViewModel product);
    void deleteProduct(Long id);
    List<ProductViewModel> getProductByCategoryId(Integer id);
    RestPageImpl<ProductViewModel> getProductPage(HttpServletRequest request);
}
