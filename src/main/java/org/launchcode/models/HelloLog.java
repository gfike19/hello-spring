package org.launchcode.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="hellolog")
public class HelloLog {
	private String name;
	private Date timestamp;
	private int uid;
	
	public HelloLog(String name) {
		this.name = name;
		timestamp = new Date();
	}
	
	public HelloLog() {} //needed for Hibernate
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@NotNull
	@Column(name = "timestamp") //also adding nullable = false
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	@Id
	@GeneratedValue
	@Column(name = "uid", unique = true)
	private int getUid() {
		return uid;
	}

	private void setUid(int uid) {
		this.uid = uid;
	}
	
}
