package com.an3ll.barcode.servicebean;

import com.an3ll.barcode.model.Retailer;
import com.an3ll.barcode.repository.RetailRepository;
import com.an3ll.barcode.service.RetailerQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.FileEditor;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

/**
 * Created by joaane on 2016-05-24.
 */

@Service
public class RetailerQueryServiceImpl implements RetailerQueryService {

    @Autowired
    RetailRepository retailRepository;

    @Override
    public Retailer getRetailer(String name) {
        Retailer retailer = retailRepository.findByName(name);

        if (null != retailer) {
            try {
                final BufferedImage bufferedImage =
                    ImageIO.read(new ByteArrayInputStream(retailer.getQrCode().getImageData()));
                File file = new File(
                    "/Users/joaane/R2M/Eget/barq-workspace/barcode-application/src/main/resources/qrcodes/test.png");
                ImageIO.write(bufferedImage, "png", file);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return retailer;
        }
        return null;
    }
}
