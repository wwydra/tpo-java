package zad1;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import javax.swing.*;
import java.awt.*;

public class ServiceGui extends JFrame{
    private JPanel panel1;
    private JTextArea countryTextArea;
    private JTextArea cityTextArea;
    private JTextArea currencyTextArea;
    private JButton confirmButton;
    private JTextField countryTextField;
    private JTextField cityTextField;
    private JTextField currencyTextField;
    private JPanel contentPanel;
    private JPanel jfx;
    private JLabel weatherLabel;
    private JLabel rateLabel;
    private JLabel NBPLabel;
    private JLabel label;
    private JFXPanel jfxPanel;
    private Service service;

    public ServiceGui(Service service) throws HeadlessException {
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Service");
        this.add(panel1);
        this.setSize(1000, 1000);
        this.service = service;

        jfxPanel = new JFXPanel();
        jfx.add(jfxPanel);
        this.pack();

        countryTextArea.setEditable(false);
        cityTextArea.setEditable(false);
        currencyTextArea.setEditable(false);

        confirmButton.addActionListener((al) -> {
            String city = cityTextField.getText();
            String country = countryTextField.getText();
            String currency = currencyTextField.getText();
            service.setCountry(country);

            String weather = service.getWeather(city);
            double rate = service.getRateFor(currency);
            double NBPrate = service.getNBPRate();

            if (weather != null || !city.isEmpty()) {
                    weatherLabel.setText("Current temperature in " + city + ": \n" + weather);
            }else{
                weatherLabel.setText("Incorrect city name");
            }
            if (rate != 0.0) {
                rateLabel.setText("Exchange rate: " + rate);
            }else{
                rateLabel.setText("Incorrect currency");
            }
            if (NBPrate != 0.0) {
                NBPLabel.setText("NBP rate: " + NBPrate);
            }else{
                NBPLabel.setText("Incorrect country");
            }
            Platform.runLater(() -> {createContent(city); this.pack();});
        });
    }

    public void createContent(String city){
        WebView webView = new WebView();
        webView.getEngine().load("https://en.wikipedia.org/wiki/" + city);
        Scene scene = new Scene(webView);
        jfxPanel.setScene(scene);
    }
}
