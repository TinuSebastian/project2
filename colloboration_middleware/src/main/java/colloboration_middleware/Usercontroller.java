package colloboration_middleware;

import java.util.ArrayList;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.colloboration_backendDAO.JobDao;
import com.niit.colloboration_backendDAO.UsersDao;

public class Usercontroller
{
	@Autowired
	UsersDao userDAO;
	@Autowired
	JobDao jobDAO;
	
	
	
	 @RequestMapping(value="/getAllUsers/{user_id}",method=RequestMethod.GET)
		public ArrayList<User> getAllUser(@PathVariable("user_id") int user_id)
	 {
		 System.out.println("in rest controller getallusers");
			ArrayList<User> user=(ArrayList<User>)userDAO.requestFriend(user_id);
			System.out.println("in rest controller getallusers");

		return user;		
		}
	 
	 @RequestMapping(value="/getAllUsersreq",method=RequestMethod.GET)
	 
		public ArrayList<User> getAllUserreq()
	 {
		 System.out.println("in rest controller getallusersreq");
			ArrayList<User> userreq=(ArrayList<User>)userDAO.userrequests();
			System.out.println("in rest controller getallusersreq");

		return userreq;		
	 } 
	 /*@RequestMapping(value="/approveusers/{username}",method=RequestMethod.GET)
	 public void approveusers(@PathVariable("username") String username)
	 {
		 String email_id=username+".com";
		 User users =userDAO.getUserbyemail(email_id);
		 users.setStatus("A");
		 userDAO.approveusers(users);	 
	 }
	 @RequestMapping(value="/rejectusers/{username}",method=RequestMethod.GET)
	 public void rejectusers(@PathVariable("username") String username)
	 {String email_id=username+".com";
		 User users =userDAO.getUserbyemail(email_id);
		 users.setStatus("R");
		 userDAO.rejectusers(users);
		 
	 }*/
	 
	 @RequestMapping(value="/approveusers/{username}",method=RequestMethod.GET)
	 public void approveusers(@PathVariable("username") String username)
	 {
		 String email_id=username+".com";
		 User user =userDAO.getUserbyemail_id(email_id);
		 user.setStatus("A");
		 
		 System.out.println("User :"+user);	 
		 userDAO.approveusers(user);
	 
	 }
	 
	 @RequestMapping(value="/rejectusers/{username}",method=RequestMethod.GET)
	 public void rejectusers(@PathVariable("username") String username)
	 {
		 String email_id=username+".com";
		 User user =userDAO.getUserbyemail_id(email_id);
		 user.setStatus("R");
		 userDAO.rejectusers(user);
		 
	 }
	 
	 @RequestMapping(value="/getUser/{userid}",method=RequestMethod.GET)
		public ResponseEntity<User> getUser(@PathVariable("userid") int userId){
			
		 if(userDAO.getUser(userId)==null){
				
			}
			return new ResponseEntity<User>(userDAO.getUser(userId),HttpStatus.OK);
					
		}
	 @RequestMapping(value="/getUserByEmail/{useremail}",method=RequestMethod.GET)
		public ResponseEntity<User> userbyemail(@PathVariable("useremail") String useremail){
		
			 String useremaill=useremail+".com";
				System.out.println(useremaill); 
				User tempuser=userDAO.getUserbyemail_id(useremaill);
				System.out.println(tempuser.getFirst_name());
				System.out.println(tempuser.getLast_name());
		if(tempuser==null)
		{
			return new ResponseEntity<User>(tempuser,HttpStatus.BAD_REQUEST);		
		}
		else
		{
		return new ResponseEntity<User>(tempuser,HttpStatus.OK);	
		}		
		
		
		
		}
	 
	 @RequestMapping(value="/register",method=RequestMethod.POST)
		public ResponseEntity<User> createUser(@RequestBody User user){
			System.out.println("In register controller");
			boolean isSaved=userDAO.saveUser(user);
			if(isSaved) {
			return new ResponseEntity<User>(user,HttpStatus.OK);
			}
			else
				return new ResponseEntity<User>(user,HttpStatus.BAD_REQUEST);
			
		}
	
	 @RequestMapping(value="/login",method=RequestMethod.POST)
		public ResponseEntity<User> login(@RequestBody User user,HttpSession http)
	 
	 {
		


		 
			if(userDAO.checkLogin(user))
			{
				 User tempuser=userDAO.getUserbyemail_id(user.getEmail_id());
			
			tempuser.setIsonline("YES");
				userDAO.updateOnlineStatus(tempuser);
	tempuser.setErrorcode(200);
	tempuser.setErrormessage("login success");
			http.setAttribute("currentuser",tempuser);	
			return new ResponseEntity<User>(tempuser,HttpStatus.OK);
				
				
			}
			else
			{
			User tempuser1=new User();
			
			if(userDAO.checkLoginsimp(user))
			{
				User tempuser=userDAO.getUserbyemail_id(user.getEmail_id());
				
				if(tempuser.getStatus().equals("P"))
				{
			tempuser1.setErrorcode(200);
			tempuser1.setErrormessage("You are not yet approved by admin");
			return new ResponseEntity<User>(tempuser1,HttpStatus.OK);
			}
				else
				{
					tempuser1.setErrorcode(200);
					tempuser1.setErrormessage("You rejected please contact admin");
					return new ResponseEntity<User>(tempuser1,HttpStatus.OK);
				}
				
				
				
			}
			
			else
			{
				if(userDAO.checkLoginsemail(user))
				
				{
						tempuser1.setErrorcode(200);
						tempuser1.setErrormessage("email id or password incorrect");
						return new ResponseEntity<User>(tempuser1,HttpStatus.OK);
					}
					else
					{
						tempuser1.setErrorcode(200);
						tempuser1.setErrormessage("You are not registered yet");
						return new ResponseEntity<User>(tempuser1,HttpStatus.OK);
					}
			
				
				
				
			}
			
			
					
				}
			
				}
				
	 @RequestMapping(value="/job",method=RequestMethod.POST)
		public ResponseEntity<Job> getJob(){
		
			
				return new ResponseEntity<Job>(jobDAO.getjob(201),HttpStatus.BAD_REQUEST);
			
		}
	 
	 @RequestMapping(value="/logout/{email}",method=RequestMethod.GET)
		public ResponseEntity<String> logout(@PathVariable("email") String email){
		 System.out.println(email);
		 
	 String emaill=email+".com";

	 System.out.println(emaill);
	 User tempuser=userDAO.getUserbyemail_id(emaill);
		 tempuser.setIsonline("NO");
		userDAO.updateOnlineStatus(tempuser);
		return new ResponseEntity<String>("Logout success",HttpStatus.OK);		 
}

	 
	 
	 @RequestMapping(value="/up",method = RequestMethod.POST)
	 public ModelAndView  upload(HttpServletRequest request,@RequestParam("uploadedFile") MultipartFile file,HttpSession session )
	 {
	 	  /* String filepath = request.getSession().getServletContext().getRealPath("/") + "resources/product/" + file.getOriginalFilename();
	 		*/
		 
		 User user = (User)session.getAttribute("currentuser");
		 	System.out.println(user.getEmail_id());
		 		user.setImage(user.getEmail_id()+".jpg");
		 	userDAO.updateOnlineStatus(user); 
		 	
		 	
	 	    String filepath ="E:/Collabrational Site/CollabrationFrondEnd/WebContent/Images/" + user.getUser_id()+".jpg";
	 		
	 		
	 		System.out.println(filepath);
	 		try {
	 			byte imagebyte[] = file.getBytes();
	 			BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(filepath));
	 			fos.write(imagebyte);
	 			fos.close();
	 			} catch (IOException e) {
	 			e.printStackTrace();
	 			} catch (Exception e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 			}
	 		
	 	
	 	ModelAndView mv = new ModelAndView("/backhome");
		return mv;
	 }
	 
	 
	 @RequestMapping(value="/upcover",method = RequestMethod.POST)
	 public ModelAndView uploadcover(HttpServletRequest request,@RequestParam("uploadedFile") MultipartFile file,HttpSession session )
	 {
	 	  /* String filepath = request.getSession().getServletContext().getRealPath("/") + "resources/product/" + file.getOriginalFilename();
	 		*/
		 
		 User user = (User)session.getAttribute("currentuser");
		 	
		 		user.setCover(user.getEmail_id()+"cover.jpg");
		 	userDAO.updateOnlineStatus(user);
	 	    String filepath ="E:/Collabrational Site/CollabrationFrondEnd/WebContent/Images/" +user.getEmail_id()+"cover.jpg";
	 		String img=file.getOriginalFilename();
	 		System.out.println(img);
	 		System.out.println(filepath);
	 		try {
	 			byte imagebyte[] = file.getBytes();
	 			BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(filepath));
	 			fos.write(imagebyte);
	 			fos.close();
	 			} catch (IOException e) {
	 			e.printStackTrace();
	 			} catch (Exception e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 			}
	 		
	 	
	 	ModelAndView mv = new ModelAndView("backhome");
		return mv;
	 }

}

}
