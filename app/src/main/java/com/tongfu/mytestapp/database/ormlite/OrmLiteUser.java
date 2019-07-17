package com.tongfu.mytestapp.database.ormlite;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "user")
public class OrmLiteUser {
    @DatabaseField(columnName = "id" , generatedId = true ,index =  true ,unique = true)
    private int id ;
    @DatabaseField(columnName = "name")
    private String name ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
