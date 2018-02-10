var app = angular.module("myApp");
app.controller("SocketCtrl", ["$log", "$http", function ($log, $http) {
    var self = this;
    self.submit = function () {
        // $log.log("Form submit with ", self.user.username,self.user.email);
        // $http.get("/sendMsg").then(function (response) {
        //     self.message = response.data;
        // },function (errResponse) {
        //     $log.log('Error Get User Data!');
        // })
        $http({
            method: "post",
            url: "http://localhost:8080/sendMsg",
            params: {
                ip: this.message.ip,
                port: this.message.port,
                sendMsg: this.message.sendMsg
            },
        }).success(function (response) {
            $log.log("请求成功" + response);
            self.message.recvMsg = response.recvMsg;
        }).error(function (response) {
            $log.log('Error Get User Data!');
        })
    };
    self.reset = function () {
        this.message = {};
    };
}]);