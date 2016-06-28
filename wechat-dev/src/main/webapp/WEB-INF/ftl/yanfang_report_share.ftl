<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <title>验房报告分享</title>
    <link href="${rc.contextPath}/res/common/css/mui.min.css" rel="stylesheet"/>
    <link href="${rc.contextPath}/res/common/css/common.css" rel="stylesheet"/>
    <link href="${rc.contextPath}/res/css/house_report.css" rel="stylesheet"/>
</head>
<body>
<div class="content">
    <div class="text-c">
        <h4 class="dis-in-block float-l">验房报告</h4>
        <div class="report_score dis-in-block">98</div>
        <img class="float-r" src="${rc.contextPath}/res/images/house_report/share.png" alt=""/>
    </div><br/>
    <p class="color-main">xxx的新房取得98份的好成绩，打败了98%的房屋。</p>
    <ul class="mui-table-view">
        <li class="mui-table-view-cell mui-collapse mui-active">
            <a class="mui-navigate-right" href="#">地面</a>
            <div class="mui-collapse-content">
                <div class="md-box">
                    <p class="md-f1">检查地面裂痕、起沙、脱皮、麻面的程度是否合理</p>
                    <p><a href=""><img class="float-r" src="${rc.contextPath}/res/images/house_report/help.png" alt=""/></a></p>
                </div>
                <div class="star-level">
                    <span class="star-gray star-smile"></span>
                    <span class="star-gray"></span>
                    <span class="star-gray"></span>
                    <span class="star-gray"></span>
                    <span class="star-gray"></span>
                    <p class="s-l-comment color-g">问题严重，必须整改</p>
                </div>
                <div class="img-wrap">
                    <div class="img-wrap">
                        <div class="img-list"><img src="${rc.contextPath}/res/images/house_report/1.jpg" alt=""/></div>
                        <div class="img-list"><img src="${rc.contextPath}/res/images/house_report/2.jpg" alt=""/></div>
                        <div class="img-list"><img src="${rc.contextPath}/res/images/house_report/3.jpg" alt=""/></div>
                        <div class="img-list"><img src="${rc.contextPath}/res/images/house_report/pictures.png" alt=""/></div>
                    </div>
                </div>
            </div>
        </li>
        <li class="mui-table-view-cell mui-collapse">
            <a class="mui-navigate-right" href="#">电气</a>
            <div class="mui-collapse-content">
                <div class="md-box">
                    <p class="md-f1">检查地面裂痕、起沙、脱皮、麻面的程度是否合理</p>
                    <p><a href=""><img class="float-r" src="${rc.contextPath}/res/images/house_report/help.png" alt=""/></a></p>
                </div>
                <div class="star-level">
                    <span class="star-gray star-smile"></span>
                    <span class="star-gray star-smile"></span>
                    <span class="star-gray"></span>
                    <span class="star-gray"></span>
                    <span class="star-gray"></span>
                    <p class="s-l-comment color-g">细微问题、可不处理</p>
                </div>
                <div class="img-wrap">
                    <div class="img-list"><img src="${rc.contextPath}/res/images/house_report/1.jpg" alt=""/></div>
                    <div class="img-list"><img src="${rc.contextPath}/res/images/house_report/2.jpg" alt=""/></div>
                    <div class="img-list"><img src="${rc.contextPath}/res/images/house_report/3.jpg" alt=""/></div>
                    <div class="img-list"><img src="${rc.contextPath}/res/images/house_report/pictures.png" alt=""/></div>
                </div>
            </div>
        </li>
        <li class="mui-table-view-cell mui-collapse">
            <a class="mui-navigate-right" href="#">防盗门</a>
            <div class="mui-collapse-content">
                <div class="md-box">
                    <p class="md-f1">检查.........是否合理</p>
                    <p><a href=""><img class="float-r" src="${rc.contextPath}/res/images/house_report/help.png" alt=""/></a></p>
                </div>
                <div class="star-level">
                    <span class="star-gray star-smile"></span>
                    <span class="star-gray star-smile"></span>
                    <span class="star-gray star-smile"></span>
                    <span class="star-gray star-smile"></span>
                    <span class="star-gray star-smile"></span>
                    <p class="s-l-comment color-main">检测合格</p>
                </div>
                <div class="img-wrap">
                    <div class="img-list"><img src="${rc.contextPath}/res/images/house_report/1.jpg" alt=""/></div>
                    <div class="img-list"><img src="${rc.contextPath}/res/images/house_report/2.jpg" alt=""/></div>
                    <div class="img-list"><img src="${rc.contextPath}/res/images/house_report/3.jpg" alt=""/></div>
                </div>
            </div>
        </li>
    </ul>
    <div>
        <div class="text-c">
            <img src="${rc.contextPath}/res/images/house_report/weixin_code.png" alt=""/>
        </div>
        <br/>
        <div class="md-box md-pj">
            <div>
                <img src="${rc.contextPath}/res/images/house_report/worker.png" alt="" align="absbottom"/>&nbsp;&nbsp;修装张小三工长
            </div>
            <div>
                <img src="${rc.contextPath}/res/images/house_report/date.png" alt="" align="absbottom"/>&nbsp;&nbsp;2016-06-12
            </div>
        </div>
    </div>
</div>
<!--点击图片放大查看 并滑动轮播-->
<div id="big_img">
    <div class="mui-slider">
        <div class="mui-slider-group"></div>
    </div>
</div>
<script src="${rc.contextPath}/res/common/js/mui.min.js"></script>
<script> mui.init();</script>
<script src="${rc.contextPath}/res/common/js/jquery.min-1.8.3.js"></script>
<script>
    (function (){
        var window_width = $(window).width(); //获取浏览器显示区域的宽度
        var img_width = (window_width-50)/3-10; //获取图片的宽度
        var $img_list =  $('.img-wrap .img-list');
        $img_list.css('height',img_width);

//    点击小图 弹出大图
        var $big_img = $("#big_img");
        $(".img-list img").on('click', function(){
            var $img_list = $(this).parent().parent('.img-wrap').find('.img-list');
            var img_list_length = $img_list.length;
//            console.log(img_list_length);
            var index_num = $img_list.index($(this).parent());
            var src = $(this).attr("src");
            var slider_str = '';
            for(var i=0; i<img_list_length; i++){
                slider_str += '<div class="mui-slider-item"><img src='+$img_list.eq(i).find('img').attr("src")+' /></div>'
            }
            $big_img.find('.mui-slider-group').html(slider_str);
            $big_img.fadeIn(200);
            var gallery = mui('.mui-slider');//获得slider插件对象
            gallery.slider({}).gotoItem(index_num,0);//跳转到对应的图片
        });
        $big_img.on('click', function(){
            $big_img.fadeOut(200);
        });
    }());
</script>
</body>
</html>