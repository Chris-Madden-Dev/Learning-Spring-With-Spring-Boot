package com.chrismaddendev.learningspring.web;

import java.util.Date;
import java.util.List;

import com.chrismaddendev.learningspring.business.domain.RoomReservation;
import com.chrismaddendev.learningspring.business.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reservations")
public class RoomReservationWebController {
    private final ReservationService reservationService;

    @Autowired
    public RoomReservationWebController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // At the request mapping URL any GET method will be responded to by this method
    // Model comes from the Spring Framework UI class
    @GetMapping
    public String getReservations(@RequestParam(value="date", required = false)String dateString, Model model){
        Date date = DateUtils.createDateFromDateString(dateString);
        List<RoomReservation> roomReservations = this.reservationService.getRoomReservationsForDate(date);
        model.addAttribute("roomReservations", roomReservations);

        // This will tell Thymeleaf to go find a template called reservations, use that template, pass this model to the template and merge with
        // the Thymeleaf engine
        return "reservations";
    }
}
