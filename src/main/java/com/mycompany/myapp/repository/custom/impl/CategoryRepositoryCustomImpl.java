package com.mycompany.myapp.repository.custom.impl;

import com.mycompany.myapp.model.CategoryRequest;
import com.mycompany.myapp.repository.custom.CategoryRepositoryCustom;
import com.mycompany.myapp.service.dto.CategoryDTO;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryRepositoryCustomImpl implements CategoryRepositoryCustom {

    @Override
    public List<CategoryDTO> search(CategoryRequest category, Pageable pageable) {
        return null;
    }

    @Override
    public long count(CategoryRequest categoryRequest) {
        return 0;
    }
}
