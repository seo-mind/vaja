package com.example.demo.springjwt.models;

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
import jakarta.persistence.ManyToMany;
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
	private String name ;
	
    @Email
    @NotBlank
    @Size(max=50)
    private String email;

	@NotBlank
	@Size(max = 120)
	private String password;
	

    private Date regDt;

    private char grade;
    
    @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "tb_member_roles_test", 
			joinColumns = @JoinColumn(name = "member_no"), 
			inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<TbRolesTest> roles = new HashSet<>();

    

	public TbMemberTest() {
	}

	public TbMemberTest(String name, String memberId, String email, String password) {
		this.name = name;
		this.memberId = memberId;
		this.email = email;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public Set<TbRolesTest> getRoles() {
		return roles;
	}

	public void setRoles(Set<TbRolesTest> roles) {
		this.roles = roles;
	}
    


}
