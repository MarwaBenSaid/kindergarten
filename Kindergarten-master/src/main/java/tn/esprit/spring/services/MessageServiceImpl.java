package tn.esprit.spring.services;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Message;
import tn.esprit.spring.entities.Parent;
import tn.esprit.spring.repositories.MessageRepository;
import tn.esprit.spring.repositories.ParentRepository;

@Service
public class MessageServiceImpl implements IMessageService {

	@Autowired
	MessageRepository messageRepository;

	@Autowired
	ParentRepository userRepository;

	@Override
	public void addMessage(Message message, int senderId, int recieverId) {

		Parent u1 = userRepository.findById(senderId).orElse(null);
		Parent u2 = userRepository.findById(recieverId).orElse(null);
		message.setSender(u1);
		message.setReciever(u2);
		messageRepository.save(message);

	}

	@Override
	public List<Message> getAllMessages() {
		return (List<Message>) messageRepository.findAll();
	}

	@Override
	public void deleteMessage(int messageId) {

		messageRepository.deleteById(messageId);

	}

	@Override
	public void updateMessage(Message m, int MessageId) {
		Message message = messageRepository.findById(MessageId).get();
		message.setDescription(m.getDescription());
		messageRepository.save(message);

	}

	@Override
	public String verifyBadWords(String sentence) {

		List<String> badWords = Arrays.asList("fuck", "shit", "hoe");
		String[] words = sentence.split("\\s+");
		for (int i = 0; i < words.length; i++) {
			if (badWords.contains(words[i]))
				words[i] = badWordsToStars(words[i]);
		}
		return String.join(" ", words);
	}

	public String badWordsToStars(String badwords) {

		String s = "";
		for (int i = 0; i < badwords.length(); i++) {
			s = s + "*";
		}
		return s;
	}

	@Override
	public List<String> getDiscussion(int senderId, int recieverId) {

		return messageRepository.getDiscussion(senderId, recieverId);
	}

	@Override
	public Set<String> searchStringInDiscussion(String string, int senderId, int recieverId) {

		return messageRepository.searchStringInDiscussion(string, senderId, recieverId);
	}

}