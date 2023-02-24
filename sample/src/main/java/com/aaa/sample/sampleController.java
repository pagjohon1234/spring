package com.aaa.sample;

import com.aaa.sample.domain.sampleVO;
import com.aaa.sample.service.sampleService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

import javax.inject.Inject;

//생략가능(print문 대신 사용하기 위해서
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class sampleController {
	//해당 클래스에 대한  로그 변수를 선연
	private static final Logger Logger = LoggerFactory.getLogger(sampleController);
	
	@Inject
	private sampleService samService;
	
	//
	//
	//JSP에 값을 전달하고 싶을 때는 

}

   @RequestMapping(value="update" , method=RequdstMethod.GET)
      public String edit(sampleVO vo, Mpdel mpdel) throws Exception{
	   Logger.ingo("update로 접속을 했습니다.");
	   //
	   model.addAttribute(samService.update(vo));
	   model.addAttribute("sampleVO" , samService.update(vo));
  	   return "sampleUpdate";
	   
   }
   
   //Form에서 input 태그에 입력된 값들을 전달 받아서
   @RequestMapping(value="sampleInsert", method=RequestMethod.POST);
   //                  전달받을 값이 저장    패이지 정보        작업 완료 후 다른 패이지 이동
   public void sampleInsert(sampleVO vo, Model model, RedirectAttributes rttr) throws Exception{
         Logger.info("msg값을 전달했습니다.");
         //삽입폼=>처리->완료->목록
         samService.create(vo); //삽입처리
         //형식적인 선언
         rttr.addFlashAttribute("msg", "INSERT"); //다른 페이지로 이동 할 때 전달 할 메세지
         return "redirect:/sampleList";
         
     }
   
   //삭제나 부분조회, 수정할 레코드 조회=>기본키 값만 가져와서
   //
   @RequestMapping("sampleDelete")
   //                  전달받을 값이 저장    패이지 정보        작업 완료 후 다른 패이지 이동
   public String sampleDelete(@RequestParam("name") String name, Model model ) throws Exception{
         Logger.info("DTO의값을 전달했습니다.");
         //삽입폼=>처리->완료->목록
         samService.dlete(name);
         //전달 페이지에 변수르르 추가===>samVO DTO를
         return "sampleDeleteResult"; //데이터베이스(x)하고 페이지 이동        
     }
   }