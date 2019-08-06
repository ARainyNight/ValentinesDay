<template>
	<view class="content">
		<image src="../../static/g1.gif" mode="widthFix"></image>
		<text class="title">小姐姐，做我女朋友吧！</text>
		<view class="operate">
			<button type="primary" class="btn" @tap="agree">好呀</button>
			<button type="warn" class="btn" @tap="disagree">不好</button>
		</view>
		<view class="message" v-for="one in love" :key="one">{{one}}</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				love:[],
				timer:{}
			}
		},
		onLoad() {
			this.back=uni.getBackgroundAudioManager()
			this.back.src="http://140.143.132.225/love/pdd.mp3"
			this.back.title="音乐"
			this.back.play()
		},
		onShow() {
			this.love=[]
			this.timer={}
			let msg={
				2000: "我爱你，我爱你！",
				4000: "I love you, I love you!（英语）",
				6000: "愛しています。愛しています。（日语）",
				8000: "Ich liebe dich, ich liebe dich!（德语）",
				10000: "Я люблю тебя, я люблю тебя!（俄语）",
				12000: "Ti amo, ti amo!（意大利语）",
				14000: "¡Te amo,te amo!（西班牙语）",
				16000: "사랑해요, 사랑해요!（韩语）",
				18000: "Jeg elsker dig, jeg elsker dig!（丹麦语）",
				20000: "Miluju tě, miluju tě!（捷克语）"
			}
			let ref=this;
			for(let key in msg){
				let t=setTimeout(function(){
					ref.love.push(msg[key])
					delete ref.timer[key]
				},key)
				ref.timer[key]=t
			}
		},
		onHide:function(){
			for(let key in this.timer){
				clearTimeout(this.timer[key])
			}
		},
		methods: {
			agree:function(){
				uni.showToast({
					icon:"none",
					title:"小姐姐，下班我们一起去吃饭吧！",
					duration:4000
				})
			},
			disagree:function(){
				uni.showModal({
					title:"小姐姐，要不再想想？",
					content:"拒绝了可就没有大红包了：）",
					cancelText:"拒绝",
					confirmText:"同意",
					success:function(res){
						if(res.confirm){
							uni.showToast({
								icon:"none",
								title:"我就知道小姐姐一定会同意的！",
								duration:3000
							})
						}else{
							uni.showToast({
								icon:"none",
								title:"小姐姐你错过了一个亿的大红包！",
								duration:3000
							})
						}
					}
				})
			}
		}
	}
</script>

<style lang="less">
	@import url("index.less");
</style>
