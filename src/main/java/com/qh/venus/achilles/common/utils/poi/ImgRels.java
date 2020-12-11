package com.qh.venus.achilles.common.utils.poi;

import lombok.Getter;

/**
 * @author liqiang
 * 图片rels
 */
@Getter
public class ImgRels {
    private int id;
    private String rId;
    private String name;

    public ImgRels(int id, String name) {
        this.id = id;
        this.name = name;
        this.rId = "rId" + id;
    }
}
