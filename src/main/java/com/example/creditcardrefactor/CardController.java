package com.example.creditcardrefactor;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CardController {

    @FXML
    public TextField creditText;
    public TextField dateText;
    public TextField cvvText;
    public ImageView cardArea;
    public ImageView checkArea;
    Image visa=new Image(CreditCardAuth.class.getResourceAsStream("Visa.png"));
    Image masterCard=new Image(CreditCardAuth.class.getResourceAsStream("Mastercard.png"));
    Image amex=new Image(CreditCardAuth.class.getResourceAsStream("Amex.png"));
    Image jcb=new Image(CreditCardAuth.class.getResourceAsStream("JCB.png"));
    Image empty=new Image(InputStream.nullInputStream());
    Image checkMark=new Image(CreditCardAuth.class.getResourceAsStream("Check.png"));

    public boolean validNum=false;
    public boolean validDate=false;
    public boolean validCVV=false;

    public void cardNumValidate(){
        String cardNum=creditText.getText();

        if(cardNum.startsWith("4")){
            cardArea.setImage(visa);
            if (isSixteenCheck(cardNum)){validNum=true;}
            else {validNum=false;}
        }
        else if(cardNum.startsWith("5")){
            cardArea.setImage(masterCard);
            if (isSixteenCheck(cardNum)){validNum=true;}
            else {validNum=false;}
        }
        else if(cardNum.startsWith("34")||cardNum.startsWith("37")){
            cardArea.setImage(amex);
            if (isSixteenCheck(cardNum)){validNum=true;}
            else {validNum=false;}
        }
        else if(cardNum.startsWith("35")){
            cardArea.setImage(jcb);
            if (isSixteenCheck(cardNum)){validNum=true;}
            else {validNum=false;}
        }
        else{
            cardArea.setImage(empty);
            validNum=false;
        }
        isValidCard();

    }

    public void dateValidate(){
        String date=dateText.getText();
        String dateRegex="^((0[1-9])|(1[0-2]))\\/((2000)|(20[1-2][0-9]))$";
        Pattern pattern= Pattern.compile(dateRegex);
        Matcher m = pattern.matcher(date);
        validDate = m.matches();
        isValidCard();
    }

    public void cvvValidate(){
        String cvv=cvvText.getText();
        if(isNumeric(cvv)) {
            if(cvv.length()>2&&cvv.length()<5) {
                validCVV = true;
            }
            else validCVV=false;
        }
        else validCVV=false;
        isValidCard();
    }

    public void isValidCard(){
        if(validNum&&validDate&&validCVV){
            checkArea.setImage(checkMark);
        }
        else {
            checkArea.setImage(empty);
        }
    }

    private boolean isSixteenCheck (String value){
        int length = value.length();
        boolean isSixteen;
        if(length==16){isSixteen=true;}
        else isSixteen=false;
        return isSixteen;
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

}