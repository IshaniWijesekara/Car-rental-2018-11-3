package lk.zeon.carrental.service.impl;

import lk.zeon.carrental.dto.VehicleDto;
import lk.zeon.carrental.entity.Cars;
import lk.zeon.carrental.repository.CarRepository;
import lk.zeon.carrental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ze on 10/31/2018.
 */

@Service
@Transactional(propagation = Propagation.SUPPORTS , readOnly = true)
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Override
    public boolean addVehicles(VehicleDto vehicleDto) {
        Cars cars = new Cars();
        cars.setVehiId(vehicleDto.getVehicleId());
        cars.setBrand(vehicleDto.getBrand());
        cars.setConditions(vehicleDto.getConditions());
        cars.setDailyPrice(vehicleDto.getDailyPrice());
        cars.setFuelType(vehicleDto.getFuelType());
        cars.setMode1(vehicleDto.getModel());
        cars.setPlateNumber(vehicleDto.getPlateNumber());
        cars.setSeatQuantity(vehicleDto.getSeatQuantity());
        cars.setType(vehicleDto.getType());

        carRepository.save(cars);
        return true;
    }

    @Override
    public boolean deleteVehicle(int vehiId) {
        carRepository.deleteById(vehiId);
        return true;
    }

    @Override
    public ArrayList<VehicleDto> getAllvehicles() {
        List<Cars> all = carRepository.findAll();
        ArrayList<VehicleDto> vehicleDtos = new ArrayList<>();

        for (Cars cars:all) {
            VehicleDto vehicleDto = new VehicleDto();
            vehicleDto.setVehicleId(cars.getVehiId());
            vehicleDto.setBrand(cars.getBrand());
            vehicleDto.setConditions(cars.getConditions());
            vehicleDto.setDailyPrice(cars.getDailyPrice());
            vehicleDto.setFuelType(cars.getFuelType());
            vehicleDto.setModel(cars.getMode1());
            vehicleDto.setPlateNumber(cars.getPlateNumber());
            vehicleDto.setSeatQuantity(cars.getSeatQuantity());
            vehicleDto.setType(cars.getType());

            vehicleDtos.add(vehicleDto);
        }
        return vehicleDtos;


    }

    @Override
    public VehicleDto getVehicleByModel(int vehiId) {
        Cars cars = carRepository.findById(vehiId).get();
        VehicleDto vehicleDto = new VehicleDto();
        vehicleDto.setVehicleId(cars.getVehiId());
        vehicleDto.setBrand(cars.getBrand());
        vehicleDto.setConditions(cars.getConditions());
        vehicleDto.setDailyPrice(cars.getDailyPrice());
        vehicleDto.setFuelType(cars.getFuelType());
        vehicleDto.setModel(cars.getMode1());
        vehicleDto.setPlateNumber(cars.getPlateNumber());
        vehicleDto.setSeatQuantity(cars.getSeatQuantity());
        vehicleDto.setType(cars.getType());

        return vehicleDto;

    }

    @Override
    public VehicleDto getVehicleBYBrand(String brand) {
        return null;
    }

    @Override
    public VehicleDto updateVehicleDetail(VehicleDto vehicleDto) {
        return null;
    }
}
