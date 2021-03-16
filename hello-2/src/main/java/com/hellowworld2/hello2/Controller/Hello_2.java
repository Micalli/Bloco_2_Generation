package com.hellowworld2.hello2.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello2")

public class Hello_2 {
	
	@GetMapping
	public String hello2()
	{
		return "Absolver todo conhecimento e não desistir!!";
	}

}
