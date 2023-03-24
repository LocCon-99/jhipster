package com.mycompany.myapp.repository.custom;

import com.mycompany.myapp.model.CategoryRequest;
import com.mycompany.myapp.model.response.CategoryResponse;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface CategoryRepositoryCustom {
    List<CategoryResponse> search(CategoryRequest category, Pageable pageable);

    long count(CategoryRequest categoryRequest);
}
