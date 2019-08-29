package com.example;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import com.example.model.Friend;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RequestGenerator {
	private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
	private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
	private static SecureRandom random = new SecureRandom();
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		ArrayList<Friend> friends = new ArrayList<Friend>();

		for(int i=0;i<1000000;i++) {
			int firstNameLen = ThreadLocalRandom.current().nextInt(5, 11);
			int lastNameLen = ThreadLocalRandom.current().nextInt(5, 11);
			String firstName = generateRandomString(firstNameLen);
			String lastName = generateRandomString(lastNameLen);
			Friend friend = new Friend(firstName,lastName);
			friends.add(friend);
		}
		System.out.println(friends.size());
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
		final ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.writeValue(out, friends);

		final byte[] data = out.toByteArray();
		//Get the file reference
		Path path = Paths.get("C:\\Shravan\\Learning\\Java\\mongooutput.json");

		//Use try-with-resource to get auto-closeable writer instance
		try (BufferedWriter writer = Files.newBufferedWriter(path))
		{
			writer.write(new String(data));
		}
	}

	public static String generateRandomString(int length) {
		if (length < 1) throw new IllegalArgumentException();

		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {


			int rndCharAt = random.nextInt(CHAR_LOWER.length());
			char rndChar='0';
			if(i == 0) {
				rndChar = CHAR_UPPER.charAt(rndCharAt);
			}else {
				rndChar = CHAR_LOWER.charAt(rndCharAt);
			}
			// debug
			//System.out.format("%d\t:\t%c%n", rndCharAt, rndChar);

			sb.append(rndChar);

		}

		return sb.toString();

	}
}
