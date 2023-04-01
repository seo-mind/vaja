package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.MemberService;
import com.example.demo.springjwt.models.TbMemberTest;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/mem")
public class MemberController {

	@Autowired
	MemberService memberService;
	
	
    @PostMapping(value = "/signup")
    public ResponseEntity<TbMemberTest> insMember(TbMemberTest tmt){
    	
        memberService.join(tmt);

        return new ResponseEntity<>(tmt, HttpStatus.OK);
    }

}
