package trg.talentsprint.starterkit.web;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
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
import trg.talentsprint.starterkit.model.Route;
import trg.talentsprint.starterkit.model.User;
import trg.talentsprint.starterkit.repository.UserRepository;
import trg.talentsprint.starterkit.service.RouteService;
import trg.talentsprint.starterkit.service.SecurityService;
import trg.talentsprint.starterkit.service.UserService;
import trg.talentsprint.starterkit.validator.UserValidator;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;
    
    @Autowired
    private UserRepository urep;
    
    
    @Autowired
    private UserValidator userValidator;
    
    @Autowired
    private RouteService rservice;

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
    public String addNewRoute(@PathVariable("username") String username, 
    		@Valid @ModelAttribute("route") Route route, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addroute";
        }
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
    @PostMapping("/search")
	 public String searchInfoByName(Model model,
			@RequestParam(value="routefrom",required = false,defaultValue = "") String routefrom,
			@RequestParam(value="routeto",required = false,defaultValue = "") String routeto,
			@RequestParam(value="type",required = false,defaultValue = "") String type){
   	List<Route> route=rservice.findInfoRoute(routefrom,routeto, type);
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
    	model.addAttribute("route", rservice.findInfoRouteByname(username));
        return "myroutes";
    }
    
    
    
//    @GetMapping("{id}/addip")
//    public ModelAndView showIpCreationForm(@PathVariable Long id,
//    		@ModelAttribute Iplace place, Model model) {
//    	ModelAndView mv=new ModelAndView();
//    	mv.addObject("rid",id);
//    	model.addAttribute("place", new Iplace());
//    	mv.setViewName("addip");
//        return mv;
//    }
//    
//    @PostMapping("{rid}/ipadd")
//    public String addNewIplace(@PathVariable("rid") Long rid, 
//    		@Valid @ModelAttribute("route") Iplace place, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            return "addip";
//        }
//        place.setRid(rid);
//        iser.save(place);
//        return "welcome";
//    }   
    
//    @GetMapping("{id}/showipinfo")
//    public String showipinfo(@ModelAttribute Iplace place, @PathVariable Long id,Model model)
//    {
//    	model.addAttribute("place",iser.findInfoByRid(id));
//    	return "p";
//    }
    
}
