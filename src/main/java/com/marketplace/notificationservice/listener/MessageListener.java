package com.marketplace.notificationservice.listener;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.marketplace.notificationservice.model.MailResponse;
import com.marketplace.notificationservice.model.RegistrationDataTemplate;
import com.marketplace.notificationservice.service.EmailService;




public class MessageListener {

	Map<String, Object> model = new HashMap<String, Object>();
	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	EmailService service;
	

	
//	@RabbitListener(queues = "RegistrationDataQueue")
//	@RabbitHandler
	public MailResponse sendEmail() {
		Message message = rabbitTemplate.receive("RegistrationDataQueue");
		RegistrationDataTemplate registrationDataTemplate = new Gson().fromJson(new String(message.getBody()), RegistrationDataTemplate.class);
		System.out.println(new String(message.getBody()));
		model.put("name", registrationDataTemplate.getUsername());
		model.put("id",registrationDataTemplate.getToken());
		model.put("email", registrationDataTemplate.getEmail());
		model.put("userId",registrationDataTemplate.getId());
		System.out.println(model.get("email"));
		System.out.println(model.get("userId"));
		return service.sendEmail(model);

	}
}
