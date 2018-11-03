package lk.zeon.carrental.Controller;

import lk.zeon.carrental.dto.VehicleDto;
import lk.zeon.carrental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/car")
public class CarController {

    @Autowired
    CarService carService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public  boolean saveCar(@RequestBody VehicleDto vehicleDto){
        return carService.addVehicles(vehicleDto);
    }


    @DeleteMapping(value = "/{vehiId}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteCar(@PathVariable("vehiId") int vehiId){
        return carService.deleteVehicle(vehiId);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<VehicleDto>getAllVehicles(){
        return carService.getAllvehicles();
    }

    @GetMapping(value = ("/{vehiId}"),produces = MediaType.APPLICATION_JSON_VALUE)
    public VehicleDto getVehicleByID(@PathVariable("vehiId") int vehiId){
        return carService.getVehicleByModel(vehiId);
    }
    
}
