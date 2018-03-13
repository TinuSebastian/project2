app.controller("forumcontroller", function ($scope,$http,$location,$rootScope,$cookieStore) {
	console.log("in forum controller")
	$scope.Forum={forumname:'',forumcontent:''};
	$scope.ForumComments={forumcomm:'',forumid:'',user_id:'',username:''};
	$scope.ForumRequests={ user_id:'',forumid:'',forumname:'',username:'',status:'P'}
	function fetchAllForums()
	{
		console.log("in fetch all forums method")
	$http.get("http://localhost:8080/colloboration_middleware/forums/getAllForums")
		.then(function(response)
		{
			console.log("Forums retrieve successfully")
			$scope.forums=response.data;
	console.log($scope.forums)
						
		},function(error)
		{
			console.log("Error on retrieving forums")
		});
	};
	
	
	fetchAllForums();
	
	
	
	function myallforums()
	{
		
	
		$http.get("http://localhost:8080/colloboration_middleware/forums/myforums/"+$rootScope.currentuser.user_id)
		.then(function(response)
		{
			
			$rootScope.myforum=response.data;
			
						
		},function(error)
		{
			console.log("Error on retrieving blogs")
		});	
		
		
	}
	myallforums();
	
	
	
	
	
	
	/*function fetchForumByIdd(idd)
	{
		
		 $http.get("http://localhost:8080/CollabrationMiddleWare/forums/getForumById/"+idd).then(function(response){
				
				$rootScope.ForumByid=response.data; 
				
				},function(error){
					console.log("Error on retrieving forum")
				});
		
		
	$http.get("http://localhost:8080/CollabrationMiddleWare/forums/checkIfMyForum/"+idd+"/"+$rootScope.currentuser.user_id).then(function(response){
		$rootScope.fcheck=response.data;
		
		
			
		
			});
	$location.path('/forumdiscus');
		
		
		
	}*/
	
	
	 $scope.addForum=function()
	 {
		console.log("in add forum method")
		console.log($scope.Forum)
		 $http.post("http://localhost:8080/colloboration_middleware/forums/addForum",$scope.Forum).then(fetchAllForums(),function(response){
			
			 console.log("Forum added successfully")
			 
								
			},function(error){
				console.error("Error while adding adding forum")
			});
		$location.path('/forummanage')
		 
	 }
	 
$rootScope.fetchforumbyid=function(idd)
{
console.log('in fetch forum by id  method'+idd)
	 $http.get("http://localhost:8080/colloboration_middleware/forums/getForumById/"+idd).then(function(response){
		

			$rootScope.ForumByid=response.data; 
			$cookieStore.put('forum',$rootScope.ForumByid);
			},function(error){
				console.log("Error on retrieving forum")
			});

	

$http.get("http://localhost:8080/colloboration_middleware/forums/checkIfMyForum/"+idd+"/"+$rootScope.currentuser.user_id).then(function(response){
	$rootScope.fcheck=response.data;
	$cookieStore.put('forumcheck',$rootScope.fcheck);
	
		


	

		});



$http.get("http://localhost:8080/colloboration_middleware/forums/getAllForumComments/"+idd)
.then(function(response)
{
	
	$rootScope.gforumcomm=response.data;
	$cookieStore.put('forumcomm',$rootScope.gforumcomm);
	
},function(error)
{
	
});		


$http.get("http://localhost:8080/colloboration_middleware/forums/forumreqbyforumid/"+idd)
.then(function(response)
{
	
	$rootScope.forusers=response.data;
	$location.path('/forumdiscus');

	
},function(error)
{
	
});





//$location.path('/forumdiscus');
}

$scope.fetchforumforedit=function(idd)
{
	console.log("in forum fetch for edit  method")
	 $http.get("http://localhost:8080/colloboration_middleware/forums/getForumById/"+idd).then(function(response){
		 

			$rootScope.eforum=response.data; 
		
			},function(error){
				console.log("Error on retrieving forum")
			});
	
	$location.path('/updateforum')

}

	 $scope.editForum=function(idd)
	 {
		console.log("in edit blog method")
		if($scope.Forum.forumname==null)
			{
			$scope.Forum.forumname=$rootScope.eforum.forumname;
			}
		if($scope.Forum.forumcontent==null)
			{
			$scope.Forum.forumcontent=$rootScope.eforum.forumcontent;
			}
		 $http.post("http://localhost:8080/colloboration_middleware/forums/updateForum/"+idd+"/"+$scope.Forum.forumname+"/"+$scope.Forum.forumcontent).then(fetchAllForums(),function(response){
			 console.log("Forum updated successfully");
								
			},function(error){
				console.error("Error while updating Forum");
			});
		
		
		
		 $http.get("http://localhost:8080/colloboration_middleware/forums/getForumById/"+$rootScope.eforum.forumid).then(function(response){
				$rootScope.eforum=response.data; 
					
				},function(error){
				
				});
		 
		 $location.path('/forummanage')
		 
		 
		 
	 }
	
	
	 $scope.deleteForum=function(idd)
	 {
		console.log("in delete forum method")
		 $http.get("http://localhost:8080/colloboration_middleware/forums/deleteForum/"+idd).then(fetchAllForums(),function(response){
			 console.log("Forum deleted successfully");
			 location.path('/forummanage')
								
			},function(error){
				console.error("Error while deleting Forum");
			});
		
		 $location.path('/forummanage')
	 }
	

	
	
	$scope.myforums=function()
	{
		
 $http.get("http://localhost:8080/colloboration_middleware/forums/myforums/"+$rootScope.currentuser.user_id).then(function(response){
			 
			$scope.myforums=response.data;
								
			},function(error){
				console.error("Error while accepting forumrequets Forum");
			});	
		
		
	}
	
	
	
	 $rootScope.sendforumrequests=function(id)
	 {
		console.log('in send froum request')
		/*console.log($rootScope.ForumByid.forumid+$rootScope.currentuser.user_id)*/
		 $http.get("http://localhost:8080/colloboration_middleware/forums/addForumReq/"+id+"/"+$rootScope.currentuser.user_id).then(function(response){
			 console.log("Forumrequested successfully");
		 });
		
		 $location.path('/forumview')
	 }
	 
	 
	 $rootScope.leaveforum=function()
	 {
		
		
		 $http.get("http://localhost:8080/colloboration_middleware//forums/leaveforum/"+$rootScope.ForumByid.forumid+"/"+$rootScope.currentuser.user_id).then(fetchForumByIdd($rootScope.ForumByid.forumid),function(response){
			 
		 });
		
		 $location.path('/forumview')
	 }
	 
	 
	 
	 
	 $scope.addForumComment=function()
	 {
		console.log("in add forumComment method")
		console.log($rootScope.ForumByid.forumid+$rootScope.currentuser.username+$scope.ForumComments.forumcomm)

		$http.get("http://localhost:8080/colloboration_middleware/forums/addForumComments/"+$rootScope.ForumByid.forumid+"/"+$rootScope.currentuser.username+"/"+$scope.ForumComments.forumcomm).then(function(response){
			 console.log("ForumComments added successfully")
								
			},function(error){
				
			});
		
		$http.get("http://localhost:8080/colloboration_middleware/forums/getAllForumComments/"+$rootScope.ForumByid.forumid)
		.then(function(response)
		{
			
			$rootScope.gforumcomm=response.data;
			
			
		},function(error)
		{
			
		});		
		
		$location.path('/forumdiscus')	 
		 
	 }
	 
	 
	 
	 
	 
	 
	 
	
	
	
	
	
});


app.controller("forumrequestcontroller", function ($scope,$http,$location,$rootScope) {
	function fetchAllForumreq()
	{
	
	 $http.get("http://localhost:8080/colloboration_middleware/forums/getForumRequests")
	    .then(function(response)
	    		{
	    	
	    
		 $scope.forumrequests=response.data;
	
		 $location.path('/forumrequests')
							
		},function(error){
			console.error("Error while deleting Forum");
		});
	}
	
	
	fetchAllForumreq();
	
	
	
	
	
	
	 $rootScope.acceptforumrequests=function(id)
	 {
		 
		 
		console.log("in forum request  accept method")
		 $http.get("http://localhost:8080/colloboration_middleware/forums/approveForumRequests/"+id).then(fetchAllForumreq(),function(response){
			 
			 console.log("Forumrequests accepted  successfully");
			 $location.path('/forumrequests')
								
			},function(error){
				console.error("Error while accepting forumrequets Forum");
			});
		$location.path('/forummanage')
		 
	 }
	 $rootScope.rejectforumrequests=function(id)
	 {
		 
		 
		console.log("in forum reject method")
		 $http.get("http://localhost:8080/colloboration_middleware/forums/rejectForumRequests/"+id).then(fetchAllForumreq(),function(response){
			 
			 console.log("Forumrequests rejected  successfully");
			 $location.path('/forumrequests')
								
			},function(error){
				console.error("Error while rejecting forumrequets Forum");
			});
		$location.path('/forummanage')
		 
	 }

	 
	
	
});
