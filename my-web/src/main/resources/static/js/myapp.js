angular.module("myApp", [])
// .controller("MainCtrl", ["$log", "$http", function ($log, $http) {
//     var self = this;
//     self.submit = function () {
//         // $log.log("Form submit with ", self.user.username,self.user.email);
//         $http.get("/user").then(function (response) {
//             self.user = response.data;
//         },function (errResponse) {
//             $log.log('Error Get User Data!');
//         })
//     };
//     self.reset = function () {
//         this.user = {};
//     };
// }])
// .controller("ListCtrl",["$log","$http",function ($log,$http) {
//     var self =this;
//     self.search=function () {
//         $http.get("/users").then(function (response) {
//             self.users = response.data;
//         },function (errResponse) {
//             $log.log('Error Get User Data!');
//         })
//     }
// }])
;