package com.example.demo;


import java.sql.Timestamp;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
public class Reply {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer rno;
	
	@Column(nullable = false)
	private Integer bno;
	
	@Column(length = 1000, nullable = false)
	private String reply;
	
	@Column(length = 50, nullable = false)
	private String replyer;
	
	@Temporal(TemporalType.DATE)
	private Timestamp replyDate;
	
	@Temporal(TemporalType.DATE)
	private Timestamp updateDate;
	
	
}
