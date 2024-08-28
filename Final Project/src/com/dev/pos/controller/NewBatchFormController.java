package com.dev.pos.controller;

import com.dev.pos.Enum.BoType;
import com.dev.pos.bo.BoFactory;
import com.dev.pos.bo.custom.BatchBo;
import com.dev.pos.dto.BatchDTO;
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
import org.apache.commons.codec.binary.Base64;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

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

    BatchBo batchBo = BoFactory.getInstance().getBo(BoType.BATCH);

    String uniqueData = null;
    BufferedImage bufferedImage = null;

    public void initialize() {
        try {
            setQRcode();
        } catch (WriterException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

        try {

            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            javax.imageio.ImageIO.write(bufferedImage, "png", baos);
            byte[] arr = baos.toByteArray();
            String barcode = Base64.encodeBase64String(arr);


            BatchDTO dto = new BatchDTO(
                    uniqueData,
                    barcode,
                    Integer.parseInt(txtQTy.getText()),
                    Double.parseDouble(txtSellingPrice.getText()),
                    rdYes.isSelected() ? true : false,
                    Double.parseDouble(txtShowPrice.getText()),
                    Double.parseDouble(txtBuyingPrice.getText()),
                    Integer.parseInt(txtProductCode.getText())

            );

            batchBo.saveBatch(dto);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private void setQRcode() throws WriterException {

        uniqueData = QRdataGenerator.generate(30);

//        System.out.println(QRdataGenerator.generate(30));
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        bufferedImage = MatrixToImageWriter.toBufferedImage(
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
