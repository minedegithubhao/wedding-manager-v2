package com.qh.venus.achilles.sms.system.controller;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Resource;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qh.venus.achilles.framework.web.domain.R;
import com.qh.venus.achilles.sms.system.domain.SysUser;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/rabbit")
public class RabbitMqController {

	@Resource
	private RabbitTemplate rabbitTemplate;

	/**
	 * 测试广播模式.
	 *
	 * @param userName
	 * @return the response entity
	 */
	@RequestMapping("/fanout/{userName}")
	@ResponseBody
	public R send(@PathVariable String userName) {
		String uuId = UUID.randomUUID().toString();
		log.info("消息的标识{}", uuId);
		CorrelationData correlationData = new CorrelationData(uuId);
		SysUser sysUser = new SysUser();
		sysUser.setUserName(userName);
		rabbitTemplate.convertAndSend("FANOUT_EXCHANGE", "", sysUser, correlationData);
		return R.ok();
	}

	@RequestMapping("/priority/{userName}")
	@ResponseBody
	public R priority(@PathVariable String userName) {
		SysUser sysUser = new SysUser();
		sysUser.setUserName(userName);
		String uuId = UUID.randomUUID().toString();
		log.info("消息的标识{}", uuId);
		rabbitTemplate.convertAndSend("FANOUT_EXCHANGE", "", sysUser, new MessagePostProcessor() {
			@Override
			public Message postProcessMessage(Message message) throws AmqpException {
				message.getMessageProperties().setPriority(1);
				message.getMessageProperties().setCorrelationId(uuId);
				return message;
			}
		});
		return R.ok();
	}

	/**
	 * 测试Direct模式.
	 *
	 * @param p
	 *            the p
	 * @return the response entity
	 */
	@RequestMapping("/direct")
	@ResponseBody
	public R direct(String p) {
		rabbitTemplate.convertAndSend("DIRECT_EXCHANGE", "DIRECT_ROUTING_KEY", "234");
		return R.ok();
	}

	/**
	 * 发送超时消息
	 * 
	 * @return
	 */
	@RequestMapping("/deadLetter")
	@ResponseBody
	public R deadLetterMsg() {
		CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
		MessagePostProcessor processor = new MessagePostProcessor() {
			public Message postProcessMessage(Message message) throws AmqpException {
				message.getMessageProperties().setExpiration("10000");
				message.getMessageProperties().setPriority(1);
				return message;
			}
		};
		log.info("send msg:[deal msg]");
		rabbitTemplate.convertAndSend("DIRECT_EXCHANGE", "DIRECT_ROUTING_KEY2", "deal msg", processor, correlationData);
		return R.ok();
	}

	AtomicInteger atomicInteger = new AtomicInteger();

	@RequestMapping("/sendMsg")
	@ResponseBody
	public String sendMsg() {
		for (int j = 0; j < 30; j++) {
			new Thread(() -> {
				for (int i = 0; i < 10000; i++) {
					try {
						SysUser sysUser = new SysUser();
						sysUser.setUserName("admin" + i);
						CorrelationData correlationData = new CorrelationData(
								String.valueOf(atomicInteger.incrementAndGet()));
						rabbitTemplate.convertAndSend("FANOUT_EXCHANGE", "", sysUser, correlationData);
					} catch (Exception e) {

						e.printStackTrace();
					}

				}

			}).start();
		}
		return "send";
	}

}
