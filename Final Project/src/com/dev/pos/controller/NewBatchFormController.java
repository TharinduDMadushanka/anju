package com.dev.pos.controller;

import com.dev.pos.util.QR.QRdataGenerator;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.QRCodeWriter;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.awt.image.BufferedImage;

public class NewBatchFormController {

    @FXML
    private Button btnSave;

    @FXML
    private AnchorPane context;

    @FXML
    private ToggleGroup discount;

    @FXML
    private ImageView imgQR;

    @FXML
    private RadioButton rdNo;

    @FXML
    private RadioButton rdYes;

    @FXML
    private TextField txtBuyingPrice;

    @FXML
    private TextArea txtDescription;

    @FXML
    private TextField txtProductCode;

    @FXML
    private TextField txtQTy;

    @FXML
    private TextField txtSellingPrice;

    @FXML
    private TextField txtShowPrice;

    String uniqueData = null;

    public void initialize() {
        try {
            setQRcode();
        } catch (WriterException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

    }

    private void setQRcode() throws WriterException {

        uniqueData = QRdataGenerator.generate(30);

//        System.out.println(QRdataGenerator.generate(30));
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(
                qrCodeWriter.encode(
                        uniqueData,
                        BarcodeFormat.QR_CODE,
                        198,
                        196
                )
        );

        Image image = SwingFXUtils.toFXImage(bufferedImage, null);
        imgQR.setImage(image);
    }

    public void setProductCode(int code, String description) {
        txtProductCode.setText(String.valueOf(code));
        txtDescription.setText(description);
    }

}
