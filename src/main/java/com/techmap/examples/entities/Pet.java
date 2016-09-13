package com.techmap.examples.entities;

import java.util.Date;

public class Pet
{
    private Integer ownerId;
    private Integer petId;
    private String petName;
    private String petType;
    private Date birthday;
    
    public Integer getOwnerId()
    {
        return ownerId;
    }
    
    public Pet setOwnerId(Integer ownerId)
    {
        this.ownerId = ownerId;
        return this;
    }
    
    public Integer getPetId()
    {
        return petId;
    }
    
    public Pet setPetId(Integer petId)
    {
        this.petId = petId;
        return this;
    }
    
    public String getPetName()
    {
        return petName;
    }
    
    public Pet setPetName(String petName)
    {
        this.petName = petName;
        return this;
    }
    
    public String getPetType()
    {
        return petType;
    }
    
    public Pet setPetType(String petType)
    {
        this.petType = petType;
        return this;
    }
    
    public Date getBirthday()
    {
        return birthday;
    }
    
    public Pet setBirthday(Date birthday)
    {
        this.birthday = birthday;
        return this;
    }
    
    @Override
    public String toString()
    {
        return "Pet [ownerId=" + ownerId + ", petId=" + petId + ", petName=" + petName + ", petType=" + petType + ", birthday=" + birthday + "]";
    }
    
    public Pet()
    {
        super();
    }
    
}
