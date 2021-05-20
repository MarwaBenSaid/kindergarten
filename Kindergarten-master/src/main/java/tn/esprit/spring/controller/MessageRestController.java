package tn.esprit.spring.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Message;
import tn.esprit.spring.services.IMessageService;

@RestController
public class MessageRestController {
	@Autowired
	IMessageService messageService;

	// http://localhost:8083/addMessage

	@PostMapping("/addMessage/{senderId}/{recieverId}")
	@ResponseBody
	public void addMessage(@RequestBody Message message, @PathVariable("senderId") int senderId,
			@PathVariable("recieverId") int recieverId) {

		message.setDescription(messageService.verifyBadWords(message.getDescription()));

		messageService.addMessage(message, senderId, recieverId);

	}

	// http://localhost:8083/getAllMessages

	@GetMapping("/getAllMessages")
	@ResponseBody
	public List<Message> getAllMessage() {

		return messageService.getAllMessages();

	}

	// http://localhost:8083/deleteMessage/1

	@DeleteMapping("/deleteMessage/{messageId}")
	@ResponseBody
	public void deleteMessage(@PathVariable("Message") int messageId) {

		messageService.deleteMessage(messageId);
	}

	// http://localhost:8083/updateMessage/1

	@PutMapping("/updateMessage/{messageId}")
	@ResponseBody
	public ResponseEntity<String> updateMessage(@RequestBody Message message,
			@PathVariable("messageId") int messageId) {

		message.setDescription(messageService.verifyBadWords(message.getDescription()));
		messageService.updateMessage(message, messageId);
		return new ResponseEntity<String>("Message updated successfully", HttpStatus.OK);

	}

	@GetMapping("/getDiscussion/{senderId}/{recieverId}")
	@ResponseBody
	public List<String> getDiscussion(@PathVariable("senderId") int senderId,
			@PathVariable("recieverId") int recieverId) {

		return messageService.getDiscussion(senderId, recieverId);

	}

	@GetMapping("/searchStringInDiscussion/{string}/{senderId}/{recieverId}")
	@ResponseBody
	public Set<String> searchStringInDiscussion(@PathVariable("string") String string,
			@PathVariable("senderId") int senderId, @PathVariable("recieverId") int recieverId) {

		return messageService.searchStringInDiscussion(string, senderId, recieverId);

	}
}
