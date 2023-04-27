package com.kbstar.controller;

import com.kbstar.dto.Item;
import com.kbstar.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/item") // /cust를 넣음으으로 기본적으로 주소에 /cust가 셋팅됨
public class ItemController {
    @Autowired
    ItemService service;

    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    String dir = "item/"; //폴더명을 변수로 넣기

    //127.0.0.1/cust
    @RequestMapping("")
    public String main(Model model){
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"center");
        return "index";
    }

    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"add");
        return "index";
    }

    @RequestMapping("/all")
    public String all(Model model){
        List<Item> list = new ArrayList<>();
        try {
            list = service.get();
        } catch (Exception e) {
            log.info("조회 에러......");
            e.printStackTrace();
        }

        model.addAttribute("allitem",list);
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"all");
        return "index";
    }

}
