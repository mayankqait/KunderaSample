package com.infotech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PREFERENCE", schema = "employeecombo@mysqlPU")
public class Preference
{
    @Id
    @Column(name="PREFERENCE_ID")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long preferenceId;

    @Column(name = "WEBSITE_THEME")
    private String websiteTheme;

    @Column(name = "PRIVACY_LEVEL")
    private String privacyLevel; // 1, 2, 3

    public Preference()
    {
    }
    public Preference(Long id,String theme, String privacyLevel)
    {
        this.preferenceId = id;
        this.websiteTheme = theme;
        this.privacyLevel = privacyLevel;
    }
	public Long getPreferenceId() {
		return preferenceId;
	}
	public void setPreferenceId(Long preferenceId) {
		this.preferenceId = preferenceId;
	}
	public String getWebsiteTheme() {
		return websiteTheme;
	}
	public void setWebsiteTheme(String websiteTheme) {
		this.websiteTheme = websiteTheme;
	}
	public String getPrivacyLevel() {
		return privacyLevel;
	}
	public void setPrivacyLevel(String privacyLevel) {
		this.privacyLevel = privacyLevel;
	}
	
	@Override
	public String toString() {
		return "Preference [preferenceId=" + preferenceId + ", websiteTheme=" + websiteTheme + ", privacyLevel="
				+ privacyLevel + "]";
	}
    
	
}
