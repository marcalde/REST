package com.example.fileuploadpermanent;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class UploadController {


	@PostMapping(value="/API/caricafile")
	ResponseEntity<String> uploadFile(@RequestPart("multipartFile") MultipartFile multipartFile) {


		byte[] bytes = null;

		try {
			bytes = multipartFile.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] decod = Base64.getDecoder().decode(bytes);


		File file = new File("C:/Users/linda/Desktop/"+multipartFile.getOriginalFilename());

		try (OutputStream os = new FileOutputStream(file)) {
			os.write(decod);
		} catch(Exception e) {
			e.printStackTrace();
		}

		String responseMessage = "Upload successful! \n Saved as: "+file.getName()+" \n Dimension: "+file.length()+" bytes";


		return	ResponseEntity.status(HttpStatus.OK).body(responseMessage);

		//	return bytes;
	}
	@PostMapping(value="/API/upload")
	ResponseEntity<String> upload(@RequestPart("file") MultipartFile multipartFile, @RequestParam String filename) {

		String originalFilename = multipartFile.getOriginalFilename();
		File file = null;

		if(filename == null || filename.equals("")) {
			file = new File("C:/Users/linda/Desktop/"+originalFilename);
		} else {
			String fileExt = originalFilename.substring(originalFilename.lastIndexOf("."));
			file = new File("C:/Users/linda/Desktop/"+filename+fileExt);
		}
		try (OutputStream os = new FileOutputStream(file)) {
			os.write(multipartFile.getBytes());
		} catch(Exception e) {
			e.printStackTrace();
		}

		String responseMessage = "Upload successful! \n Saved as: "+file.getName()+" \n Dimension: "+file.length()+" bytes";

		return ResponseEntity.status(HttpStatus.OK).body(responseMessage);
	}
}
