<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>工程管理</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <link href="${rc.contextPath}/res/common/css/mui.min.css" rel="stylesheet"/>
    <link href="${rc.contextPath}/res/common/css/common.css" rel="stylesheet" />
    <link href="${rc.contextPath}/res/css/project_manage.css" rel="stylesheet" />
</head>
<body>
<div class="content">
    <div class="project bg-fff border-bbb">
        <div class="project-name">龙城国际五期 1-2-13-6</div>
        <p>开工：2016-06-08</p>
        <p>竣工：2016-08-10（预计）</p>
        <p class="border-b-bbb mar-b10">类型：399基装包</p>
        <div class="progress">
            <progress class="progress-bar" value="42.2" max="100"></progress>
            <span class="color-main">已施工24天</span>
        </div>
    </div>
    <div class="p-manage bg-fff border-bbb mar-b10">
        <div class="p-manage-list">
            <a href="${rc.contextPath}/d/page/yanfang_report">
                <img src="${rc.contextPath}/res/images/test.png" alt=""/>
                <p>验房报告</p>
            </a>
        </div>
        <div class="p-manage-list">
            <a href="${rc.contextPath}/d/page/liangfang_report">
                <img src="${rc.contextPath}/res/images/test.png" alt=""/>
                <p>量房报告</p>
            </a>
        </div>
        <div class="p-manage-list ">
            <a href="${rc.contextPath}/d/page/quote">
                <img src="${rc.contextPath}/res/images/test.png" alt=""/>
                <p>报价工期</p>
            </a>
        </div>
        <div class="p-manage-list ">
            <a href="">
                <img src="${rc.contextPath}/res/images/test.png" alt=""/>
                <p>施工合同</p>
            </a>
        </div>
        <div class="p-manage-list ">
            <a href="">
                <img src="${rc.contextPath}/res/images/test.png" alt=""/>
                <p>保险</p>
            </a>
        </div>
        <div class="p-manage-list ">
            <a href="">
                <img src="${rc.contextPath}/res/images/test.png" alt=""/>
                <p>开工许可</p>
            </a>
        </div>
    </div>
    <div class="pad-12 bg-fff border-bbb mar-b10">
        <div class="pad-b10 border-b-bbb mar-b10">施工团队</div>
        <div id="team">
            <div class="member-list">
                <div class="head-img"><img src="${rc.contextPath}/res/images/project_manage/head_img.jpg" alt=""/></div>
                <p class="work-post text-c color-main">工长</p>
            </div>
            <div class="member-list">
                <div class="head-img"><img src="${rc.contextPath}/res/images/project_manage/head_img.png" alt=""/></div>
                <p class=" work-post text-c color-main">水电工</p>
            </div>
            <div class="member-list">
                <div class="head-img"><img src="${rc.contextPath}/res/images/project_manage/head_img.png" alt=""/></div>
                <p class="work-post text-c color-main">泥工</p>
            </div>
            <div class="member-list">
                <div class="head-img"><img src="${rc.contextPath}/res/images/project_manage/head_img.png" alt=""/></div>
                <p class="work-post text-c color-main">油漆工</p>
            </div>
            <div class="member-list">
                <div class="head-img"><img src="${rc.contextPath}/res/images/project_manage/head_img.png" alt=""/></div>
                <p class="work-post text-c color-main">其他工</p>
            </div>
        </div>
    </div>
    <div class="pad-12 bg-fff border-bbb">
        <div class="course-list pad-b10 border-b-bbb">
            <a href="${rc.contextPath}/d/page/material">
                <div class="float-l">主材配合</div>
                <div class="float-r"><span class="color-main">15项新任务</span> <span class="color-bbb">＞</span></div>
            </a>
        </div>
        <div class="course-list pad-b10 border-b-bbb mar-t10">
            <a href="${rc.contextPath}/d/page/project_state">
                <div class="float-l">工地动态</div>
                <div class="color-bbb float-r"> ＞ </div>
            </a>
        </div>
        <div class="course-list pad-b10 border-b-bbb mar-t10">
            <a href="${rc.contextPath}/d/page/project_check">
                <div class="float-l">工序验收</div>
                <div class="color-bbb float-r"> ＞ </div>
            </a>
        </div>
    </div>
</div>

<!--弹窗-->
<div id="mask-page">
    <div class="pop-content text-center">
        <div class="close-mask-pop"></div>
        <div class="pop-title text-c border-b-bbb">施工团队</div>
        <div class="worker-inf md-box">
            <div class="head-img">
                <img src="${rc.contextPath}/res/images/project_manage/head_img.jpg" alt=""/>
            </div>
            <div class="md-f1">
                <div class="work-post">
                    <span class="worker-name">李小二</span>
                    <span class="color-bbb">工长</span>
                </div>
                <p class="duty">负责工地现场管理、工人安排等工作</p>
            </div>
        </div>
        <a href="tel:13764567708" class="dis-block btn bg-main">联系他</a>
    </div>
</div>
<script src="${rc.contextPath}/res/common/js/mui.min.js"></script>
<script> mui.init();</script>
<script src="${rc.contextPath}/res/common/js/jquery.min-1.8.3.js"></script>
<script>
    //    弹窗
    $maskpage = $("#mask-page");
    function mask_page(){
        this.open= function () {
            $maskpage.fadeIn(300);
        };
        this.close=function(){
            $maskpage.fadeOut(300);
        };
    }
    //    点击打开、关闭弹窗
    $('#team').on("click", ".member-list .head-img", function(){
        var index_num = $('#team').find('.member-list').index($(this).parent());
        var src = $(this).find('img').attr('src');
        var work_post = $(this).parent().find('.work-post').text();
        //假设这是ajax返回的json数据
        var data = [
            { "name":"李小二" , "duty":"负责工地现场管理、工人安排等工作", "phone_number":"18628363666"},
            { "name":"张三" , "duty":"负责工地水电设施等工作", "phone_number":"18628363777"},
            { "name":"李四" , "duty":"负责工泥瓦等工作", "phone_number":"18628363888"},
            { "name":"王五" , "duty":"负责工地油漆等工作", "phone_number":"18628363999"},
            { "name":"赵六" , "duty":"负责工地其他工作", "phone_number":"18628363333"}
        ];
        $maskpage.find('.head-img img').attr('src', src);
        $maskpage.find('.worker-inf .md-f1 .worker-name').text(data[index_num].name);
        $maskpage.find('.worker-inf .md-f1 .color-bbb').text(work_post);
        $maskpage.find('.worker-inf .md-f1 .duty').text(data[index_num].duty);
        $maskpage.find('.dial').attr('href', 'tel:'+data[index_num].phone_number);
        var mask = new mask_page();
        mask.open();
        $maskpage.on("click", ".close-mask-pop", function(){
            mask.close();
        });
    });
</script>
</body>
</html>