package com.qh.venus.achilles.pts.sys.domain;

public class CheckUnique {

    private String tableName;
    private String colName;
    private String colValue;

    private String idName;

    private String idValue;



    public String getTableName() {
        return tableName;
    }

    public String getColName() {
        return colName;
    }

    public String getColValue() {
        return colValue;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    public void setColValue(String colValue) {
        this.colValue = colValue;
    }

    public String getIdName() {
        return idName;
    }

    public void setIdName(String idName) {
        this.idName = idName;
    }

    public String getIdValue() {
        return idValue;
    }

    public void setIdValue(String idValue) {
        this.idValue = idValue;
    }
}
