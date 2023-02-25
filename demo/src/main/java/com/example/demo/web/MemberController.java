package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.TbMemberTest;
import com.example.demo.service.MemberService;

@RestController
@RequestMapping("/api")
public class MemberController {

	@Autowired
	MemberService memberService;
	
	
    @GetMapping(value = "/insMember")
    public ResponseEntity<TbMemberTest> insMember(TbMemberTest tmt){
    	
        memberService.join(tmt);

        return new ResponseEntity<>(tmt, HttpStatus.OK);
    }

}
