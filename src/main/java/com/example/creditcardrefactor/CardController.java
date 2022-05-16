package com.example.creditcardrefactor;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class CardController {

    @FXML
    TextField creditText;
    public ImageView cardArea;
    public ImageView checkArea;
    Image visa=new Image(CreditCardAuth.class.getResourceAsStream("Visa.png"));
    Image masterCard=new Image(CreditCardAuth.class.getResourceAsStream("Mastercard.png"));
    Image amex=new Image(CreditCardAuth.class.getResourceAsStream("Amex.png"));
    Image jcb=new Image(CreditCardAuth.class.getResourceAsStream("JCB.png"));
    Image empty=new Image(InputStream.nullInputStream());

    Image checkMark=new Image(CreditCardAuth.class.getResourceAsStream("Check.png"));


    public void Type(){
        String cardNum=creditText.getText();

        if(cardNum.startsWith("4")){
            cardArea.setImage(visa);
            if (isSixteenCheck(cardNum)){
                checkArea.setImage(checkMark);
            }
            else checkArea.setImage(empty);
        }
        else if(cardNum.startsWith("5")){
            cardArea.setImage(masterCard);
            if (isSixteenCheck(cardNum)){checkArea.setImage(checkMark);}
            else checkArea.setImage(empty);
        }
        else if(cardNum.startsWith("34")||cardNum.startsWith("37")){
            cardArea.setImage(amex);
            if (isSixteenCheck(cardNum)){checkArea.setImage(checkMark);}
            else checkArea.setImage(empty);
        }
        else if(cardNum.startsWith("35")){
            cardArea.setImage(jcb);
            if (isSixteenCheck(cardNum)){checkArea.setImage(checkMark);}
            else checkArea.setImage(empty);
        }
        else{
            cardArea.setImage(empty);
        }
        System.out.println(cardNum);

    }

    private boolean isSixteenCheck (String value){
        int length = value.length();
        boolean isSixteen;
        if(length==16){isSixteen=true;}
        else isSixteen=false;
        return isSixteen;
    }

}