package com.icf.employee.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.icf.employee.dto.DependantDto;
import com.icf.employee.service.DependantService;
import com.icf.employee.service.impl.DependantServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/api/employee")
public class DependantController {

	@Autowired
	DependantService dependantService;

	@Autowired
	DependantServiceImpl dependantDetailService;

	@ApiOperation(value = "save Dependant", notes = "This api is used to save the Dependant", httpMethod = "POST")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server error"),
			@ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 401, message = "UnAuthorized"),
			@ApiResponse(code = 404, message = "NOT_FOUND") })

	@PostMapping("/dependant")
	public DependantDto saveDependantDto(@RequestBody DependantDto dependantDto, Device device) {
		DependantDto userResDto = dependantService.createDependant(dependantDto);
		return userResDto;

	}

	@ApiOperation(value = "get all Dependants", notes = "This api is used to get all the Dependants", httpMethod = "GET")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server error"),
			@ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 401, message = "UnAuthorized"),
			@ApiResponse(code = 404, message = "NOT_FOUND") })

	@GetMapping("/dependants")
	public List<DependantDto> getAllDependants() {
		return dependantService.getAllDependants();

	}

	@ApiOperation(value = "get Dependant by Id", notes = "This api is used to get the Dependant by Id", httpMethod = "GET")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server error"),
			@ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 401, message = "UnAuthorized"),
			@ApiResponse(code = 404, message = "NOT_FOUND") })

	@GetMapping("/dependant/{id}")
	public DependantDto getDependantById(@PathVariable Long id) {

		return dependantService.getDependantById(id);
	}

	@ApiOperation(value = "delete Dependant by Id", notes = "This api is used to delete the Dependant by Id", httpMethod = "DELETE")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server error"),
			@ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 401, message = "UnAuthorized"),
			@ApiResponse(code = 404, message = "NOT_FOUND") })

	@DeleteMapping("/dependant/{id}")
	public void deleteDependantById(@PathVariable Long id) {
		dependantService.deleteDependantById(id);
	}
}
