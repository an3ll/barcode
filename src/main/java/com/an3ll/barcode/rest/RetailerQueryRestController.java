package com.an3ll.barcode.rest;

import com.an3ll.barcode.model.Retailer;
import com.an3ll.barcode.repository.RetailRepository;
import com.an3ll.barcode.service.RetailerQueryService;
import com.an3ll.barcode.servicebean.RetailerQueryServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/retailer/query")
public class RetailerQueryRestController {

    @Autowired
    private RetailerQueryService retailerQueryService;

    @Autowired RetailRepository retailRepository;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * @param name String
     * @return retailer.
     */
    @RequestMapping(value = "/name/{name}", method = GET)
    public Retailer getRetailerByName(@PathVariable("name") String name)
            throws ObjectNotFoundException {

        objectMapper.getSerializerFactory();
        Retailer response = retailerQueryService.getRetailer(name);
        if (response != null) {
            return response;
        } else {
            throw new ObjectNotFoundException("retailer with name = " + name);
        }
    }

//    /**
//     * @param id String
//     * @return retailer.
//     */
//    @RequestMapping(value = "/name/{name}", method = GET)
//    public Retailer getRetailerById(@PathVariable("id") String id)
//        throws ObjectNotFoundException {
//
//        objectMapper.getSerializerFactory();
//        Retailer response = retailRepository.findById(id);
//        if (response != null) {
//            return response;
//        } else {
//            throw new ObjectNotFoundException("retailer with name = " + id);
//        }
//    }
}
