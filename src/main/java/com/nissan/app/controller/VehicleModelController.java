package com.nissan.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.app.reporsitory.ModelRepository;
import com.nissan.app.exception.ResourceNotFoundException;
import com.nissan.app.model.VehicleModel;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class VehicleModelController {

	@Autowired
	private ModelRepository modelRepository;

	@GetMapping("/getmodels")
	public List<VehicleModel> getAllModels() {
		return modelRepository.findAll();
	}

	@PostMapping("/createmodel")
	public VehicleModel createModel(@RequestBody VehicleModel vehicleModel) {		
		return modelRepository.save(vehicleModel);
	}

	@GetMapping("/model/{id}")
	public ResponseEntity<VehicleModel> getModelByID(@PathVariable Long id) {
		VehicleModel vehicleModel = modelRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Model not exist with id :" + id));
		return ResponseEntity.ok(vehicleModel);
	}

	@PutMapping("/model/{id}")
	public ResponseEntity<VehicleModel> updateModel(@PathVariable Long id,
			@RequestBody VehicleModel vechicleDetails) {
		VehicleModel vehicleModel = modelRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Model not exist with id :" + id));

		vehicleModel.setModelName(vechicleDetails.getModelName());
		vehicleModel.setLaunchYear(vechicleDetails.getLaunchYear());
		vehicleModel.setBodyStyle(vechicleDetails.getBodyStyle());
		vehicleModel.setPrice(vechicleDetails.getPrice());
		vehicleModel.setTrimLevel(vechicleDetails.getTrimLevel());
		vehicleModel.setType(vechicleDetails.getType());

		VehicleModel updatedModel = modelRepository.save(vehicleModel);
		return ResponseEntity.ok(updatedModel);
	}
	
	@DeleteMapping("/model/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteModel(@PathVariable Long id){
		VehicleModel vehicleModel = modelRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		modelRepository.delete(vehicleModel);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	

}
