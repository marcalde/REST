package com.example.fileupload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class UploadController {

	@PostMapping(value ="/API/provafile"/*, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE*/)
	String upFile(@RequestBody String file) {
		
		byte[] decoded = Base64.getDecoder().decode(file);
		String retString = new String(decoded, StandardCharsets.UTF_8);
		retString = "Contenuto del file di log: \n" + retString;
		String encoded = Base64.getEncoder().encodeToString(retString.getBytes());

		return encoded;
	}
	/*
	@PostMapping(value="/API/caricafile")
	byte[] uploadFile(@RequestPart("multipartFile") MultipartFile multipartFile) {
		
		
		byte[] bytes = null;
		
		try {
			bytes = multipartFile.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] decod = decod = Base64.getDecoder().decode(bytes);
		
		File file = new File("C:/Users/linda/Desktop/prova.txt");

		try (OutputStream os = new FileOutputStream(file)) {
		    os.write(decod);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	return bytes;
	}
	*/
}
