var app = angular.module("myApp", ["ngRoute","ngCookies"]);
app.config(function($routeProvider) {
    $routeProvider
    .when("/",{
    	templateUrl :"Views/Home.html",
    		})
    		
    		.when("/home",{
    	templateUrl :"Views/Home.html",
    		})
    		
    .when("/login", {
        templateUrl : "Views/User/Login.html",
    })
    .when("/registration", {
        templateUrl : "Views/User/Registration.html",
    })
    
    .when("/userrequests", {
        templateUrl : "Views/User/UserRequest.html",
       
        
    })
    
    .when("/usersearch", {
	  templateUrl : "Views/User/UserList.html"
  }) 
  
  
  
  .when("/myprofile", {
	  templateUrl : "Views/User/MyProfile.html"
  }) 
    
  
    
    
    .when("/newblog", {
        templateUrl : "Views/Blog/NewBlog.html",
       
       
    })
    .when("/singleblog", {
        templateUrl : "Views/Blog/SingleBlog.html",
       
       
    })
     .when("/notifications", {
        templateUrl : "Views/notifications/Notifications.html",
    
    })
    
    .when("/blogrequests", {
        templateUrl : "Views/Blog/BlogRequest.html",
       
        
    })
    
    .when("/UpdateBlog", {
        templateUrl : "Views/Blog/UpdateBlog.html",
        
    })
    
     .when("/blogview", {
        templateUrl : "Views/Blog/ViewBlog.html",
  
    })
    
    .when("/myblogs",  {
    	templateUrl :"Views/Blog/MyBlog.html"
    })
    
    .when("/blogmanage", {
        templateUrl : "Views/Blog/BlogManage.html",
        
    })
    
    
.when("/newjob", {
        templateUrl : "Views/Job/NewJob.html",
       
       
    })
    
    .when("/jobmanage", {
        templateUrl : "Views/Job/JobManage.html",
       
       
    })
    
     .when("/updatejob", {
        templateUrl : "Views/Job/UpdateJob.html",
       
       
    })
      .when("/viewjob", {
        templateUrl : "Views/Job/ViewJob.html",
       
       
    })
    
    .when("/applyjob", {
        templateUrl : "Views/Job/ApplyJob.html",
       
       
    })
           
        
  .when("/newforum", {
        templateUrl : "Views/Forum/NewForum.html",
       
       
    })
    .when("/updateforum", {
        templateUrl : "Views/Forum/UpdateForum.html",
       
       
    })
    .when("/viewforum", {
        templateUrl : "Views/Forum/ViewForum.html",
       
       
    })
    .when("/forummanage", {
        templateUrl : "Views/Forum/ForumManage.html",
       
       
    })
    .when("/forumrequests", {
        templateUrl : "Views/Forum/ForumRequest.html",
       
       
    })
    
       .when("/forumdiscus", {
        templateUrl : "Views/Forum/ForumDiscussion.html",
       
       
    })
     .when("/myforum", {
        templateUrl : "Views/Forum/MyForum.html",
       
       
    })
    
    
    
    .when("/acceptrequest", {
        templateUrl : "Views/Friend/PentRequest.html",
       
       
    })
    
    .when("/frnds", {
        templateUrl : "Views/Friend/Friends.html",
       
       
    })
    
    
     .when("/chat", {
        templateUrl : "Views/Chat/Chat.html",
       
       
    })
    
   
});


app.run( function ($rootScope, $location, $cookieStore, $http) 
		{
			 $rootScope.$on('$locationChangeStart', function (event, next, current) 
			 {
				 console.log("$locationChangeStart")
				    
				 var userPages = ['/blog','/forum','/chat'];
				 var adminPages = [];
				 
				 var currentPage = $location.path();
				 
				 var isUserPage = $.inArray(currentPage, userPages);
				 var isAdminPage = $.inArray(currentPage, adminPages);
				 
				 var isLoggedIn = $rootScope.currentuser.username;
			        
			     console.log("isLoggedIn:" +isLoggedIn)
			     console.log("isUserPage:" +isUserPage)
			     console.log("isAdminPage:" +isAdminPage)
			        
			        if(!isLoggedIn)
			        	{
			        	
			        		if(isUserPage!=-1 || isAdminPage!=-1)  
			        	 	{
				        	  console.log("Navigating to login page:")
				        	  alert("You need to Login first!")
				              $location.path('/login');
				         	}
			        	}
			        
					 else //logged in
			        	{
			        	
						 var role = $rootScope.currentuser.role;
						 if(isAdminPage!=-1 && role!='ADMIN' )
							 {
							  alert("You cannot view this page as a " + role )
							  $location.path('/');
							 }
			        	}
			 });
			 
			 // to keep the user logged in after page refresh
		    $rootScope.currentuser = $cookieStore.get('currentUser') || {};
		    if ($rootScope.currentuser)
		    {
		        $http.defaults.headers.common['Authorization'] = 'Basic' + $rootScope.currentuser; 
		    }
		    
		    
		    
		    
		 // to keep the blog view in after page refresh
		    $rootScope.gblog = $cookieStore.get('blog') || {};
		    if ($rootScope.gblog)
		    {
		        $http.defaults.headers.common['Authorization'] = 'Basic' + $rootScope.gblog; 
		    }
		    
		    
		    $rootScope.gblogcomm = $cookieStore.get('blogcomm') || {};
		    if ($rootScope.gblogcomm)
		    {
		        $http.defaults.headers.common['Authorization'] = 'Basic' + $rootScope.gblogcomm; 
		    }
		    
		    
		 // to keep the forum view  in after page refresh
		    
		    $rootScope.ForumByid = $cookieStore.get('forum') || {};
		    if ($rootScope.ForumByid)
		    {
		        $http.defaults.headers.common['Authorization'] = 'Basic' + $rootScope.ForumByid; 
		    }
		    
		    $rootScope.fcheck = $cookieStore.get('forumcheck') || {};
		    if ($rootScope.fcheck)
		    {
		        $http.defaults.headers.common['Authorization'] = 'Basic' +$rootScope.fcheck; 
		    }
		    
		    
		    $rootScope.gforumcomm = $cookieStore.get('forumcomm') || {};
		    if ($rootScope.gforumcomm)
		    {
		        $http.defaults.headers.common['Authorization'] = 'Basic' +$rootScope.gforumcomm; 
		    }
		});
