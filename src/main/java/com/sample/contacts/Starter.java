package com.sample.contacts;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.mail.SimpleMailMessage;


@RestController
public class Starter {

	@Autowired
	private MailService mailService;
	
	@GetMapping("/")
	public String Home() {
		return "Started";
	}
	
	@GetMapping("/send")
	public String send(@RequestParam String mailid) {
		try {
			mailService.SendMail(mailid);
			mailService.sendMail();
			return "mail sent successfully";
		}catch (Exception e) {
			return "error while sending mail"+e.getMessage();
		}
	}
	
	@GetMapping("/upload")
	public String Upload(@RequestParam("file") MultipartFile file) {
		try {
			InputStream in=file.getInputStream();
			Workbook book=WorkbookFactory.create(in);
			Sheet sheet=book.getSheetAt(0);
			List<String> mails=new ArrayList<>();
			
			for(Row row:sheet) {
				Cell cell=row.getCell(0);
				if(cell!=null)mails.add(cell.toString().trim());
			}
			for(String mail:mails) {
				mailService.SendMail(mail);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "OK";
	}
}
