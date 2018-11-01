package com.apap.tutorial7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tutorial7.model.PilotModel;
import com.apap.tutorial7.repository.PilotDB;

/**
 * PilotServiceImpl
 */
@Service
@Transactional
public class PilotServiceImpl implements PilotService {
    @Autowired
    private PilotDB pilotDb;

    public PilotModel getPilotDetailByLicenseNumber(String licenseNumber) {
        return pilotDb.findByLicenseNumber(licenseNumber);
    }

    public PilotModel addPilot(PilotModel pilot) {
        return pilotDb.save(pilot);
    }

    public void deletePilotByLicenseNumber(String licenseNumber) {
        pilotDb.deleteByLicenseNumber(licenseNumber);
    }

    public PilotModel getPilotDetailById(long id) {
        return pilotDb.findById(id);
    }

	@Override
	public void deletePilot(PilotModel pilot) {
		pilotDb.deleteById(pilot.getId());
	}

	@Override
	public void updatePilot(long pilotId, PilotModel pilot) {
		pilotDb.save(pilot);
	}
    
    
}