<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>发布日志</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <link href="${rc.contextPath}/res/common/css/mui.min.css" rel="stylesheet"/>
    <link href="${rc.contextPath}/res/common/css/common.css" rel="stylesheet" />
</head>
<body>
<div class="content">
    <div class="publish-log bg-fff border-bbb mar-b10">
        <div class="img-wrap">
            <div class="img-list">
                <img src="${rc.contextPath}/res/images/house_report/1.jpg" alt=""/>
                <span class="close-img">×</span>
            </div>
            <div class="img-list">
                <img src="${rc.contextPath}/res/images/house_report/2.jpg" alt=""/>
                <span class="close-img">×</span>
            </div>
            <div class="img-list">
                <img src="${rc.contextPath}/res/images/house_report/3.jpg" alt=""/>
                <span class="close-img">×</span>
            </div>
            <div class="add-img-wrap">
                <div class="add-img border-bbb"><span></span></div>
            </div>
        </div>
    </div>
    <div class="">
        <textarea name="" id="" cols="30" rows="5" placeholder="记录美好的回忆"></textarea>
    </div>
</div>
<div class="reply-frame md-box dis-none">
    <div class="md-f1"><input class="reply-input" type="text" /></div>
    <div class="btn bg-main send-msg">发送</div>
</div>
<div class="btn bg-main">立即发表</div>
<!--点击图片放大查看 并滑动轮播-->
<div id="big_img">
    <div class="mui-slider">
        <div class="mui-slider-group"></div>
    </div>
</div>
<div class="btn bg-main uploadImage">上传图片</div>
<script src="${rc.contextPath}/res/common/js/mui.min.js"></script>
<script> mui.init();</script>
<script src="${rc.contextPath}/res/common/js/jquery.min-1.8.3.js"></script>
<script src="${rc.contextPath}/res/common/js/common.js"></script>
<script src="${rc.contextPath}/res/common/js/jweixin-1.0.0.js"></script>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script>
    var jsapi_ticket="${jsapi_ticket!''}";
    wx.config({
        debug: false,
        appId: 'wx72154d0c46dda56c',
        timestamp: "${timestamp!''}",
        nonceStr: "${nonceStr!''}",
        signature: "${signature!''}",
        jsApiList: [
            'chooseImage',
            'uploadImage'
        ]
    });
    wx.ready(function () {
        // 5.1 拍照、本地选图
        var images = {
            localId: [],
            serverId: []
        };
        $('.add-img-wrap').on('click', function (){
            var $this = $(this);
            wx.chooseImage({
                success: function (res) {
                    images.localId = res.localIds;
                    alert('已选择 ' + res.localIds.length + ' 张图片');
                    for(var i=0; i<res.localIds.length; i++){
                        var new_img = '<div class="img-list"><img src="'+res.localIds[i]+'" alt=""/><span class="close-img">×</span></div>';
                        $this.before(new_img);
                    }
                    var window_width = $(window).width(); //获取浏览器显示区域的宽度
                    var img_width = (window_width-50)/3-10; //获取图片的宽度
                    var $img_list = $('.img-wrap .img-list');
                    $img_list.css('height',img_width);
                }
            });
        });

        // 5.3 上传图片
        document.querySelector('.uploadImage').onclick = function () {
            if (images.localId.length == 0) {
                alert('请先使用 chooseImage 接口选择图片');
                return;
            }
            var i = 0, length = images.localId.length;
            images.serverId = [];
            function upload() {
                wx.uploadImage({
                    localId: images.localId[i],
                    success: function (res) {
                        i++;
                        alert('已上传：' + i + '/' + length);
                        images.serverId.push(res.serverId);
                        if (i < length) {
                            upload();
                        }
                    },
                    fail: function (res) {
                        alert(JSON.stringify(res));
                    }
                });
            }
            upload();
        };

    });
    wx.error(function (res) {
        alert(res.errMsg);
    });
</script>
</body>
</html>

