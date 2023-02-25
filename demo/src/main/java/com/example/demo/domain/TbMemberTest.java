package com.example.demo.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.util.Date;


@Entity
@DynamicInsert
@Table(name="TB_MEMBER_TEST")
public class TbMemberTest{

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_MEMBER_TEST_SEQ")
    @SequenceGenerator(name = "TB_MEMBER_TEST_SEQ",sequenceName="TB_MEMBER_TEST_SEQ", allocationSize=1 )
    private Long memberNo;

    private String memberId;

    private String name;

    private String email;

    private Date regDt;

    private char grade;

	public Long getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegDt() {
		return regDt;
	}

	public void setRegDt(Date regDt) {
		this.regDt = regDt;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}
    
    


}
