<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>支付</title>
	<link href="${baseurl}/res/common/css/mui.min.css" rel="stylesheet"/>
    <link href="${baseurl}/res/common/css/common.css" rel="stylesheet" />
    <script src="${baseurl}/res/common/js/jquery.min-1.8.3.js"></script>
	<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
	<style>
		#test{position: fixed; bottom: 2rem; left: 10%;}
		.pay-head{margin-bottom: 20px;}
		.pay-content{padding: 0 12px;}
		.pay-way-list{padding: 3px 0; border-bottom: 1px solid #bbbbbb;}
		.pay-way-list:last-of-type{margin-bottom: 0; border-bottom: none;}
		.pay-log{width: 15%; position: relative;}
		.pay-log img{width: 80%; position: absolute; top: 50%; -webkit-transform: translateY(-50%); -moz-transform: translateY(-50%); -ms-transform: translateY(-50%);}
		.mui-radio label{padding: 10px 58px 5px 0;}
		.mui-radio input[type=radio]{position: absolute; right: 0; top: 3px;}
		.mui-radio p{padding-right: 20px;}
		.mui-radio input[type=radio]:checked:before{content: '\e442';}
		#projectSection{margin-bottom: 0;margin-top: 5px;}
	</style>
</head>
<body>
<div class="content">
	<div class="pay-head md-box bg-fff border-bbb pad-12">
		<div class="md-f1 text-l">
			<div id="community_name"></div>
			<p id="projectSection"></p>
		</div>
		<div class="md-f1 text-r">¥<span id="total_fee"></span>元</div>
	</div>
	<div class="pay-content bg-fff border-bbb">
		<div class="pay-way-list md-box">
			<div class="pay-log">
				<img src="${baseurl}/res/images/jspay/weixin.png" alt=""/>
			</div>
			<div class="mui-input-row mui-radio md-f1">
				<label>微信支付</label>
				<input name="pay-way-radio" type="radio">
				<p>推荐安装微信5.0及以上版本的用户使用</p>
			</div>
		</div>
		<div class="pay-way-list md-box">
			<div class="pay-log">
				<img src="${baseurl}/res/images/jspay/bank.png" alt=""/>
			</div>
			<div class="mui-input-row mui-radio md-f1">
				<label>银行卡支付</label>
				<input name="pay-way-radio" type="radio" disabled>
				<p>支持储蓄卡、信用卡，无需开通网银</p>
			</div>
		</div>
		<div class="pay-way-list md-box">
			<div class="pay-log">
				<img src="${baseurl}/res/images/jspay/zhifubao.png" alt=""/>
			</div>
			<div class="mui-input-row mui-radio md-f1">
				<label>支付宝支付</label>
				<input name="pay-way-radio" type="radio" disabled>
				<p>支付宝用户使用，需要在外部浏览器打开</p>
			</div>
		</div>
	</div>
</div>
<div class="btn bg-main" id="test">立即支付</div>
<script src="${baseurl}/res/common/js/mui.min.js"></script>
<script> mui.init();</script>
<script src="${baseurl}/res/common/js/jquery.min-1.8.3.js"></script>
<script type="text/javascript">
var projectId='${projectId}';
var community_name='${community_name}';
var projectSection='${projectSection}';
var total_fee='';
if('${total_fee}'!=null){
	total_fe='${total_fee}';
}
$('#community_name').text(community_name);
$('#total_fee').text(total_fee);
(function (){
	var project_node='';
	if(projectSection==1){
		project_node='水电及改选保护阶段';
	}
	if(projectSection==2){
		project_node='木作及其他隐蔽阶段';
	}
	if(projectSection==3){
		project_node='泥作阶段';
	}
	if(projectSection==4){
		project_node='墙顶面阶段';
	}
	if(projectSection==5){
		project_node='竣工阶段';
	}
	$('#projectSection').text(project_node);
}());
wx.config({
	debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
    appId: '${sign.appid}', // 必填，公众号的唯一标识
    timestamp: '${sign.timestamp}', // 必填，生成签名的时间戳
    nonceStr: '${sign.nonceStr}', // 必填，生成签名的随机串
    signature: '${sign.signature}',// 必填，签名，见附录1
    jsApiList: ['chooseWXPay'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
});
$("#test").one("click", function() {
	wx.ready(function () {
		wx.chooseWXPay({
			timestamp: '${jspayMessage.timeStamp}', // 支付签名时间戳，注意微信jssdk中的所有使用timestamp字段均为小写。但最新版的支付后台生成签名使用的timeStamp字段名需大写其中的S字符
			nonceStr: '${jspayMessage.nonceStr}', // 支付签名随机串，不长于 32 位
			package: '${jspayMessage.packageValue}', // 统一支付接口返回的prepay_id参数值，提交格式如：prepay_id=***）
			signType: '${jspayMessage.signType}', // 签名方式，默认为'SHA1'，使用新版支付需传入'MD5'
			paySign: '${jspayMessage.paySign}', // 支付签名
			success: function (res) {
				// 支付成功后的回调函数
				window.location.href = '${ctx}/page/wechat.user_center';
// 	    	$.post('${ctx}/wechatpay/saveOrder',{openId:'${openId}',openid:'${openId}',brokerage_id:'${brokerage_id}'},function(resp){
// 		    	alert(JSON.stringify(res));
// 	    	});
// 	    	alert('支付成功');
			}, cancel: function (res) {
				mui.toast('您已取消支付');
				window.location.href = '${ctx}/page/wechat.user_center';
			}, fail: function (res) {
				mui.toast(res);
			}
		});
	});
});
</script>
</body>
</html>