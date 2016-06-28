<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>验房报告</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <link href="${rc.contextPath}/res/common/css/mui.min.css" rel="stylesheet"/>
    <link href="${rc.contextPath}/res/common/css/common.css" rel="stylesheet"/>
    <link href="${rc.contextPath}/res/css/house_report.css" rel="stylesheet"/>
</head>
<body>
<div class="content">
    <div class="text-c">
        <div class="report_score dis-in-block">98</div>
    </div><br/>
    <p class="mar-b10 color-main">您的新房取得98份的好成绩，打败了98%的房屋。</p>
    <ul class="mui-table-view">
        <li class="mui-table-view-cell mui-collapse mui-active">
            <a class="mui-navigate-right" href="#">地面</a>
            <div class="mui-collapse-content">
                <div class="md-box pad-lr5">
                    <p class="md-f1">检查地面裂痕、起沙、脱皮、麻面的程度是否合理</p>
                    <p><a href=""><img class="float-r" src="${rc.contextPath}/res/images/house_report/help.png" alt=""/></a></p>
                </div>
                <div class="star-level pad-lr5">
                    <span class="star-gold"></span>
                    <span class="star-gold grey"></span>
                    <span class="star-gold grey"></span>
                    <span class="star-gold grey"></span>
                    <p class="s-l-comment color-g">问题严重，必须整改</p>
                </div>
                <div class="img-wrap">
                    <div class="img-list"><img src="${rc.contextPath}/res/images/house_report/1.jpg" alt=""/><span class="close-img">×</span></div>
                    <div class="add-img-wrap"><div class="add-img border-bbb"><img src="" alt=""/><span></span></div></div>
                </div>
            </div>
        </li>
        <li class="mui-table-view-cell mui-collapse">
            <a class="mui-navigate-right" href="#">电气</a>
            <div class="mui-collapse-content">
                <div class="md-box pad-lr5">
                    <p class="md-f1">检查地面裂痕、起沙、脱皮、麻面的程度是否合理</p>
                    <p><a href=""><img class="float-r" src="${rc.contextPath}/res/images/house_report/help.png" alt=""/></a></p>
                </div>
                <div class="star-level pad-lr5">
                    <span class="star-gold"></span>
                    <span class="star-gold"></span>
                    <span class="star-gold"></span>
                    <span class="star-gold grey"></span>
                    <p class="s-l-comment color-g">细微问题、可不处理</p>
                </div>
                <div class="img-wrap">
                    <div class="img-list"><img src="${rc.contextPath}/res/images/house_report/3.jpg" alt=""/><span class="close-img">×</span></div>
                    <div class="add-img-wrap"><div class="add-img border-bbb"><span></span></div></div>
                </div>
            </div>
        </li>
        <li class="mui-table-view-cell mui-collapse">
            <a class="mui-navigate-right" href="#">防盗门</a>
            <div class="mui-collapse-content">
                <div class="md-box pad-lr5">
                    <p class="md-f1">检查地面裂痕、起沙、脱皮、麻面的程度是否合理</p>
                    <p><a href=""><img class="float-r" src="${rc.contextPath}/res/images/house_report/help.png" alt=""/></a></p>
                </div>
                <div class="star-level pad-lr5">
                    <span class="star-gold"></span>
                    <span class="star-gold"></span>
                    <span class="star-gold"></span>
                    <span class="star-gold"></span>
                    <p class="s-l-comment color-main">检测合格</p>
                </div>
                <div class="img-wrap">
                    <div class="img-list"><img src="${rc.contextPath}/res/images/house_report/1.jpg" alt=""/><span class="close-img">×</span></div>
                    <div class="add-img-wrap"><div class="add-img border-bbb"><span></span></div></div>
                </div>
            </div>
        </li>
    </ul>
    <div class="bg-fff border-bbb pad-12">
        <div>整改方案和费用</div>
        <p>请联系物业和开发商，尽快安排施工人员维修地面空谷。</p>
        <div class="text-r">100元</div>
    </div>
    <div id="test_img"></div>
    <br/>
</div>
<p class="text-c pad-lr5">分享验房报告到朋友圈，即可获得888元的装修基金</p>
<div class="btn bg-main share-btn mar-t1">一键分享</div>
<!--点击图片放大查看 并滑动轮播-->
<div id="big_img">
    <div class="mui-slider">
        <div class="mui-slider-group"></div>
    </div>
</div>
<!--点击一键分享弹出的蒙板-->
<div class="pop-div">
    <img src="${rc.contextPath}/res/images/house_report/share_pointer.png" alt=""/>
    <div class="i-know-btn">我知道了</div>
</div>
<div class="btn bg-main previewImage">图片预览</div>
<div class="btn bg-main uploadImage">上传图片</div>
<div class="btn bg-main downloadImage">下载图片</div>
<script src="${rc.contextPath}/res/common/js/mui.min.js"></script>
<script> mui.init();</script>
<script src="${rc.contextPath}/res/common/js/jquery.min-1.8.3.js"></script>
<script src="${rc.contextPath}/res/common/js/common.js"></script>
<script src="${rc.contextPath}/res/common/js/jweixin-1.0.0.js"></script>
<script>
    (function (){
        var ua = navigator.userAgent.toLowerCase();
        if(ua.match(/MicroMessenger/i)=='micromessenger') {//判断是否是微信内置浏览器打开
            $('.share-btn').on('click', function(){
                $(".pop-div").css({"width":'100%', "height":$(document).height(), "top":"0", "left":"0"}).show("fast");
                $("body").css("overflow-y","hidden");
                $(document).on("click", ".i-know-btn", function(){
                    $(".pop-div").hide("fast");
                    $("body").css("overflow-y","scroll");
                });
            });
        } else {
            $('.share-btn').on('click', function(){
                alert('请在微信端打开！');
            })
        }
    }());
    /*
     * 注意：
     * 1. 所有的JS接口只能在公众号绑定的域名下调用，公众号开发者需要先登录微信公众平台进入“公众号设置”的“功能设置”里填写“JS接口安全域名”。
     * 2. 如果发现在 Android 不能分享自定义内容，请到官网下载最新的包覆盖安装，Android 自定义分享接口需升级至 6.0.2.58 版本及以上。
     * 3. 完整 JS-SDK 文档地址：http://mp.weixin.qq.com/wiki/7/aaa137b55fb2e0456bf8dd9148dd613f.html
     *
     * 如有问题请通过以下渠道反馈：
     * 邮箱地址：weixin-open@qq.com
     * 邮件主题：【微信JS-SDK反馈】具体问题
     * 邮件内容说明：用简明的语言描述问题所在，并交代清楚遇到该问题的场景，可附上截屏图片，微信团队会尽快处理你的反馈。
     */
    var jsapi_ticket="${jsapi_ticket!''}";
    wx.config({
        debug: false,
        appId: 'wx72154d0c46dda56c',
        timestamp: "${timestamp!''}",
        nonceStr: "${nonceStr!''}",
        signature: "${signature!''}",
        jsApiList: [
            'chooseImage',
            'previewImage',
            'uploadImage',
            'downloadImage',
            'chooseWXPay'
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
                    alert('已选择 ' + res.localIds.length + ' 张图片');
                    for(var i=0,localId_len=res.localIds.length; i<localId_len; i++){
                        images.localId.push(res.localIds[i]);
                        var new_img = '<div class="img-list"><img src="'+res.localIds[i]+'" alt=""/><span class="close-img">×</span></div>';
                        $this.before(new_img);
                    }
                    var window_width = $(window).width(); //获取浏览器显示区域的宽度
                    var img_width = (window_width-50)/3-10; //获取图片的宽度
                    var $img_list = $('.img-wrap .img-list');
                    $img_list.css('height',img_width);
                    //alert(images.localId.length)
                }
            });
        });
        // 5.2 图片预览
        document.querySelector('.previewImage').onclick = function () {
            wx.previewImage({
                current: 'http://img5.douban.com/view/photo/photo/public/p1353993776.jpg',
                urls: images.localId
            });
        };
        // 5.3 上传图片
        document.querySelector('.uploadImage').onclick = function () {
            var $img = $('.img-wrap .img-list img');
            var img_src = [];
            if ($img.length == 0) {
                alert('请先选择图片');
                return;
            }
            for(var k= 0,img_len=$img.length; k<img_len; k++){
                img_src.push($img.eq(k).attr('src'));
            }
            alert(img_src.length);
            syncUpload(img_src);
        };
        var syncUpload = function(localIds){
            var localId = localIds.pop();
            wx.uploadImage({
                localId: localId,
                isShowProgressTips: 1,
                success: function (res) {
                    //alert(res.serverId);
                    images.serverId.push(res.serverId);// 返回图片的服务器端ID
                    //其他对serverId做处理的代码
                    if(localIds.length > 0){
                        syncUpload(localIds);
                    }
                    alert(images.serverId.length)
                }
            });
        };
        // 5.4 下载图片
        document.querySelector('.downloadImage').onclick = function () {
            if (images.serverId.length === 0) {
                alert('请先使用 uploadImage 上传图片');
                return;
            }
            var i = 0, length = images.serverId.length;
            images.localId = [];
            function download() {
                wx.downloadImage({
                    serverId: images.serverId[i],
                    success: function (res) {
                        i++;
                        alert('已下载：' + i + '/' + length);
                        images.localId.push(res.localId);
                        if (i < length) {
                            download();
                        }
                    }
                });
            }
            download();
        };
    });
    wx.error(function (res) {
        alert(res.errMsg);
    });
</script>
</body>
</html>