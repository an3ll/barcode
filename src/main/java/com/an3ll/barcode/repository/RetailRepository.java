
package com.an3ll.barcode.repository;

import java.util.List;

import com.an3ll.barcode.model.Retailer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface RetailRepository extends MongoRepository<Retailer, String> {

	Retailer findByName(String name);

	Retailer findById(String id);

}
