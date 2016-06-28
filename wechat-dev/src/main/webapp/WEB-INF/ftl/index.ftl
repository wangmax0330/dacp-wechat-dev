<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<title>首页</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <link href="${rc.contextPath}/res/common/css/mui.min.css" rel="stylesheet"/>
    <link href="${rc.contextPath}/res/common/css/common.css" rel="stylesheet"/>
    <link href="${rc.contextPath}/res/css/home.css" rel="stylesheet"/>
</head>
<body>
<div class="mui-slider">
	<div class="mui-slider-group mui-slider-loop">
		<!--支持循环，需要重复图片节点-->
		<div class="mui-slider-item mui-slider-item-duplicate"><a href="#"><img src="${rc.contextPath}/res/common/images/banner3.png" /></a></div>
		<div class="mui-slider-item"><a href="#"><img src="${rc.contextPath}/res/common/images/banner1.png" /></a></div>
		<div class="mui-slider-item"><a href="#"><img src="${rc.contextPath}/res/common/images/banner2.png" /></a></div>
		<div class="mui-slider-item"><a href="#"><img src="${rc.contextPath}/res/common/images/banner3.png" /></a></div>
		<!--支持循环，需要重复图片节点-->
		<div class="mui-slider-item mui-slider-item-duplicate"><a href="#"><img src="${rc.contextPath}/res/common/images/banner1.png" /></a></div>
	</div>
	<!--分页器-->
	<div class="mui-slider-indicator">
		<div class="mui-indicator mui-active"></div>
		<div class="mui-indicator"></div>
		<div class="mui-indicator"></div>
	</div>
</div>
<div class="container">
	<div class="item-wrap">
		<div class="vertical-line1"></div>
		<div class="vertical-line2"></div>
		<div class="vertical-line3"></div>
		<div class="item-list md-box border-b">
			<div class="md-f1">
				<a href="">
					<img src="${rc.contextPath}/res/images/test.png" alt=""/>
					<div>产品介绍</div>
				</a>
			</div>
			<div class="md-f1">
				<a href="">
					<img src="${rc.contextPath}/res/images/test.png" alt=""/>
					<div>设计师</div>
				</a>
			</div>
			<div class="md-f1">
				<a href="">
					<img src="${rc.contextPath}/res/images/test.png" alt=""/>
					<div>工长</div>
				</a>
			</div>
			<div class="md-f1">
				<a href="">
					<img src="${rc.contextPath}/res/images/test.png" alt=""/>
					<div>装修日记</div>
				</a>
			</div>
		</div>
		<div class="item-list md-box border-b">
			<div class="md-f1">
				<a href="">
					<img src="${rc.contextPath}/res/images/test.png" alt=""/>
					<div>在建工程</div>
				</a>
			</div>
			<div class="md-f1">
				<a href="">
					<img src="${rc.contextPath}/res/images/test.png" alt=""/>
					<div>样板房</div>
				</a>
			</div>
			<div class="md-f1">
				<a href="">
					<img src="${rc.contextPath}/res/images/test.png" alt=""/>
					<div>装修保障</div>
				</a>
			</div>
			<div class="md-f1">
				<a href="">
					<img src="${rc.contextPath}/res/images/test.png" alt=""/>
					<div>验收标准</div>
				</a>
			</div>
		</div>
		<div class="item-list md-box">
			<div class="md-f1">
				<a href="">
					<img src="${rc.contextPath}/res/images/test.png" alt=""/>
					<div>装修合伙人</div>
				</a>
			</div>
			<div class="md-f1">
				<a href="">
					<img src="${rc.contextPath}/res/images/test.png" alt=""/>
					<div>报价查询</div>
				</a>
			</div>
			<div class="md-f1">
				<a href="">
					<img src="${rc.contextPath}/res/images/test.png" alt=""/>
					<div>……</div>
				</a>
			</div>
			<div class="md-f1"></div>
		</div>
	</div>
</div>
<!--页尾-->
<div class="footer-wrap">
	<div class="footer">
		<div class="link on">
			<a class="home-img" href="${rc.contextPath}/d/page/index">
				<span></span>
				<p>首页</p>
			</a>
		</div>
		<div class="link">
			<a class="invest-img" href="${rc.contextPath}/d/page/order">
				<span></span>
				<p>预约装修</p>
			</a>
		</div>
		<div class="link">
			<a class="loan-img" href="">
				<span></span>
				<p>钱包</p>
			</a>
		</div>
		<div class="link">
			<a class="user-center-img" href="${rc.contextPath}/d/page/user_center">
				<span></span>
				<p>我的</p>
			</a>
		</div>
	</div>
</div>
<script src="${rc.contextPath}/res/common/js/mui.min.js"></script>
<!--<script src="${rc.contextPath}/res/common/js/jquery.min-1.8.3.js"></script>-->
<script type="text/javascript" charset="UTF-8">
	mui.init();
	var gallery = mui('.mui-slider');//获得slider插件对象
	gallery.slider({
		interval:3000//自动轮播周期，若为0则不自动播放，默认为0；
	});
</script>
</body>
</html>