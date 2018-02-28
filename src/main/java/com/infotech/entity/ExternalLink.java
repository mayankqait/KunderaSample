package com.infotech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EXTERNAL_LINK", schema = "employeecombo@mysqlPU")
public class ExternalLink
{
    @Id
    @Column(name="EXT_LINK_ID")
   // @GeneratedValue(strategy = GenerationType.TABLE)
    private Long extLinkId;

    @Column(name = "LINK_TYPE")
    private String linkType;

    @Column(name = "LINK_ADDRESS")
    private String linkAddress;

    public ExternalLink()
    {
    }

    public ExternalLink(Long id,String type, String address)
    {
        this.extLinkId = id;
        this.linkType = type;
        this.linkAddress = address;
    }

	public Long getExtLinkId() {
		return extLinkId;
	}

	public void setExtLinkId(Long extLinkId) {
		this.extLinkId = extLinkId;
	}

	public String getLinkType() {
		return linkType;
	}

	public void setLinkType(String linkType) {
		this.linkType = linkType;
	}

	public String getLinkAddress() {
		return linkAddress;
	}

	public void setLinkAddress(String linkAddress) {
		this.linkAddress = linkAddress;
	}

	@Override
	public String toString() {
		return "ExternalLink [extLinkId=" + extLinkId + ", linkType=" + linkType + ", linkAddress=" + linkAddress + "]";
	}
   
    
}