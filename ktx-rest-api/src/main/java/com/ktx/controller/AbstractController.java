package com.ktx.controller;

import com.ktx.common.condition.RestPreConditions;
import com.ktx.common.interfaces.IWithAllFields;
import com.ktx.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AbstractController<E extends IWithAllFields> extends AbstractReadOnlyController {

    @Autowired
    private ProductServiceImpl productService;


    public void updateInternal(final int id,final E resource){
        RestPreConditions.checkRequestElementNotNull(resource);
        RestPreConditions.checkRequestElementNotNull(resource.getId());
        RestPreConditions.checkRequestState(resource.getId()==id,resource.getClass().getSimpleName()+"id and URI id doesn't match");
    }

    public void deleteInternal(final int id){
        RestPreConditions.checkRequestElementNotNull(id);
    }

}
