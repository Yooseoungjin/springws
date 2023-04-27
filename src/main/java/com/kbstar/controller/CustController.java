package com.kbstar.controller;

import com.kbstar.dto.Cust;
import com.kbstar.service.CustService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j /*로그 찍는 골뱅이*/
@Controller


@RequestMapping("/cust") // /cust를 넣음으으로 기본적으로 주소에 /cust가 셋팅됨
public class CustController {
    @Autowired
    CustService service;

    // Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    String dir = "cust/"; //폴더명을 변수로 넣기
    //127.0.0.1/cust
    @RequestMapping("")
    public String main(Model model){
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"center");
        //logger.info("----------------------------------------------------------------------------");
        Random r= new Random();
        int inx = r.nextInt(1000)+1;
        log.info(inx+""); /*String 타입만 가능해서 +""추가함*/
        return "index";
    }

    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"add");
        return "index";
    }

    @RequestMapping("/all")

    public String all(Model model) {
        List<Cust> list = new ArrayList<>();
        try {
            list = service.get();
        } catch (Exception e) {
            log.info("조회 에러......");
            e.printStackTrace();
        }
        model.addAttribute("clist", list);
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"all");
        return "index";
    }

    @RequestMapping("/get")
    public String get(Model model,String id){
        Cust cust = new Cust();
        try {
            cust = service.get(id);
        } catch (Exception e) {
            log.info("조회 에러......");
            e.printStackTrace();
        }
        model.addAttribute("gcust",cust);
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"get");
        return "index";
    }

}
