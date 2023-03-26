package com.example.demo.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.persistence.JoinColumn;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@DynamicInsert
@Table(name="TB_MEMBER_TEST", 
	uniqueConstraints = { 
		@UniqueConstraint(columnNames = "name"),
		@UniqueConstraint(columnNames = "email") 
	})
public class TbMemberTest{

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_MEMBER_TEST_SEQ")
    @SequenceGenerator(name = "TB_MEMBER_TEST_SEQ",sequenceName="TB_MEMBER_TEST_SEQ", allocationSize=1 )
    private Long memberNo;

    @NotBlank
    @Size(max=30)
    private String memberId;
    
    @NotBlank
    @Size(max=30)
    private String name;
    
    @Email
    @NotBlank
    @Size(max=50)
    private String email;

    private Date regDt;

    private char grade;
    
    @OneToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "member_roles", 
			joinColumns = @JoinColumn(name = "user_id"), 
			inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<TbRolesTest> roles = new HashSet<>();

    

	public TbMemberTest() {
	}

	public TbMemberTest(String memberId, String name, String email) {
		this.memberId = memberId;
		this.name = name;
		this.email = email;
	}
	
    

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
