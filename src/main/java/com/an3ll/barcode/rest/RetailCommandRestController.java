package com.an3ll.barcode.rest;

import com.an3ll.barcode.model.Retailer;
import com.an3ll.barcode.model.command.AddRetailerInfoCommand;
import com.an3ll.barcode.model.command.CreateRetailerCommand;
import com.an3ll.barcode.service.RetailerCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by joaane on 2016-05-24.
 */
@RestController(value = "/retailer/command")
public class RetailCommandRestController {

    @Autowired
    private RetailerCommandService retailerCommandService;

    /**
     * Rest controller.
     *
     * @param command CreateRetailerCommand
     * @return retailerId
     */
    @RequestMapping(value = "/create-retailer", method = POST)
    public String createRetailer (
            @RequestBody @Valid CreateRetailerCommand command)
            throws Exception {

        Retailer retailer = retailerCommandService.createRetailer(command);
        return retailer.getId();
    }

    /**
     * Rest controller.
     *
     * @param command add AddRetailerInfoCommand
     * @return retailerId
     */
    @RequestMapping(value = "/add-retailer-info", method = POST)
    public String addRetailerInfo (
        @RequestBody @Valid AddRetailerInfoCommand command)
        throws Exception {

        Retailer retailer = retailerCommandService.addRetailerContent(command);
        return retailer.getId();
    }
}
