package springproject.com;

import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class App 
{
    public static String main( String[] args )
    {
        System.out.println( "Hello World!" );
        return "Hello World!";
    }
    @RequestMapping(value="/hii",method=RequestMethod.GET)
    public String go()
    {
    	
    	return "in method go and went and came";
    }
    @RequestMapping("/hello/{username}/{country}")
    public ModelAndView gowent(@PathVariable("username") String name,@PathVariable("country") String countryname)
    {
    	ModelAndView model=new ModelAndView("hello");
    	model.addObject("msg","hello"+name+"you are from"+countryname);
    	return model;
    }
    @RequestMapping("/second/{username}/{country}")
    public ModelAndView gowentcame(@PathVariable Map<String,String> var)
    {
    	String name=var.get("username");
    	String countryname=var.get("country");
    	ModelAndView model=new ModelAndView("hello");
    	model.addObject("msg","hello"+name+"you are from"+countryname);
    	return model;
    	
    }
    @RequestMapping("/form/apply")
    public ModelAndView apply()
    {
    	ModelAndView model=new ModelAndView("apply");
    //	model.addObject("headermsg","DBS");
    	return model;
    }
    @RequestMapping("/form/check")
    public ModelAndView check(@RequestParam("Sname") String name,@RequestParam("branch") String branch)
    {
    	Student s1=new Student();
    	s1.setSname(name);
    	s1.setBranch(branch);
    	ModelAndView model=new ModelAndView("check");
    	model.addObject("studentdetails","registered with"+name+"branch:"+branch);
    	model.addObject("studentobj",s1);
    	return model;
    }
    @RequestMapping(value="/form/check1",method=RequestMethod.POST)
    public ModelAndView check1(@ModelAttribute("student1") Student student1)
    {
    	
    	ModelAndView model=new ModelAndView("check1");
    	//model.addObject("headermsg","DBS");
    	
    	return model;
    }
    @ModelAttribute
    public void content(Model model)
    {
    	model.addAttribute("headermsg", "DBSAsiaHub2"); 
    	
    }
    

}

