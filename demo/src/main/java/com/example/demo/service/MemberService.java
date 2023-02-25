package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.TbMemberTest;
import com.example.demo.repository.MemberRepository;

/**
 * User: HolyEyE
 * Date: 2013. 12. 3. Time: 오전 1:07
 */
@Service
@Transactional
public class MemberService {
	
	@Autowired
    MemberRepository memberRepository;

    /**
     * 회원 가입
     */
    public Long join(TbMemberTest member) {

        System.out.println(member);

        memberRepository.save(member);
        //memberRepository.save(member);
        
        return member.getMemberNo();
    }

}
