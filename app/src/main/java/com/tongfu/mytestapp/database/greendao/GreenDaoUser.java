package com.tongfu.mytestapp.database.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class GreenDaoUser {
    @Id(autoincrement = true)
    @Index
    private Long id ;
    private String name ;
    @Generated(hash = 758334243)
    public GreenDaoUser(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    @Generated(hash = 83249558)
    public GreenDaoUser() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
