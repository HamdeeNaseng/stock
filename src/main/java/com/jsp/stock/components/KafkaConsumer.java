package com.jsp.stock.components;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.jsp.stock.entity.Category;
import com.jsp.stock.entity.Items;
import com.jsp.stock.entity.User;
import com.jsp.stock.service.CategoryService;
import com.jsp.stock.service.ItemService;
import com.jsp.stock.service.UserService;

@Component
public class KafkaConsumer {

	private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
	private final UserService userService;
	private final ItemService itemService;
	private final CategoryService categoryService;

	public KafkaConsumer(
			UserService userService,
			ItemService itemService,
			CategoryService categoryService) {
		this.userService = userService;
		this.itemService = itemService;
		this.categoryService = categoryService;
	}

	@SuppressWarnings("null")
	@KafkaListener(topics = "users", groupId = "create-user")
	public void consumeUser(String message) {
		System.out.println("Consumed message: " + message);
		// Manually handle the non-standard JSON format
		if (message != null) {
			String jsonMessage = message
					.replaceAll("'", "\"") // Replace single quotes with double quotes
					.replaceAll("([\\w]+):", "\"$1\":"); // Add double quotes around keys
			try {
				ObjectMapper mapper = new ObjectMapper();
				User user = mapper.readValue(jsonMessage, User.class);
				if (user != null) {
					userService.save(user);
				}
				logger.info(String.format("Consumed message -> %s", user.toString()));
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	}

	@KafkaListener(topics = "items", groupId = "create-item")
	public void consumeItems(String message) {
		System.out.println("Consumed message: " + message);
		// Manually handle the non-standard JSON format
		if (message != null) {

			try {
				// Improved regular expression for handling nested quotes:
				String jsonMessage = message
						.replaceAll("([\\w]+):", "\"$1\":");
				Items item = extractItem(jsonMessage);
				// Save the item
				itemService.save(item);
				logger.info(String.format("Consumed message -> %s", item.toString()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private String extractValue(String jsonString, String fieldName) {
		String fieldKey = "\"" + fieldName + "\":";
		int startIndex = jsonString.indexOf(fieldKey);
		if (startIndex != -1) {
			int endIndex = jsonString.indexOf(",", startIndex);
			if (endIndex == -1) {
				endIndex = jsonString.indexOf("}", startIndex);
			}
			if (endIndex != -1) {
				String value = jsonString.substring(startIndex + fieldKey.length(), endIndex).trim();
				// Remove surrounding quotes if present
				value = value.replace("\"", "").replace("'", ""); // Remove both single and double quotes
				return value;
			}
		}
		return null;
	}

	private Items extractItem(String jsonMessage) {
		Items item = new Items();
		String itemName = extractValue(jsonMessage, "itemName");
		String itemDescription = extractValue(jsonMessage, "itemDescription");
		String itemStatus = extractValue(jsonMessage, "itemStatus");
		String itemImageUrl = extractValue(jsonMessage, "itemImageUrl");
		String category = extractValue(jsonMessage, "category");
		String itemQuantity = extractValue(jsonMessage, "itemQuantity");
		String itemPrice = extractValue(jsonMessage, "itemPrice");
		String id = extractValue(jsonMessage, "id");
		String author = extractValue(jsonMessage, "author");
		String itemCreated = extractValue(jsonMessage, "itemCreated");
		String itemUpdated = extractValue(jsonMessage, "itemUpdated");
		// Set Id
		if (id != "null" && id != null && id != "") {
			Long longid = Long.parseLong(id);
			if (longid > 0) {
				item.setId(longid);
			}
		}

		// Set the category objects
		if (!(category == null || category.isEmpty() || category == "" || category == "null")) {
			Category categoryObj = categoryService.getCategoryById(Integer.parseInt(category));
			if (categoryObj != null) {
				item.setCategory(categoryObj);
			}
		}
		// Set the author objects
		try {
			// UUID authorId = UUID.fromString(author);
			Long authorId = Long.parseLong(author);
			// If no exception is thrown, 'authorId' is a valid UUID
			User authorObj = userService.getUserById(authorId);
			if (authorObj != null) {
				item.setAuthor(authorObj);
			}
		} catch (IllegalArgumentException e) {
			// Handle the case where 'author' is not a valid UUID
			// Log an error, throw an exception, or handle it according to your needs
			e.printStackTrace();
		}

		LocalDateTime localDateTimeitemCreated = LocalDateTime.parse(itemCreated,
				DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		LocalDateTime localDateTimeitemUpdated = LocalDateTime.parse(itemUpdated,
				DateTimeFormatter.ISO_LOCAL_DATE_TIME);

		item.setItemName(itemName);
		item.setItemDescription(itemDescription);
		item.setItemStatus(itemStatus);
		item.setItemImageUrl(itemImageUrl);
		// item.setAuthor(authorObj);
		item.setItemQuantity(Integer.parseInt(itemQuantity));
		item.setItemPrice(Integer.parseInt(itemPrice));
		item.setItemCreated(localDateTimeitemCreated);
		item.setItemUpdated(localDateTimeitemUpdated);
		return item;
	}

}
