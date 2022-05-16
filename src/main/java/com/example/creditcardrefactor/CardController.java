package com.example.creditcardrefactor;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CardController {

    @FXML
    //Declaring the Fields in the fxml
    //All Text Fields Below have a function they call on key typed
    public TextField creditText;
    public TextField dateText;
    public TextField cvvText;
    public ImageView cardArea;
    public ImageView checkArea;

    //Importing all images from the resource folder
    Image visa=new Image(CreditCardAuth.class.getResourceAsStream("Visa.png"));
    Image masterCard=new Image(CreditCardAuth.class.getResourceAsStream("Mastercard.png"));
    Image amex=new Image(CreditCardAuth.class.getResourceAsStream("Amex.png"));
    Image jcb=new Image(CreditCardAuth.class.getResourceAsStream("JCB.png"));
    Image empty=new Image(InputStream.nullInputStream());
    Image checkMark=new Image(CreditCardAuth.class.getResourceAsStream("Check.png"));

    //Creating booleans for full card validation
    public boolean validNum=false;
    public boolean validDate=false;
    public boolean validCVV=false;
    public boolean isAmex= false;

    //Validating the card number textbox
    public void cardNumValidate(){
        String cardNum=creditText.getText();
        //If Visa
        if(cardNum.startsWith("4")){
            cardArea.setImage(visa);
            if (isSixteenCheck(cardNum)){
                validNum=true;
                isAmex=false;
            }
            else {validNum=false;}
        }
        //If MasterCard
        else if(cardNum.startsWith("5")){
            cardArea.setImage(masterCard);
            if (isSixteenCheck(cardNum)){
                validNum=true;
                isAmex=false;
            }
            else {validNum=false;}
        }
        //If Amex
        else if(cardNum.startsWith("34")||cardNum.startsWith("37")){
            cardArea.setImage(amex);
            if (isSixteenCheck(cardNum)){
                validNum=true;
                isAmex=true;
            }
            else {
                validNum=false;
            }
        }
        //If JCB
        else if(cardNum.startsWith("35")){
            cardArea.setImage(jcb);
            if (isSixteenCheck(cardNum)){
                validNum=true;
                isAmex=false;
            }
            else {validNum=false;}
        }
        else{
            isAmex=false;
            cardArea.setImage(empty);
            validNum=false;
        }
        //Any Change at any textfield calls the validation function
        isValidCard();

    }

    //Regex valifation of the date textfield
    public void dateValidate(){
        String date=dateText.getText();
        //Allows Dates between 01/2010 to 12/2029
        String dateRegex="^((0[1-9])|(1[0-2]))\\/((2000)|(20[1-2][0-9]))$";
        Pattern pattern= Pattern.compile(dateRegex);
        Matcher m = pattern.matcher(date);
        validDate = m.matches();
        //Any Change at any textfield calls the validation function
        isValidCard();
    }

    //Validating the Cvv textfield
    public void cvvValidate(){
        String cvv=cvvText.getText();
        if(isNumeric(cvv)) {
            if(cvv.length()==4&&isAmex==true) {
                    validCVV = true;
            }
            else if(cvv.length()==3&&isAmex==false){
                    validCVV = true;
            }
            else validCVV=false;
        }
        else validCVV=false;
        //Any Change at any textfield calls the validation function
        isValidCard();
    }

    //Checking all booleans to show the checkmark
    public void isValidCard(){
        if(validNum&&validDate&&validCVV){
            checkArea.setImage(checkMark);
        }
        else {
            checkArea.setImage(empty);
        }
    }

    //Used in other functions (Validating creditText textfield)
    private boolean isSixteenCheck (String value){
        int length = value.length();
        boolean isSixteen;
        if(length==16){isSixteen=true;}
        else isSixteen=false;
        return isSixteen;
    }

    //User defined fucntion (used in cvv textfield validation)
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

}