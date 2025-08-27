package com.ruoyi.web.service.impl;

import com.github.pagehelper.Page;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssociationSelectImpl {

    /**
     *
     * @param objects
     * @param
     */
    public <T> TableDataInfo toList(Page<Object> objects, List<T> list) {
        TableDataInfo tableDataInfo=new TableDataInfo();
        tableDataInfo.setRows(list);
        tableDataInfo.setTotal(objects.getTotal());

        return tableDataInfo;
    }
}
