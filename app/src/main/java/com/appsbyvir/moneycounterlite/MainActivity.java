package com.appsbyvir.moneycounterlite;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import android.support.annotation.NonNull;

public class MainActivity extends Activity {

	private static final String HUNDRED_VALUE = "HUNDRED_VALUE", FIFTY_VALUE = "FIFTY_VALUE", TWENTY_VALUE = "TWENTY_VALUE", TEN_VALUE = "TEN_VALUE", FIVE_VALUE = "FIVE_VALUE", TWO_VALUE = "TWO_VALUE", ONE_VALUE = "ONE_VALUE";
	private static final String COIN_DOLLAR_VALUE = "COIN_DOLLAR_VALUE", HALF_DOLLAR_VALUE = "HALF_DOLLAR_VALUE", QUARTER_VALUE = "QUARTER_VALUE", DIME_VALUE = "DIME_VALUE", NICKEL_VALUE = "NICKEL_VALUE", PENNY_VALUE = "PENNY_VALUE";
	private static final String COIN_DOLLAR_ROLL_VALUE = "COIN_DOLLAR_ROLL_VALUE", HALF_DOLLAR_ROLL_VALUE = "HALF_DOLLAR_ROLL_VALUE", QUARTER_ROLL_VALUE = "QUARTER_ROLL_VALUE", DIME_ROLL_VALUE = "DIME_ROLL_VALUE", NICKEL_ROLL_VALUE = "NICKEL_ROLL_VALUE", PENNY_ROLL_VALUE = "PENNY_ROLL_VALUE";
	private static final String BILL_VALUE = "BILL_VALUE", COIN_VALUE = "COIN_VALUE", CHECK_VALUE = "CHECK_VALUE", TOTAL_VALUE = "TOTAL_VALUE";
	private static final String CHECK_ARRAY = "CHECK_ARRAY", BILL_COIN = "BILL_COIN";
	
	private int hundred, fifty, twenty, ten, five, two, one, coinDollar, coinDollarRoll, halfDollar, halfDollarRoll, quarter, quarterRoll, dime, dimeRoll, nickel, nickelRoll, penny, pennyRoll;
	private double bill, coin, check, total;
	private double billsAndCoins;
	
	EditText hundredET, fiftyET, twentyET, tenET, fiveET, twoET, oneET, coinDollarET, coinDollarRollET, halfDollarET, halfDollarRollET, quarterET, quarterRollET, dimeET, dimeRollET, nickelET, nickelRollET, pennyET, pennyRollET;
	EditText hundredVET, fiftyVET, twentyVET, tenVET, fiveVET, twoVET, oneVET, coinDollarVET, halfDollarVET, quarterVET, dimeVET, nickelVET, pennyVET;
	EditText billET, coinET, checkET, totalET;
	EditText billsAndCoinsET;

	private LinearLayout checksLayout;
	private EditText checksEditText;
	private Button addButton;
	private int count = 0;
	private double checkValue;
	private ArrayList<String> checkArray = new ArrayList<String>();
	private String helpText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		OnClickListener clearButtonListener = new OnClickListener(){ //when clear button is pressed the following activates
			@Override
			public void onClick(View v) {
				AlertDialog clearBox = Clear();
				clearBox.show();
			}
		};
		
		Button clearButton = (Button) findViewById(R.id.clearButton);
		clearButton.setOnClickListener(clearButtonListener);
		
		OnClickListener saveButtonListener = new OnClickListener(){ //when save button is pressed the following activates
			@Override
			public void onClick(View v) {
				AlertDialog proFeatureBox = Pro_Feature();
				proFeatureBox.show();
			}
		};
		
		Button saveButton = (Button) findViewById(R.id.saveButton);
		saveButton.setOnClickListener(saveButtonListener);
		
		OnClickListener sendButtonListener = new OnClickListener(){ //when send button is pressed the following activates
			@Override
			public void onClick(View v) {
				AlertDialog proFeatureBox = Pro_Feature();
				proFeatureBox.show();
				}
		};
		
		Button sendButton = (Button) findViewById(R.id.sendButton);
		sendButton.setOnClickListener(sendButtonListener);
		
		hundredVET = (EditText) findViewById(R.id.hundredValueEditText);
		fiftyVET = (EditText) findViewById(R.id.fiftyValueEditText);
		twentyVET = (EditText) findViewById(R.id.twentyValueEditText);
		tenVET = (EditText) findViewById(R.id.tenValueEditText);
		fiveVET = (EditText) findViewById(R.id.fiveValueEditText);
		twoVET = (EditText) findViewById(R.id.twoValueEditText);
		oneVET = (EditText) findViewById(R.id.oneValueEditText);
		coinDollarVET = (EditText) findViewById(R.id.coinDollarValueEditText);
		halfDollarVET = (EditText) findViewById(R.id.halfDollarValueEditText);
		quarterVET = (EditText) findViewById(R.id.quarterValueEditText);
		dimeVET = (EditText) findViewById(R.id.dimeValueEditText);
		nickelVET = (EditText) findViewById(R.id.nickelValueEditText);
		pennyVET = (EditText) findViewById(R.id.pennyValueEditText);
		billET = (EditText) findViewById(R.id.billTotalEditText);
		coinET = (EditText) findViewById(R.id.coinTotalEditText);
		checkET = (EditText) findViewById(R.id.checkTotalEditText);
		totalET = (EditText) findViewById(R.id.finalAmountEditText);
		billsAndCoinsET = (EditText) findViewById(R.id.billsAndCoinsEditText);
			
		hundredET = (EditText) findViewById(R.id.hundredEditText);
		fiftyET = (EditText) findViewById(R.id.fiftyEditText);
		twentyET = (EditText) findViewById(R.id.twentyEditText);
		tenET = (EditText) findViewById(R.id.tenEditText);
		fiveET = (EditText) findViewById(R.id.fiveEditText);
		twoET = (EditText) findViewById(R.id.twoEditText);
		oneET = (EditText) findViewById(R.id.oneEditText);
		coinDollarET = (EditText) findViewById(R.id.coinDollarEditText);
		coinDollarRollET = (EditText) findViewById(R.id.coinDollarRollEditText);
		halfDollarET = (EditText) findViewById(R.id.halfDollarEditText);
		halfDollarRollET = (EditText) findViewById(R.id.halfDollarRollEditText);
		quarterET = (EditText) findViewById(R.id.quarterEditText);
		quarterRollET = (EditText) findViewById(R.id.quarterRollEditText);
		dimeET = (EditText) findViewById(R.id.dimeEditText);
		dimeRollET = (EditText) findViewById(R.id.dimeRollEditText);
		nickelET = (EditText) findViewById(R.id.nickelEditText);
		nickelRollET = (EditText) findViewById(R.id.nickelRollEditText);
		pennyET = (EditText) findViewById(R.id.pennyEditText);
		pennyRollET = (EditText) findViewById(R.id.pennyRollEditText);
			
		hundredET.addTextChangedListener(hundredListener);
		fiftyET.addTextChangedListener(fiftyListener);
		twentyET.addTextChangedListener(twentyListener);
		tenET.addTextChangedListener(tenListener);
		fiveET.addTextChangedListener(fiveListener);
		twoET.addTextChangedListener(twoListener);
		oneET.addTextChangedListener(oneListener);
		coinDollarET.addTextChangedListener(coinDollarListener);
		coinDollarRollET.addTextChangedListener(coinDollarRollListener);
		halfDollarET.addTextChangedListener(halfDollarListener);
		halfDollarRollET.addTextChangedListener(halfDollarRollListener);
		quarterET.addTextChangedListener(quarterListener);
		quarterRollET.addTextChangedListener(quarterRollListener);
		dimeET.addTextChangedListener(dimeListener);
		dimeRollET.addTextChangedListener(dimeRollListener);
		nickelET.addTextChangedListener(nickelListener);
		nickelRollET.addTextChangedListener(nickelRollListener);
		pennyET.addTextChangedListener(pennyListener);
		pennyRollET.addTextChangedListener(pennyRollListener);

		checksLayout = (LinearLayout) findViewById(R.id.linearLayout);
		checksEditText = (EditText) findViewById(R.id.checksEditText);
		addButton = (Button) findViewById(R.id.addButton);
		addButton.setOnClickListener(onClick());
		TextView textView = new TextView(this);
		textView.setText("");
		    
		helpText = getResources().getString(R.string.helpText);
	}

	private OnClickListener onClick() {
	    return new OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	if (checksEditText.getText().length() > 0) {
	        		count ++;
	        		checkValue += (Double.parseDouble(checksEditText.getText().toString()));	
	        		String newText = checksEditText.getText().toString();
	        		checksLayout.addView(createNewTextView(newText));
	        		checksEditText.setText("");
	        		updateValues();
	        	}else{
	        		Toast.makeText(getApplicationContext(), "ERROR! No misc value entered!", Toast.LENGTH_SHORT).show();
	        	}
	        }
	    };
	}
	@SuppressLint("DefaultLocale")
	TextView createNewTextView(String text) {
	    final LayoutParams lparams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
	    final TextView textView = new TextView(this);
	    textView.setLayoutParams(lparams);
	    textView.setTextColor(Color.parseColor("#56A0D3"));
	    double checkVET = Double.parseDouble(text);
	    String checkString = String.format("%.02f", (checkVET*1.00));
	    checkArray.add("Misc Value " + count + ": $" + checkString);
	    textView.setText("Misc Value " + count + ": $" + checkString);
	    return textView;
	}
	
	private TextWatcher hundredListener = new TextWatcher(){
		@Override
		public void afterTextChanged(Editable s) {
			try{
				hundred = Integer.parseInt(s.toString());
			}catch(NumberFormatException e){
				hundred = 0;
			}
			updateValues();
		}
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {}
	};
	
	private TextWatcher fiftyListener = new TextWatcher(){
		@Override
		public void afterTextChanged(Editable s) {
			try{
				fifty = Integer.parseInt(s.toString());
			}catch(NumberFormatException e){
				fifty = 0;
			}
			updateValues();
		}
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {}
	};
	
	private TextWatcher twentyListener = new TextWatcher(){
		@Override
		public void afterTextChanged(Editable s) {
			try{
				twenty = Integer.parseInt(s.toString());
			}catch(NumberFormatException e){
				twenty = 0;
			}
			updateValues();
		}
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {}
	};
	
	private TextWatcher tenListener = new TextWatcher(){
		@Override
		public void afterTextChanged(Editable s) {
			try{
				ten = Integer.parseInt(s.toString());
			}catch(NumberFormatException e){
				ten = 0;
			}
			updateValues();
		}
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {}
	};
	
	private TextWatcher fiveListener = new TextWatcher(){
		@Override
		public void afterTextChanged(Editable s) {
			try{
				five = Integer.parseInt(s.toString());
			}catch(NumberFormatException e){
				five = 0;
			}
			updateValues();
		}
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {}
	};

	private TextWatcher twoListener = new TextWatcher(){
		@Override
		public void afterTextChanged(Editable s) {
			try{
				two = Integer.parseInt(s.toString());
			}catch(NumberFormatException e){
				two = 0;
			}
			updateValues();
		}
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {}
	};
	
	private TextWatcher oneListener = new TextWatcher(){
		@Override
		public void afterTextChanged(Editable s) {
			try{
				one = Integer.parseInt(s.toString());
			}catch(NumberFormatException e){
				one = 0;
			}
			updateValues();
		}
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {}
	};
	
	private TextWatcher coinDollarListener = new TextWatcher(){
		@Override
		public void afterTextChanged(Editable s) {
			try{
				coinDollar = Integer.parseInt(s.toString());
			}catch(NumberFormatException e){
				coinDollar = 0;
			}
			updateValues();
		}
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {}
	};
	
	private TextWatcher coinDollarRollListener = new TextWatcher(){
		@Override
		public void afterTextChanged(Editable s) {
			try{
				coinDollarRoll = Integer.parseInt(s.toString());
			}catch(NumberFormatException e){
				coinDollarRoll = 0;
			}
			updateValues();
		}
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {}
	};

	private TextWatcher halfDollarListener = new TextWatcher(){
		@Override
		public void afterTextChanged(Editable s) {
			try{
				halfDollar = Integer.parseInt(s.toString());
			}catch(NumberFormatException e){
				halfDollar = 0;
			}
			updateValues();
		}
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {}
	};
	
	private TextWatcher halfDollarRollListener = new TextWatcher(){
		@Override
		public void afterTextChanged(Editable s) {
			try{
				halfDollarRoll = Integer.parseInt(s.toString());
			}catch(NumberFormatException e){
				halfDollarRoll = 0;
			}
			updateValues();
		}
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {}
	};

	private TextWatcher quarterListener = new TextWatcher(){
		@Override
		public void afterTextChanged(Editable s) {
			try{
				quarter = Integer.parseInt(s.toString());
			}catch(NumberFormatException e){
				quarter = 0;
			}
			updateValues();
		}
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {}
	};
	
	private TextWatcher quarterRollListener = new TextWatcher(){
		@Override
		public void afterTextChanged(Editable s) {
			try{
				quarterRoll = Integer.parseInt(s.toString());
			}catch(NumberFormatException e){
				quarterRoll = 0;
			}
			updateValues();
		}
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {}
	};
	
	private TextWatcher dimeListener = new TextWatcher(){
		@Override
		public void afterTextChanged(Editable s) {
			try{
				dime = Integer.parseInt(s.toString());
			}catch(NumberFormatException e){
				dime = 0;
			}
			updateValues();
		}
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {}
	};
	
	private TextWatcher dimeRollListener = new TextWatcher(){
		@Override
		public void afterTextChanged(Editable s) {
			try{
				dimeRoll = Integer.parseInt(s.toString());
			}catch(NumberFormatException e){
				dimeRoll = 0;
			}
			updateValues();
		}
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after){}
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count){}
	};
	
	private TextWatcher nickelListener = new TextWatcher(){
		@Override
		public void afterTextChanged(Editable s) {
			try{
				nickel = Integer.parseInt(s.toString());
			}catch(NumberFormatException e){
				nickel = 0;
			}
			updateValues();
		}
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {}
	};
	
	private TextWatcher nickelRollListener = new TextWatcher(){
		@Override
		public void afterTextChanged(Editable s) {
			try{
				nickelRoll = Integer.parseInt(s.toString());
			}catch(NumberFormatException e){
				nickelRoll = 0;
			}
			updateValues();
		}
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {}
	};
	
	private TextWatcher pennyListener = new TextWatcher(){
		@Override
		public void afterTextChanged(Editable s) {
			try{
				penny = Integer.parseInt(s.toString());
			}catch(NumberFormatException e){
				penny = 0;
			}
			updateValues();
		}
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {}
	};
	
	private TextWatcher pennyRollListener = new TextWatcher(){
		@Override
		public void afterTextChanged(Editable s) {
			try{
				pennyRoll = Integer.parseInt(s.toString());
			}catch(NumberFormatException e){
				pennyRoll = 0;
			}
			updateValues();
		}
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {}
	};

    private void updateValues(){
        double check = checkValue;
        double bill = hundred*100+fifty*50+twenty*20+ten*10+five*5+two*2+one;
        double coin = coinDollar*1.00+coinDollarRoll*25.00+halfDollar*0.50+halfDollarRoll*10.00+quarter*0.25+quarterRoll*10.00+dime*0.10+dimeRoll*5.00+nickel*0.05+nickelRoll*2.00+penny*0.01+pennyRoll*0.50;
        double total = bill + coin + check;
        double billsAndCoins = bill + coin;

        hundredVET.setText("$"+String.format("%.02f", (hundred*100.00)));
        fiftyVET.setText("$"+String.format("%.02f", (fifty*50.00)));
        twentyVET.setText("$"+String.format("%.02f", (twenty*20.00)));
        tenVET.setText("$"+String.format("%.02f", (ten*10.00)));
        fiveVET.setText("$"+String.format("%.02f", (five*5.00)));
        twoVET.setText("$"+String.format("%.02f", (two*2.00)));
        oneVET.setText("$"+String.format("%.02f", (one*1.00)));
        coinDollarVET.setText("$"+String.format("%.02f", (coinDollar*1.00+coinDollarRoll*25.00)));
        halfDollarVET.setText("$"+String.format("%.02f", (halfDollar*0.50+halfDollarRoll*10.00)));
        quarterVET.setText("$"+String.format("%.02f", (quarter*0.25+quarterRoll*10.00)));
        dimeVET.setText("$"+String.format("%.02f", (dime*0.10+dimeRoll*5.00)));
        nickelVET.setText("$"+String.format("%.02f", (nickel*0.05+nickelRoll*2.00)));
        pennyVET.setText("$"+String.format("%.02f", (penny*0.01+pennyRoll*0.50)));
        billET.setText("$"+String.format("%.02f", bill));
        coinET.setText("$"+String.format("%.02f", coin));
        checkET.setText("$"+String.format("%.02f", check));
        totalET.setText("$"+String.format("%.02f", total));
        billsAndCoinsET.setText("$"+String.format("%.02f", billsAndCoins));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState){
        outState.putInt(HUNDRED_VALUE, hundred);
        outState.putInt(FIFTY_VALUE, fifty);
        outState.putInt(TWENTY_VALUE, twenty);
        outState.putInt(TEN_VALUE, ten);
        outState.putInt(FIVE_VALUE, five);
        outState.putInt(TWO_VALUE, two);
        outState.putInt(ONE_VALUE, one);
        outState.putInt(COIN_DOLLAR_VALUE, coinDollar);
        outState.putInt(COIN_DOLLAR_ROLL_VALUE, coinDollarRoll);
        outState.putInt(HALF_DOLLAR_VALUE, halfDollar);
        outState.putInt(HALF_DOLLAR_ROLL_VALUE, halfDollarRoll);
        outState.putInt(QUARTER_VALUE, quarter);
        outState.putInt(QUARTER_ROLL_VALUE, quarterRoll);
        outState.putInt(DIME_VALUE, dime);
        outState.putInt(DIME_ROLL_VALUE, dimeRoll);
        outState.putInt(NICKEL_VALUE, nickel);
        outState.putInt(NICKEL_ROLL_VALUE, nickelRoll);
        outState.putInt(PENNY_VALUE, penny);
        outState.putInt(PENNY_ROLL_VALUE, pennyRoll);
        outState.putDouble(BILL_VALUE, bill);
        outState.putDouble(COIN_VALUE, coin);
        outState.putDouble(CHECK_VALUE, check);
        outState.putDouble(TOTAL_VALUE, total);
        outState.putStringArrayList(CHECK_ARRAY, checkArray);
        outState.putDouble(BILL_COIN, billsAndCoins);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        hundred = savedInstanceState.getInt(HUNDRED_VALUE);
        if(hundred > 0)hundredET.setText(String.valueOf(hundred));
        fifty=savedInstanceState.getInt(FIFTY_VALUE);
        if(fifty > 0)fiftyET.setText(String.valueOf(fifty));
        twenty=savedInstanceState.getInt(TWENTY_VALUE);
        if(twenty > 0)twentyET.setText(String.valueOf(twenty));
        ten=savedInstanceState.getInt(TEN_VALUE);
        if(ten > 0)tenET.setText(String.valueOf(ten));
        five=savedInstanceState.getInt(FIVE_VALUE);
        if(five > 0)fiveET.setText(String.valueOf(five));
        two=savedInstanceState.getInt(TWO_VALUE);
        if(two > 0)twoET.setText(String.valueOf(two));
        one=savedInstanceState.getInt(ONE_VALUE);
        if(one > 0)oneET.setText(String.valueOf(one));
        coinDollar=savedInstanceState.getInt(COIN_DOLLAR_VALUE);
        if(coinDollar > 0)coinDollarET.setText(String.valueOf(coinDollar));
        coinDollarRoll=savedInstanceState.getInt(COIN_DOLLAR_ROLL_VALUE);
        if(coinDollarRoll > 0)coinDollarRollET.setText(String.valueOf(coinDollarRoll));
        halfDollar=savedInstanceState.getInt(HALF_DOLLAR_VALUE);
        if(halfDollar > 0)halfDollarET.setText(String.valueOf(halfDollar));
        halfDollarRoll=savedInstanceState.getInt(HALF_DOLLAR_ROLL_VALUE);
        if(halfDollarRoll > 0)halfDollarRollET.setText(String.valueOf(halfDollarRoll));
        quarter=savedInstanceState.getInt(QUARTER_VALUE);
        if(quarter > 0)quarterET.setText(String.valueOf(quarter));
        quarterRoll=savedInstanceState.getInt(QUARTER_ROLL_VALUE);
        if(quarterRoll > 0)quarterRollET.setText(String.valueOf(quarterRoll));
        dime=savedInstanceState.getInt(DIME_VALUE);
        if(dime > 0)dimeET.setText(String.valueOf(dime));
        dimeRoll=savedInstanceState.getInt(DIME_ROLL_VALUE);
        if(dimeRoll > 0)dimeRollET.setText(String.valueOf(dimeRoll));
        nickel=savedInstanceState.getInt(NICKEL_VALUE);
        if(nickel > 0)nickelET.setText(String.valueOf(nickel));
        nickelRoll=savedInstanceState.getInt(NICKEL_ROLL_VALUE);
        if(nickelRoll > 0)nickelRollET.setText(String.valueOf(nickelRoll));
        penny=savedInstanceState.getInt(PENNY_VALUE);
        if(penny > 0)pennyET.setText(String.valueOf(penny));
        pennyRoll=savedInstanceState.getInt(PENNY_ROLL_VALUE);
        if(pennyRoll > 0)pennyRollET.setText(String.valueOf(pennyRoll));
        bill=savedInstanceState.getDouble(BILL_VALUE);
        coin=savedInstanceState.getDouble(COIN_VALUE);
        check=savedInstanceState.getDouble(CHECK_VALUE);
        total=savedInstanceState.getDouble(TOTAL_VALUE);
        checkArray=savedInstanceState.getStringArrayList(CHECK_ARRAY);
        billsAndCoins=savedInstanceState.getDouble(BILL_COIN);

        final LayoutParams lparams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        String checkList;
        checksLayout.removeAllViews();
        count = 0;
        for (String s : checkArray){
            TextView textView = new TextView(this);
            textView.setLayoutParams(lparams);
            checkList = s;
            if (s.contains("-")){
                textView.setTextColor(Color.parseColor("#FF0000"));
            }else {
                textView.setTextColor(Color.parseColor("#56A0D3"));
            }
            textView.setText(checkList);
            count++;
            checksLayout.addView(textView);
        }
        updateValues();
    }

	private AlertDialog Clear() {
	    AlertDialog myClearingDialogBox = new AlertDialog.Builder(this)
	        .setTitle("Confirmation") 
	        .setMessage("Do you want to Clear?") 
	        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

	            public void onClick(DialogInterface dialog, int whichButton) {
					((EditText)findViewById(R.id.hundredEditText)).setText("");
					((EditText)findViewById(R.id.fiftyEditText)).setText("");
					((EditText)findViewById(R.id.twentyEditText)).setText("");
					((EditText)findViewById(R.id.tenEditText)).setText("");
					((EditText)findViewById(R.id.fiveEditText)).setText("");
					((EditText)findViewById(R.id.twoEditText)).setText("");
					((EditText)findViewById(R.id.oneEditText)).setText("");
					((EditText)findViewById(R.id.coinDollarEditText)).setText("");
					((EditText)findViewById(R.id.coinDollarRollEditText)).setText("");
					((EditText)findViewById(R.id.halfDollarEditText)).setText("");
					((EditText)findViewById(R.id.halfDollarRollEditText)).setText("");
					((EditText)findViewById(R.id.quarterEditText)).setText("");
					((EditText)findViewById(R.id.quarterRollEditText)).setText("");
					((EditText)findViewById(R.id.dimeEditText)).setText("");
					((EditText)findViewById(R.id.dimeRollEditText)).setText("");
					((EditText)findViewById(R.id.nickelEditText)).setText("");
					((EditText)findViewById(R.id.nickelRollEditText)).setText("");
					((EditText)findViewById(R.id.pennyEditText)).setText("");
					((EditText)findViewById(R.id.pennyRollEditText)).setText("");
					((EditText)findViewById(R.id.billsAndCoinsEditText)).setText("");
					
					checksLayout.removeAllViews();
					checkArray.clear();
					checkValue = 0;
					count = 0;
					billsAndCoins = 0.00;
					
					updateValues();
	                dialog.dismiss();
	            }
	        })
	        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            })
	        .create();
	        return myClearingDialogBox;
	    }
	 
	 private AlertDialog Pro_Feature() {
         AlertDialog proFeatureDialogBox = new AlertDialog.Builder(this)
                 .setTitle("Pro Feature Only!")
                 .setMessage("This version does not come with this feature. Please purchase the pro version to utilize this function.")
                 .setPositiveButton("Okay", new DialogInterface.OnClickListener() {

                     public void onClick(DialogInterface dialog, int whichButton) {
                         Toast.makeText(getApplicationContext(), "Please purchase the pro version to use that feature.", Toast.LENGTH_LONG).show();
                         dialog.dismiss();
                     }
                 })
                 .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                     public void onClick(DialogInterface dialog, int which) {
                         Toast.makeText(getApplicationContext(), "Please purchase the pro version to use that feature.", Toast.LENGTH_LONG).show();
                         dialog.dismiss();
                     }
                 })
                 .create();
         return proFeatureDialogBox;
     }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()){

		case R.id.about:
			Uri uri = Uri.parse("http://www.appsbyvir.com");
			Intent redirect = new Intent(Intent.ACTION_VIEW, uri);
			redirect.addFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
			startActivity(redirect);
			break;

		case R.id.action_settings:
			AlertDialog proFeatureBox = Pro_Feature();
			proFeatureBox.show();
			break;

        case R.id.load:
            proFeatureBox = Pro_Feature();
            proFeatureBox.show();
            break;

		case R.id.help:
			AlertDialog helpBox = HelpDialog();
			helpBox.show();
			break;
		}
		return false;
	}

	private AlertDialog HelpDialog() {
	    AlertDialog myHelpDialogBox = new AlertDialog.Builder(this)
	        .setTitle("Help") 
	        .setMessage(helpText)
	        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {

	            public void onClick(DialogInterface dialog, int whichButton) {
	            	//what happens when clicked					
	                dialog.dismiss();   
	            }
	        })
	        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
	            public void onClick(DialogInterface dialog, int which) {

	                dialog.dismiss();
	            }
	        })
	        .create();
	        return myHelpDialogBox;
	    }
}