package com.infotech.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PersonalDetail
{
    @Column(name = "personal_detail_id")
    private String personalDetailId;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "rel_status")
    private String relationshipStatus;

    public PersonalDetail()
    {
    }
    public PersonalDetail(String id,String name, String password, String relationshipStatus)
    {
        setPersonalDetailId(id);
        setName(name);
        setPassword(password);
        setRelationshipStatus(relationshipStatus);
    }
	public String getPersonalDetailId() {
		return personalDetailId;
	}
	public void setPersonalDetailId(String personalDetailId) {
		this.personalDetailId = personalDetailId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRelationshipStatus() {
		return relationshipStatus;
	}
	public void setRelationshipStatus(String relationshipStatus) {
		this.relationshipStatus = relationshipStatus;
	}
	
	@Override
	public String toString() {
		return "PersonalDetail [personalDetailId=" + personalDetailId + ", name=" + name + ", password=" + password
				+ ", relationshipStatus=" + relationshipStatus + "]";
	}
    
    
}
