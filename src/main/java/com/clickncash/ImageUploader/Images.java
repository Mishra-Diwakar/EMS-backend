package com.clickncash.ImageUploader;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.activation.MimetypesFileTypeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.clickncash.entity.User;
import com.clickncash.repository.UserRepository;

import net.bytebuddy.asm.Advice.Return;

@Component
public class Images {
	
	@Autowired
	UserRepository userRepository;
	public final String UPLOAD_PROFILE="";
//	public final String UPLOAD_PROFILE="C:\\Users\\admin\\angular\\fintechUi\\src\\assets\\images\\user\\profile";
	public String uploadFile(MultipartFile multipartFile,String email, String username,long id) {
	    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_HH.mm.ss.SSS");  
	    Date date = new Date();  
	    String format = formatter.format(date);
		String filename=format+"_"+multipartFile.getOriginalFilename();
		System.out.println(filename);

		
		   String mimeType =  multipartFile.getContentType();
		   System.out.println(mimeType);
		   // mimeType should now be something like "image/png"

		   if(mimeType.substring(0,5).equalsIgnoreCase("image") &&
				   ((multipartFile.getSize()/(1024*1024))<=1) &&
				   (multipartFile.getSize()!=0)){
			   try {
//				   System.out.println("comes");
//				   System.out.println("filename: "+filename+" email: "+email+" username: "+username+" Id: "+id);
					  User user = userRepository.findById(id).get();
//					  user.setProfilepic(filename);
					  user.setUpdatedAt(new Timestamp(new Date().getTime()));
					  user.setId(id);
					  userRepository.save(user);
				   Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_PROFILE+"\\"+ filename),StandardCopyOption.REPLACE_EXISTING );
				   return "yes";
			   }catch (Exception e) {
				  e.printStackTrace();
				return "no";
			}
		   }

		   return "no";
	}
}
