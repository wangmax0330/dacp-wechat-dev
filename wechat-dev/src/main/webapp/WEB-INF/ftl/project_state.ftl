<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>工地动态</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <link href="${rc.contextPath}/res/common/css/mui.min.css" rel="stylesheet"/>
    <link href="${rc.contextPath}/res/common/css/common.css" rel="stylesheet" />
    <link href="${rc.contextPath}/res/css/project_state.css" rel="stylesheet" />
</head>
<body>
<div class="content">
    <div class="dynamic-log bg-fff border-bbb">
        <div class="worker-inf md-box border-b-bbb">
            <div class="head-img">
                <img src="${rc.contextPath}/res/images/project_manage/head_img.png" alt=""/>
            </div>
            <div class="md-f1">
                <div class="work-post color-main mar-b10">
                    <span>李小二</span>
                    <span>工长</span>
                </div>
                <p>上传于：2016-06-23</p>
            </div>
            <div class="praise"></div>
        </div>
        <div class="log-body">
            <div class="explain pad-lr5">铲墙保护-入户保护</div>
            <div class="img-wrap">
                <div class="img-list"><img src="${rc.contextPath}/res/images/house_report/pictures.png" alt=""/></div>
                <div class="img-list"><img src="${rc.contextPath}/res/images/house_report/1.jpg" alt=""/></div>
                <div class="img-list"><img src="${rc.contextPath}/res/images/house_report/2.jpg" alt=""/></div>
                <div class="img-list"><img src="${rc.contextPath}/res/images/house_report/3.jpg" alt=""/></div>
                <div class="img-list"><img src="${rc.contextPath}/res/images/house_report/pictures.png" alt=""/></div>
            </div>
        </div>
    </div>
</div>
<!--<div class="reply-frame md-box dis-none">-->
    <!--<div class="md-f1"><input class="reply-input" type="text" /></div>-->
    <!--<div class="btn bg-main send-msg">发送</div>-->
<!--</div>-->
<div class="btn bg-main publish-project-state">发表日志</div>
<!--点击图片放大查看 并滑动轮播-->
<div id="big_img">
    <div class="mui-slider">
        <div class="mui-slider-group"></div>
    </div>
</div>
<script src="${rc.contextPath}/res/common/js/mui.min.js"></script>
<script> mui.init();</script>
<script src="${rc.contextPath}/res/common/js/jquery.min-1.8.3.js"></script>
<script src="${rc.contextPath}/res/common/js/common.js"></script>
<script>
    (function(){
        $('.worker-inf .praise').on('click', function(){
            $(this).addClass('good')
        });
    }())
    document.querySelector('.publish-project-state').onclick = function(){
        window.location.href='${rc.contextPath}/d/page/publish_log';
    }
</script>
</body>
</html>

