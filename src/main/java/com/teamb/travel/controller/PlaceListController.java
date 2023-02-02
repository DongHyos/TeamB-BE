package com.teamb.travel.controller;

import com.teamb.travel.dto.PlaceListReqDTO;
import com.teamb.travel.dto.PlaceListResDTO;
import com.teamb.travel.service.PlaceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlaceListController {

    @Autowired
    PlaceListService placeListService;

    @GetMapping("/tourlist/keyword")
    public List<PlaceListResDTO> keywordPlacesSearch(@RequestParam String keyword, @RequestParam(name = "pageno") int pageNo) {

        PlaceListReqDTO placeListReqDTO = new PlaceListReqDTO(keyword);
        return placeListService.selectPlacesByTitleContaining(placeListReqDTO, pageNo);
    }
}
