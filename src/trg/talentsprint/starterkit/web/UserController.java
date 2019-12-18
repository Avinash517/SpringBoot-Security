package trg.talentsprint.starterkit.web;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import trg.talentsprint.starterkit.model.Diagnostic;
import trg.talentsprint.starterkit.model.Favplace;
import trg.talentsprint.starterkit.model.Img;
import trg.talentsprint.starterkit.model.Lab;
import trg.talentsprint.starterkit.model.Ltest;
import trg.talentsprint.starterkit.model.Route;
import trg.talentsprint.starterkit.model.SearchDate;
import trg.talentsprint.starterkit.model.Test;
import trg.talentsprint.starterkit.model.User;
import trg.talentsprint.starterkit.repository.DiagnosticRepository;
import trg.talentsprint.starterkit.repository.FavplaceRepository;
import trg.talentsprint.starterkit.repository.LabRepository;
import trg.talentsprint.starterkit.repository.LtestRepository;
import trg.talentsprint.starterkit.repository.RouteRepository;
import trg.talentsprint.starterkit.repository.SearchDateRep;
import trg.talentsprint.starterkit.repository.TestRepository;
import trg.talentsprint.starterkit.repository.UserRepository;
import trg.talentsprint.starterkit.service.ImgService;
import trg.talentsprint.starterkit.service.RouteService;
import trg.talentsprint.starterkit.service.SecurityService;
import trg.talentsprint.starterkit.service.UserService;
import trg.talentsprint.starterkit.validator.UserValidator;

@Controller
public class UserController {
	
	//public static String uploadDirectory =System.getProperty("user.dir")+"/uploads";
	
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;
    
    @Autowired
    private UserRepository urep;
    
    @Autowired
    private RouteRepository rurep;
    
    @Autowired
    private FavplaceRepository frep;
    
    @Autowired
    private UserValidator userValidator;
    
    @Autowired
    private RouteService rservice;
    
    @Autowired
    private TestRepository trep;
    
    
    @Autowired
    private LabRepository lrep;
    
    @Autowired
    private LtestRepository ltrep;
    
    @Autowired
    private DiagnosticRepository drep;
    
    
    @Value("${upload.location}")
    private String uploadDirectory;
    
    
    
    private ImgService iservice;
    
    
//    @Autowired
//    ServletContext context;

   
    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @GetMapping({"/","/welcome"})
    public String welcome(Model model) {
    	//model.addAttribute("s",new Route());
    	model.addAttribute("route", rservice.findAll());
        return "welcome";
    }
   
    @GetMapping("{username}/new-route")
    public ModelAndView showRouteCreationForm(@PathVariable String username,
    		@ModelAttribute Route route, Model model) {
    	ModelAndView mv=new ModelAndView();
    	User u=userService.findByUsername(username);
    	String us=u.getUsername();
    	mv.addObject("user",us);
    	model.addAttribute("route", new Route());
    	mv.setViewName("addroute");
        return mv;
    }
    @PostMapping("{username}/add")
    public String addNewRoute(
    		@PathVariable("username") String username, 
    	    Route route, Model model,
    	    @RequestParam(value="name",required = false,defaultValue = "") String name,
    	    @RequestParam(value="type",required = false,defaultValue = "") String type,
    	    @RequestParam(value="keywords",required = false,defaultValue = "") String keywords,
    	    @RequestParam(value="decryption",required = false,defaultValue = "") String decryption,
    	    @RequestParam(value="rfrom",required = false,defaultValue = "") String rfrom,
    	    @RequestParam(value="rto",required = false,defaultValue = "") String rto,
    	    @RequestParam(value="location",required = false,defaultValue = "") String location,
    	    @RequestParam(value="placename",required = false,defaultValue = "") String placename,
    	    @RequestParam(value="placeinfo",required = false,defaultValue = "") String placeinfo,
    	    @RequestParam(value="file",defaultValue = "")  MultipartFile[] files)
    {
    
        route.setName(name);
        route.setType(type);
        route.setKeywords(keywords);
        route.setDecryption(decryption);
        route.setRoutefrom(rfrom);
        route.setRouteto(rto);
      route.setPlaceinfo(placeinfo);
        System.out.println(uploadDirectory);
        
        
		 StringBuilder fileNames = new StringBuilder();
		  for (MultipartFile file : files) {
			  Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
			  fileNames.append(file.getOriginalFilename()+" ");
			  try {
				Files.write(fileNameAndPath, file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		  }
		  String path=fileNames.toString();
		  System.out.println(fileNames.toString());
		  
        route.setPath(path);     
        route.setUsername(username);
        rservice.save(route);
        model.addAttribute("route",rservice.findAll());
        return "welcome";
    }
    
    @GetMapping("/{id}")
    public String showRouteById(@PathVariable("id") Long id, Model model) {
        Route route = rservice.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid route Id:" + id));
        
        model.addAttribute("route", route);
        return "editroute";
    }
    
    @PostMapping("/{id}/update")
    public String updateRoute(@PathVariable Long id, @Valid @ModelAttribute Route route, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "editroute";
        }
        rservice.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Route Id:" + id));
        rservice.save(route);
        //model.addAttribute("route", rservice.findAll());
        return "welcome";
    }
    
    @GetMapping("/{id}/delete")
    public String deleteRoute(@PathVariable Long id, Model model) {
        rservice.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Route Id:" + id));
        rservice.deleteById(id);
        model.addAttribute("route", rservice.findAll());
        return "welcome";
    }
    @GetMapping("/search")
	 public String searchInfoByName(Model model,
			@RequestParam(value="area",required = false,defaultValue = "") String routefrom,
			@RequestParam(value="routeto",required = false,defaultValue = "") String routeto,
			@RequestParam(value="type",required = false,defaultValue = "") String type){
   	List<Route> route=rservice.findInfoRoute(routefrom,routeto,type);
			 model.addAttribute("route",route);
			 return "map"; 
      }
    
   
    @GetMapping("/searchbyrfrom")
	 public String searchInfoByrfrom(Model model,
			@RequestParam(value="area",required = false,defaultValue = "") String routefrom){
  	List<Route> route=rurep.getInfoByroute(routefrom);
			 model.addAttribute("route",route);
			 return "result"; 
     }
    
    @GetMapping("{username}/profile")
    public String showProfile(Model model,@PathVariable String username) {
        User u=userService.findByUsername(username);
    	model.addAttribute("user", u);
        return "profile";
    }
    
    @GetMapping("{username}/myroute")
    public String showRouteByUsername(Model model,@PathVariable String username) {
    	model.addAttribute("routes", rservice.findInfoRouteByname(username));
    	// model.addAttribute("download",downloadDirectory);
        return "myroutes";
    }
    
    
    @GetMapping("{username}/myfavplace")
    public String showFavplaceByUsername(Model model,@PathVariable String username) {
    	model.addAttribute("places",rurep.findinfoByUsername(username));
        return "favplace";
    }
    
    
    
    @GetMapping("{id}/{username}/favp")
    public String Addfavplace(@PathVariable("id") Long rid,
    		@PathVariable("username") String username,
    		Favplace f, Model model) {
    	f.setRid(rid);
    	f.setUsername(username);
    	frep.save(f);
        return "welcome";
    }
    
  //Upload image
    
    
    @RequestMapping("/u")
	  public String UploadPage(Model model) {
		  return "test";
	 }
    
    @RequestMapping("/m")
	  public String UploadMap(Model model) {
		  return "map";
	 }
    
    
   

    
	 @RequestMapping(value="/upload",method = RequestMethod.POST)
	  public String upload(Model model,@RequestParam("file") MultipartFile[] files,HttpServletRequest req,Route r) {
		 System.out.println(uploadDirectory);
		 StringBuilder fileNames = new StringBuilder();
		  for (MultipartFile file : files) {
			  Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
			  fileNames.append(file.getOriginalFilename()+" ");
			  try {
				Files.write(fileNameAndPath, file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		  }
		  model.addAttribute("msg", "Successfully uploaded files "+fileNames.toString());
		  String path=fileNames.toString();
		  System.out.println(fileNames.toString());
		//  model.addAttribute("download",downloadDirectory);
		  
		//  System.out.println("download"+downloadDirectory);
		  r.setPath(path);
		  rservice.save(r);
	 // System.out.println(Paths.get("").toAbsolutePath().toString());
		//  System.out.println(context.getRealPath("/uploads"));
	  //System.out.println(this.getClass().getClassLoader().getResource("").getPath());
		  return "welcome";
	  }
	 
	 
	 @RequestMapping(value="/upl",method = RequestMethod.POST)
	  public String upload1(Model model,
			  @RequestParam("name") String name,
			  @RequestParam("file") MultipartFile[] files,
			  HttpServletRequest req,Test t) {
		 System.out.println(uploadDirectory);
		 StringBuilder fileNames = new StringBuilder();
		  for (MultipartFile file : files) {
			  Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
			  fileNames.append(file.getOriginalFilename()+" ");
			  try {
				Files.write(fileNameAndPath, file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		  }
		  model.addAttribute("msg", "Successfully uploaded files "+fileNames.toString());
		  String path=fileNames.toString();
		  t.setIname(name);
		  t.setPath(path);
		  trep.save(t);
		  System.out.println(fileNames.toString());
		//  model.addAttribute("download",downloadDirectory);
		 // System.out.println("download"+downloadDirectory);
	 // System.out.println(Paths.get("").toAbsolutePath().toString());
		//  System.out.println(context.getRealPath("/uploads"));
	  //System.out.println(this.getClass().getClassLoader().getResource("").getPath());
		  return "welcome";
	  }
	 
	 
	 @RequestMapping("{rname}/searchbyroutename")
	 public String showresult(@PathVariable("rname") String name,Model model)
	 {
		 System.out.println("routname"+name);
//		 Route r=rurep.findByRoutefrom(name);
//		 System.out.println(r.getId());
//		 model.addAttribute("route",rurep.findByRoutefrom(name));
		 return "viewroute";
	 }
	 
	 //----------Diagnostic project--------------//
	 
	 @RequestMapping("/d")
	  public String showdiagno(Model model) {
		  return "diagnostic";
	 }
	 
	 @RequestMapping("/l")
	  public String showaddlab(Model model) {
		  return "lab";
	 }
	 
	 @RequestMapping("/t")
	  public String showaddtest(Model model) {
		  return "ltest";
	 }
	 
	 @RequestMapping("/addlab")
	 public String addlab(@RequestParam("labname") String labname,
			 @RequestParam("location") String location,Lab l)
	 {
		 l.setLabname(labname);
		 l.setLocation(location);
		 lrep.save(l);
		 return "diagnostic";
	 }
	 
	 @RequestMapping("/addtest")
	 public String addtest(@RequestParam("testname") String testname,Ltest t)
	 {
		 t.setTestname(testname);
		 ltrep.save(t);
		 return "diagnostic";
	 }
	 
	 @RequestMapping("/setup")
	  public String showsetup(Model model) {
		 model.addAttribute("lablist",lrep.findAll());
		 model.addAttribute("testlist",ltrep.findAll());
		  return "setup";
	 }
	 
	 @RequestMapping("/addsetup")
	  public String showaddsetup(@RequestParam("labname") String labname,
			  @RequestParam("testname") String testname,Lab l,
			  Ltest t,Diagnostic d,Model model) {
		 l=lrep.findByLabname(labname);
		 t=ltrep.findByTestname(testname);
		 d.setLid(l.getLid());
		 d.setTid(t.getTid());
		 drep.save(d);
		 model.addAttribute("lablist",lrep.findAll());
		 model.addAttribute("testlist",ltrep.findAll());
		  return "setup";
	 }
	 
	 @RequestMapping("/searchlab")
	  public String showsearchlab(Model model) {
		 model.addAttribute("testlist",ltrep.findAll());
		  return "searchlab";
	 }
	 @RequestMapping("/resultserach")
	  public String resultsearch(@RequestParam("testname") String testname,
			  Ltest t,Model model) {
		 t=ltrep.findByTestname(testname);
		 long tid=t.getTid();
		 model.addAttribute("tname",testname);
		 model.addAttribute("lablist",lrep.findlabnamebytid(tid));
		 model.addAttribute("testlist",ltrep.findAll());
		  return "searchlab";
	 }
	 
	 @RequestMapping("{labname}/{testname}/booking")
	 public String showbooking(@PathVariable("labname") String labname,
			 @PathVariable("testname") String testname,Model model)
	 {
		 System.out.println("labname="+labname+"\n"+"testname="+testname);
		 return "searchlab";
	 }
}