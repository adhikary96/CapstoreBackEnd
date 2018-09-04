package com.cg.capstore.service;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.cg.capstore.bean.CustomerBean;
import com.cg.capstore.bean.MerchantBean;
import com.cg.capstore.exception.ValidationException;
import com.cg.capstore.repo.CustomerRepo;
import com.cg.capstore.repo.MerchantRepo;

@Service
@Transactional
public class ValidationService implements IValidationService {

	@Autowired
	private CustomerRepo repo1;

	@Autowired
	private MerchantRepo repo2;
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	public ValidationService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	static Optional<CustomerBean> list1;
	static Optional<MerchantBean> list2;

	@Override
	public String findMerchant(String emailId) throws ValidationException {
		String senderEmail = emailId;

		MerchantBean merchants = repo2.getEmail(emailId);


		try {

			if ((merchants.getEmailId()!=null) && (senderEmail.equals(merchants.getEmailId()))) {
				System.err.println(senderEmail);
				System.err.println(merchants.getEmailId());
				String message="";
				//message = sendMail(emailId);   ----> to send a mail this condition must be used

				message = "Mail Sent to "+emailId+" Successfully...";

				return message;
			}

			else {
				return "Error in sending mail...";
			}
		}

		catch (Exception e) {
			throw new  ValidationException("Merchant Mail is not valid ");
		}



	}


	private String sendMail(String merchantEmail) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(merchantEmail);
		System.err.println(merchantEmail);
		mail.setFrom("udykmr13@gmail.com");
		mail.setSubject("Verification");
		mail.setText(" The Merchant Mail is Verified"); // get the v_code from the table and give it here
		javaMailSender.send(mail);
		return "Mail Sent to "+merchantEmail+" Successfully...";
	}


	@Override
	public String findCustomer(String email) throws ValidationException {
		String senderEmail = email;
		CustomerBean customers = repo1.getEmail(email);
		String message="";

		try {
			if(senderEmail.equals(customers.getEmail()) && customers.getEmail()!=null ) {

				//message = sendMail(emailId);    ---> to send a mail this condition must be used
				message = "Mail Sent to "+email+" Successfully...";

				//res = "Success";

			}
			else {

				message="Error in sending mail...";

			}
			return message;


		} catch (Exception e) {
			throw new ValidationException( "Customer Mail is not valid");

		}
	}

	private String sendCustomerMail(String customerEmail) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(customerEmail);
		System.err.println(customerEmail);
		mail.setFrom("udykmr13@gmail.com");
		mail.setSubject("Verification");
		mail.setText(" The Merchant Mail is Verified"); // get the v_code from the table and give it here
		javaMailSender.send(mail);
		return "Mail Sent to "+customerEmail+" Successfully...";
	}



}
