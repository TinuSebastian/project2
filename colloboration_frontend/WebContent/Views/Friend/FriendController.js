app.controller("friendrequestcontroller", function ($scope,$http,$location,$rootScope) {

	/*$http.get("http://localhost:8080/CollabrationMiddleWare/friend/getAllMyFriendRequests/"+ $rootScope.currentuser.user_id)
	.then(function(response) {
		$scope.myfriendreqs = response.data;
		console.log("all my friendsreqs  fetched")
	},function(error)
	{
		console.log("Error on retrieving friends")
	});*/
	
	
	function fetchAllfriendreq()
	{
	
	 $http.get("http://localhost:8080/colloboration_middleware/getAllMyFriendRequests/"+$rootScope.currentuser.user_id)
	    .then(function(response)
	    		{
	    	
	    
		 $scope.myfriendreqs=response.data;
	
		console.log("all my friend request fetched")
							
		},function(error){
			console.log("Error on retrieving friends")
		});
	}
	fetchAllfriendreq();
	
	$scope.acceptfriend = function(friendid)
	{
	console.log("in unfriend method")
		$http.get('http://localhost:8080/colloboration_middleware/acceptfriend/'+$rootScope.currentuser.user_id+'/'+friendid)
		.then(fetchAllfriendreq(), function(response) {
			console.log("successful friend add ");
			$location.path("/usersearch")
		});
	}
	
	$scope.rejectfriend = function(friendid)
	{
	console.log("in unfriend method")
		$http.get('http://localhost:8080/colloboration_middleware/rejectfriend/'+$rootScope.currentuser.user_id+'/'+friendid)
		.then(fetchAllfriendreq(), function(response) {
			console.log("successful friend rejected ");
			$location.path("/usersearch")
		});
	}

});




app.controller("friendcontroller", function ($scope,$http,$location,$rootScope) {
	
	
	
	function fetchAlluser()
	{
	
	 $http.get("http://localhost:8080/colloboration_middleware/user/getAllUsers/"+ $rootScope.currentuser.user_id)
	    .then(function(response)
	    		{
	    	
	    
		 $scope.users=response.data;
	
/*		 $location.path('/usersearch')
*/							
		},function(error){
			console.error("Error while fetching user");
		});
	}
	
	
	fetchAlluser();
	
	function fetchAllUsers()
	{
		
		
		$http.get("http://localhost:8080/colloboration_middleware/getMyFriends/"+ $rootScope.currentuser.user_id)

		.then(function(response) {
			$scope.myfriends = response.data;
			console.log("all my friends fetched")
		},function(error)
		{
			console.log("Error on retrieving friends")
		});
		
		
		$http.get("http://localhost:8080/colloboration_middleware/getAllOtherUsers/"+ $rootScope.currentuser.user_id)

		.then(function(response) {
			$scope.otherusers = response.data;
			console.log("all other users fetched")
		},function(error)
		{
			console.log("Error on retrieving friends")
		});
		

		$http.get("http://localhost:8080/colloboration_middleware/getOnlineFriends/"+ $rootScope.currentuser.user_id)

		.then(function(response) {
			$scope.onlineusers = response.data;
			console.log("all online users fetched")
		},function(error)
		{
			console.log("Error on retrieving friends")
		});
		
		
		$http.get("http://localhost:8080/colloboration_middleware/getAllMyFriendRequests/"+ $rootScope.currentuser.user_id)

		.then(function(response) {
			$scope.myfriendreqs = response.data;
			console.log("all my friendsreqs  fetched")
		},function(error)
		{
			console.log("Error on retrieving friends")
		});
		
		
		
		
	}
	;
	fetchAllUsers();
	
	$scope.insertFriend = function(friendid)
	{
		console.log('entered add friend method'+friendid);
		$http.get('http://localhost:8080/colloboration_middleware/addFriend/'+$rootScope.currentuser.user_id+'/'+friendid)
		.then(fetchAllUsers(), function(response) {
			console.log("successful friend add ");
			$location.path("/usersearch")
		});
	}
	
	
	

	$scope.unfriend = function(friendid)
	{
	console.log("in unfriend method")
		$http.get('http://localhost:8080/colloboration_middleware/unfriend/'+$rootScope.currentuser.user_id+'/'+friendid)
		.then(fetchAllUsers(), function(response) {
			console.log("successful friend add ");
			$location.path("/usersearch")
		});
	}
	
	
	
	$rootScope.friendpreview=function(friendid)
	{
		if(friendid==$rootScope.currentuser.user_id)
			{
			$location.path("/usersearch")
			}
		else
			{
		$http.get("http://localhost:8080/colloboration_middleware/user/getUser/"+friendid)

		.then(function(response) {
			$rootScope.friendpreviewdata = response.data;
			$scope.fr=response.data;
			console.log($rootScope.friendpreviewdata.email);
			console.log($rootScope.friendpreviewdata.user_id);
			console.log($rootScope.currentuser.user_id);
		},function(error)
		{
			console.log("Error on retrieving friends")
		});

	$http.get("http://localhost:8080/colloboration_middleware/user/ismyfriend/"+$rootScope.friendpreviewdata.user_id+"/"+$rootScope.currentuser.user_id)

		.then(function(response) {
			$rootScope.ismyfriend = response.data;
		
		},function(error)
		{
			
		});
		
		
		$http.get("http://localhost:8080/colloboration_middleware/user/friendsfriends/"+$rootScope.friendpreviewdata.user_id+"/"+$rootScope.currentuser.user_id)

		.then(function(response) {
			$rootScope.friendsfriends = response.data;
		
		},function(error)
		{
			
		});
		
		
		
		
		$http.get("http://localhost:8080/colloboration_middleware/blogs/getAllMyBlogs/"+$rootScope.friendpreviewdata.user_id)
		.then(function(response)
		{
			
			$rootScope.friendblogs=response.data;
			
						
		},function(error)
		{
			console.log("Error on retrieving blogs")
		});	
		
		$http.get("http://localhost:8080/colloboration_middleware/forums/myforums/"+$rootScope.friendpreviewdata.user_id)
		.then(function(response)
		{
			
			$rootScope.friendforums=response.data;
			
						
		},function(error)
		{
			console.log("Error on retrieving blogs")
		});	
		$location.path("/usersearch")
		
	}
	}
	
	
});

/*app.controller("userlistcontroller", function ($scope,$http,$location,$rootScope,$cookieStore) {
	function fetchAlluser()
	{
	
	 $http.get("http://localhost:8080/colloboration_middleware/user/getAllUsers")
	    .then(function(response)
	    		{
	    	
	    
		 $scope.users=response.data;
	
		 $location.path('/usersearch')
							
		},function(error){
			console.error("Error while fetching user");
		});
	}
	
	
	fetchAlluser();
});
*/