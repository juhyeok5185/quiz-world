package com.danny.quizworld;

import com.danny.quizworld.common.util.AES256Utils;
import com.danny.quizworld.member.Member;
import com.danny.quizworld.member.MemberRepository;
import com.danny.quizworld.member.MemberRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class QuizWorldApplicationTests {

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private MemberRepository memberRepository;

//	@Test
//	void memberSaveTest() {
//		Member member = Member.builder()
//				.role(MemberRole.USER)
//				.loginId(AES256Utils.encrypt("user"))
//				.password(passwordEncoder.encode("1234"))
//				.name(AES256Utils.encrypt("박주혁"))
//				.phone(AES256Utils.encrypt("01066805185"))
//				.email(AES256Utils.encrypt("juhyeok.park5185@gmail.com"))
//				.build();
//		memberRepository.save(member);
//	}

	@Test
	void findBy(){
		Member member = memberRepository.findById(1L).orElse(null);


	}
}
