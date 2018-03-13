app.controller("blogcontroller", function ($scope,$http,$location,$rootScope,$cookieStore,$route) {
	 console.log("blog controller",$rootScope.currentuser.email_id)
	 $scope.Blog={blogname:'',blogcontent:'',status:'P',likes:'0',dislikes:'0',views:'0',username:$rootScope.currentuser.email_id,user_id:$rootScope.currentuser.user_id};
	$scope.BlogComment={blogcomm:'',blogid:'',user_id:'',username:''};

	function fetchAllBlogs()
	{
	$http.get("http://localhost:8080/colloboration_middleware/blogs/getAllBlogs")
		.then(function(response)
		{
			console.log("Blogs retrieve successfully")
			$scope.blogs=response.data;
			console.log($scope.blogs)
						
		},function(error)
		{
			console.log("Error on retrieving blogs")
		});
	};
	fetchAllBlogs();
	
	function myallblogs()
	{
		console.log("in all my blogs method")
		console.log($rootScope.currentuser.email_id)
		$http.get("http://localhost:8080/colloboration_middleware/blogs/getAllMyBlogs/"+$rootScope.currentuser.user_id)
		.then(function(response)
		{
			
			$rootScope.myblogs=response.data;
			
						
		},function(error)
		{
			console.log("Error on retrieving blogs")
		});	
		
		
	}
	myallblogs();
	
	function fetchBlogById(idd)
	{
		
		 $http.get("http://localhost:8080/colloboration_middleware/blogs/getBlogById/"+idd).then(function(response){
				
				$rootScope.gblog=response.data;
				 
				
				console.log("blog fetched successfully")				
				},function(error){
					console.log("error in fetching blog")
				});
		 $location.path('/singleblog')
		
	}
	
	
	
	
	 $rootScope.maximum=getSelectedBlog
	 function getSelectedBlog(idd)
	 {
		 console.log("in add max method------"+idd)
		 
		 
		 
		 
		 console.log("view incremented")

		 $http.get("http://localhost:8080/colloboration_middleware/blogs/getBlogById/"+idd).then(function(response){
				$rootScope.blogbyid=response.data;
				$rootScope.gblog=response.data;
				$cookieStore.put('blog',$rootScope.gblog);
				 
				
				console.log("blog fetched successfully")				
				},function(error){
					console.log("error in fetching blog")
				});
	
		
		 $http.get("http://localhost:8080/colloboration_middleware/blogs/getAllBlogComments/"+idd)
			.then(function(response)
			{
				
				$rootScope.gblogcomm=response.data;
				console.log($rootScope.gblogcomm)
				$cookieStore.put('blogcomm',$rootScope.gblogcomm);
			},function(error)
			{
				
			});
		 
		 $http.get("http://localhost:8080/colloboration_middleware/blogs/incview/"+idd).then(function(response){
				
			},function(error){
			
			});
		
		 
		
		 $location.path('/singleblog')
		 
	 }
	 
	
	 
	 
	 

	 $scope.addBlog=function()
	 {
		console.log("in add blog method"+$scope.Blog.blogname)
	console.log("current user data :",$rootScope.currentuser)
		 $http.post("http://localhost:8080/colloboration_middleware/blogs/addBlog",$scope.Blog).then(fetchAllBlogs(),function(response){
			 console.log("Blog added successfully")
			 
				alert("Your Blog is waiting for Admin's Approval")				
			},function(error){
				console.error("Error while creating blog")
			});
		
		
		$location.path('/blogview')
		 
	 }

	 
	 
	 $scope.fetchforedit=function(idd)
	 {
		 
		 $http.get("http://localhost:8080/colloboration_middleware/blogs/getBlogById/"+idd).then(function(response){
				$rootScope.eblog=response.data; 
					
				},function(error){
				
				});
		 $location.path('/UpdateBlog')	 
	 }
	 
	 
	 
	 

	 $scope.editBlog=function()
	 {
		
	console.log("blog nammme : ",$scope.Blog.blogname+"-?Blog Contents "+$scope.Blog.blogcontent)
	console.log("rootscop blog",$rootScope.eblog)
	if($scope.Blog.blogname=='')
		{
		  alert("Blog Name is empty..");
		  $scope.Blog.blogname=$rootScope.eblog.blogname;
		}
	if($scope.Blog.blogcontent=='')
	{
	  alert("Blog blogcontent is empty..");
	  $scope.Blog.blogcontent=$scope.eblog.blogcontent;
	}
	console.log("scope blog",$scope.Blog)
		 $http.get("http://localhost:8080/colloboration_middleware/blogs/updateBlog/"+$rootScope.eblog.blogid+"/"+$scope.Blog.blogname+"/"+$scope.Blog.blogcontent).then(function(response){
			 console.log("Blog updated successfully");
								
			},function(error){
				console.error("Error while updating blog");
			});
		 
		 
		 $http.get("http://localhost:8080/colloboration_middleware/blogs/getBlogById/"+$rootScope.eblog.blogid).then(function(response){
			 $route.reload();
				$rootScope.eblog=response.data; 
					
				},function(error){
				
				});
		
		$location.path('/myblogs')	 
		 
	 }
	 
	 $scope.deleteBlog=function(idd)
	 {
		console.log("in delete blog method")
		 $http.get("http://localhost:8080/colloboration_middleware/blogs/deleteBlog/"+idd).then(fetchAllBlogs(),function(response){
			 console.log("Blog deleted successfully");
								
			},function(error){
				console.error("Error while deleting blog");
			});
		
		
		
		$location.path('/blogview')	 
		 
	 }
	 
	 
	
	 
	 $scope.rejetcBlog=function(idd)
	 {
		console.log("in reject blog method")
		 $http.get("http://localhost:8080/colloboration_middleware/blogs/rejectBlog/"+idd).then(fetchBlog(idd),fetchAllBlogs(),function(response){
			 console.log("Blog rejected successfully");
								
			},function(error){
				console.error("Error while rejecting blog");
			});
		$location.path('/blogview')	 
		 
	 }
	 
	 $scope.likeBlog=function(idd)
	 {
		console.log("in like blog method")
		 $http.get("http://localhost:8080/colloboration_middleware//blogs/likeBlog/"+idd).then(function(response){
			 console.log("Blog liked successfully");
								
			},function(error){
				console.error("Error while liking blog");
			});
		
		
		$http.get("http://localhost:8080/colloboration_middleware/blogs/getBlogById/"+idd).then(function(response){
			
			$rootScope.gblog=response.data;
			 
			
			console.log("blog fetched successfully")				
			},function(error){
				console.log("error in fetching blog")
			});
		
		
		
		$location.path('/singleblog')	 
		 
	 }
	 
	 
	 $scope.dislikeBlog=function(idd)
	 {
		console.log("in like blog method")
		 $http.get("http://localhost:8080/colloboration_middleware/blogs/dislikeBlog/"+idd).then(fetchBlogById(idd),function(response){
			 console.log("Blog disliked successfully");
								
			},function(error){
				console.error("Error while disliking blog");
			});
		
		$location.path('/singleblog')	 
		 
	 }

	 
	 
	 $scope.addBlogComment=function()
	 {
		console.log("in add blogComment method")
		console.log($rootScope.gblog.blogid+$rootScope.currentuser.email_id+$scope.BlogComment.blogcomm)

		$http.get("http://localhost:8080/colloboration_middleware/blogs/addBlogComments/"+$rootScope.gblog.blogid+"/"+$rootScope.currentuser.user_id+"/"+$scope.BlogComment.blogcomm+"/"+$rootScope.currentuser.email_id).then(function(response){
			 console.log("BlogComments added successfully")
								
			},function(error){
				
			});
		
		$http.get("http://localhost:8080/colloboration_middleware/blogs/getAllBlogComments/"+$rootScope.gblog.blogid)
		.then(function(response)
		{
			
			$rootScope.gblogcomm=response.data;
			
			
		},function(error)
		{
			
		});		
		
		$location.path('/singleblog')	 
		 
	 }
	 
	 
	 $scope.updateBlogComment=function(idd)
	 {
		console.log("in update blogComment method")
		 $http.post("http://localhost:8080/colloboration_middleware/blogs/updateBlogComments/"+idd,$scope.BlogComments).then(function(response){
			 console.log("BlogComments updated successfully")
								
			},function(error){
				console.error("Error while updating blogComments")
			});
		$location.path('/blogview')	 
		 
	 }
	 
	 
	 $scope.deleteBlogComment=function(idd)
	 {
		console.log("in delete blogcomment method")
		 $http.get("http://localhost:8080/colloboration_middleware/blogs/deleteBlogComment/"+idd).then(function(response){
			 console.log("Blogcomments deleted successfully");
								
			},function(error){
				console.error("Error while deleting blogcomments");
			});
		
		$location.path('/blogview')	 
		 
	 }
	 
	 
	 
});



app.controller("blogrequestcontroller", function ($scope,$http,$location,$rootScope) {
	function fetchAllblogreq()
	{
	
	 $http.get("http://localhost:8080/colloboration_middleware/blogs/blogrequests")
	    .then(function(response)
	    		{
	    	
	    
		 $scope.blogequests=response.data;
	
		 $location.path('/blogrequests')
							
		},function(error){
			
		});
	}
	fetchAllblogreq();
	
	 $rootScope.acceptblogrequests=function(id)
	 {
		 
		 console.log('in acceptblog request method')
		
		 $http.get("http://localhost:8080/colloboration_middleware/blogs/approveblogRequests/"+id).then(fetchAllblogreq(),function(response){
			 
		console.log("accepted successfully")
			 $location.path('/blogrequests')
								
			},function(error){
				console.error("Error while accepting blogrequests Forum");
			});
		 
		 $location.path('/blogmanage')
		 
	 }
	 
	 
	 $rootScope.rejectblogrequests=function(id)
	 {
		 
		 console.log('in acceptblog request method')
		
		 $http.get("http://localhost:8080/colloboration_middleware/blogs/rejectblogRequests/"+id).then(fetchAllblogreq(),function(response){
			 
		console.log("rejected successfully")
			 $location.path('/blogrequests')
								
			},function(error){
				console.error("Error while rejecting blogrequests Forum");
			});
		 
		 $location.path('/blogmanage')
		 
	 }
	
	
});
