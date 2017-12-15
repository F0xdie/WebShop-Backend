package de.krombacher.ebenerWebshop.repository;

import org.springframework.data.repository.CrudRepository;

import de.krombacher.ebenerWebshop.domain.StorageLocation;

public interface StorageLocationRepository extends CrudRepository<StorageLocation, Long> {
	
	public StorageLocation findByLocationName(String locationName);

}
