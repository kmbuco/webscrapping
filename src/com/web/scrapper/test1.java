package com.web.scrapper;

public class test1 {
	
	public test1(){
		String phone = "0722715026";
		
		//change phone to start with +254
	    if(phone.contains("+254")){
	        //phone is good
	    }else if (phone.contains("254")){
	        //add +
	        phone = "+"+ phone;
	    }else if(phone.substring(0,1).equals("0") ){
	        //remove 0 add +254
	        int end  = phone.length();
	        phone = phone.substring(1);
	        phone = "+254" + phone;
	        System.out.println("the phone is: "+ phone);
	    }else{
	        //not a valid number
	    }

		System.out.println("phone test "+phone.substring(0,1));
		System.out.println("phone test 1 "+phone.substring(1,1));
		System.out.println("phone test 2 "+phone.substring(1,2));
		System.out.println("The phone is: "+ phone);
	}
	public static void main (String args[]) {
		new test1();
	}
}
