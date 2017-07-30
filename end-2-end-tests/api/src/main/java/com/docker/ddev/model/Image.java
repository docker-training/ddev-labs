package com.docker.ddev.model;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="images", uniqueConstraints = { @UniqueConstraint(columnNames = "imageid")})
@JsonInclude(Include.NON_NULL)
public class Image implements Serializable {

	private static final long serialVersionUID = 3222530297013481114L;
	 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long imageId;
    
    @NotEmpty
    @Column(name = "url", length = 255, nullable = false)
    private String url;
    
    @Column(name = "description", length=10485760, nullable = false)
    private String description;
          
	public Image() {
		
	}
	
	public Image(Long imageId, String url, String description, double price, String image) {
		this.imageId = imageId;
		this.url = url;
		this.description = description;
	}

    public long getImageId() {
    	return imageId;
    }
    
    public void setImageId(long imageId) {
        this.imageId = imageId;
    }
 
    public String getUrl() {
        return url;
    }
 
    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getDescription() {
    	return description;
    }
    
    public void setDescription(String description) {
    	this.description = description;
    }
    
	@Override
	public String toString() {
		return "Image [imageId=" + imageId +
				         ", url=" + url +
				         ", description=" + description +
				         "]";
	}
	
}