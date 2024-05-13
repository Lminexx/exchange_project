package org.example.curren.Controller;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.curren.Currencies;
import org.example.curren.View.WindowSwing;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
public class Controller implements Initializable {
    @FXML
    private Button ButtonCurrency;

    @FXML
    private Button ButtonStop;

    @FXML
    private Button buttonStart;

    @FXML
    private ComboBox<String> comboFirstWallet;

    @FXML
    private TextField inputValue;

    @FXML
    private Label randomValue;

    @FXML
    private Label result;
    @FXML
    private Label textSeria;

    @FXML
    private Label textOfCurrency;
    private int cnt=0;
    private Random random;
    private int value;
    private CurrencyController currencyController;
    private Currencies currencies;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setButtons();
        setComboBoxes();
        buttonStart.setOnAction(event -> start());
        ButtonStop.setOnAction(event-> stop());
        inputValue.setOnAction(e->{
            CheckingWallet();
        });
        ButtonCurrency.setOnAction(e-> getCurrentCurrency());
    }

    public void setButtons(){
        textOfCurrency.setVisible(true);
        ButtonCurrency.setVisible(true);
        ButtonStop.setDisable(true);
        result.setVisible(true);
        textSeria.setVisible(true);
        currencies = new Currencies();
        currencies.setController(this);
    }
    public void setComboBoxes(){
        textOfCurrency.setVisible(false);
        ButtonCurrency.setVisible(false);
        randomValue.setText("");
        comboFirstWallet.getItems().addAll("AUD (Австралия)", "AZN (Азербайджан)", "AMD (Армения)", "BYN (Белорусь)", "BGN (Болгария)", "BRL (Бразилия)","HUF (Венгрия)",
                "KRW (Корея)", "VND (Вьетнам)", "HKD (Гонконг)", "GEL (Грузия)", "DKK (Дания)", "AED (АОЭ)", "USD", "EUR", "EGP (Египет)" ,"INR (Индия)" , "IDR (Индонещзия)",
                "KZT (Казахстан)", "CAD (Канада)", "QAR (Катар)", "KGS (Киргизтан)", "CNY (Китай)", "MDL (Молдова)", "NZD (Новая зеландия", "TMT (Туркменистан)", "NOK (Норвегия)",
                "PLN (Польша)", "RON (Румыния)", "RSD (Сербия)", "SGD (Сингапур)", "TJS (Таджикистан)", "THB (Тайланд)", "TRY (Турция)", "GBP (Великобретания)", "CZK (Чехия)", "SEK (Швеция)",
                "CHF (Швейцария)", "UZS (Узбекистан)", "UAH (Украина)", "ZAR (ЮАР)", "JPY (Япония)");
        comboFirstWallet.setValue("USD");
        this.random = new Random();
    }

    public void start(){
        setButtons();
        String selectedFirst = comboFirstWallet.getValue();
        if(selectedFirst.equals("USD")){
            this.value = random.nextInt(1,1000);
            randomValue.setText(value + "$");
        }else if(selectedFirst.equals("EUR")){
            this.value = random.nextInt(1,1000);
            randomValue.setText(value + "€");
        }else{
            this.value = random.nextInt(1,1000);
            randomValue.setText(value+"");
        }
        buttonStart.setDisable(true);
        ButtonStop.setDisable(false);
        comboFirstWallet.setDisable(true);
    }
    public void stop(){
        textOfCurrency.setVisible(false);
        ButtonCurrency.setVisible(false);
        buttonStart.setDisable(false);
        ButtonStop.setDisable(true);
        result.setVisible(false);
        textSeria.setVisible(false);
        comboFirstWallet.setDisable(false);
        result.setText("0");
        randomValue.setText("");
    }
    public void CheckingWallet(){
        String text = inputValue.getText();
        double wallet = 0;
        wallet = Double.parseDouble(currencies.getWallet().replace(",","."));
        if(wallet*value == Double.parseDouble(text) || ((wallet*value)*0.80 <= Double.parseDouble(text) && (wallet*value)*1.2 >= Double.parseDouble(text))){
            cnt++;
            this.result.setText(String.valueOf(cnt));
            inputValue.setText("");
            start();
        }else{
            cnt=0;
            inputValue.setText("");
            this.result.setText(String.valueOf(cnt));
            start();
        }
    }
    public void getWalletCourse(){

    }

    public void getCurrentCurrency(){
//        currencyController = new CurrencyController();
//        currencyController.start();
//        try {
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

        WindowSwing swing = new WindowSwing(this);
        swing.showConsole();
    }

    public Currencies getCurrencies() {
        return currencies;
    }

    public ComboBox<String> getComboFirstWallet() {
        return comboFirstWallet;
    }
}
