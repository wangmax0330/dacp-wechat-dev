<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>会员中心</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <link href="${rc.contextPath}/res/common/css/mui.min.css" rel="stylesheet"/>
    <link href="${rc.contextPath}/res/common/css/common.css" rel="stylesheet" />
    <link href="${rc.contextPath}/res/css/user_center.css" rel="stylesheet" />
</head>
<body>
<div class="container">
    <div class="account">
        <img class="account-bg" src="${rc.contextPath}/res/images/user_center/account_bg.png" alt=""/>
        <div class="head-img"><img src="${rc.contextPath}/res/images/user_center/head_img.png" alt=""/></div>
        <div class="text-c">轻装小助手</div>
    </div>
    <div class="classify md-box text-c">
        <div class="md-f1">验房</div>
        <div class="md-f1">辅材</div>
        <div class="md-f1">合同</div>
        <div class="md-f1">保险</div>
        <div class="md-f1"><a href="${rc.contextPath}/d/page/test_port">接口测试</a></div>
    </div>
    <div class="item-wrap">
        <div class="item-list md-box">
            <div class="md-f1">
                <a href="${rc.contextPath}/d/page/liangfang_report">
                    <img src="${rc.contextPath}/res/images/test.png" alt=""/>
                    <div>量房报告</div>
                </a>
            </div>
            <div class="md-f1">
                <a href="${rc.contextPath}/d/page/yanfang_report">
                    <img src="${rc.contextPath}/res/images/test.png" alt=""/>
                    <div>验房报告</div>
                </a>
            </div>
            <div class="md-f1">
                <a href="${rc.contextPath}/d/page/yanfang_report_share">
                    <img src="${rc.contextPath}/res/images/test.png" alt=""/>
                    <div>报告分享</div>
                </a>
            </div>
            <div class="md-f1">
                <a href="${rc.contextPath}/d/page/project_check">
                    <img src="${rc.contextPath}/res/images/test.png" alt=""/>
                    <div>工地验收</div>
                </a>
            </div>
        </div>
        <div class="item-list md-box">
            <div class="md-f1">
                <a href="${rc.contextPath}/d/page/quote">
                    <img src="${rc.contextPath}/res/images/test.png" alt=""/>
                    <div>报价工期</div>
                </a>
            </div>
            <div class="md-f1">
                <a href="${rc.contextPath}/d/page/project_manage">
                    <img src="${rc.contextPath}/res/images/test.png" alt=""/>
                    <div>工程管理</div>
                </a>
            </div>
            <div class="md-f1">
                <a href="${rc.contextPath}/d/page/project_state">
                    <img src="${rc.contextPath}/res/images/test.png" alt=""/>
                    <div>工地动态</div>
                </a>
            </div>
            <div class="md-f1">
                <a href="${rc.contextPath}/d/page/comment">
                    <img src="${rc.contextPath}/res/images/test.png" alt=""/>
                    <div>发表评论</div>
                </a>
            </div>
        </div>
    </div>
</div>
<a href="tel:13764567708" class="dial dis-block btn bg-main">
    <img src="${rc.contextPath}/res/images/user_center/phone.png" alt="" align="absmiddle"/>
    客服：400-1234-5678
</a>
<script src="${rc.contextPath}/res/common/js/mui.min.js"></script>
<!--<script src="${rc.contextPath}/res/common/js/jquery.min-1.8.3.js"></script>-->
<script> mui.init();</script>
</body>
</html>

