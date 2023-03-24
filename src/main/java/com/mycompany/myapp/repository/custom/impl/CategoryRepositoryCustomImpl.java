package com.mycompany.myapp.repository.custom.impl;

import com.mycompany.myapp.model.CategoryRequest;
import com.mycompany.myapp.model.response.CategoryResponse;
import com.mycompany.myapp.repository.custom.CategoryRepositoryCustom;
import com.mycompany.myapp.utils.Datautils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryRepositoryCustomImpl implements CategoryRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<CategoryResponse> search(CategoryRequest category, Pageable pageable) {
        Query query = buildQuerySearch(category, pageable);
        List<Object[]> objs = query.getResultList();
        if (Datautils.notNullOrEmpty(objs)) {
            List<CategoryResponse> result = new LinkedList<>();
            for (Object[] obj : objs) {
                int i = 0;
                CategoryResponse e = new CategoryResponse();
                e.setId(Datautils.safeToString(obj[i++]));
                e.setName(Datautils.safeToString(obj[i++]));
                e.setDescription(Datautils.safeToString(obj[i++]));
                e.setStatus(Datautils.safeToString(obj[i++]));
                result.add(e);
            }
            return result;
        }
        return new LinkedList<>();
    }

    private Query buildQuerySearch(CategoryRequest request, Pageable pageable) {
        String from = pageable == null ? "COUNT(1)\n" : "c.id," + " c.name," + " c.description," + " c.status\n";
        String select = "Select\n" + from + "from category c where 1=1\n";
        StringBuilder sb = new StringBuilder(select);
        Map<String, Object> params = new HashMap<>();
        if (Datautils.notNullOrEmpty(request.getName())) {
            sb.append("and (UPPER(c.name) LIKE CONCAT('%',UPPER(:name),'%'))\n");
            params.put("name", request.getName());
        }

        Query query = em.createNativeQuery(sb.toString());
        params.forEach(query::setParameter);
        if (pageable != null) {
            query.setFirstResult((int) pageable.getOffset());
            query.setMaxResults(pageable.getPageSize());
        }
        return query;
    }

    @Override
    public long count(CategoryRequest categoryRequest) {
        Query query = buildQuerySearch(categoryRequest, null);
        return Datautils.safeToLong(query.getSingleResult());
    }
}
