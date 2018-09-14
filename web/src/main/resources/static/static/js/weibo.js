$(function () {
    Vue.filter('date_format', function (input) {
        var oDate = new Date(input);
        return oDate.getFullYear() + '-' + suppleZero((oDate.getMonth() + 1)) + '-' + suppleZero(oDate.getDate()) + ' ' + suppleZero(oDate.getHours()) + ':' + suppleZero(oDate.getMinutes()) + ':' + suppleZero(oDate.getSeconds());
    });
    function suppleZero(input) {
        return input<10?'0'+input:input;
    }
    // var url_prefix = 'http://localhost:8088/weibo';
    var url_prefix = '/weibo';
    new Vue({
        el: '.znsArea',
        data: {
            content: '',
            msgData: [],
            nowPage: 1,
            rows: 10,
            total: 0,
            pageData: []
        },
        watch: {
            total: function () {
                let tmpData = [];
                for (let i = 1; i <= Math.ceil(this.total / this.rows); i++) {
                    tmpData.push(i);
                }
                this.pageData = tmpData;
            },
            nowPage: function () {
                this.getList();
            }
        },
        methods: {
            add: function () {
                if ('' == this.content) return false;
                this.$http.post(url_prefix + '/add', {content: this.content}, {
                    emulateJSON: true
                }).then(function (res) {
                    if (res.data.code = 200) {
                        this.content = '';
                        this.getList();
                    } else {
                        alert(res.data.message);
                    }
                })
            },
            top: function (index) {
                let data = this.msgData[index];
                this.$http.post(url_prefix + '/operate/top/' + data.id).then(function (res) {
                    if (res.data.code = 200) {
                        this.msgData[index].acc++;
                    } else {
                        alert(res.data.message);
                    }
                })
            },
            down: function (index) {
                let data = this.msgData[index];
                this.$http.post(url_prefix + '/operate/down/' + data.id).then(function (res) {
                    if (res.data.code = 200) {
                        this.msgData[index].ref++;
                    } else {
                        alert(res.data.message);
                    }
                })
            },
            del: function (index) {
                let data = this.msgData[index];
                this.$http.options.emulateJSON = true;
                this.$http.post(url_prefix + '/operate/delete/' + data.id).then(function (res) {
                    if (res.ok && res.data.code === 200) {
                        this.getList();
                    } else {
                        alert(res.data.message);
                    }
                })
            },
            getList: function () {
                this.$http.get(url_prefix + '/getList', {
                    page: this.nowPage,
                    rows: this.rows
                }).then(function (res) {
                    if (200 == res.data.code) {
                        this.msgData = eval(res.data.data);
                        this.total = res.data.total;
                    } else {
                        alert(res.data.message);
                    }
                })
            }
        },
        created: function () {
            this.getList();
        }
    });
});