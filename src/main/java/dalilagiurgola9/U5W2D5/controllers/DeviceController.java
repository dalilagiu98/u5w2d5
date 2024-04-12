package dalilagiurgola9.U5W2D5.controllers;

import dalilagiurgola9.U5W2D5.entities.Device;
import dalilagiurgola9.U5W2D5.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/devices")
public class DeviceController {
    //ATTRIBUTES LIST:
    @Autowired
    private DeviceService deviceService;

    @GetMapping
    private Page<Device> getAllDevices(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sort) {
        return this.deviceService.findAll(page, size, sort);
    }

    @GetMapping("/{id}")
    private Device getDeviceById(@PathVariable long id) {
        return this.deviceService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Device saveNewDevice(@RequestBody Device body){
        return this.deviceService.save(body);
    }

    @PutMapping("/{id}")
    private Device findDeviceByIdAndUpdate(@PathVariable long id, @RequestBody Device body){
        return this.deviceService.findByIdAndUpdate(id, body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void findByIdAndDelete(@PathVariable long id) {
        this.deviceService.findByIdAndDelete(id);
    }
}
