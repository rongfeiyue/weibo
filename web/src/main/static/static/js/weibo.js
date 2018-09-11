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
                this.$http.get('/weibo/getList', {page: page, rows:10}).then(function (res) {
                    var data = res.data;
                    console.log(data)
                })
            }
        },
        created: function () {
            this.getList(1);
        }
    });
});