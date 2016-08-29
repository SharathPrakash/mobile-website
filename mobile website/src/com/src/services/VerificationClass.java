package com.src.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerificationClass implements Verification {

	
	@Override
	public boolean numberCheck(String input) {
		boolean valid=true;
		for(char ch:input.toCharArray()){
			if(Character.isDigit(ch)){
				valid=false;
				break;
				
			}
			else{
				valid=true;
				
			}
		}
		return valid;
	}

	@Override
	public boolean keywordCheck(String input) {
		boolean valid=true;
		String[] keywords={"delete","drop","insert","update","alter","1=1","0=0"};
		for(String s:keywords){
			if(s.equalsIgnoreCase(input)){
				valid=false;
				break;
				
			}
			else{
				valid=true;
				
			}
		}
		return valid;
	}

	@Override
	public boolean charecterCheck(String input) {
		boolean valid=true;
		Pattern charecters=Pattern.compile("\\W");
		Matcher match=charecters.matcher(input);
		while(match.find()){
			valid=false;
			break;
		}
		return valid;
	}
	public boolean emailCheck(String input){
		boolean valid=true;
		Pattern mail=Pattern.compile("@.*.com");
		Matcher validemail=mail.matcher(input);
		if(!validemail.find()){
			valid=false;
		}
		else{
			valid=true;
		}
		return valid;
	}

	@Override
	public boolean passwordCount(String input) {
		boolean valid=true;
		if(input.length()<5){
			valid=false;
			
		}
		return valid;
	}

	@Override
	public boolean managerCheck(String input) {
		boolean valid=true;
		Pattern manager=Pattern.compile("man[\\d][\\d][\\d]");
		Matcher match=manager.matcher(input);
		if(!match.find()){
			valid=false;
			
		}
		return valid;
	}
	
	
}
