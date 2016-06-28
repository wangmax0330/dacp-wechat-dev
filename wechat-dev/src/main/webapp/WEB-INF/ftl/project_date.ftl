<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>工期表</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <link href="${rc.contextPath}/res/common/css/mui.min.css" rel="stylesheet"/>
    <link href="${rc.contextPath}/res/common/css/common.css" rel="stylesheet" />
    <link href="${rc.contextPath}/res/css/quote_project_date.css" rel="stylesheet" />
</head>
<body>
<div class="q-header text-c">
    <div class="q-h-btn quote-btn">报价单</div>
    <div class="q-h-btn color-main">工期</div>
</div>
<div class="content">
    <div class="total-quote md-box md-pj color-main">
        <div class="md-f1">总工期（不含节假日）</div>
        <div class="md-f1 text-r">71天</div>
    </div>
    <ul class="mui-table-view">
        <li class="mui-table-view-cell mui-collapse mui-active">
            <a class="mui-navigate-right" href="#">
                <div class="md-box md-pj">
                    <div>水电及改造保护阶段</div>
                    <div class="pad-r20">7天</div>
                </div>
            </a>
            <div class="mui-collapse-content">
                <div class="item-list"><span class="item-title"></span>铲除及门窗保护，墙面封固</div>
                <div class="item-list"><span class="item-title"></span>主材测量</div>
                <div class="item-list"><span class="item-title"></span>封阳台</div>
                <div class="item-list"><span class="item-title"></span>水电改造</div>
                <div class="item-list"><span class="item-title"></span>确认浴室柜、马桶或蹲便尺寸</div>
                <div class="item-list"><span class="item-title"></span>改煤气管道</div>
            </div>
        </li>
        <li class="mui-table-view-cell mui-collapse">
            <a class="mui-navigate-right" href="#">
                <div class="md-box md-pj">
                    <div>木作及其他隐蔽阶段</div>
                    <div class="pad-r20">7天</div>
                </div>
            </a>
            <div class="mui-collapse-content">
                <div class="item-list"><span class="item-title"></span>木工制作</div>
                <div class="item-list"><span class="item-title"></span>防水施工和闭水实验</div>
                <div class="item-list"><span class="item-title"></span>回填、包管</div>
            </div>
        </li>
        <li class="mui-table-view-cell mui-collapse">
            <a class="mui-navigate-right" href="#">
                <div class="md-box md-pj">
                    <div>泥作阶段</div>
                    <div class="pad-r20">7天</div>
                </div>
            </a>
            <div class="mui-collapse-content">
                <div class="item-list"><span class="item-title"></span>瓷砖及石材进场</div>
                <div class="item-list"><span class="item-title"></span>贴墙砖</div>
                <div class="item-list"><span class="item-title"></span>厨卫铝扣板吊顶尺寸测量</div>
                <div class="item-list"><span class="item-title"></span>橱柜复尺</div>
                <div class="item-list"><span class="item-title"></span>贴地砖</div>
                <div class="item-list"><span class="item-title"></span>安装飘窗石</div>
                <div class="item-list"><span class="item-title"></span>非实木木地板安装地面找平</div>
                <div class="item-list"><span class="item-title"></span>安装钛合金门</div>
            </div>
        </li>
        <li class="mui-table-view-cell mui-collapse">
            <a class="mui-navigate-right" href="#">
                <div class="md-box md-pj">
                    <div>墙顶面阶段</div>
                    <div class="pad-r20">7天</div>
                </div>
            </a>
            <div class="mui-collapse-content">
                <div class="item-list"><span class="item-title"></span>墙面基层处理</div>
            </div>
        </li>
        <li class="mui-table-view-cell mui-collapse">
            <a class="mui-navigate-right" href="#">
                <div class="md-box md-pj">
                    <div>竣工阶段</div>
                    <div class="pad-r20">7天</div>
                </div>
            </a>
            <div class="mui-collapse-content">
                <div class="item-list"><span class="item-title"></span>安装开关面板、角阀、筒灯</div>
                <div class="item-list"><span class="item-title"></span>安装木门和空门套</div>
                <div class="item-list"><span class="item-title"></span>安装定制家具</div>
                <div class="item-list"><span class="item-title"></span>安装厨卫铝扣板吊顶</div>
                <div class="item-list"><span class="item-title"></span>安装橱柜</div>
                <div class="item-list"><span class="item-title"></span>刷乳胶漆</div>
                <div class="item-list"><span class="item-title"></span>安装木地板</div>
                <div class="item-list"><span class="item-title"></span>贴墙纸</div>
                <div class="item-list"><span class="item-title"></span>安装卫浴洁具</div>
                <div class="item-list"><span class="item-title"></span>安装五金挂件</div>
                <div class="item-list"><span class="item-title"></span>保洁</div>
            </div>
        </li>
    </ul>
    <div class="btn bg-main">支付99元开工</div>
</div>

<script src="${rc.contextPath}/res/common/js/mui.min.js"></script>
<script> mui.init();</script>
<script>
document.querySelector('.quote-btn').onclick = function(){
    window.location.href='${rc.contextPath}/d/page/quote';
}
</script>
</body>
</html>

