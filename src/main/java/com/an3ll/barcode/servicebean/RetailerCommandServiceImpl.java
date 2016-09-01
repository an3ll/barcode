package com.an3ll.barcode.servicebean;

import com.an3ll.barcode.generator.QRGenerator;
import com.an3ll.barcode.model.Retailer;
import com.an3ll.barcode.model.RetailerInfo;
import com.an3ll.barcode.model.command.AddRetailerInfoCommand;
import com.an3ll.barcode.model.command.CreateRetailerCommand;
import com.an3ll.barcode.repository.RetailRepository;
import com.an3ll.barcode.service.RetailerCommandService;
import javassist.tools.rmi.ObjectNotFoundException;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import javax.annotation.Nonnull;

/**
 * Created by joaane on 2016-05-24.
 */

@Service
public class RetailerCommandServiceImpl implements RetailerCommandService{

    @Autowired
    RetailRepository retailRepository;

    @Autowired
    QRGenerator qrGenerator;

    @Override
    public Retailer createRetailer(@Nonnull final CreateRetailerCommand createRetailerCommand) {

        Retailer retailer = new Retailer();
        try {
            retailer.setId(new ObjectId().toString());
            retailer.setName(createRetailerCommand.getName());
            retailer.setQrCode(qrGenerator.generateQR(retailer.getId()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return retailRepository.save(retailer);
    }

    @Override
    public Retailer addRetailerContent(@Nonnull final AddRetailerInfoCommand addRetailerInfoCommand) throws Exception{

        Retailer retailer = retailRepository.findById(addRetailerInfoCommand.getId());

        if (null != retailer) {
            RetailerInfo retailerInfo = retailer.getRetailerInfo();
            if (null == retailerInfo) {
                RetailerInfo toAdd = new RetailerInfo();
                toAdd.addInfo(addRetailerInfoCommand.getRetailerInfo());
                retailer.setRetailerInfo(toAdd);
            } else {
                retailerInfo.addInfo(addRetailerInfoCommand.getRetailerInfo());
            }

            return retailRepository.save(retailer);
        }
        throw new ObjectNotFoundException("Retailer not found");
    }
}
