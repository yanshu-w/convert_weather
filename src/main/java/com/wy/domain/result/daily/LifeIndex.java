package com.wy.domain.result.daily;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;
import lombok.Data;

import java.util.List;

@Data
public class LifeIndex {

    private List<Value> ultraviolet;

    private List<Value> carWashing;

    private List<Value> dressing;

    private List<Value> comfort;

    private List<Value> coldRisk;

    public List<Value> getUltraviolet() {
        return CollUtil.isEmpty(ultraviolet) ? ListUtil.empty() : ultraviolet;
    }

    public List<Value> getCarWashing() {
        return CollUtil.isEmpty(carWashing) ? ListUtil.empty() : carWashing;
    }

    public List<Value> getDressing() {
        return CollUtil.isEmpty(dressing) ? ListUtil.empty() : dressing;
    }

    public List<Value> getComfort() {
        return CollUtil.isEmpty(comfort) ? ListUtil.empty() : comfort;
    }

    public List<Value> getColdRisk() {
        return CollUtil.isEmpty(coldRisk) ? ListUtil.empty() : coldRisk;
    }

    @Data
    public static
    class Value {

        private String date;

        private Integer index;

        private String desc;

    }
}
