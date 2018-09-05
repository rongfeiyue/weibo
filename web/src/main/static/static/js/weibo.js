$(function () {
    new Vue({
        el: '.znsArea',
        data: {
            t1: '',
            msgData: []
        },
        methods: {
            add: function () {
                
            },
            top: function () {
                
            },
            down: function () {
                
            },
            del: function () {
                
            },
            getList: function (page) {
                var data = Vue.$http('weibo/getList', {page: page});
                eval(data).forEach(function (value) {
                    alert(value)
                })
            }
        },
        created: function () {
            this.getList(1);
        }
    });
    Vue.prototype.$http_get=function (url, params) {
        $http.get(url, params).then(function (res) { 
            return res.data;
        })
    }
});