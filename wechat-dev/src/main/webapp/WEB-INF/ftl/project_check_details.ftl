<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>工地验收详情</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <link href="${rc.contextPath}/res/common/css/mui.min.css" rel="stylesheet"/>
    <link href="${rc.contextPath}/res/common/css/common.css" rel="stylesheet" />
    <link href="${rc.contextPath}/res/css/material_check.css" rel="stylesheet" />
</head>
<body>
<div class="content">
    <div class="check-wrap bg-fff border-bbb">
        <div class="item-title md-box">
            <div class="md-f1">水电及改选保护阶段</div>
            <div class="color-bbb color-main">待验收</div>
        </div>
        <p>工长邀请您于2016-08-21到工地进行验收</p>
        <p>您也可以依照下面的验收标准直接在线验收</p>
    </div>
    <div class="">工地现场照片</div>
    <div class="img-wrap">
        <div class="img-list"><img src="${rc.contextPath}/res/images/house_report/pictures.png" alt=""/></div>
        <div class="img-list"><img src="${rc.contextPath}/res/images/house_report/1.jpg" alt=""/></div>
        <div class="img-list"><img src="${rc.contextPath}/res/images/house_report/2.jpg" alt=""/></div>
        <div class="img-list"><img src="${rc.contextPath}/res/images/house_report/3.jpg" alt=""/></div>
        <div class="img-list"><img src="${rc.contextPath}/res/images/house_report/pictures.png" alt=""/></div>
    </div>
    <div class="check-standard">
        <div class="">验收标准</div>
        <div class="c-s-list md-box">
            <div class=""><img src="${rc.contextPath}/res/images/house_report/1.jpg" alt=""/></div>
            <div class="md-f1">卫生间110排水管管孔中符合，卫生间110排水管管孔中符合。</div>
        </div>
        <div class="c-s-list md-box">
            <div class=""><img src="${rc.contextPath}/res/images/house_report/1.jpg" alt=""/></div>
            <div class="md-f1">卫生间110排水管管孔中符合，卫生间110排水管管孔中符合。</div>
        </div>
        <div class="c-s-list md-box">
            <div class=""><img src="${rc.contextPath}/res/images/house_report/1.jpg" alt=""/></div>
            <div class="md-f1">卫生间110排水管管孔中符合，卫生间110排水管管孔中符合。</div>
        </div>
        <p class="statistics">本阶段需验收39个节点。</p>
    </div>
</div>
<div class="btn-wrap">
    <div class="btn bg-fff border-bbb">验收不通过</div>
    <div class="btn bg-main">验收通过</div>
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
<script src="${rc.contextPath}/res/common/js/common.js"></script>
</body>
</html>