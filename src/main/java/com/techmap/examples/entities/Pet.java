package com.techmap.examples.entities;

import java.util.Date;

public class Pet
{
    private String ownerId;
    private String petId;
    private String petName;
    private String petType;
    private Date birthday;
    
    public String getOwnerId()
    {
        return ownerId;
    }
    
    public Pet setOwnerId(String ownerId)
    {
        this.ownerId = ownerId;
        return this;
    }
    
    public String getPetId()
    {
        return petId;
    }
    
    public Pet setPetId(String petId)
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
