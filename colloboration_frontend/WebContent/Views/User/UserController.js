app.controller("picuploadcontroller", function ($scope,$location,$http,$rootScope,$cookieStore) {

	 $http.post("http://localhost:8080/colloboration_middleware/user/login",$rootScope.currentuser).then(function(response)
			 {
		
		
		 $rootScope.currentuser=response.data;
		 $cookieStore.put('user',response.data);
		
		
			 });
	
	
});



app.controller("registercontroller", function ($scope,$location,$http,$rootScope,$cookieStore) {
	 $scope.msg = "Register  page";
	 $scope.User={username:'',first_name:'',last_name:'',status:'P',gender:'',email_id:'',password:'',place:'',contact:'',role:'ROLE_USER',isonline:'NO'};
	 $scope.register=function()
	 {
		 console.log("in register controller angualar");
		
		 $http.post("http://localhost:8080/colloboration_middleware/user/register",$scope.User).then(function(response){
		 
			 console.log("Registerd Successfully")
			 $scope.User=response.data;
			 $location.path("/login")
								
			},function(error){
				console.error("Error while creating user"+error)
			});
		 
	 }
	 
	 
	 
	 $scope.login=function()
	 {
		 console.log("in login method");
		 $http.post("http://localhost:8080/colloboration_middleware/user/login",$scope.User).then(function(response)
				 {
			 $scope.Userdet=response.data;
			 if($scope.Userdet.status=='P')
			 {
			     alert("You Are not Approved. please Wait for Admin Approval");
			     $location.path("/")
			 }
		 else if($scope.Userdet.status=='R')
			 {
			 alert("Sry..You Are Rejected By Admin...");
		     $location.path("/forumdiscus")
			 }
		 else
			 {
			 $rootScope.currentuser=response.data;
			 //console.log("ROLE"+$rootScope.currentuser.role)
			  $http.defaults.headers.common['Authorization'] = 'Basic' + $rootScope.currentuser;
	          $cookieStore.put('currentUser', $rootScope.currentuser)
	          console.log($cookieStore.get('currentUser'));
			 $location.path("/home")
				 }
		 });
		 
	 }
	 
});



app.controller("logoutcontroller", function ($scope,$location,$http,$rootScope,$cookieStore) {
console.log("in logout controller")
	 $scope.logout=function()
	 {
	 
		 console.log( $rootScope.currentuser.email_id)
			$http.get("http://localhost:8080/colloboration_middleware/user/logout/"+ $rootScope.currentuser.email_id)
				.then(function(response)
				{
					 $rootScope.currentuser=null;
					 $cookieStore.remove('currentUser');
					 $location.path("/login")
					
				},function(error)
				{
					
				});
	 
	 }
	 

});


app.controller("userrequestcontroller", function ($scope,$http,$location,$rootScope,$cookieStore) {
	function fetchAlluserreq()
	{
	
	 $http.get("http://localhost:8080/colloboration_middleware/user/getAllUsersreq")
	    .then(function(response)
	    		{
	    	
	    
		 $scope.userrequests=response.data;
	
		 $location.path('/userrequests')
							
		},function(error){
			console.error("Error while fetching requests");
		});
	}
	
	
	fetchAlluserreq();
	
	
	
	
	
	
	 $scope.acceptuserrequests=function(id)
	 {
		 
		 
		console.log("in user request  accept method")
		 $http.get("http://localhost:8080/colloboration_middleware/user/approveusers/"+id).then(fetchAlluserreq(),function(response){
			 
			 console.log("userrequets accepted  successfully");
			 $location.path('/userrequests')
								
			},function(error){
				console.error("Error while accepting userrequets");
			});
		$location.path('/blog')
		 
	 }
	 
	 
	 
	 $scope.rejectuserrequests=function(id)
	 {
		 
		 
		console.log("in user request  reject method")
		 $http.get("http://localhost:8080/colloboration_middleware/user/rejectusers/"+id).then(fetchAlluserreq(),function(response){
			 
			 console.log("userrequets rejected  successfully");
			 $location.path('/userrequests')
								
			},function(error){
				console.error("Error while rejecting userrequets");
			});
		$location.path('/blog')
		 
	 }

	 
	
	
});
