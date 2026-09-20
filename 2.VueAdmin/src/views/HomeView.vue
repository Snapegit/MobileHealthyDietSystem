<template>
	<div class="home_view">
		<div class="projectTitle">欢迎使用 {{projectName}}</div>
	</div>
</template>

<script setup>
	import {
		inject,
		nextTick,
		ref,
		getCurrentInstance
	} from 'vue';
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	const projectName = context.$project.projectName
	const init=()=>{
	}
	//权限验证
	const btnAuth = (e,a)=>{
		return context?.$toolUtil.isAuth(e,a)
	}
	init()
</script>
<style lang="scss">
	.projectTitle{
		padding: 20px 0;
		margin: 20px 0 20px;
		color: #4F1904;
		font-weight: bold;
		display: flex;
		width: 100%;
		font-size: 22px;
		justify-content: center;
		align-items: center;
		height: auto;
	}

	.showIcons {
		transition: transform 0.3s;
		margin-right: 10px;
	}

	.showIcons1 {
		transform: rotate(-180deg);
	}
	
	// 总数盒子
	.count_list{
		padding: 0 0 20px;
		grid-column-gap: 20px;
		display: flex;
		width: 100%;
		justify-content: center;
		align-items: flex-start;
		flex-wrap: wrap;
		// 总数card
		.card_view {
			border: 1px solid #ddd;
			box-shadow: 0px 0px 0px rgba(0,0,0,.12);
			padding-top: 60px;
			flex: 1;
			background: linear-gradient(90deg,#FFFAF2, #FDE9CB);
			width: 100%;
			position: relative;
			box-sizing: border-box;
			height: auto;
			// card头部
			.el-card__header {
				border-radius: 20px 0 0 20px;
				padding: 0 20px;
				top: 20px;
				background: #EED6B4;
				line-height: 40px;
				position: absolute;
				right: 0;
				border-bottom: none;
				// 头部盒子
				.index_card_head {
					display: flex;
					width: 100%;
					justify-content: space-between;
					align-items: center;
					// 标题
					.card_head_title {
						color: #313131;
						font-size: 14px;
						margin-right: 40px;
					}
					// 按钮盒子
					.card_head_right {
						display: flex;
						align-items: center;
						// 按钮
						.el-icon {
							cursor: pointer;
							color: #313131;
							font-weight: 700;
							font-size: 14px;
						}
					}
				}
			}
			// body
			.el-card__body {
				padding: 0;
				// body盒子
				.count_item{
					padding: 30px;
					text-align: center;
					// 总数标题
					.count_title{
						color: #9E9E9E;
						font-size: 18px;
						line-height: 2;
						text-align: left;
					}
					// 总数数字
					.count_num{
						color: #E7B668;
						font-weight: 700;
						font-size: 64px;
						line-height: 1;
						text-align: left;
					}
				}
			}
		}
	}
	// 首页盒子
	.home_view {
		padding: 0px 30px;
		margin: 0;
		background: url(http://clfile.zggen.cn/20240203/480e76b8afa24188a2f7a3a171f56e7d.png) no-repeat center top / 100% 100% !important;
		width: 100%;
		min-height: 100vh;
		height: auto;
	}
	// 统计图盒子
	.card_list {
		padding: 0 0 20px;
		display: flex;
		width: 100%;
		justify-content: space-between;
		align-items: flex-start;
		flex-wrap: wrap;
		// 统计图card
		.card_view {
			border: 1px solid #ddd;
			box-shadow: 0px 0px 0px rgba(0,0,0,.12);
			padding-top: 60px;
			margin: 0 1% 30px;
			width: 48%;
			position: relative;
			box-sizing: border-box;
			height: auto;
			// 头部
			.el-card__header {
				border-radius: 20px 0px 0px 20px;
				padding: 0px 20px;
				top: 20px;
				background: rgb(238, 214, 180);
				line-height: 40px;
				position: absolute;
				right: 0;
				border-bottom: none;
				// 头部盒子
				.index_card_head {
					display: flex;
					justify-content: space-between;
					align-items: center;
					// 标题
					.card_head_title {
						color: #313131;
						font-size: 14px;
					}
					// 按钮盒子
					.card_head_right {
						display: flex;
						align-items: center;
						// 按钮
						.el-icon{
							cursor: pointer;
							color: #313131;
							font-weight: 700;
							font-size: 14px;
						}
					}
				}
			}
			// body
			.el-card__body {
				padding: 0;
				// body盒子
				.card_item{
					padding: 30px;
					text-align: center;
				}
			}
		}
	}
</style>
