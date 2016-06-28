<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>报价单</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <link href="${rc.contextPath}/res/common/css/mui.min.css" rel="stylesheet"/>
    <link href="${rc.contextPath}/res/common/css/common.css" rel="stylesheet" />
    <link href="${rc.contextPath}/res/css/quote_project_date.css" rel="stylesheet" />
</head>
<body>
<div class="q-header text-c">
    <div class="q-h-btn color-main">报价单</div>
    <div class="q-h-btn project-date-btn">工期表</div>
</div>
<div class="content">
    <div class="total-quote md-box md-pj color-main">
        <div class="md-f1">总计（不含税金）</div>
        <div class="md-f1 text-r">4.624万元</div>
    </div>
    <div class="base">
        <div class="border-b-main">基础包</div>
        <div>130.12㎡×399元/㎡ = 4.642 万元</div>
    </div>
    <div class="add-item">
        <div class="border-b-main">增项</div>
        <p>12墙打拆 40×120元/㎡ = 4800元</p>
        <p>12墙打拆 40×120元/㎡ = 4800元</p>
        <p>12墙打拆 40×120元/㎡ = 4800元</p>
        <p>12墙打拆 40×120元/㎡ = 4800元</p>
        <p class="border-b-d"></p>
        <p class="text-r add-item-total">小计：19200元</p>
    </div>
    <div class="btn bg-main">支付99元开工</div>
</div>

<script src="${rc.contextPath}/res/common/js/mui.min.js"></script>
<script> mui.init();</script>
<script>
document.querySelector('.project-date-btn').onclick = function(){
    window.location.href='${rc.contextPath}/d/page/project_date';
}
</script>
</body>
</html>

