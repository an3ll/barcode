package com.an3ll.barcode.service;

import com.an3ll.barcode.model.Retailer;
import com.an3ll.barcode.model.command.AddRetailerInfoCommand;
import com.an3ll.barcode.model.command.CreateRetailerCommand;

/**
 * Created by joaane on 2016-05-24.
 */
public interface RetailerCommandService {

    Retailer createRetailer(CreateRetailerCommand createRetailerCommand);

    Retailer addRetailerContent(AddRetailerInfoCommand addRetailerInfoCommand) throws Exception;
}
