var app = angular.module('myApp', ["ngRoute"]);
app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "pages/home.html"
    })
    .when("/login", {
        templateUrl : "User/login.html"
    })
    .when("/signup", {
        templateUrl : "User/register.html"
    })
    .when("/Blog", {
        templateUrl : "blog/blog.html"
    })
    .when("/job", {
        templateUrl : "jobs/jobcard.html"
    })
    .when("/myprofile", {
        templateUrl : "User/myprofile.html"
    })
    .when("/blog form", {
        templateUrl : "blog/blog form.html"
    })
     .when("/blog list", {
        templateUrl : "blog/blog list.html"
    })
    .when("/blog manage", {
        templateUrl : "blog/blog manage.html"
    })
     .when("/blog request", {
        templateUrl : "blog/blog request.html"
    })
    
    .when("/my blog", {
        templateUrl : "blog/my blog.html"
    })

  .when("/update blogs", {
        templateUrl : "blog/update blogs.html"
    })
    .when("/view blog", {
        templateUrl : "blog/view blog.html"
    })
    .when("/apply job", {
        templateUrl : "blog/apply job.html"
    })
    .when("/job manage", {
        templateUrl : "blog/job manage.html"
    })
    
});





