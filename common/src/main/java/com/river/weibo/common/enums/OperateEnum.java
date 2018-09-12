package com.river.weibo.common.enums;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum OperateEnum {

    TOP("top", "赞"),
    DOWN("down", "踩"),
    DELETE("delete", "删除");

    private String code;
    private String desc;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    OperateEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static OperateEnum getByCode(String code) {
        OperateEnum operateEnum = Arrays.asList(OperateEnum.values()).stream().filter(o -> o.getCode()
                .equals(code)).findFirst().orElseThrow(() -> new IllegalArgumentException("参数不合法"));
        return operateEnum;
    }
}
